package edu.java.bot;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.BotCommand;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SetMyCommands;
import org.springframework.stereotype.Component;

public record BotDTO(Update update, BotCommand command, UpdatesListener updatesListener,
                     SetMyCommands setMyCommands, TelegramBot telegramBot) {
}
