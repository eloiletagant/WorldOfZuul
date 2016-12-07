import java.io.File;
import java.net.URL;

import javax.sound.sampled.*;
/*
 * This class manages the song of the game.
 * Group 4
 * 01/12/2016
 */

public class Sound {
	
	/**
	 * This method launch the song. 
	 * @param url way of the song
	 */
	public synchronized void playSound(String path) {
		  
		  URL url = this.getClass().getResource(path);		  
		  
		  new Thread(new Runnable() {
		    public void run() {
		      try {
		        Clip clip = AudioSystem.getClip();
		        AudioInputStream inputStream = AudioSystem.getAudioInputStream(url);
		        clip.open(inputStream);
		        clip.loop(Clip.LOOP_CONTINUOUSLY);
		        clip.start(); 
		      } catch (Exception e) {
		        System.err.println(e.getMessage());
		      }
		    }
		  }).start();
		}
}