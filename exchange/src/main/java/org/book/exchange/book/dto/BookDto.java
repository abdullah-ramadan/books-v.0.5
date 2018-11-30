package org.book.exchange.book.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookDto {

  private Long id;

  private String name;

  private String aliasName;

  private String description;

  private Date publishDate;
}
