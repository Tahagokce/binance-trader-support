package com.binance.trader.support.business.Impl;

import com.binance.trader.support.business.LoginService;
import com.binance.trader.support.business.UserService;
import com.binance.trader.support.models.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class LoginImpl implements LoginService {
    @Value("${user.api.key}")
    private String apiKey;

    @Value("${user.api.secret.key}")
    private String apiSecretKey;

    private final UserService userService;

    @Override
    public User loginWithAppProperties() {
        User user = new User(
                0,
                "Properties Login",
                apiKey,
                apiSecretKey,
                null,
                null
        );

        return user;
    }

    @Override
    public User loginWithDatabaseQuery(int id) {
        User user =  this.userService.findById(id).getData();
        if (Objects.nonNull(user)){
            return user;
        }
        throw new EntityNotFoundException(id + "ID'li kullanıcı bulunamadı.");
    }

    @Override
    public User loginWithRestApi(User user) {
        User result  = this.userService.findById(user.getId()).getData();
        if (Objects.nonNull(result)){
            return user;
        }
        throw new EntityNotFoundException(user.getId() + "ID'li kullanıcı bulunamadı.");
    }
}
