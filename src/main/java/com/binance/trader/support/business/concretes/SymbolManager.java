package com.binance.trader.support.business.concretes;

import com.binance.api.client.domain.market.TickerPrice;
import com.binance.api.client.domain.market.TickerStatistics;
import com.binance.trader.support.business.abstracts.SymbolService;
import com.core.utilities.results.DataResult;
import com.core.utilities.results.SuccessDataResult;

import java.util.List;

import static com.binance.trader.support.api.controller.UsersController.client;

public class SymbolManager implements SymbolService {
    @Override
    public DataResult<String> latestPriceOfSymbol(String symbol) {
        TickerStatistics tickerStatistics = client.get24HrPriceStatistics(symbol);
        System.out.println(tickerStatistics.getLastPrice());

        return new SuccessDataResult<String>(tickerStatistics.getLastPrice(),"Başarılı") ;
    }

    @Override
    public  DataResult<List<TickerPrice>> gettingAllLatestsPrices() {
        List<TickerPrice> allPrices = client.getAllPrices();
        System.out.println(allPrices);
        return new SuccessDataResult<List<TickerPrice>>(allPrices) ;

    }
}
