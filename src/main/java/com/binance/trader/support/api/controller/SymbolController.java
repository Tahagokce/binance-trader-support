package com.binance.trader.support.api.controller;

import com.binance.api.client.domain.market.TickerPrice;
import com.binance.api.client.domain.market.TickerStatistics;
import com.binance.trader.support.business.abstracts.SymbolService;
import com.binance.trader.support.models.entities.Symbol;
import com.binance.trader.support.repository.SymbolRepository;
import com.core.utilities.results.DataResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/symbol")
@RequiredArgsConstructor
public class SymbolController {
    private final SymbolService symbolService;
    private final SymbolRepository symbolRepository;

    @GetMapping("/latest-price")
    public DataResult<TickerStatistics> latestPriceOfSymbol(String symbol) {
        return symbolService.latestPriceOfSymbol(symbol);
    }

    @GetMapping("/all-latest-prices")
    public DataResult<List<TickerPrice>> gettingAllLatestPrices() {
        return symbolService.gettingAllLatestsPrices();
    }

    public void addAllSymbol() {
        var allSymbol = symbolService.gettingAllLatestsPrices().getData();
        List<Symbol> symbols = new ArrayList<>();
        allSymbol.forEach(i -> {
            Symbol symbol = new Symbol();
            symbol.setSymbolName(i.getSymbol());
            symbol.setActive(false);
            symbols.add(symbol);
        });
        symbolRepository.saveAll(symbols);
    }

}
