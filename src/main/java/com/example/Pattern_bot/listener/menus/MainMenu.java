package com.example.Pattern_bot.listener.menus;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.model.request.Keyboard;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MainMenu {
    private final TelegramBot telegramBot;

    public void sendMessage(long chatId) {
        InlineKeyboardButton button0 = new InlineKeyboardButton("button 1").callbackData("/start");
        InlineKeyboardButton button2 = new InlineKeyboardButton("button 2").callbackData("/help");
        InlineKeyboardButton button1 = new InlineKeyboardButton("button 3").callbackData("/universal");
        InlineKeyboardButton button3 = new InlineKeyboardButton("button 4").callbackData("/custom_command");



        Keyboard keyboard1 = new InlineKeyboardMarkup(new InlineKeyboardButton[][]{
                {button0, button1},
                {button2, button3}}
        );

        telegramBot.execute(
                new SendMessage(chatId,
                        "Main menu:")
                        .replyMarkup(keyboard1));


    }

}
