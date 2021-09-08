package com.binance.trader.support.business.concretes;

import com.binance.trader.support.business.abstracts.UserService;
import com.binance.trader.support.dataAccess.abstracts.UserDao;
import com.binance.trader.support.entities.concretes.User;
import com.core.utilities.results.DataResult;
import com.core.utilities.results.SuccessDataResult;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private final UserDao userDao;



    @Override
    public DataResult<User> findById(int id) {
        var result = this.userDao.findById(id);
        return new SuccessDataResult<User>(result.get());
    }
}
