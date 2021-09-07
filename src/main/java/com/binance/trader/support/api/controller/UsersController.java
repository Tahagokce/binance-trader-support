package com.binance.trader.support.api.controller;

import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiRestClient;
import com.binance.api.client.domain.TimeInForce;
import com.binance.api.client.domain.account.Account;
import com.binance.api.client.domain.account.DepositHistory;
import com.binance.api.client.domain.account.Trade;
import com.binance.api.client.domain.market.AggTrade;
import com.binance.trader.support.business.abstracts.AccountService;
import com.binance.trader.support.business.abstracts.MarketDataService;
import com.binance.trader.support.business.abstracts.OrderService;
import com.binance.trader.support.business.abstracts.UserService;
import com.binance.trader.support.business.concretes.AccountManager;
import com.binance.trader.support.business.concretes.MarketDataManager;
import com.binance.trader.support.business.concretes.OrderManager;
import com.binance.trader.support.entities.concretes.User;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import lombok.AllArgsConstructor;

import java.util.List;

import static com.binance.api.client.domain.account.NewOrder.limitBuy;
import static com.binance.api.client.domain.account.NewOrder.marketBuy;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UsersController {


    private final UserService userService;
    public static BinanceApiRestClient client;

    @GetMapping("/findbyid")
    public ResponseEntity<Object> findById(@RequestParam int id){

        User user = this.userService.findById(id);

        if (user==null){
            return  ResponseEntity.badRequest().body("Hata");
        }


        login(user);

        return ResponseEntity.ok("başarılı");
    }


    public void login(User user){

        BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance(user.getUserApiKey(), user.getUserSecretKey());
         this.client = factory.newRestClient();


    }

   @GetMapping("/get")
    public String get (){

       OrderService orderService = new OrderManager();
       orderService.placingTestMarketOrder("LINKETH", "1000");
       return " başarılı";
    }

    }


