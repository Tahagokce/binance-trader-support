package com.binance.trader.support.business.abstracts;

import com.binance.api.client.domain.account.*;

import java.util.List;

public interface AccountService {

    Account getAccountBalances(Long aLong);

    List<Trade> getListOfTrades(String symbol);

    WithdrawHistory getWithDraw(String symbol);

    DepositHistory getDepositHistory(String symbol);

    DepositAddress getDepositAddress(String symbol);

    WithdrawResult withdraw (String var1, String var2, String var3, String var4, String var5);

}





