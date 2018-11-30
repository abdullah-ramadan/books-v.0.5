package org.book.exchange.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

  private int status;
  private String message;

  private T result;

  public ApiResponse(int status, String message, T result) {
    this.status = status;
    this.message = message;
    this.result = result;
  }
}
