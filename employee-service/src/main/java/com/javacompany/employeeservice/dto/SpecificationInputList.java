package com.javacompany.employeeservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class SpecificationInputList {
    private List<SpecificationInput> specifications;
    private String operationType;
    private PageRequestDTO pageRequest;
}
