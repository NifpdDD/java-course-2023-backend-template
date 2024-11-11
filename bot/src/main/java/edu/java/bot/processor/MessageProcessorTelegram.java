package edu.java.bot.processor;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import edu.java.bot.command.Command;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class MessageProcessorTelegram implements UserMessageProcessor<SendMessage,Update> {
    private final List<Command> commands;

    public MessageProcessorTelegram(List<Command> commands) {
        this.commands = commands;
    }

    @Override
    public List<? extends Command> commands() {
        return commands;
    }

    @Override
    public SendMessage process(Update update) {
        long chatId = update.message().chat().id();
        String messageText = update.message().text().trim();

        for (Command command : commands) {
            if (command.supports(update)) {
                return command.handle(update);
            }
        }

        return new SendMessage(chatId, "There is no such command as " + messageText);
    }
}

