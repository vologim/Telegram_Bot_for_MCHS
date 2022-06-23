package com.golovackii.mchs_tg_bot.telegram.command.commandImpl;

import com.golovackii.mchs_tg_bot.model.MapHydrant;
import com.golovackii.mchs_tg_bot.service.MapHydrantService;
import com.golovackii.mchs_tg_bot.telegram.Bot;
import com.golovackii.mchs_tg_bot.telegram.command.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class GetMapHydrantByIdCommand implements Command {

    private final MapHydrantService mapHydrantService;

    @Autowired
    public GetMapHydrantByIdCommand(MapHydrantService mapHydrantService) {
        this.mapHydrantService = mapHydrantService;
    }

    @Override
    public void doAction(Bot bot, String[] data) {

        String chatId = data[0];
        int elementId = Integer.parseInt(data[1]);

        MapHydrant mapHydrant = mapHydrantService.getById(elementId);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(mapHydrant.getPath());

        try {
            bot.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
