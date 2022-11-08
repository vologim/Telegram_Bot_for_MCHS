package com.golovackii.mchs_tg_bot.telegram.command;

public enum ButtonName {

    RD_BUTTON("Руководящие документы"),
    HYDRANT_MAP_BUTTON("Карты гидрантов"),
    SCHEDULE_BUTTON("График дежурств"),
    KNOWLEDGE_BASE("База знаний"),
    RESPONSIBILITIES("Обязанности"),
    CHARACTERISTICS("ТТХ"),
    GARRISON_SERVICE("Служба"),
    DEVELOPER_BUTTON("Разработчики");

    private final String buttonName;

    ButtonName(String buttonName) {
        this.buttonName = buttonName;
    }

    public String getButtonName() {
        return buttonName;
    }
}
