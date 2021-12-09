package com.binance.trader.support.api.controller;

import com.binance.trader.support.business.UserService;
import com.binance.trader.support.mapper.UserMapper;
import com.binance.trader.support.models.dtos.UserDto;
import com.binance.trader.support.models.entities.User;
import com.core.utilities.results.DataResult;
import com.core.utilities.results.ErrorDataResult;
import com.core.utilities.results.ErrorResult;
import com.core.utilities.results.Result;
import com.core.utilities.results.SuccessDataResult;
import com.core.utilities.results.SuccessResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("save")
    public DataResult<UserDto> save(@RequestBody UserDto userDto) {
        if (Objects.nonNull(userDto)) {
            User user = userMapper.toModel(userDto);
            this.userService.save(user);
            return new SuccessDataResult<>(userDto, "Success");
        }
        return new ErrorDataResult<>(userDto, "Error");
    }

    @PostMapping("delete")
    public Result delete(@RequestBody UserDto userDto) {
        if (Objects.nonNull(userDto)) {
            User user = userMapper.toModel(userDto);
            this.userService.delete(user);
            return new SuccessResult("Success");
        }
        return new ErrorResult("Error");
    }

    @PostMapping("update")
    public Result update(@RequestBody UserDto userDto) {
        if (Objects.nonNull(userDto)) {
            User user = userMapper.toModel(userDto);
            this.userService.update(user);
            return new SuccessResult("Success");
        }
        return new ErrorResult("Error");
    }

    @GetMapping("find-by-ıd")
    public DataResult<UserDto> findById(@RequestParam int userId) {
        User user = this.userService.findById(userId).getData();
        if (Objects.nonNull(user)) {
            UserDto userDto = this.userMapper.toDto(user);
            return new SuccessDataResult<>(userDto,"Success");

        }
        return new ErrorDataResult<>("User not found.");

    }
}
