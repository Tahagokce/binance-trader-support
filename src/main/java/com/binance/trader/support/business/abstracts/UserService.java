package com.binance.trader.support.business.abstracts;

import com.binance.trader.support.entities.concretes.User;

public interface UserService {
    User findById(int id);
}
