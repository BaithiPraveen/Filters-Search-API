package com.javacompany.employeeservice.dto;

import lombok.Data;

@Data
public class SpecificationInput {
    private String columnName;
    private String value;
    private String operatorName;
    private String joinTable;
    private PageRequestDTO pageRequest;

}
