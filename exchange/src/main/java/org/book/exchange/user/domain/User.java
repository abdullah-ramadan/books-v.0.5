package org.book.exchange.user.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.book.exchange.common.Status;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity(name = "USER")
@Table(name = "USER")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "FIRST_NAME")
  private String firstName;

  @Column(name = "LAST_NAME")
  private String lastName;

  @Column(name = "ALIAS_NAME")
  private String aliasName;

  @Column(name = "EMAIL")
  private String email;

  @Column(name = "USER_NAME")
  private String username;

  @Column(name = "PASSWORD")
  private String password;

  @OneToOne
  @JoinColumn(name = "PRIMARY_ADDRESS_ID")
  private Address primaryAddress;

  @Column(name = "STATUS")
  @Enumerated(EnumType.STRING)
  private Status status;
}
