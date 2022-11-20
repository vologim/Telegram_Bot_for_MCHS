package com.golovackii.mchs_tg_bot.telegram.command;

import com.golovackii.mchs_tg_bot.telegram.command.commandImpl.*;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.golovackii.mchs_tg_bot.telegram.command.CommandName.*;

@Component
public class CommandContainer {

    private final Map<String, Command> commandMap;
    private final NoCommand noCommand;

    public CommandContainer(StartCommand startCommand,
                            ShowListRDCommand showListRDCommand,
                            GetRDByIdCommand getRDByIdCommand,
                            ShowListMapHydrantCommand showListMapHydrantCommand,
                            GetMapHydrantByIdCommand getMapHydrantByIdCommand,
                            ShowListSchedulesCommand showListSchedulesCommand,
                            GetScheduleByIdCommand getScheduleByIdCommand,
                            ShowResponsibilitiesCommand showResponsibilitiesCommand,
                            GetResponsibilityByIdCommand getResponsibilityByIdCommand,
                            ShowKnowledgeBase showKnowledgeBase,
                            ShowDeveloper showDeveloper,
                            ShowListCharacteristics showListCharacteristics,
                            GetCharacteristicsByIdCommand getCharacteristicsByIdCommand,
                            ShowListGarrisonService showListGarrisonService,
                            GetGarrisonServiceByIdCommand getGarrisonServiceByIdCommand,
                            ShowListGDZSCommand showListGDZSCommand,
                            GetGDZSByIdCommand getGDZSByIdCommand,

                            NoCommand noCommand) {
        this.commandMap = new HashMap<>();

        commandMap.put(START_COMMAND.getCommandName(), startCommand);
        commandMap.put(SHOW_LIST_RD_COMMAND.getCommandName(), showListRDCommand);
        commandMap.put(GET_RD_BY_ID_COMMAND.getCommandName(), getRDByIdCommand);
        commandMap.put(SHOW_LIST_MAP_HYDRANT_COMMAND.getCommandName(), showListMapHydrantCommand);
        commandMap.put(GET_MAP_HYDRANT_BY_ID_COMMAND.getCommandName(), getMapHydrantByIdCommand);
        commandMap.put(SHOW_LIST_SCHEDULES_COMMAND.getCommandName(), showListSchedulesCommand);
        commandMap.put(GET_SCHEDULE_BY_ID_COMMAND.getCommandName(), getScheduleByIdCommand);
        commandMap.put(SHOW_RESPONSIBILITIES_COMMAND.getCommandName(), showResponsibilitiesCommand);
        commandMap.put(GET_RESPONSIBILITIES_BY_ID_COMMAND.getCommandName(), getResponsibilityByIdCommand);
        commandMap.put(SHOW_KNOWLEDGE_BASE_COMMAND.getCommandName(), showKnowledgeBase);
        commandMap.put(SHOW_DEVELOPER.getCommandName(), showDeveloper);
        commandMap.put(SHOW_CHARACTERISTICS_COMMAND.getCommandName(), showListCharacteristics);
        commandMap.put(GET_CHARACTERISTICS_COMMAND.getCommandName(), getCharacteristicsByIdCommand);
        commandMap.put(GET_GARRISON_SERVICE_COMMAND.getCommandName(), getGarrisonServiceByIdCommand);
        commandMap.put(SHOW_GARRISON_SERVICE_COMMAND.getCommandName(), showListGarrisonService);
        commandMap.put(GET_GDZS_COMMAND.getCommandName(), getGDZSByIdCommand);
        commandMap.put(SHOW_GDZS_COMMAND.getCommandName(), showListGDZSCommand);

        this.noCommand = noCommand;
    }

    public boolean checkCommand(String commandName) {
        return commandMap.containsKey(commandName);
    }

    public Command getStatus(String commandName) {
        return commandMap.get(commandName);
    }

    public Command getNoCommand() {
        return noCommand;
    }
}
