package edu.java.bot.command;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;

public class CommandHelp implements Command {
    @Override
    public String command() {
        return "/help";
    }

    @Override
    public String description() {
        return "Помощь";
    }

    @Override
    public SendMessage handle(Update update) {
        return null;
    }
}
