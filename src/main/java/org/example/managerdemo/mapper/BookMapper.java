package org.example.managerdemo.mapper;

import org.example.managerdemo.dto.request.BookRequest;
import org.example.managerdemo.entity.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper extends EntityMapper<Book, BookRequest> {
}
