/* 
Name: Vinod Vairavaraj and Thomas Nghiem
Email: vinod.vairavaraj@gmail.com, thomasnghiem2@gmail.com
Sources used: StackOverflow

This file creates the background music. 
*/
import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;
/**
 * This class creates the background music
 */
public class Sound {
    private URL url;
    private Clip clip;
/**
 * @param requestedSound The requested type of sound
 */
public Sound(String requestedSound) {
    url = this.getClass().getResource(requestedSound);
    if (url != null) {
        try {
            // Open an audio input stream.
            // Get a sound clip resource.
            // Open audio clip and load samples from the audio input stream.
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(url);
            clip = AudioSystem.getClip();
            clip.open(audioInput);


        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }

    }
}

/**
 * Plays the sound
 */
public void play() {
    clip.setFramePosition(0);
    clip.start();
}
}