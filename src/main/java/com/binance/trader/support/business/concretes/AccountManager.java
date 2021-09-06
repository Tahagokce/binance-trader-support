package com.binance.trader.support.business.concretes;

import com.binance.api.client.domain.account.*;
import com.binance.trader.support.business.abstracts.AccountService;

import java.util.List;

import static com.binance.trader.support.api.controller.UsersController.client;

public class AccountManager implements AccountService {


    // Hesap bakiyesi döner
    @Override
    public Account getAccountBalances(Long aLong) {

        Account account = client.getAccount(aLong, System.currentTimeMillis());
    //  System.out.println(account.getBalances());
    //  System.out.println(account.getAssetBalance("ETH"));
        return account;
    }


    // İşlemlerin listesi döner
    @Override
    public List<Trade> getListOfTrades(String symbol) {

        List<Trade> myTrades = client.getMyTrades(symbol);

        return myTrades;
    }


    //para çekme geçmişini döner
    @Override
    public WithdrawHistory getWithDraw(String symbol) {

        return  client.getWithdrawHistory(symbol);


    }

    // Para yatırma geçmişi döner
    @Override
    public DepositHistory getDepositHistory(String symbol) {

        return client.getDepositHistory(symbol);

    }


    // Para yatırma adresi döner
    @Override
    public DepositAddress getDepositAddress(String symbol) {

      return  client.getDepositAddress(symbol);

    }

    // ??
    @Override
    public WithdrawResult withdraw(String var1, String var2, String var3, String var4, String var5) {

       return  client.withdraw(var1,var2,var3,var4,var5);

    }
}
