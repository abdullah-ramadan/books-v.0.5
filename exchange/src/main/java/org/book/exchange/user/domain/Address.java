package org.book.exchange.user.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "Address")
@Table(name = "ADDRESS")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "ADDRESS_STRING")
  private String addressString;
}
