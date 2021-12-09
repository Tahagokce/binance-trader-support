package com.binance.trader.support.business.abstracts;

import com.binance.api.client.domain.account.Pool;
import com.binance.api.client.domain.account.SwapHistory;
import com.binance.api.client.domain.account.SwapQuote;
import com.core.utilities.results.DataResult;

import java.util.List;

public interface SwapService {
    DataResult<List<Pool>> poolLiquidityInfo();

    DataResult<SwapQuote> swapQuote(String s, String s1, String s2);

    DataResult<SwapHistory> swapRecord(String s, String s1, String s2);

}
