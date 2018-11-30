package org.book.exchange.user.controller;

import org.book.exchange.user.domain.User;
import org.book.exchange.user.dto.UserDto;
import org.book.exchange.user.mapper.UserMapper;
import org.book.exchange.user.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/users")
public class UserController {

  private final UserService userService;

  private final UserMapper userMapper;

  public UserController(UserService userService, UserMapper userMapper) {
    this.userService = userService;
    this.userMapper = userMapper;
  }

  @PostMapping("/sign-up")
  public ResponseEntity createUser(@RequestBody UserDto userDto) throws URISyntaxException {
    User user = userService.saveUser(userDto);
    UserDto savedUserDto = userMapper.toUserDto(user);
    return ResponseEntity.created(new URI("/api/users/")).body(savedUserDto);
  }

  @GetMapping
  public ResponseEntity getUsers(Pageable pageable) {
    Page<User> users = userService.getAllUsers(pageable);
    Page<UserDto> userDtos = users.map(userMapper::toUserDto);
    return ResponseEntity.ok(userDtos);
  }
}
