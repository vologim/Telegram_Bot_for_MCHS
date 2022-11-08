package com.golovackii.mchs_tg_bot.telegram.command.commandImpl;

import com.golovackii.mchs_tg_bot.model.GarrisonService;
import com.golovackii.mchs_tg_bot.service.GarrisonServiceService;
import com.golovackii.mchs_tg_bot.telegram.Bot;
import com.golovackii.mchs_tg_bot.telegram.command.Command;
import com.golovackii.mchs_tg_bot.telegram.command.CommandName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class ShowListGarrisonService implements Command {

    private final GarrisonServiceService service;
    private final String MESSAGE = "Выберите документ:";

    @Autowired
    public ShowListGarrisonService(GarrisonServiceService service) {
        this.service = service;
    }

    @Override
    public void doAction(Bot bot, Map<String, String> data) {
        String chatId = data.get("chatId");
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(MESSAGE);
        sendMessage.setReplyMarkup(getKeyboard());

        try {
            bot.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private InlineKeyboardMarkup getKeyboard() {

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        for (GarrisonService garrisonService : service.getList()) {
            InlineKeyboardButton button = new InlineKeyboardButton();
            button.setText(garrisonService.getFileName());
            button.setCallbackData(CommandName.GET_GARRISON_SERVICE_COMMAND.getCommandName() + " " + garrisonService.getId());

            List<InlineKeyboardButton> row = new ArrayList<>();
            row.add(button);

            rowList.add(row);
        }

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(rowList);

        return inlineKeyboardMarkup;
    }
}
