package com.binance.trader.support.business.concretes;

import com.binance.api.client.BinanceApiRestClient;
import com.binance.api.client.domain.account.Account;
import com.binance.api.client.domain.account.DepositAddress;
import com.binance.api.client.domain.account.DepositHistory;
import com.binance.api.client.domain.account.Trade;
import com.binance.api.client.domain.account.WithdrawHistory;
import com.binance.api.client.domain.account.WithdrawResult;
import com.binance.trader.support.business.abstracts.AccountService;
import com.core.utilities.results.DataResult;
import com.core.utilities.results.SuccessDataResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountManager implements AccountService {
    private final BinanceApiRestClient binanceApiRestClient;

    // Hesap bakiyesi döner.
    @Override
    public DataResult<Account> getAccountBalances(Long aLong) {
        Account account = binanceApiRestClient.getAccount(aLong, System.currentTimeMillis());
        System.out.println(account.getBalances());
        System.out.println(account.getAssetBalance("SHIB"));

        return new SuccessDataResult<Account>(account);
    }


    // İşlemlerin listesi döner.
    @Override
    public DataResult<List<Trade>> getListOfTrades(String symbol) {

        List<Trade> myTrades = binanceApiRestClient.getMyTrades(symbol);

        return new SuccessDataResult<List<Trade>>(myTrades);
    }


    // Para çekme geçmişini döner.
    @Override
    public DataResult<WithdrawHistory> getWithDraw(String symbol) {

        return new SuccessDataResult<WithdrawHistory>(binanceApiRestClient.getWithdrawHistory(symbol));


    }

    @Override
    public DataResult<DepositHistory> getDepositHistory(String symbol) {
        DepositHistory depositHistory = this.binanceApiRestClient.getDepositHistory(symbol);
        return new SuccessDataResult<>(depositHistory);
    }


    // Para yatırma adresi döner.
    @Override
    public DataResult<DepositAddress> getDepositAddress(String symbol) {

        return new SuccessDataResult<DepositAddress>(binanceApiRestClient.getDepositAddress(symbol));

    }

    // ??
    @Override
    public DataResult<WithdrawResult> withdraw(String var1, String var2, String var3, String var4, String var5) {

        return new SuccessDataResult<>(binanceApiRestClient.withdraw(var1, var2, var3, var4, var5));

    }
}
