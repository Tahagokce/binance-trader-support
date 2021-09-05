package com.binance.trader.support.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduser")
    private int id ;

    @Column(name = "user_name")
    private String userName ;

    @Column(name = "user_api_key")
    private String userApiKey;

    @Column(name = "user_secret_key")
    private String userSecretKey;

}
