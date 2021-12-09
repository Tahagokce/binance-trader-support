package com.binance.trader.support.business;

import com.binance.trader.support.models.entities.SelectedToken;
import com.binance.trader.support.models.entities.User;

import java.util.List;

public interface SelectedTokenService {
     SelectedToken addSelectedCoin (String symbol);

     List<SelectedToken> getAllSelectedToken (User user);

     SelectedToken save (SelectedToken selectedToken);
}
