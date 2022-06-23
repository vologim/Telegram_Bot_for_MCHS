package com.golovackii.mchs_tg_bot.telegram.command;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ButtonContainer {

    private final Map<String, String> stringMap;

    public ButtonContainer() {
        stringMap = new HashMap<>();

        stringMap.put(ButtonName.RD_BUTTON.getButtonName(), CommandName.SHOW_LIST_RD_COMMAND.getCommandName());
        stringMap.put(ButtonName.HYDRANT_MAP_BUTTON.getButtonName(), CommandName.SHOW_LIST_MAP_HYDRANT_COMMAND.getCommandName());
        stringMap.put(ButtonName.SCHEDULE_BUTTON.getButtonName(), CommandName.SHOW_LIST_SCHEDULES_COMMAND.getCommandName());
        stringMap.put(ButtonName.KNOWLEDGE_BASE.getButtonName(), CommandName.SHOW_KNOWLEDGE_BASE_COMMAND.getCommandName());
        stringMap.put(ButtonName.DEVELOPER_BUTTON.getButtonName(), CommandName.SHOW_DEVELOPER.getCommandName());

    }

    public boolean checkButton(String buttonName) {
        return stringMap.containsKey(buttonName);
    }

    public String getCommandName(String buttonName) {
        return stringMap.get(buttonName);
    }
}
