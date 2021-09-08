package com.binance.trader.support.business.abstracts;

import com.binance.trader.support.entities.concretes.User;
import com.core.utilities.results.DataResult;

public interface UserService {
    DataResult<User> findById(int id);
}
