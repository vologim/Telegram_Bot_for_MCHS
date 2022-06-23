package com.golovackii.mchs_tg_bot.telegram.command;

import com.golovackii.mchs_tg_bot.telegram.Bot;
import org.springframework.stereotype.Component;

@Component
public interface Command {
    void doAction(Bot bot, String[] data);
}
