package com.binance.trader.support.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class TokenInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String symbol;

    private String priceChange;

    private String priceChangePercent;

    private String weightedAvgPrice;

    private String prevClosePrice;

    private String lastPrice;

    private String bidPrice;

    private String askPrice;

    private String openPrice;

    private String highPrice;

    private String lowPrice;

    private String volume;

    private Integer openTime;

    private Integer closeTime;

    private Integer firstId;

    private Integer lastId;

    private Integer count;
}