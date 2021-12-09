package com.binance.trader.support.repository;

import com.binance.trader.support.models.entities.Symbol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SymbolRepository extends JpaRepository<Symbol, Integer> {

    Symbol findBySymbolName(String symbol);
}
