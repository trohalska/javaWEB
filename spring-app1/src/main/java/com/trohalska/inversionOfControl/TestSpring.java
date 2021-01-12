package com.trohalska.inversionOfControl;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                        "applicationContext.xml");

        Music music = context.getBean("musicBeanIoC", Music.class);

        MusicPlayer mp = new MusicPlayer(music);

        mp.playMusic();

        context.close();
    }
}
