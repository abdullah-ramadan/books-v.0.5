package org.book.exchange.user.service;

import org.book.exchange.user.domain.User;
import org.book.exchange.user.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {

  User saveUser(UserDto userDto);

  User updateUserInfo(UserDto userDto);

  User updateUserPrimaryAddress(UserDto userDto);

  void deleteUser(Long userId);

  User getUserById(Long userId);

  Page<User> getAllUsers(Pageable pageable);

  User getByEmail(String email);

  UserDetails loadUserByUsername(String username);
}
