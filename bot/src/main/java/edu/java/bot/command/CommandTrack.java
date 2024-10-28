package edu.java.bot.command;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;

public class CommandTrack implements Command {
    @Override
    public String command() {
        return "/track";
    }

    @Override
    public String description() {
        return "Following links";
    }

    @Override
    public SendMessage handle(Update update) {
        return null;
    }
}
