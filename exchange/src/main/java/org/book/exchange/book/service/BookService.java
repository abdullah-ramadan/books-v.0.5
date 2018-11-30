package org.book.exchange.book.service;

import org.book.exchange.book.domain.Book;
import org.book.exchange.book.dto.BookDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {

  Book saveBook(BookDto bookDto);

  Book updateBookInfo(BookDto bookDto);

  Book updateBookOwnerData(BookDto bookDto);

  void deleteBook(Long bookId);

  Book getBookById(Long bookId);

  Page<Book> getUserBooks(Long userId, Pageable pageable);
}
