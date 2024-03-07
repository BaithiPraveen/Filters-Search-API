package com.javacompany.employeeservice.pagination;

import com.javacompany.employeeservice.dto.PageRequestDTO;
import com.javacompany.employeeservice.utils.DefaultValues;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;

import java.util.Optional;

public class Pagination {
    public static Pageable getPageableResponse(PageRequestDTO pageRequestDTO) {
        int validatedPageNumber = DefaultValues.DEFAULT_PAGE_NUMBER;
        int validatedPageSize = DefaultValues.DEFAULT_PAGE_SIZE;
        String validatedField = DefaultValues.DEFAULT_FIELD;
        Sort sort = Sort.by(Sort.Direction.ASC, validatedField);
        if (pageRequestDTO != null) {
            String sortDirection = Optional.ofNullable(pageRequestDTO.getSortDirection()).orElse(DefaultValues.DEFAULT_SORT_DIRECTION);
            validatedPageNumber = Optional.ofNullable(pageRequestDTO.getPageNumber()).orElse(DefaultValues.DEFAULT_PAGE_NUMBER);
            validatedPageSize = Optional.ofNullable(pageRequestDTO.getPageSize()).orElse(DefaultValues.DEFAULT_PAGE_SIZE);
            validatedField = StringUtils.hasText(pageRequestDTO.getSortColumnName()) ? pageRequestDTO.getSortColumnName() : DefaultValues.DEFAULT_FIELD;
            sort = sortDirection.equalsIgnoreCase(DefaultValues.DEFAULT_SORT_DIRECTION) ? Sort.by(Sort.Direction.ASC, validatedField) : Sort.by(Sort.Direction.DESC, validatedField);
        }
        return PageRequest.of(validatedPageNumber, validatedPageSize, sort);
    }
}