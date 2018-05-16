import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.DropMode;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.TextArea;

public class Frame {

	private String artistName;
	private String songName;
	private JFrame frmMusicplayer;
	private JTextField txtArtist;
	private JTextField txtSong;
	private JTextArea textAreaXd;
	private JLabel lblNewLabel;
	private final static String newline = "\n";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame window = new Frame();
					window.frmMusicplayer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMusicplayer = new JFrame();
		frmMusicplayer.setTitle("Musicplayer");
		frmMusicplayer.setBounds(100, 100, 637, 465);
		frmMusicplayer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMusicplayer.getContentPane().setLayout(null);

		JTextArea textAreaXd = new JTextArea();
		textAreaXd.setEditable(false);
		textAreaXd.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textAreaXd.setBounds(324, 30, 272, 353);
		frmMusicplayer.getContentPane().add(textAreaXd);

		JLabel lblNewLabel = new JLabel("Song Playing\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(43, 304, 210, 41);
		frmMusicplayer.getContentPane().add(lblNewLabel);

		txtArtist = new JTextField();
		txtArtist.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtArtist.setText(" Artist...");
		txtArtist.setBounds(43, 30, 210, 49);
		frmMusicplayer.getContentPane().add(txtArtist);
		txtArtist.setColumns(10);

		txtSong = new JTextField();
		txtSong.setText(" Song...");
		txtSong.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtSong.setColumns(10);
		txtSong.setBounds(43, 159, 210, 49);
		frmMusicplayer.getContentPane().add(txtSong);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					MusikSpelarVerktyg.readAllFiles();
					artistName = txtArtist.getText();
					//System.out.println(artistName);
					textAreaXd.setText("");
					String[] artistSongs = MusikSpelarVerktyg.findArtist(artistName);

					for(int i = 0; i < artistSongs.length; i++)
					{
						if(artistSongs[i] != null) {
							textAreaXd.append(artistSongs[i] + newline);
						}
					}
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Please enter a artist that is valid");
				}
			}
		});
		btnSearch.setBounds(98, 92, 97, 25);
		frmMusicplayer.getContentPane().add(btnSearch);

		JButton button = new JButton("Choose");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				try {
					MusikSpelarVerktyg.readAllFiles();
					songName = txtSong.getText();
					//System.out.println(songName);
					lblNewLabel.setText(MusikSpelarVerktyg.findSong(songName));
					PlayMusic.Name = MusikSpelarVerktyg.findSong(songName);

				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Please enter a song that is valid");
				}
			}
		});
		button.setBounds(98, 221, 97, 25);
		frmMusicplayer.getContentPane().add(button);

		JButton btnStart = new JButton("Play");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PlayMusic audioPlayer = new PlayMusic();
					PlayMusic.clip.start();
				}
				catch(Exception e2){
					JOptionPane.showMessageDialog(null, "Non existing sound file");
				}
			}
		});
		btnStart.setBounds(43, 358, 97, 25);
		frmMusicplayer.getContentPane().add(btnStart);

		JButton btnPause = new JButton("Stop");
		btnPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {					
					PlayMusic.currentFrame = 0L;
					PlayMusic.clip.stop();
					PlayMusic.clip.close();
				}
				catch(Exception e2){
					JOptionPane.showMessageDialog(null, "No can do");
				}
			}
		});
		btnPause.setBounds(152, 358, 97, 25);
		frmMusicplayer.getContentPane().add(btnPause);


	}
}
