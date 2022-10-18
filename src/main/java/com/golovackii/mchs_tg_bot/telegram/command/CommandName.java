package com.golovackii.mchs_tg_bot.telegram.command;

public enum CommandName {

    START_COMMAND("/start"),
    SHOW_LIST_RD_COMMAND("/show_list_rd"),
    GET_RD_BY_ID_COMMAND("/get_rd_by_id"),
    SHOW_LIST_MAP_HYDRANT_COMMAND("/show_list_map_hydrant"),
    GET_MAP_HYDRANT_BY_ID_COMMAND("/get_map_hydrant_by_id"),
    SHOW_LIST_SCHEDULES_COMMAND("/show_list_schedules"),
    GET_SCHEDULE_BY_ID_COMMAND("/get_schedule_by_id"),
    SHOW_RESPONSIBILITIES_COMMAND("/show_responsibilities"),
    GET_RESPONSIBILITIES_BY_ID_COMMAND("/get_responsibilities_by_id"),
    SHOW_KNOWLEDGE_BASE_COMMAND("/show_knowledge_base"),
    GET_CHARACTERISTIC_FIRE_HOSE_COMMAND("get_characteristic_fire_hose"),
    GET_CHARACTERISTIC_FIRE_PUMP_COMMAND("get_characteristic_fire_pump"),
    GET_CHARACTERISTIC_FIRE_STAIRS_COMMAND("get_characteristic_fire_stairs"),
    SHOW_DEVELOPER("/show_developer");

    private final String commandName;

    CommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}
