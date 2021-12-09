package com.binance.trader.support.business.abstracts;

import com.binance.api.client.domain.market.TickerPrice;
import com.binance.api.client.domain.market.TickerStatistics;
import com.core.utilities.results.DataResult;

import java.util.List;

public interface SymbolService {
    DataResult<TickerStatistics> latestPriceOfSymbol(String symbol);

    DataResult<List<TickerPrice>> gettingAllLatestsPrices();

}
