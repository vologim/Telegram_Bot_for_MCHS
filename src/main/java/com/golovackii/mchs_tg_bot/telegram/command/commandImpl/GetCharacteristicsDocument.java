package com.golovackii.mchs_tg_bot.telegram.command.commandImpl;

import com.golovackii.mchs_tg_bot.model.Characteristics;
import com.golovackii.mchs_tg_bot.model.Statistics;
import com.golovackii.mchs_tg_bot.service.CharacteristicsService;
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
public class GetCharacteristicsDocument implements Command {

    private final CharacteristicsService characteristicsService;
    private final StatisticsService statisticsService;

    @Autowired
    public GetCharacteristicsDocument(CharacteristicsService characteristicsService, StatisticsService statisticsService) {
        this.characteristicsService = characteristicsService;
        this.statisticsService = statisticsService;
    }

    @Override
    public void doAction(Bot bot, Map<String, String> data) {

        String chatId = data.get("chatId");
        int elementId = Integer.parseInt(data.get("elementId"));

        Characteristics characteristics = characteristicsService.getById(elementId);

        String filePath = characteristics.getDocument().getFilePath();
        String fileName = characteristics.getFileName();

        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            SendDocument sendDocument = new SendDocument();
            sendDocument.setChatId(chatId);
            sendDocument.setDocument(new InputFile(fileInputStream, fileName));

            bot.execute(sendDocument);

            String userName = data.get("userName");
            statisticsService.incrementCountByUserName(userName, GetCharacteristicsDocument.class.getSimpleName());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
