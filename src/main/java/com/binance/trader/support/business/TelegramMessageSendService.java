package com.binance.trader.support.business;

public interface TelegramMessageSendService {
     void sendBotMessage(Long chatId, String message);
}
