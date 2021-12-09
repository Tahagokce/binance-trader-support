package com.binance.trader.support.business.concretes;

import com.binance.api.client.BinanceApiSwapRestClient;
import com.binance.api.client.domain.account.Liquidity;
import com.binance.api.client.domain.account.Pool;
import com.binance.api.client.domain.account.SwapHistory;
import com.binance.api.client.domain.account.SwapQuote;
import com.binance.api.client.domain.account.SwapRecord;
import com.binance.trader.support.business.abstracts.SwapService;
import com.core.utilities.results.DataResult;
import com.core.utilities.results.SuccessDataResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SwapManager implements SwapService {
    private final BinanceApiSwapRestClient swapClient;

    public DataResult<List<Pool>> poolLiquidityInfo() {
        List<Pool> pools = swapClient.listAllSwapPools();
        for (Pool pool : pools) {
            System.out.println(pool);
            Liquidity poolLiquidityInfo = swapClient.getPoolLiquidityInfo(pool.getPoolId());
            System.out.println(poolLiquidityInfo);
        }
        return new SuccessDataResult<List<Pool>>(pools);
    }


    public DataResult<SwapQuote> swapQuote(String s, String s1, String s2) {
        // SwapQuote swapQuote = swapClient.requestQuote("USDT", "USDC", "10");
        SwapQuote swapQuote = swapClient.requestQuote(s, s1, s2);
        System.out.println(swapQuote);
        return new SuccessDataResult<SwapQuote>(swapQuote);

    }


    public DataResult<SwapHistory> swapRecord(String s, String s1, String s2) {

        // SwapRecord swapRecord = swapClient.swap("USDT", "USDC", "10");
        SwapRecord swapRecord = swapClient.swap(s, s1, s2);
        SwapHistory swapHistory = swapClient.getSwapHistory(swapRecord.getSwapId());
        System.out.println(swapHistory);

        return new SuccessDataResult<SwapHistory>(swapHistory);

    }


}


