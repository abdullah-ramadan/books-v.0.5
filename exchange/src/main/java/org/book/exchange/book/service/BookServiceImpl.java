package org.book.exchange.book.service;

import org.book.exchange.book.domain.Book;
import org.book.exchange.book.dto.BookDto;
import org.book.exchange.book.mapper.BookMapper;
import org.book.exchange.book.repository.BookRepository;
import org.book.exchange.common.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@Transactional
public class BookServiceImpl implements BookService {

  private final BookMapper bookMapper;
  private final BookRepository bookRepo;

  public BookServiceImpl(BookMapper bookMapper, BookRepository bookRepo) {
    this.bookMapper = bookMapper;
    this.bookRepo = bookRepo;
  }

  @Override
  public Book saveBook(BookDto bookDto) {
    Book bookToSave = bookMapper.toBook(bookDto);
    return bookRepo.save(bookToSave);
  }

  @Override
  public Book updateBookInfo(BookDto bookDto) {
    Book bookToSave = bookMapper.toBook(bookDto);
    return bookRepo.save(bookToSave);
  }

  @Override
  public Book updateBookOwnerData(BookDto bookDto) {
    Book bookToSave = bookMapper.toBook(bookDto);
    return bookRepo.save(bookToSave);
  }

  @Override
  public void deleteBook(Long bookId) {
    Optional<Book> bookOpt = bookRepo.findById(bookId);
    bookOpt.ifPresent(book -> book.setStatus(Status.DELETED));
  }

  @Override
  public Book getBookById(Long bookId) {
    Optional<Book> bookOpt = bookRepo.findById(bookId);
    if (bookOpt.isPresent()) return bookOpt.get();
    else throw new EntityNotFoundException("Book with id " + bookId + " not found");
  }

  @Override
  public Page<Book> getUserBooks(Long userId, Pageable pageable) {
    return bookRepo.getAllByOwner_IdAndStatusNot(userId, Status.DELETED, pageable);
  }
}
