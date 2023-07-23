package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class GuessNumberBot extends TelegramLongPollingBot {

    String botUsername = "";
    String botToken = "";

    @Override
    public void onUpdateReceived(Update update) {

    }


    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }
}
