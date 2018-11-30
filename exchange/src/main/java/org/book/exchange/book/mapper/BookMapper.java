package org.book.exchange.book.mapper;

import org.book.exchange.book.domain.Book;
import org.book.exchange.book.dto.BookDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface BookMapper {

  Book toBook(BookDto bookDto);

  BookDto toBookDto(Book book);
}
