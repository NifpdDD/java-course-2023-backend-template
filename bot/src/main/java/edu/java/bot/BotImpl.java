package edu.java.bot;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.BotCommand;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.request.SetMyCommands;
import com.pengrad.telegrambot.response.BaseResponse;
import edu.java.bot.command.Command;
import edu.java.bot.configuration.ApplicationConfig;
import edu.java.bot.processor.MessageProcessor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BotImpl implements Bot {

    private final TelegramBot Bot;
    private final MessageProcessor messageProcessor;

    public BotImpl(ApplicationConfig Bot, MessageProcessor messageProcessor) {
        this.Bot = new TelegramBot(Bot.telegramToken());
        this.messageProcessor = messageProcessor;
    }

    public void createMenu() {
        List<? extends Command> commands = messageProcessor.commands();
        BotCommand[] menu = new BotCommand[commands.size()];
        for (int i = 0; i < commands.size(); i++) {
            menu[i] = commands.get(i).toApiCommand();
        }
        Bot.execute(new SetMyCommands(menu));
    }

    @Override
    public void start() {
        createMenu();
    }

    @Override
    public void close() {

    }

    @Override
    public int process(List<Update> updates) {
            for (Update update : updates) {
                Bot.execute(messageProcessor.process(update));
            }
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }
}
