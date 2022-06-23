package com.golovackii.mchs_tg_bot.telegram.command.commandImpl;

import com.golovackii.mchs_tg_bot.telegram.Bot;
import com.golovackii.mchs_tg_bot.telegram.command.Command;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class ShowDeveloper implements Command {

    @Value("${developer.information}")
    private String developer;

    @Override
    public void doAction(Bot bot, String[] data) {
        String chatId = data[0];
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(developer);

        try {
            bot.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
