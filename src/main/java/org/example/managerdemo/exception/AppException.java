package org.example.managerdemo.exception;

import lombok.Data;

import java.util.List;

@Data
public class AppException extends RuntimeException{
    private String msg;
    private List<String> errorFields;

    public AppException(String msg, List<String> errorFields) {
        super(msg);
        this.msg = msg;
        this.errorFields = errorFields;
    }

    public AppException(String msg) {
        this.msg = msg;
    }
}
