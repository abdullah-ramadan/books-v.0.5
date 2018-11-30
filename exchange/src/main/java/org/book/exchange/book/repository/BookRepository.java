package org.book.exchange.book.repository;

import org.book.exchange.book.domain.Book;
import org.book.exchange.common.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

  Page<Book> getAllByOwner_IdAndStatusNot(Long OwnerId, Status status, Pageable pageable);
}
