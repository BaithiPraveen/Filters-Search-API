package com.javacompany.employeeservice.service;

import com.javacompany.employeeservice.dto.SpecificationInput;
import com.javacompany.employeeservice.dto.SpecificationInputList;
import com.javacompany.employeeservice.entity.User;
import com.javacompany.employeeservice.repository.UserRepository;
import com.javacompany.employeeservice.specifcations.FilterSpecification;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static com.javacompany.employeeservice.pagination.Pagination.getPageableResponse;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final FilterSpecification<User> userSpecification;

    public Page<User> getAllUserByOneSearch(SpecificationInput specificationInput) {
        Pageable pageable = getPageableResponse(specificationInput.getPageRequest());
        return userRepository.findAll(userSpecification.getEmployeeSpecification(specificationInput), pageable);
    }

    public Page<User> getAllUserByOneSearch(SpecificationInputList specificationInputList) {
        Pageable pageable = getPageableResponse(specificationInputList.getPageRequest());
        return userRepository.findAll(userSpecification.getEmployeeSpecificationForList(specificationInputList), pageable);
    }

}
