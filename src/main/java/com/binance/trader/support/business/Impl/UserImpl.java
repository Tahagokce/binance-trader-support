package com.binance.trader.support.business.Impl;

import com.binance.trader.support.business.UserService;
import com.binance.trader.support.models.entities.User;
import com.binance.trader.support.repository.UserRepository;
import com.core.utilities.results.DataResult;
import com.core.utilities.results.Result;
import com.core.utilities.results.SuccessDataResult;
import com.core.utilities.results.SuccessResult;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@AllArgsConstructor
public class UserImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public DataResult<User> findById(Integer id) {
        User result = this.userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return new SuccessDataResult<>(result, "Başarılı");
    }


    @Override
    public DataResult<User> save(User user) {
        User result = this.userRepository.save(user);
        return new SuccessDataResult<>(result, "Başarılı");
    }

    @Override
    public DataResult<User> update(User user) {
        User updateUser = this.userRepository.findById(user.getId()).orElseThrow(EntityNotFoundException::new);
        updateUser.setUserName(user.getUserName());
        updateUser.setUserApiKey(user.getUserApiKey());
        updateUser.setUserSecretKey(user.getUserSecretKey());
        User updatedUser = this.userRepository.save(updateUser);
        return new SuccessDataResult<>(updatedUser, "Başarılı");
    }

    @Override
    public Result delete(User user) {
        this.userRepository.delete(user);
        return new SuccessResult("Başarılı");
    }

    @Override
    public DataResult<List<User>> findAll() {
        List<User> result = this.userRepository.findAll();
        return new SuccessDataResult<>(result, "Başarılı");
    }


}
