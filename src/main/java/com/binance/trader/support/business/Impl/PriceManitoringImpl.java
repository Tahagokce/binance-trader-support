package com.binance.trader.support.business.Impl;

import com.binance.api.client.domain.market.TickerStatistics;
import com.binance.trader.support.business.PriceManitoringService;
import com.binance.trader.support.business.SelectedTokenService;
import com.binance.trader.support.business.TelegramMessageSendService;
import com.binance.trader.support.business.UserService;
import com.binance.trader.support.business.concretes.SymbolManager;
import com.binance.trader.support.models.entities.SelectedToken;
import com.binance.trader.support.models.entities.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class PriceManitoringImpl implements PriceManitoringService {
    private final UserService userService;
    private final SelectedTokenService selectedTokenService;
    private final SymbolManager symbolManager;
    private final TelegramMessageSendService telegramMessageSendService;

    private boolean isExpectedPriceHigh = false;
    @Value("${telagram.bot.chat.id}")
    private Long chatId;

    public List<SelectedToken> getTokenInfo(int userId) {
        User result = this.userService.findById(userId).getData();
        if (Objects.isNull(result)) {
            throw new EntityNotFoundException();
        }
        List<SelectedToken> selectedTokenList = selectedTokenService.getAllSelectedToken(result);
        if (selectedTokenList.isEmpty()) {
            throw new EntityNotFoundException();
        }
        selectedTokenList.forEach(selectedToken -> {
            TickerStatistics tickerStatistics = symbolManager.latestPriceOfSymbol(selectedToken.getSymbol().getSymbolName()).getData();
            if (selectedToken.getOldPrice() == null || selectedToken.getOldPrice() == 0) {
                selectedToken.setLastPrice(Double.parseDouble(tickerStatistics.getLastPrice()));
                selectedToken.setOldPrice(Double.parseDouble(tickerStatistics.getLastPrice()));
                selectedTokenService.save(selectedToken);
            } else {
                selectedToken.setOldPrice(selectedToken.getLastPrice());
                selectedToken.setLastPrice(Double.parseDouble(tickerStatistics.getLastPrice()));
                if (compareTokenPrice(selectedToken)) {
                    if (isExpectedPriceHigh) {
                        telegramMessageSendService.sendBotMessage(chatId, selectedToken.getSymbol().getSymbolName() + " isimli coin fiyatı %" + selectedToken.getRate() + " oranında yükselmiştir.");

                    } else {
                        telegramMessageSendService.sendBotMessage(chatId, selectedToken.getSymbol().getSymbolName() + " isimli coin fiyatı %" + selectedToken.getRate() + " oranında düşmüştür.");

                    }
                }
                selectedTokenService.save(selectedToken);
            }
        });
        return selectedTokenList;
    }

    public boolean compareTokenPrice(SelectedToken selectedToken) {
        double possibleHighPrice;
        double possibleLowPrice;
        possibleHighPrice = (((selectedToken.getOldPrice() * selectedToken.getRate()) / 100) + selectedToken.getOldPrice());
        possibleLowPrice = (((selectedToken.getOldPrice() * selectedToken.getRate()) / 100) - selectedToken.getOldPrice());
        if (selectedToken.getLastPrice() >= possibleHighPrice) {
            isExpectedPriceHigh = true;
            return true;
        }

        return false;
    }

}
