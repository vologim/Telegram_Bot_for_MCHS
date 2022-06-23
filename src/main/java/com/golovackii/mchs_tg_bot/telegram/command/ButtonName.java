package com.golovackii.mchs_tg_bot.telegram.command;

public enum ButtonName {

    RD_BUTTON("Руководящие документы"),
    HYDRANT_MAP_BUTTON("Карты гидрантов"),
    SCHEDULE_BUTTON("График дежурств"),
    KNOWLEDGE_BASE("База знаний"),
    RESPONSIBILITIES("Обязанности"),
    CHARACTERISTIC_FIRE_PUMP("ТТХ стволов"),
    CHARACTERISTIC_FIRE_HOSE("ТТХ рукавов"),
    DEVELOPER_BUTTON("Разработчики");

    private final String buttonName;

    ButtonName(String buttonName) {
        this.buttonName = buttonName;
    }

    public String getButtonName() {
        return buttonName;
    }
}
