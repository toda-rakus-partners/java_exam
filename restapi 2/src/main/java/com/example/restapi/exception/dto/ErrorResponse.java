package com.example.restapi.exception.dto;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

public class ErrorResponse {
    private Integer status;
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Map<String, String> details; // エラー詳細

    public ErrorResponse(Integer status, String message, Map<String, String> details) {
        this.status = status;
        this.message = message;
        this.details = details;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
    
    public Map<String, String> getDetails() {
        return details;
    }
}
