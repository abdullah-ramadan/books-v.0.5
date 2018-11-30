package org.book.exchange.user.service;

import org.book.exchange.common.Status;
import org.book.exchange.user.domain.User;
import org.book.exchange.user.dto.UserDto;
import org.book.exchange.user.mapper.UserMapper;
import org.book.exchange.user.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service(value = "userService")
@Transactional
public class UserServiceImpl implements UserDetailsService, UserService {

  private final UserMapper userMapper;
  private final UserRepository userRepo;

  public UserServiceImpl(UserMapper userMapper, UserRepository userRepo) {
    this.userMapper = userMapper;
    this.userRepo = userRepo;
  }

  @Override
  public User saveUser(UserDto userDto) {
    User userToSave = userMapper.toUser(userDto);
    return userRepo.save(userToSave);
  }

  @Override
  public User updateUserInfo(UserDto userDto) {
    User userToSave = userMapper.toUser(userDto);
    return userRepo.save(userToSave);
  }

  @Override
  public User updateUserPrimaryAddress(UserDto userDto) {
    return null;
  }

  @Override
  public void deleteUser(Long userId) {
    Optional<User> userOpt = userRepo.findById(userId);
    userOpt.ifPresent(user -> user.setStatus(Status.DELETED));
  }

  @Override
  public User getUserById(Long userId) {
    Optional<User> userOpt = userRepo.findById(userId);
    if (userOpt.isPresent()) return userOpt.get();
    else throw new EntityNotFoundException("User with id " + userId + " not found");
  }

  @Override
  public Page<User> getAllUsers(Pageable pageable) {
    return userRepo.findAll(pageable);
  }

  @Override
  public User getByEmail(String email) {
    return getUserFromOptional(userRepo.getCustomerByEmail(email));
  }

  @Override
  public UserDetails loadUserByUsername(String s) {
    Optional<User> userOpt = userRepo.getCustomerByEmail(s);
    User user = getUserFromOptional(userOpt);
    return new org.springframework.security.core.userdetails.User(
        user.getEmail(), user.getPassword(), getAuthority());
  }

  private List<GrantedAuthority> getAuthority() {
    return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
  }

  private User getUserFromOptional(Optional<User> userOpt) {
    if (userOpt.isPresent()) {
      return userOpt.get();
    } else {
      throw new EntityNotFoundException("");
    }
  }
}
