package com.example.Pattern_bot.listener;

import com.example.Pattern_bot.service.listenerService.MainListenerService;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UpdateListener implements UpdatesListener {

    private final TelegramBot telegramBot;
    private final MainListenerService listenerService;


    @PostConstruct
    public void init() {
        telegramBot.setUpdatesListener(this);
    }

    @Override
    public int process(List<Update> updates) {
        updates.forEach(update -> {
            if (update.message() != null) {
                if (update.message().text() != null) {
                    listenerService.workWithText(
                            update.message().text(),
                            update
                    );
                } else {
                    listenerService.dontUnderstand(
                            update.message().chat().id()
                    );
                }
            } else if (update.callbackQuery() != null) {
                listenerService.workWithButton(
                        update
                );
            }


        });
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }
}
