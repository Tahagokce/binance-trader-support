package com.binance.trader.support.api.controller;
import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiRestClient;
import com.binance.trader.support.business.abstracts.UserService;
import com.binance.trader.support.entities.concretes.User;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UsersController {


    private final UserService userService;

    @GetMapping("/findbyid")
    public ResponseEntity<User> findById(@RequestParam int id){
        User user = this.userService.findById(id);


        BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance(user.getUserApiKey(),user.getUserSecretKey());
        BinanceApiRestClient client = factory.newRestClient();


        // TODO: tahagokce example for
        return ResponseEntity.ok(user);
    }
}
