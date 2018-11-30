package org.book.exchange.user.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

  private Long id;

  private String firstName;

  private String lastName;

  private String aliasName;

  private String email;

  private String password;
}
