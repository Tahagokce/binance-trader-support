package com.binance.trader.support.business.abstracts;

import com.binance.api.client.domain.market.*;
import com.core.utilities.results.DataResult;

import java.util.List;

public interface MarketDataService {

    DataResult<OrderBook> gettindDepthOfSymbol (String symbol, int var);

    DataResult<TickerStatistics> gettingLatestPriceOfSymbol(String symbol);

    DataResult<List<TickerPrice>> gettingAllLatestPrices();

    DataResult<List<AggTrade>> gettingAggTrades(String symbol);

    DataResult<List<Candlestick>> weeklyCandlestickBarsForSymbol(String symbol, CandlestickInterval candlestickInterval);

    DataResult<List<BookTicker>> gettingAllBookTickers();



}




