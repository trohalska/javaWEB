package com.epam.training;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;

public class JulLogTest {
	private static final String LOGGING_PROPERTIES_FILE = "conf/logging.properties";
	static java.util.logging.Logger julLog;
	
	// logger configuration
	static {
		System.setProperty("java.util.logging.config.file", LOGGING_PROPERTIES_FILE);
		julLog = java.util.logging.Logger.getLogger(JulLogTest.class.getName());
	}

	// alternate logger configuration
//	static {
//		try {
//			java.util.logging.LogManager.getLogManager().readConfiguration(new FileInputStream(LOGGING_PROPERTIES_FILE));
//			julLog = java.util.logging.Logger.getLogger(JulLogTest.class.getName());
//		} catch (SecurityException | IOException e) {
//			e.printStackTrace();
//		}
//	}
	
	public static void main(String[] args) throws Exception {
		julLog.log(Level.FINER, "main start");
		Set<Level> levels = getAllLevels();
		for (Level level : levels) {
			julLog.log(level, level.toString(), level.intValue());
		}
	}

	public static Set<Level> getAllLevels() throws IllegalAccessException {
        Class<Level> levelClass = Level.class;

        Set<Level> allLevels = new TreeSet<>(
                Comparator.comparingInt(Level::intValue));

        for (Field field : levelClass.getDeclaredFields()) {
            if (field.getType() == Level.class) {
                allLevels.add((Level) field.get(null));
            }
        }
        return allLevels;
    }
}

