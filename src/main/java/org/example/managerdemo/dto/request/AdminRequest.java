package org.example.managerdemo.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminRequest {

    @NotNull(message = "userId is mandatory")
    private Integer userId;

    @NotNull(message = "role is mandatory")
    private String role;

}
