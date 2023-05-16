package com.tma.appium.lib;

import org.apache.logging.log4j.core.config.Configurator;

import java.io.File;

public class Log4J2 {

    public Log4J2() {
    }

    public static void init() {
        Configurator.initialize(null, new File(EnvSetup.LOGGER_PROPERTY_FILE).toURI().toString());
    }
}
