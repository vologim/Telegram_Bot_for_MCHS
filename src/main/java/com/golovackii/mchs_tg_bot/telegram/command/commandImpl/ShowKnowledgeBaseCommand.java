package com.golovackii.mchs_tg_bot.telegram.command.commandImpl;

import com.golovackii.mchs_tg_bot.telegram.Bot;
import com.golovackii.mchs_tg_bot.telegram.command.ButtonName;
import com.golovackii.mchs_tg_bot.telegram.command.Command;
import com.golovackii.mchs_tg_bot.telegram.command.CommandName;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShowKnowledgeBaseCommand implements Command {

    private final String DECEPTION_ID = " " + 0;
    private final String MESSAGE = "Выберите пункт:";

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

        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText(ButtonName.RESPONSIBILITIES.getButtonName());
        button1.setCallbackData(CommandName.SHOW_RESPONSIBILITIES_COMMAND.getCommandName() + DECEPTION_ID);

        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText(ButtonName.CHARACTERISTIC_FIRE_HOSE.getButtonName());
        button2.setCallbackData(CommandName.SHOW_CHARACTERISTIC_FIRE_HOSE_COMMAND.getCommandName() + DECEPTION_ID);

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        row1.add(button1);
        row1.add(button2);

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(row1);

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(rowList);

        return inlineKeyboardMarkup;
    }
}