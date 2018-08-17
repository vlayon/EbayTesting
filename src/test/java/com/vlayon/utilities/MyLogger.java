package com.vlayon.utilities;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class MyLogger {

        static private FileHandler fileTxt;
        static private SimpleFormatter formatterTxt;


        static public void setup() throws IOException {

            // get the global logger to configure it
            Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

          // // suppress the logging output to the console
          // Logger rootLogger = Logger.*getLogger*("");
          // Handler[] handlers = rootLogger.getHandlers();
          // if (handlers[0] instanceof ConsoleHandler) {
          //     rootLogger.removeHandler(handlers[0]);
          // }

            logger.setLevel(Level.INFO);
            fileTxt = new FileHandler("Logging.txt",8096,1, true);


            // create a TXT formatter
            formatterTxt = new SimpleFormatter();
            fileTxt.setFormatter(formatterTxt);
            logger.addHandler(fileTxt);


        }
    }
