package com.binance.trader.support.business.concretes;

import com.binance.api.client.BinanceApiRestClient;
import com.binance.api.client.domain.market.TickerPrice;
import com.binance.api.client.domain.market.TickerStatistics;
import com.binance.trader.support.business.abstracts.SymbolService;
import com.core.utilities.results.DataResult;
import com.core.utilities.results.SuccessDataResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class SymbolManager implements SymbolService {
    private final BinanceApiRestClient client;

    @Override
    public DataResult<TickerStatistics> latestPriceOfSymbol(String symbol) {
        TickerStatistics tickerStatistics = client.get24HrPriceStatistics(symbol);
        System.out.println(tickerStatistics.getLastPrice());

        return new SuccessDataResult<>(tickerStatistics,"Başarılı") ;
    }

    @Override
    public  DataResult<List<TickerPrice>> gettingAllLatestsPrices() {
        List<TickerPrice> allPrices = client.getAllPrices();
        System.out.println(allPrices);
        return new SuccessDataResult<>(allPrices,"Başarılı.") ;

    }
}
