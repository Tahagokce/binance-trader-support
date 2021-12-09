package com.binance.trader.support.models.dtos;

import com.binance.trader.support.models.entities.Symbol;
import com.binance.trader.support.models.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TrackingModelDto {
    private Long id;

    private Symbol symbol;

    private User user;

    private Double oldPrice;

    private Double price;
}
