package com.binance.trader.support.business.abstracts;

import com.binance.api.client.domain.market.TickerPrice;
import com.core.utilities.results.DataResult;

import java.util.List;

public interface SymbolService {

    DataResult<String> latestPriceOfSymbol(String symbol);

    DataResult<List<TickerPrice>> gettingAllLatestsPrices();


}
