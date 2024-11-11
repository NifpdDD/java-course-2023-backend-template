package edu.java.bot.command;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;

public class CommandUntrack implements Command {
    @Override
    public String command() {
        return "/untrack";
    }

    @Override
    public String description() {
        return "Untrack links";
    }

    @Override
    public SendMessage handle(Update update) {
        return null;
    }
}
