package com.javacompany.employeeservice.specifcations;

import com.javacompany.employeeservice.dto.SpecificationInput;
import com.javacompany.employeeservice.dto.SpecificationInputList;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;

@Service
@Slf4j
public class FilterSpecification<T> {
    public Specification<T> getFilterSpecificationForList(SpecificationInputList specificationInputList) {
        String operationType = specificationInputList.getOperationType();
        List<SpecificationInput> specificationInputLists = specificationInputList.getSpecifications();
        List<Specification<T>> specifications = specificationInputLists.stream()
                .map(this::getFilterSpecification)
                .toList();
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = specifications.stream()
                    .map(spec -> spec.toPredicate(root, query, criteriaBuilder))
                    .toList();
            if (operationType.equalsIgnoreCase("AND")) {
                log.info("✅ cursor in AND operation ");
                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            } else if (operationType.equalsIgnoreCase("OR")) {
                log.info("✅ cursor in OR operation ");
                return criteriaBuilder.or(predicates.toArray(new Predicate[0]));
            } else {
                throw new InputMismatchException("❎ INPUT IS NOT VALID : " + operationType);
            }
        };
    }

    public Specification<T> getFilterSpecification(SpecificationInput specificationInput) {
        return (root, query, criteriaBuilder) -> {
            String operatorName = specificationInput.getOperatorName().toUpperCase();
            String columnName = specificationInput.getColumnName();
            String value = specificationInput.getValue();
            switch (operatorName) {
                case "EQUALS":
                    log.info("✅ cursor in EQUALS operation : ⬇");
                    return criteriaBuilder.equal(root.get(columnName), value);
                case "GREATER_THAN":
                    log.info("✅ cursor in GREATER_THAN operation : ⬇");
                    return criteriaBuilder.greaterThan(root.get(columnName), value);
                case "GREATER_THAN_EQUALS":
                    log.info("✅ cursor in GREATER_THAN_EQUALS operation : ⬇");
                    return criteriaBuilder.greaterThanOrEqualTo(root.get(columnName), value);
                case "LESS_THAN":
                    log.info("✅ cursor in LESS_THAN operation : ⬇");
                    return criteriaBuilder.lessThan(root.get(columnName), value);
                case "LESS_THAN_EQUALS":
                    log.info("✅ cursor in LESS_THAN_EQUALS operation : ⬇");
                    return criteriaBuilder.lessThanOrEqualTo(root.get(columnName), value);
                case "NOT_EQUALS":
                    log.info("✅ cursor in NOT_EQUALS operation : ⬇");
                    return criteriaBuilder.notEqual(root.get(columnName), value);
                case "LIKE", "CONTAINS":
                    log.info("✅ cursor in LIKE or CONTAINS operation : ⬇");
                    return criteriaBuilder.like(root.get(columnName), "%" + value + "%");
                case "IN":
                    log.info("✅ cursor in IN operation : ⬇");
                    String[] valuesArray = value.split(",");
                    return root.get(columnName).in((Object[]) valuesArray);
                case "NOT_IN":
                    log.info("✅ cursor in NOT_IN operation : ⬇");
                    String[] notInValuesArray = value.split(",");
                    return criteriaBuilder.not(root.get(columnName).in((Object[]) notInValuesArray));
                case "BETWEEN":
                    log.info("✅ cursor in BETWEEN operation : ⬇");
                    String[] betweenValuesArray = value.split(",");
                    return criteriaBuilder.between(root.get(columnName), betweenValuesArray[0], betweenValuesArray[1]);
                case "DATES_BETWEEN":
                    log.info("✅ cursor in DATES_BETWEEN operation : ⬇");
                    String[] dates = value.split(",");
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
                    Date startDate, endDate;
                    try {
                        startDate = dateFormat.parse(dates[0]);
                        endDate = dateFormat.parse(dates[1]);
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                    return criteriaBuilder.between(root.get(specificationInput.getColumnName()), startDate, endDate);
                case "JOIN":
                    log.info("✅ cursor in JOIN operation : ⬇");
                    return criteriaBuilder.equal(root.join(specificationInput.getJoinTable()).get(specificationInput.getColumnName()), specificationInput.getValue());
                default:
                    log.info("❌ INPUT IS NOT VALID : " + operatorName);
                    throw new InputMismatchException("INPUT IS NOT VALID : " + operatorName);
            }
        };
    }
}
