package com.binance.trader.support.business.concretes;

import com.binance.api.client.BinanceApiRestClient;
import com.binance.api.client.domain.market.AggTrade;
import com.binance.api.client.domain.market.BookTicker;
import com.binance.api.client.domain.market.Candlestick;
import com.binance.api.client.domain.market.CandlestickInterval;
import com.binance.api.client.domain.market.OrderBook;
import com.binance.api.client.domain.market.TickerPrice;
import com.binance.api.client.domain.market.TickerStatistics;
import com.binance.trader.support.business.abstracts.MarketDataService;
import com.core.utilities.results.DataResult;
import com.core.utilities.results.SuccessDataResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MarketDataManager implements MarketDataService {
    private final BinanceApiRestClient binanceApiRestClient;

    // Verilen sembolün derinliğini döner.
    @Override
    public DataResult<OrderBook> gettindDepthOfSymbol(String symbol, int var) {

        OrderBook orderBook = binanceApiRestClient.getOrderBook(symbol, var);

       // orderBook.getAsks();

        return new SuccessDataResult<OrderBook>(orderBook) ;
    }


    // Verilen sembolün son fiyatını döner
    @Override
    public DataResult<TickerStatistics> gettingLatestPriceOfSymbol(String symbol) {

        TickerStatistics tickerStatistics = binanceApiRestClient.get24HrPriceStatistics(symbol);

        return new SuccessDataResult<TickerStatistics>(tickerStatistics) ;
    }


    // En son fiyatları listeler.
    @Override
    public DataResult<List<TickerPrice>> gettingAllLatestPrices() {

        List<TickerPrice> allPrices = binanceApiRestClient.getAllPrices();

        return new SuccessDataResult<List<TickerPrice>>(allPrices) ;
    }


    // Agg ticareti döndürür. ????
    @Override
    public DataResult<List<AggTrade>> gettingAggTrades(String symbol) {

        List<AggTrade> aggTrades = binanceApiRestClient.getAggTrades(symbol);

        return new SuccessDataResult<List<AggTrade>>(aggTrades);

    }


    // Sembolün haftalık Candlastiğini (şamdan çubukları) döner.
    @Override
    public DataResult<List<Candlestick>> weeklyCandlestickBarsForSymbol(String symbol, CandlestickInterval candlestickInterval) {

        List<Candlestick> candlesticks = binanceApiRestClient.getCandlestickBars(symbol, candlestickInterval);

        return new SuccessDataResult<List<Candlestick>>(candlesticks);
    }


    // Tüm kitap etiketlerini döner.
    @Override
    public DataResult<List<BookTicker>> gettingAllBookTickers() {

        List<BookTicker> allBookTickers = binanceApiRestClient.getBookTickers();

        return new SuccessDataResult<List<BookTicker>>(allBookTickers);
    }
}
