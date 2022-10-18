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
                            ShowKnowledgeBaseCommand showKnowledgeBaseCommand,
                            ShowDeveloper showDeveloper,
                            GetCharacteristicsDocument getCharacteristicsDocument,

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
        commandMap.put(SHOW_KNOWLEDGE_BASE_COMMAND.getCommandName(), showKnowledgeBaseCommand);
        commandMap.put(SHOW_DEVELOPER.getCommandName(), showDeveloper);
        commandMap.put(GET_CHARACTERISTIC_FIRE_HOSE_COMMAND.getCommandName(), getCharacteristicsDocument);
        commandMap.put(GET_CHARACTERISTIC_FIRE_PUMP_COMMAND.getCommandName(), getCharacteristicsDocument);
        commandMap.put(GET_CHARACTERISTIC_FIRE_STAIRS_COMMAND.getCommandName(), getCharacteristicsDocument);

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
