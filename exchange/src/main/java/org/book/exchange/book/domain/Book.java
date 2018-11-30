package org.book.exchange.book.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.book.exchange.common.Status;
import org.book.exchange.user.domain.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity(name = "BOOK")
@Table(name = "BOOK")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Book implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "BOOK_NAME")
  private String name;

  @Column(name = "BOOK_ALIAS_NAME")
  private String aliasName;

  @Column(name = "DESCRIPTION")
  private String description;

  @Column(name = "PUBLISH_DATE")
  private Date publishDate;

  @Column(name = "STATUS")
  @Enumerated(EnumType.STRING)
  private Status status;

  @ManyToOne
  @JoinColumn(name = "OWNER_ID")
  private User owner;
}
