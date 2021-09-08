package com.binance.trader.support.business.abstracts;

import com.binance.api.client.domain.account.*;
import com.core.utilities.results.DataResult;

import java.util.List;

public interface AccountService {

    DataResult<Account> getAccountBalances(Long aLong);

    DataResult<List<Trade>> getListOfTrades(String symbol);

    DataResult<WithdrawHistory> getWithDraw(String symbol);

    DataResult<DepositHistory> getDepositHistory(String symbol);

    DataResult<DepositAddress> getDepositAddress(String symbol);

    DataResult<WithdrawResult> withdraw (String var1, String var2, String var3, String var4, String var5);

}





