package com.trohalska.dependencyInjection;

public class MusicPlayer {
    private Music music;

    // IoC inversion of control
    public MusicPlayer(Music music) {
        this.music = music;
    }

    public void playMusic() {
        System.out.println("Playing: " + music.getSong());
    }

}
