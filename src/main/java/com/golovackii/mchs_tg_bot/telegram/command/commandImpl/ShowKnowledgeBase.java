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
import java.util.Map;

@Component
public class ShowKnowledgeBase implements Command {

    private final String DECEPTION_ID = " " + 0;
    private final String MESSAGE = "Выберите пункт:";

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

        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText(ButtonName.RESPONSIBILITIES.getButtonName());
        button1.setCallbackData(CommandName.SHOW_RESPONSIBILITIES_COMMAND.getCommandName() + DECEPTION_ID);

        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText(ButtonName.CHARACTERISTICS.getButtonName());
        button2.setCallbackData(CommandName.SHOW_CHARACTERISTICS_COMMAND.getCommandName() + DECEPTION_ID);

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        row1.add(button1);
        row1.add(button2);

        InlineKeyboardButton button3 = new InlineKeyboardButton();
        button3.setText(ButtonName.GARRISON_SERVICE.getButtonName());
        button3.setCallbackData(CommandName.SHOW_GARRISON_SERVICE_COMMAND.getCommandName() + DECEPTION_ID);

        InlineKeyboardButton button4 = new InlineKeyboardButton();
        button4.setText(ButtonName.GDZS_BUTTON.getButtonName());
        button4.setCallbackData(CommandName.SHOW_GDZS_COMMAND.getCommandName() + DECEPTION_ID);

        List<InlineKeyboardButton> row2 = new ArrayList<>();
        row2.add(button3);
        row2.add(button4);

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(row1);
        rowList.add(row2);

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(rowList);

        return inlineKeyboardMarkup;
    }
}
