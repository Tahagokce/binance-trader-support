package com.binance.trader.support.business;

import com.binance.trader.support.models.entities.User;

public interface LoginService {
    User loginWithAppProperties();

    User loginWithDatabaseQuery(int id);

    User loginWithRestApi(User user);

}
