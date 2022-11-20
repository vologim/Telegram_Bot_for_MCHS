package com.golovackii.mchs_tg_bot.telegram.command.commandImpl;

import com.golovackii.mchs_tg_bot.model.GDZS;
import com.golovackii.mchs_tg_bot.service.GDZSService;
import com.golovackii.mchs_tg_bot.service.StatisticsService;
import com.golovackii.mchs_tg_bot.telegram.Bot;
import com.golovackii.mchs_tg_bot.telegram.command.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

@Component
public class GetGDZSByIdCommand implements Command {

    private final GDZSService gdzsService;
    private final StatisticsService statisticsService;

    @Autowired
    public GetGDZSByIdCommand(GDZSService gdzsService, StatisticsService statisticsService) {
        this.gdzsService = gdzsService;
        this.statisticsService = statisticsService;
    }

    @Override
    public void doAction(Bot bot, Map<String, String> data) {

        String chatId = data.get("chatId");
        int elementId = Integer.parseInt(data.get("elementId"));

        GDZS gdzs = gdzsService.getById(elementId);

        String filePath = gdzs.getDocument().getFilePath();
        String fileName = gdzs.getFileName();

        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            SendDocument sendDocument = new SendDocument();
            sendDocument.setChatId(chatId);
            sendDocument.setDocument(new InputFile(fileInputStream, fileName));

            bot.execute(sendDocument);

            String userName = data.get("userName");
            statisticsService.incrementCountByUserName(userName, this.getClass().getSimpleName());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
