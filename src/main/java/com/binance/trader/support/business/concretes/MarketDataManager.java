package com.binance.trader.support.business.concretes;

import com.binance.api.client.domain.market.*;
import com.binance.trader.support.business.abstracts.MarketDataService;
import com.core.utilities.results.DataResult;
import com.core.utilities.results.SuccessDataResult;

import java.util.List;

import static com.binance.trader.support.api.controller.UsersController.client;

public class MarketDataManager implements MarketDataService {



    // Verilen sembolün derinliğini döner.
    @Override
    public DataResult<OrderBook> gettindDepthOfSymbol(String symbol, int var) {

        OrderBook orderBook = client.getOrderBook(symbol, var);

       // orderBook.getAsks();

        return new SuccessDataResult<OrderBook>(orderBook) ;
    }


    // Verilen sembolün son fiyatını döner
    @Override
    public DataResult<TickerStatistics> gettingLatestPriceOfSymbol(String symbol) {

        TickerStatistics tickerStatistics = client.get24HrPriceStatistics(symbol);

        return new SuccessDataResult<TickerStatistics>(tickerStatistics) ;
    }


    // En son fiyatları listeler.
    @Override
    public DataResult<List<TickerPrice>> gettingAllLatestPrices() {

        List<TickerPrice> allPrices = client.getAllPrices();

        return new SuccessDataResult<List<TickerPrice>>(allPrices) ;
    }


    // Agg ticareti döndürür. ????
    @Override
    public DataResult<List<AggTrade>> gettingAggTrades(String symbol) {

        List<AggTrade> aggTrades = client.getAggTrades(symbol);

        return new SuccessDataResult<List<AggTrade>>(aggTrades);

    }


    // Sembolün haftalık Candlastiğini (şamdan çubukları) döner.
    @Override
    public DataResult<List<Candlestick>> weeklyCandlestickBarsForSymbol(String symbol, CandlestickInterval candlestickInterval) {

        List<Candlestick> candlesticks = client.getCandlestickBars(symbol, candlestickInterval);

        return new SuccessDataResult<List<Candlestick>>(candlesticks);
    }


    // Tüm kitap etiketlerini döner.
    @Override
    public DataResult<List<BookTicker>> gettingAllBookTickers() {

        List<BookTicker> allBookTickers = client.getBookTickers();

        return new SuccessDataResult<List<BookTicker>>(allBookTickers);
    }
}
