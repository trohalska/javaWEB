package com.epam.training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.*;


public class Log4jTest {
    private static final Logger log = LogManager.getLogger(Log4jTest.class);
    public static final Marker EXCEPTION = MarkerManager.getMarker("EXCEPTION");
    public static final Marker FLOW = MarkerManager.getMarker("EXCEPTION");

    public static void main(String[] args) {
    	test(log);
//    	log.debug("Message {} - {} - {}", 10, 20, 30 );
//    	log.info("Text");
		testLogHierarchy();
//		testException();
//		testMultiThreadedLog();
//        testRollingFile();
    }

    private static void testLogHierarchy() {
        a.X x1 = new a.X();
        a.b.X x2 = new a.b.X();
        a.b.c.X x3 = new a.b.c.X();
        System.out.println("~~~~~~~~ a.X");
        x1.test();
        System.out.println("~~~~~~~~ a.b.X");
        x2.test();
        System.out.println("~~~~~~~~ a.b.c.X");
        x3.test();
    }

    public static void test(Logger log) {
        System.out.println("Current log level " + log.getName() + " " + log.getLevel());
        System.out.println(log.getName());

        Level[] levels = Level.values();
        Arrays.sort(levels);
        for (Level l : levels) {
            log.log(l, l.toString() + " {}", l.intLevel());
        }
    }

    public static void testException() {
        try {
            throw new Exception("Some exception");
        } catch (Exception e) {
            log.error("Exception occurs", e);
        }
    }

    public static void testMultiThreadedLog() {
        List<Thread> threads = new ArrayList<>();
        final int N = 10;
        for (int i = 0; i < N; i++) {
            threads.add(new Thread(() -> {
                log.debug(FLOW, "Starting thread execution");
                try {
                    throw new Exception("Some exception");
                } catch (Exception e) {
                    log.error(EXCEPTION, "Exception occurs", e);
                    log.debug(FLOW, "Thread execution aborted");
                }
                log.debug(FLOW, "Finishing thread execution");
            }));
        }
        for (Thread t : threads) {
			t.start();
        }
    }

    public static void testRollingFile() {
        final int n = 20;
        a.X ax = new a.X();
        a.b.X bx = new a.b.X();
        a.b.c.X cx = new a.b.c.X();
        for (int i = 0; i < n; i++) {
            ax.test();
            bx.test();
            cx.test();
        }
    }
}
