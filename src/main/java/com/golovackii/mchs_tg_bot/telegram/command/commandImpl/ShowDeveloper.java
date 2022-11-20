package com.golovackii.mchs_tg_bot.telegram.command.commandImpl;

import com.golovackii.mchs_tg_bot.service.StatisticsService;
import com.golovackii.mchs_tg_bot.telegram.Bot;
import com.golovackii.mchs_tg_bot.telegram.command.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Map;

@Component
public class ShowDeveloper implements Command {

    @Value("${developer.information}")
    private String developer;
    private String MESSAGE = "По всем вопросам и предложениям обращаться: ";

    private final StatisticsService statisticsService;

    @Autowired
    public ShowDeveloper(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @Override
    public void doAction(Bot bot, Map<String, String> data) {
        String chatId = data.get("chatId");
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(MESSAGE + developer);

        try {
            bot.execute(sendMessage);

            String userName = data.get("userName");
            statisticsService.incrementCountByUserName(userName, this.getClass().getSimpleName());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
