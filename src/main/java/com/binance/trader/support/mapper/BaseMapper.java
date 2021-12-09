package com.binance.trader.support.mapper;

public interface BaseMapper<MODEL, DTO> {
    MODEL toModel(DTO dto);

    DTO toDto(MODEL model);
}