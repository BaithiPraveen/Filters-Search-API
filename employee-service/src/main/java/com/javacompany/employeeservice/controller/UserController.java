package com.javacompany.employeeservice.controller;

import com.javacompany.employeeservice.dto.SpecificationInput;
import com.javacompany.employeeservice.dto.SpecificationInputList;
import com.javacompany.employeeservice.entity.User;
import com.javacompany.employeeservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/byOneSearch")
    public ResponseEntity<Page<User>> getAllEmployeesByOneSearch(@RequestBody SpecificationInput specificationInput) {
        return ResponseEntity.ok(userService.getAllUserByOneSearch(specificationInput));
    }

    @PostMapping("/byOneSearchForList")
    public ResponseEntity<Page<User>> getAllEmployeesByOneSearch(@RequestBody SpecificationInputList specificationInputList) {
        return ResponseEntity.ok(userService.getAllUserByOneSearch(specificationInputList));
    }
}
