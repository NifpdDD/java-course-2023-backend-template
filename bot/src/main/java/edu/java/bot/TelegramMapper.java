package edu.java.bot;

import com.pengrad.telegrambot.TelegramBot;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TelegramMapper  {
    BotDTO toBotDTO(TelegramBot telegramBot);
    TelegramBot toTelegramBot(BotDTO botDTO);
}
