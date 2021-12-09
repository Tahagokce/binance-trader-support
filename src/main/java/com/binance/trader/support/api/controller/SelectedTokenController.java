package com.binance.trader.support.api.controller;

import com.binance.trader.support.business.PriceManitoringService;
import com.binance.trader.support.business.SelectedTokenService;
import com.binance.trader.support.models.entities.SelectedToken;
import com.binance.trader.support.models.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("selected-token")
@RequiredArgsConstructor
public class SelectedTokenController {
    private final SelectedTokenService selectedTokenService;
    private final PriceManitoringService priceManitoringService;

    @GetMapping("add")
    public SelectedToken addSelectedCoin(@RequestParam String symbol) {
        return selectedTokenService.addSelectedCoin(symbol);

    }

    @PostMapping("getAll")
    public List<SelectedToken> getAllSelectedToken(@RequestBody User user) {
        return selectedTokenService.getAllSelectedToken(user);
    }

    @GetMapping("hesap")
    public List<SelectedToken> hesaplama(@RequestParam int userId) {
        return this.priceManitoringService.getTokenInfo(userId);
    }
}
