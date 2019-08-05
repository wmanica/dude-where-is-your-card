package org.academiadecodigo.whiledcards.dudewhereisyourcard;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.InputStream;

public class Audio {

    public void runAudio() {
        try {
            ClassLoader classLoader = Audio.class.getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream("song.wav");

                Clip clip = AudioSystem.getClip();
                AudioInputStream ais = AudioSystem.getAudioInputStream(new BufferedInputStream(inputStream));
                clip.open(ais);
                clip.start();
        } catch (Exception ex) {
            System.out.println("NOT");
        }
    }

}
