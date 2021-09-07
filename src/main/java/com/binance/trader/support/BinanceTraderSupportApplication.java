package com.binance.trader.support;

import com.binance.trader.support.business.abstracts.AccountService;
import com.binance.trader.support.business.concretes.AccountManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BinanceTraderSupportApplication {

    public static void main(String[] args) {
        SpringApplication.run(BinanceTraderSupportApplication.class, args);



    }



}
