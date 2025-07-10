package com.example.Pattern_bot.command.needed;

import com.pengrad.telegrambot.model.Update;

public interface Command {
    void execute(Update update);
}
