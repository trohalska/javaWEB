package com.epam.training;

import java.util.Arrays;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Log4jTest {
    private static final Logger log = LogManager.getLogger(Log4jTest.class);

    public static void main(String[] args) {
		log.fatal(log.getName());
        Level[] levels = Level.values();
        Arrays.sort(levels);
        for (Level l : levels) {
            log.log(l, l.toString() + " {}", l.intLevel());
        }
    }
}
