package com.epam.training;

import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;

public class JulLogTest {
	private static final String LOGGING_PROPERTIES_FILE = "conf/logging.properties";
	static java.util.logging.Logger log;
	static {
		System.setProperty("java.util.logging.config.file", LOGGING_PROPERTIES_FILE);
		log = java.util.logging.Logger.getLogger(JulLogTest.class.getName());
	}

	public static void main(String[] args) throws Exception {
		log.finest(log.getName());
		Set<Level> levels = getAllLevels();
		for (Level level : levels) {
			log.log(level, level.toString(), level.intValue());
		}
	}

	public static Set<Level> getAllLevels() throws IllegalAccessException {
		Class<Level> levelClass = Level.class;

		Set<Level> allLevels = new TreeSet<>(Comparator.comparingInt(Level::intValue));

		for (Field field : levelClass.getDeclaredFields()) {
			if (field.getType() == Level.class) {
				allLevels.add((Level) field.get(null));
			}
		}
		return allLevels;
	}
}
