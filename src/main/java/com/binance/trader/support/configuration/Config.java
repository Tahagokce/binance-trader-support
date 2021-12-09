package com.binance.trader.support.configuration;

import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiMarginRestClient;
import com.binance.api.client.BinanceApiRestClient;
import com.binance.api.client.BinanceApiSwapRestClient;
import com.binance.api.client.BinanceApiWebSocketClient;
import com.binance.trader.support.business.LoginService;
import com.binance.trader.support.models.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityNotFoundException;
import java.util.Objects;


@Configuration
@RequiredArgsConstructor
public class Config {
    private final LoginService loginService;

    @Bean
    public BinanceApiClientFactory binanceApiClientFactory(){
        User user = this.loginService.loginWithAppProperties();
        if (Objects.isNull(user)) {
            throw new EntityNotFoundException("Kullanıcı bulunamadı.");
        }
        return BinanceApiClientFactory.newInstance(user.getUserApiKey(), user.getUserSecretKey());
    }

    @Bean
    public BinanceApiRestClient binanceApiRestClient(BinanceApiClientFactory binanceApiClientFactory) {
        return binanceApiClientFactory.newRestClient();
    }

    @Bean
    public BinanceApiSwapRestClient binanceApiSwapRestClient(BinanceApiClientFactory binanceApiClientFactory) {
        return binanceApiClientFactory.newSwapRestClient();
    }

    @Bean
    public BinanceApiWebSocketClient binanceApiWebSocketClient(BinanceApiClientFactory binanceApiClientFactory) {
        return binanceApiClientFactory.newWebSocketClient();
    }

    @Bean
    public BinanceApiMarginRestClient binanceApiMarginRestClient(BinanceApiClientFactory binanceApiClientFactory) {
        return binanceApiClientFactory().newMarginRestClient();
    }
}
