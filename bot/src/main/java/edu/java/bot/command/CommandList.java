package edu.java.bot.command;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;

public class CommandList implements Command {
    @Override
    public String command() {
        return "/list";
    }

    @Override
    public String description() {
        return "List of commands";
    }

    @Override
    public SendMessage handle(Update update) {
        return null;
    }
}
