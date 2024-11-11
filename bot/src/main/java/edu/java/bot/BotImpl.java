package edu.java.bot;


import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.BotCommand;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SetMyCommands;
import edu.java.bot.command.Command;
import edu.java.bot.configuration.ApplicationConfig;
import edu.java.bot.processor.MessageProcessorTelegram;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BotImpl implements Bot {

    private final BotDTO BotDTO;
    private final MessageProcessorTelegram messageProcessorTelegram;
    private final TelegramMapper telegramMapper;

    public BotImpl(ApplicationConfig Bot, MessageProcessorTelegram messageProcessorTelegram, TelegramMapper mapper) {
        this.telegramMapper = new TelegramMapperImpl();
        this.BotDTO = telegramMapper.toBotDTO(new TelegramBot(Bot.telegramToken()));
        this.messageProcessorTelegram = messageProcessorTelegram;
        
    }

    public void createMenu() {
        List<? extends Command> commands = messageProcessorTelegram.commands();
        BotCommand[] menu = new BotCommand[commands.size()];
        for (int i = 0; i < commands.size(); i++) {
            menu[i] = commands.get(i).toApiCommand();
        }
        BotDTO.telegramBot().execute(new SetMyCommands(menu));
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
                BotDTO.telegramBot().execute(messageProcessorTelegram.process(update));
            }
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }
}
