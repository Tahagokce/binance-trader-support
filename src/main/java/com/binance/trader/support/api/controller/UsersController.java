package com.binance.trader.support.api.controller;

import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiRestClient;
import com.binance.api.client.domain.market.AggTrade;
import com.binance.trader.support.business.abstracts.MarketDataService;
import com.binance.trader.support.business.abstracts.UserService;
import com.binance.trader.support.business.concretes.MarketDataManager;
import com.binance.trader.support.business.concretes.SwapManager;
import com.binance.trader.support.entities.concretes.User;
import com.core.utilities.results.DataResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import lombok.AllArgsConstructor;

import java.util.List;


@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UsersController {


    private final UserService userService;
    public static BinanceApiClientFactory factory;
    public static BinanceApiRestClient client;

    @GetMapping("/findbyid")
    public ResponseEntity<Object> findById(@RequestParam int id){

        DataResult<User> user = this.userService.findById(id);

        if (user==null){
            return  ResponseEntity.badRequest().body("Hata");
        }


        login(user.getData());
        SwapManager swapManager = new SwapManager();


        return ResponseEntity.ok("başarılı");
    }


    public void login(User user){

         factory = BinanceApiClientFactory.newInstance(user.getUserApiKey(), user.getUserSecretKey());
         client = factory.newRestClient();


    }


    }


