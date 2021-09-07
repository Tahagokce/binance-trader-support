package com.binance.trader.support.business.concretes;

import com.binance.api.client.domain.market.*;
import com.binance.trader.support.business.abstracts.MarketDataService;

import java.util.List;

import static com.binance.trader.support.api.controller.UsersController.client;

public class MarketDataManager implements MarketDataService {




    // Verilen sembolün derinliğini döner.
    @Override
    public OrderBook gettindDepthOfSymbol(String symbol, int var) {

        OrderBook orderBook = client.getOrderBook(symbol, var);

       // orderBook.getAsks();

        return orderBook;
    }


    // Verilen sembolün son fiyatını döner
    @Override
    public TickerStatistics gettingLatestPriceOfSymbol(String symbol) {

        TickerStatistics tickerStatistics = client.get24HrPriceStatistics(symbol);

        return tickerStatistics;
    }


    // En son fiyatları listeler.
    @Override
    public List<TickerPrice> gettingAllLatestPrices() {

        List<TickerPrice> allPrices = client.getAllPrices();

        return allPrices;
    }


    // Agg ticareti döndürür. ????
    @Override
    public List<AggTrade> gettingAggTrades(String symbol) {

        List<AggTrade> aggTrades = client.getAggTrades(symbol);

        return aggTrades;
    }


    // Sembolün haftalık Candlastiğini (şamdan çubukları) döner.
    @Override
    public List<Candlestick> weeklyCandlestickBarsForSymbol(String symbol, CandlestickInterval candlestickInterval) {

        List<Candlestick> candlesticks = client.getCandlestickBars(symbol, candlestickInterval);

        return candlesticks;
    }


    // Tüm kitap etiketlerini döner.
    @Override
    public List<BookTicker> gettingAllBookTickers() {

        List<BookTicker> allBookTickers = client.getBookTickers();

        return allBookTickers;
    }
}
