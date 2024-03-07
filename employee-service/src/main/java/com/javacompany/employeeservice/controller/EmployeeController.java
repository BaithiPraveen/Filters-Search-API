package com.javacompany.employeeservice.controller;

import com.javacompany.employeeservice.dto.SpecificationInput;
import com.javacompany.employeeservice.dto.SpecificationInputList;
import com.javacompany.employeeservice.entity.Employee;
import com.javacompany.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/byOneSearch")
    public ResponseEntity<Page<Employee>> getAllEmployeesByOneSearch(@RequestBody SpecificationInput specificationInput) {
        return ResponseEntity.ok(employeeService.getAllEmployeesByOneSearch(specificationInput));
    }

    @PostMapping("/byOneSearchForList")
    public ResponseEntity<Page<Employee>> getAllEmployeesByOneSearch(@RequestBody SpecificationInputList specificationInputList) {
        return ResponseEntity.ok(employeeService.getAllEmployeesByOneSearch(specificationInputList));
    }


//    @GetMapping("/byName")
//    public List<Employee> getAllEmployees() {
//        return employeeService.findAllEmployee();
//    }
//
//    @PostMapping("/bySpecification")
//    public ResponseEntity<Page<Employee>> getAllEmployeesListBySpecificationInput(@RequestBody SpecificationInput specificationInput) {
//        return ResponseEntity.ok(employeeService.getAllEmployeesListBySpecificationInput(specificationInput));
//    }
//
//    @PostMapping("/byDateSpecification")
//    public ResponseEntity<Page<Employee>> getAllEmployeesListBySpecificationDate(@RequestBody SpecificationInput specificationInput) throws ParseException {
//        return ResponseEntity.ok(employeeService.getAllEmployeesListBySpecificationDate(specificationInput));
//    }
//
//    @PostMapping("/byPaginationAndSorting")
//    public ResponseEntity<Page<Employee>> getAllEmployeesByPaginationAndSorting(@RequestBody SpecificationInput specificationInput) throws ParseException {
//        return ResponseEntity.ok(employeeService.getAllEmployeesByPaginationAndSorting(specificationInput));
//    }
//
//    @PostMapping("/byLike")
//    public ResponseEntity<Page<Employee>> getAllEmployeesByLike(@RequestBody SpecificationInput specificationInput) throws ParseException {
//        return ResponseEntity.ok(employeeService.getAllEmployeesByLike(specificationInput));
//    }
//
//    @PostMapping("/byGraterThan")
//    public ResponseEntity<Page<Employee>> getAllEmployeesByGraterThan(@RequestBody SpecificationInput specificationInput) throws ParseException {
//        return ResponseEntity.ok(employeeService.getAllEmployeesByGraterThan(specificationInput));
//    }
//
//    @PostMapping("/byLessThan")
//    public ResponseEntity<Page<Employee>> getAllEmployeesByLessThan(@RequestBody SpecificationInput specificationInput) throws ParseException {
//        return ResponseEntity.ok(employeeService.getAllEmployeesByLessThan(specificationInput));
//    }
//
////    @PostMapping("/deleteBySpecification")
////    public String deleteBySpecification(@RequestBody SpecificationInput specificationInput) throws ParseException {
////        employeeService.deleteBySpecificCriteria(specificationInput);
////        return "done 👍";
////    }
//
//    @PostMapping("/bySpecificationInputList")
//    public ResponseEntity<Page<Employee>> getAllEmployeesBySpecificationInputList(@RequestBody SpecificationInputList specificationInputList) throws ParseException {
//        return ResponseEntity.ok(employeeService.getAllEmployeesBySpecificationInputList(specificationInputList));
//    }
//
//    @PostMapping("/bySpecificationInputListWithDynamicCode")
//    public ResponseEntity<Page<Employee>> getAllEmployees(@RequestBody SpecificationInputList specificationInputList) {
//        return ResponseEntity.ok(employeeService.getAllEmployeesListWithDynamicSearch(specificationInputList));
//    }
//
//    @PostMapping("/byBetweenSpecification")
//    public ResponseEntity<Page<Employee>> getAllEmployeesByBetweenSpecification(@RequestBody SpecificationInput specificationInput) {
//        return ResponseEntity.ok(employeeService.getAllEmployeesByBetweenSpecification(specificationInput));
//    }


}
