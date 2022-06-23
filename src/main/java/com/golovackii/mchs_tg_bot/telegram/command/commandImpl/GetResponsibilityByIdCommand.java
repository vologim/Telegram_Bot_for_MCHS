package com.golovackii.mchs_tg_bot.telegram.command.commandImpl;

import com.golovackii.mchs_tg_bot.model.Responsibility;
import com.golovackii.mchs_tg_bot.service.ResponsibilityService;
import com.golovackii.mchs_tg_bot.telegram.Bot;
import com.golovackii.mchs_tg_bot.telegram.command.Command;
import com.golovackii.mchs_tg_bot.util.FileLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class GetResponsibilityByIdCommand implements Command {

    private final ResponsibilityService responsibilityService;
    private final FileLoader fileLoader;

    @Autowired
    public GetResponsibilityByIdCommand(ResponsibilityService responsibilityService, FileLoader fileLoader) {
        this.responsibilityService = responsibilityService;
        this.fileLoader = fileLoader;
    }

    @Override
    public void doAction(Bot bot, Map<String, String> data) {

        String chatId = data.get("chatId");
        int elementId = Integer.parseInt(data.get("elementId"));

        Responsibility responsibility = responsibilityService.getById(elementId);

        String filePath = responsibility.getDocument().getFilePath();
        String fileName = responsibility.getPosition();

        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            SendDocument sendDocument = new SendDocument();
            sendDocument.setChatId(chatId);
            sendDocument.setDocument(new InputFile(fileInputStream, fileName));

            bot.execute(sendDocument);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
