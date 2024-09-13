package org.example.managerdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.managerdemo.entity.User;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    private HttpStatus status;
    private String message;
    private T data;


}
