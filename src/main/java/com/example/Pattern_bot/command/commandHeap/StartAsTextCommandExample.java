package com.example.Pattern_bot.command.commandHeap;

import com.example.Pattern_bot.command.abstractCommands.MessageCommand;
import com.example.Pattern_bot.command.annotation.BotCommand;
import com.example.Pattern_bot.listener.menus.MainMenu;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;


/**
 * Пример команды, обрабатывающей текстовые сообщения.
 * Использует аннотацию @BotCommand для автоматической регистрации.
 * Наследуется от MessageCommand для упрощения обработки текстовых сообщений.
 */
@BotCommand(command = "/start")
//@RequiredArgsConstructor
public class StartAsTextCommandExample extends MessageCommand {

    private final MainMenu menu;
    private static final String HELLO = ". My creater is glad for you. U can use me!";

    /**
     * Конструктор с указанием TelegramBot.
     * 
     * @param telegramBot экземпляр TelegramBot
     * @param menu экземпляр MainMenu
     */
    public StartAsTextCommandExample(TelegramBot telegramBot, MainMenu menu) {
        super(telegramBot);
        this.menu = menu;
    }

    /**
     * Обработка текстового сообщения.
     * Этот метод вызывается только если update содержит текстовое сообщение.
     * 
     * @param update объект обновления от Telegram
     */
    @Override
    protected void handleMessage(Update update) {
        // Получаем ID чата и имя пользователя
        long chatId = getChatId(update);
        String username = getUsername(update);

        // Отправляем приветственное сообщение
        sendTextMessage(chatId, "Hello, " + username + HELLO);
        
        // Отображаем главное меню
        menu.sendMessage(chatId);
    }
}