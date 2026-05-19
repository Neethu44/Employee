package com.example.employeemanagement.exception;

public class ResourceNotFoundException extends RuntimeException {
    private Long id;

    public ResourceNotFoundException(Long id) {
        this.id = id;
    }

}
