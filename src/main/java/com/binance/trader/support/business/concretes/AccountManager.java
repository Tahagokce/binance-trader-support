package com.binance.trader.support.business.concretes;

import com.binance.api.client.domain.account.*;
import com.binance.trader.support.business.abstracts.AccountService;
import com.core.utilities.results.DataResult;
import com.core.utilities.results.SuccessDataResult;

import java.util.List;

import static com.binance.trader.support.api.controller.UsersController.client;


public class AccountManager implements AccountService {



    // Hesap bakiyesi döner.
    @Override
    public DataResult<Account> getAccountBalances(Long aLong) {


        Account account = client.getAccount(aLong, System.currentTimeMillis());
        System.out.println(account.getBalances());
        System.out.println(account.getAssetBalance("SHIB"));

        return new SuccessDataResult<Account>(account);
    }


    // İşlemlerin listesi döner.
    @Override
    public DataResult<List<Trade>> getListOfTrades(String symbol) {

        List<Trade> myTrades = client.getMyTrades(symbol);

        return new SuccessDataResult<List<Trade>>(myTrades) ;
    }


    // Para çekme geçmişini döner.
    @Override
    public DataResult<WithdrawHistory> getWithDraw(String symbol) {

        return new SuccessDataResult<WithdrawHistory>(client.getWithdrawHistory(symbol));


    }

    // Para yatırma geçmişi döner.
    @Override
    public DataResult<DepositHistory> getDepositHistory(String symbol) {

        return new SuccessDataResult<>(client.getDepositHistory(symbol));

    }


    // Para yatırma adresi döner.
    @Override
    public DataResult<DepositAddress> getDepositAddress(String symbol) {

      return new SuccessDataResult<DepositAddress> (client.getDepositAddress(symbol));

    }

    // ??
    @Override
    public DataResult<WithdrawResult> withdraw(String var1, String var2, String var3, String var4, String var5) {

       return new SuccessDataResult<>(client.withdraw(var1,var2,var3,var4,var5));

    }
}
