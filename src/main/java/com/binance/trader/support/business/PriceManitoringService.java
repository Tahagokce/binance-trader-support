package com.binance.trader.support.business;

import com.binance.trader.support.models.entities.SelectedToken;

import java.util.List;

public interface PriceManitoringService {
    public List<SelectedToken> getTokenInfo(int user);
}
