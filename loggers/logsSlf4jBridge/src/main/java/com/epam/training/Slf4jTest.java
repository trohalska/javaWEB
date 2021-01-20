package com.epam.training;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jTest {
    private static final Logger log = LoggerFactory. getLogger(Slf4jTest.class);
	
	public static void main(String[] args) throws Exception {
		log.error(log.getName());
		log.error("Error");
		log.warn("Warn");
		log.info("Info");
		log.debug("Debug");
	}
}
