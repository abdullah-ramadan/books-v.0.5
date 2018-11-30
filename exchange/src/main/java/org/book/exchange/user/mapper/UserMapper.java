package org.book.exchange.user.mapper;

import org.book.exchange.user.domain.User;
import org.book.exchange.user.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

  User toUser(UserDto userDto);

  UserDto toUserDto(User user);
}
