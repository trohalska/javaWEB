package com.epam.training;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jTest {
	// Java util logging configuration
	private static final String LOGGING_PROPERTIES_FILE = "conf/logging.properties";
	static {
		System.setProperty("java.util.logging.config.file", LOGGING_PROPERTIES_FILE);
	}

    private static final Logger log = LoggerFactory. getLogger(Slf4jTest.class);
	
	public static void main(String[] args) throws Exception {
		log.error("Error");
		log.warn("Warn");
		log.info("Info");
		log.debug("Debug");
	}
}
