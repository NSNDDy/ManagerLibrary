package org.example.managerdemo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {
    private Integer bookId;
    private String title;
    private String author;
    private String publisher;
    private Date dateOfPulication;
    private String category;
}
