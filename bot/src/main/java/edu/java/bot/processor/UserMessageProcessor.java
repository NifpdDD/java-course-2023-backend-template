package edu.java.bot.processor;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import edu.java.bot.command.Command;
import okhttp3.Request;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import java.util.List;

public interface UserMessageProcessor<R, A> {
    List<? extends Command> commands();

   R process(A update);
}
