import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class PlayMusic 
{

	 // lagra nuvarande tillstånd
	static Long currentFrame;
	static Clip clip;

	// nuvarande tillstånd clip
	static String status;

	AudioInputStream audioInputStream;
	static String filePath;
	static String Name = "";

	// konstruktor för att initiera strömmar och clip
	public PlayMusic() throws UnsupportedAudioFileException,IOException, LineUnavailableException {
		
		filePath = "C:\\Users\\anton\\Documents\\Algoritmer och datastruktur\\MiniProject\\src\\songLibrary\\" + Name;
		
		audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());

		// skapa clip referens
		clip = AudioSystem.getClip();

		// öppna audioInputStream till clip
		clip.open(audioInputStream);

		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
}
