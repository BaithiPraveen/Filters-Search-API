package com.javacompany.employeeservice.service;

import com.javacompany.employeeservice.dto.SpecificationInput;
import com.javacompany.employeeservice.dto.SpecificationInputList;
import com.javacompany.employeeservice.entity.Employee;
import com.javacompany.employeeservice.repository.EmployeeRepository;
import com.javacompany.employeeservice.specifcations.FilterSpecification;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static com.javacompany.employeeservice.pagination.Pagination.getPageableResponse;

@Service
@AllArgsConstructor
@Slf4j
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final FilterSpecification<Employee> employeeEmployeeSpecification;

    public Page<Employee> getAllEmployeesByOneSearch(SpecificationInput specificationInput) {
        Pageable pageable = getPageableResponse(specificationInput.getPageRequest());
        return employeeRepository.findAll(employeeEmployeeSpecification.getFilterSpecification(specificationInput), pageable);
    }

    public Page<Employee> getAllEmployeesByOneSearch(SpecificationInputList specificationInputList) {
        Pageable pageable = getPageableResponse(specificationInputList.getPageRequest());
        return employeeRepository.findAll(employeeEmployeeSpecification.getFilterSpecificationForList(specificationInputList), pageable);
    }


//    private Specification<Employee> getSpecification() {
//        String columnName = "name", value = "ajay";
//        return (root, query, criteriaBuilder) -> {
//            return criteriaBuilder.equal(root.get(columnName), value);
//        };
//    }
//
//    public List<Employee> findAllEmployee() {
//        return employeeRepository.findAll(getSpecification());
//    }
//
//    public Page<Employee> getAllEmployeesListBySpecificationInput(SpecificationInput specificationInput) {
//        Pageable pageable = getPageableResponse(specificationInput.getPageNumber(), specificationInput.getPageSize(), specificationInput.getSortColumnName(), specificationInput.getSortDirection());
//        return employeeRepository.findAll(employeeEmployeeSpecification.getEmployeeSpecification(specificationInput), pageable);
//    }
//
//    public Page<Employee> getAllEmployeesListBySpecificationDate(SpecificationInput specificationInput) {
//        Pageable pageable = getPageableResponse(specificationInput.getPageNumber(), specificationInput.getPageSize(), specificationInput.getSortColumnName(), specificationInput.getSortDirection());
//        return employeeRepository.findAll(EmployeeSpecification.getEmployeeSpecification(specificationInput), pageable);
//    }
//
//    public Page<Employee> getAllEmployeesByPaginationAndSorting(SpecificationInput specificationInput) {
//        Pageable pageable = getPageableResponse(specificationInput.getPageNumber(), specificationInput.getPageSize(), specificationInput.getSortColumnName(), specificationInput.getSortDirection());
//        return employeeRepository.findAll(EmployeeSpecification.getEmployeeSpecification(specificationInput), pageable);
//    }
//
//    public Page<Employee> getAllEmployeesByLike(SpecificationInput specificationInput) {
//        Pageable pageable = getPageableResponse(specificationInput.getPageNumber(), specificationInput.getPageSize(), specificationInput.getSortColumnName(), specificationInput.getSortDirection());
//        return employeeRepository.findAll(EmployeeSpecification.getEmployeeSpecification(specificationInput), pageable);
//    }
//
//    public Page<Employee> getAllEmployeesByGraterThan(SpecificationInput specificationInput) {
//        Pageable pageable = getPageableResponse(specificationInput.getPageNumber(), specificationInput.getPageSize(), specificationInput.getSortColumnName(), specificationInput.getSortDirection());
//        return employeeRepository.findAll(EmployeeSpecification.getEmployeeSpecification(specificationInput), pageable);
//    }
//
//    public Page<Employee> getAllEmployeesByLessThan(SpecificationInput specificationInput) {
//        Pageable pageable = getPageableResponse(specificationInput.getPageNumber(), specificationInput.getPageSize(), specificationInput.getSortColumnName(), specificationInput.getSortDirection());
//        Specification<Employee> specification = EmployeeSpecification.getEmployeeSpecification(specificationInput);
//        log.info("Count : " + employeeRepository.count(specification));
//        log.info("Exist : " + employeeRepository.exists(getSpecification()));
////        employeeRepository.delete(specification);
//        return employeeRepository.findAll(specification, pageable);
//    }
//
//    public Page<Employee> getAllEmployeesBySpecificationInputList(SpecificationInputList specificationInputList) {
//        Pageable pageable = getPageableResponse(specificationInputList.getPageNumber(), specificationInputList.getPageSize(), specificationInputList.getSortColumnName(), specificationInputList.getSortDirection());
//        return employeeRepository.findAll(EmployeeSpecification.getEmployeeSpecificationForList(specificationInputList), pageable);
//    }
//
//    public Page<Employee> getAllEmployeesListWithDynamicSearch(SpecificationInputList specificationInputList) {
//        Pageable pageable = getPageableResponse(specificationInputList.getPageNumber(), specificationInputList.getPageSize(), specificationInputList.getSortColumnName(), specificationInputList.getSortDirection());
//        return employeeRepository.findAll(EmployeeSpecification.getEmployeeSpecificationForList(specificationInputList), pageable);
//    }
//
//    public Page<Employee> getAllEmployeesByBetweenSpecification(SpecificationInput specificationInput) {
//        Pageable pageable = getPageableResponse(specificationInput.getPageNumber(), specificationInput.getPageSize(), specificationInput.getSortColumnName(), specificationInput.getSortDirection());
//        return employeeRepository.findAll( EmployeeSpecification.getEmployeeSpecification(specificationInput),pageable);
//    }

//    public void deleteBySpecificCriteria(SpecificationInput specificationInput) {
//        employeeRepository.delete(getDeleteBySpecificCriteriaSpecification(specificationInput));
//    }

}
