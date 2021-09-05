package com.binance.trader.support.entities.concretes;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    private String userName ;

    private String userApiKey;

    private String userSecretKey;
}
