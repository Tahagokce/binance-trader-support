package com.binance.trader.support.business.abstracts;

import com.binance.api.client.domain.market.*;

import java.util.List;

public interface MarketDataService {

    OrderBook gettindDepthOfSymbol (String symbol,int var);

    TickerStatistics gettingLatestPriceOfSymbol(String symbol);

    List<TickerPrice> gettingAllLatestPrices();

    List<AggTrade> gettingAggTrades(String symbol);

    List<Candlestick> weeklyCandlestickBarsForSymbol(String symbol, CandlestickInterval candlestickInterval);

    List<BookTicker> gettingAllBookTickers();



}




