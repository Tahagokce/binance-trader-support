package com.binance.trader.support.business.concretes;

import com.binance.api.client.domain.market.TickerPrice;
import com.binance.api.client.domain.market.TickerStatistics;
import com.binance.trader.support.business.abstracts.SymbolService;

import java.util.List;

import static com.binance.trader.support.api.controller.UsersController.client;

public class SymbolManager implements SymbolService {
    @Override
    public String latestPriceOfSymbol(String symbol) {
        TickerStatistics tickerStatistics = client.get24HrPriceStatistics(symbol);
        System.out.println(tickerStatistics.getLastPrice());

        return tickerStatistics.getLastPrice();
    }

    @Override
    public List<TickerPrice> gettingAllLatestsPrices() {
        List<TickerPrice> allPrices = client.getAllPrices();
        System.out.println(allPrices);
        return allPrices;

    }
}
