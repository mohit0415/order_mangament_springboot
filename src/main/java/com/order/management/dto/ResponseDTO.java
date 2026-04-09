package com.order.management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class ResponseDTO {
    private Long statusCode;
    private String message;
    private Object resObj;
    private Map<String,String> errors;
}
