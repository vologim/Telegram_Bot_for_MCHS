package com.golovackii.mchs_tg_bot.telegram.command.commandImpl;

import com.golovackii.mchs_tg_bot.model.RD;
import com.golovackii.mchs_tg_bot.service.RDService;
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

@Component
public class ShowListRDCommand implements Command {

    private final RDService rdService;
    private final String MESSAGE = "Выберите документ:";

    @Autowired
    public ShowListRDCommand(RDService rdService) {
        this.rdService = rdService;
    }

    @Override
    public void doAction(Bot bot, String[] data) {
        String chatId = data[0];
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

        for (RD element : rdService.getList()) {
            InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
            inlineKeyboardButton.setText(element.getNameDocument() + " от " + element.getDocumentDate());
            inlineKeyboardButton.setCallbackData(CommandName.GET_RD_BY_ID_COMMAND.getCommandName() + " " + element.getId());

            List<InlineKeyboardButton> row = new ArrayList<>();
            row.add(inlineKeyboardButton);

            rowList.add(row);
        }

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(rowList);

        return inlineKeyboardMarkup;
    }

}
