package org.example.managerdemo.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {

    @NotBlank(message = "title is mandatory")
    private String title;

    @NotBlank(message = "author is mandatory")
    private String author;

    @NotBlank(message = "publisher is mandatory")
    private String publisher;

    @PastOrPresent(message = "Publication date should be in the past or present")
    private Date dateOfPulication;

    @NotBlank(message = "category is mandatory")
    private String category;
}
