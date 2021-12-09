package com.binance.trader.support.business.Impl;

import com.binance.trader.support.business.TelegramMessageSendService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

@Service
@Slf4j
@RequiredArgsConstructor
public class TelegramMessageSendServiceImpl extends TelegramLongPollingBot implements TelegramMessageSendService {
    @Value("${telegram.bot.username}")
    String telegramBotUsername;
    @Value("${telegram.bot.token}")
    String telegramBotToken;

    public void sendBotMessage(Long chatId, String message) {

        SendMessage response = new SendMessage();
        response.setChatId(chatId);
        response.setText(message);
        try {
            sendMessage(response);
        } catch (TelegramApiException e) {
            System.out.println(e.getMessage());
        }
        log.info("Pump sniper bildirim yollandı.");
    }


    @Override
    public void onUpdateReceived(Update update) {

    }

    @Override
    public String getBotUsername() {
        return telegramBotUsername;
    }

    @Override
    public String getBotToken() {
        return telegramBotToken;
    }
}
