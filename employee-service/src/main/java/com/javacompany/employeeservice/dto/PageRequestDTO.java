package com.javacompany.employeeservice.dto;

import lombok.Data;

@Data
public class PageRequestDTO {
    private String sortColumnName;
    private String sortDirection;
    private Integer pageNumber;
    private Integer pageSize;
}
