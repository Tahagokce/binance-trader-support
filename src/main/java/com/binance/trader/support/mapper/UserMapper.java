package com.binance.trader.support.mapper;

import com.binance.trader.support.models.dtos.UserDto;
import com.binance.trader.support.models.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements BaseMapper<User,UserDto> {
    @Override
    public User toModel(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setUserName(userDto.getUserName());
        user.setUserApiKey(userDto.getUserApiKey());
        user.setUserSecretKey(userDto.getUserSecretKey());
        return user;
    }

    @Override
    public UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUserName(user.getUserName());
        userDto.setUserApiKey(user.getUserApiKey());
        userDto.setUserSecretKey(user.getUserSecretKey());
        return userDto;
    }
}
