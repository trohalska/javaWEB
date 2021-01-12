package com.trohalska.dependencyInjection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                        "applicationContext.xml");

//        Music music = context.getBean("musicBeanDI", Music.class);
//        MusicPlayer mp = new MusicPlayer(music);

        MusicPlayer mp = context.getBean("musicPlayer", MusicPlayer.class);
        mp.playMusic();

        context.close();
    }
}
