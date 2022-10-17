package com.golovackii.mchs_tg_bot.telegram;

import com.golovackii.mchs_tg_bot.telegram.command.ButtonContainer;
import com.golovackii.mchs_tg_bot.telegram.command.CommandContainer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.HashMap;
import java.util.Map;

@Component
public class Bot extends TelegramLongPollingBot {

    @Value("${bot.name}")
    private String botName;

    @Value("${bot.token}")
    private String botToken;

    private final CommandContainer commandContainer;
    private final ButtonContainer buttonContainer;

    public Bot(CommandContainer commandContainer, ButtonContainer buttonContainer) {
        this.commandContainer = commandContainer;
        this.buttonContainer = buttonContainer;
    }

    @Override
    public void onUpdateReceived(Update update) {
        Map<String, String> data = new HashMap<>();

        if (update.hasMessage() && update.getMessage().hasText()) {
            String chatId = update.getMessage().getChatId().toString();
            String message = update.getMessage().getText().trim();
            String userName = update.getMessage().getFrom().getUserName();

            data.put("chatId", chatId);
            data.put("userName", userName);

            if (commandContainer.checkCommand(message)) {
                String commandName = message.split(" ")[0].toLowerCase();
                commandContainer.getStatus(commandName).doAction(this, data);
            }
            else if (buttonContainer.checkButton(message)) {
                commandContainer.getStatus(buttonContainer.getCommandName(message)).doAction(this, data);
            }
            else {
                commandContainer.getNoCommand().doAction(this, data);
            }
        }
        else if (update.hasCallbackQuery()) {
            String chatId = update.getCallbackQuery().getMessage().getChatId().toString();
            String callBackQuery = update.getCallbackQuery().getData().split(" ")[0];
            String elementId = update.getCallbackQuery().getData().split(" ")[1];
            String userName = update.getCallbackQuery().getFrom().getUserName();

            data.put("chatId", chatId);
            data.put("elementId", elementId);
            data.put("userName", userName);

            commandContainer.getStatus(callBackQuery).doAction(this, data);
        }
    }

    @Override
    public String getBotUsername() {
        return botName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }
}
