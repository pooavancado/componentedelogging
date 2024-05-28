package com.example.logging;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Utilitário de logger para registrar chamadas de métodos.
 */
public class MethodLogger {
    private static final Logger LOGGER = Logger.getLogger(MethodLogger.class.getName());
    private static final List<String> logMessages = new ArrayList<>();

    static {
        LOGGER.setLevel(Level.INFO);
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.INFO);
        LOGGER.addHandler(handler);
    }

    /**
     * Loga uma mensagem e a armazena na lista de mensagens de log.
     *
     * @param message a mensagem a ser logada
     */
    public static void log(String message) {
        LOGGER.info(message);
        logMessages.add(message);
    }

    /**
     * Exibe todas as mensagens de log registradas anteriormente.
     */
    public static void showLogs() {
        System.out.println("Registros anteriores:");
        for (String logMessage : logMessages) {
            System.out.println(logMessage);
        }
    }
}
