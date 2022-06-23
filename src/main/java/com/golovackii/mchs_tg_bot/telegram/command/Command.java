package com.golovackii.mchs_tg_bot.telegram.command;

import com.golovackii.mchs_tg_bot.telegram.Bot;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public interface Command {
    void doAction(Bot bot, Map<String, String> data);
}
