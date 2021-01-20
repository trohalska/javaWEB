package a;

import java.util.Arrays;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class X {
	private static final Logger log = LogManager.getLogger(X.class);
	
	public void test() {
		System.out.println("Current log level " + log.getLevel());
		
		Level[] levels = Level.values();
		Arrays.sort(levels);
		for (Level l: levels) {
			log.log(l, l.toString() + " {}", l.intLevel());
		}
	
	}
}
