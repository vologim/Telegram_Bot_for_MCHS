package com.golovackii.mchs_tg_bot.telegram.command.commandImpl;

import com.golovackii.mchs_tg_bot.model.MapHydrant;
import com.golovackii.mchs_tg_bot.service.MapHydrantService;
import com.golovackii.mchs_tg_bot.service.StatisticsService;
import com.golovackii.mchs_tg_bot.telegram.Bot;
import com.golovackii.mchs_tg_bot.telegram.command.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Map;

@Component
public class GetMapHydrantByIdCommand implements Command {

    private final MapHydrantService mapHydrantService;
    private final StatisticsService statisticsService;

    @Autowired
    public GetMapHydrantByIdCommand(MapHydrantService mapHydrantService, StatisticsService statisticsService) {
        this.mapHydrantService = mapHydrantService;
        this.statisticsService = statisticsService;
    }

    @Override
    public void doAction(Bot bot, Map<String, String> data) {

        String chatId = data.get("chatId");
        int elementId = Integer.parseInt(data.get("elementId"));

        MapHydrant mapHydrant = mapHydrantService.getById(elementId);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(mapHydrant.getPath());

        try {
            bot.execute(sendMessage);

            String userName = data.get("userName");
            statisticsService.incrementCountByUserName(userName, GetMapHydrantByIdCommand.class.getSimpleName());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
