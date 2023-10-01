package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Random;

public class GuessNumberBot extends TelegramLongPollingBot {

    String botUsername = "GNBdemolessonbot";
    String botToken = "6312515853:AAG11PdtWdA5G9oOnipnDZro2Ir_bey-jPk";
    Random random = new Random();
    int computerNumber;
    int userNumber;

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() == true) {
            Message messageFromUser = update.getMessage();

            if (messageFromUser.hasText() == true) {
                String textFromMessage = messageFromUser.getText();
                long chatId = messageFromUser.getChatId();

                SendMessage messageToUser = new SendMessage();

                messageToUser.setChatId(chatId);

                if (textFromMessage.equals("/start") == true){
                    computerNumber = random.nextInt(1, 101);
                    messageToUser.setText("Привет! Я бот угадай число, попробуй отгадать число от 1 до 100!");
                } else {
                    userNumber = Integer.parseInt(textFromMessage);

                    if (userNumber == computerNumber) {
                        messageToUser.setText("Ура! Вы молодец, вы победили!");
                    }
                    if (userNumber < computerNumber) {
                        messageToUser.setText("Введите число побольше");
                    }
                    if (userNumber > computerNumber) {
                        messageToUser.setText("Введите число поменьше");
                    }
                }

                try {
                    execute(messageToUser);
                } catch (TelegramApiException e) {

                }
            }
        }
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
