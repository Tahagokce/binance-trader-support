package com.binance.trader.support.business.abstracts;

import com.binance.api.client.domain.market.TickerPrice;

import java.util.List;

public interface SymbolService {

    String latestPriceOfSymbol(String symbol);

    List<TickerPrice> gettingAllLatestsPrices();


}
