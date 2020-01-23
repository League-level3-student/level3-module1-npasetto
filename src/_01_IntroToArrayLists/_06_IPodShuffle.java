package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import java.util.Random;

import javax.swing.*;


//Copyright The League of Amazing Programmers, 2015

public class _06_IPodShuffle implements ActionListener{
	JFrame frame=new JFrame();
	JButton button=new JButton();
	ArrayList<Song> songs=new ArrayList<Song>();
	Song song1=new Song("demo.mp3");
	
	Song song2=new Song("sound.mp3");
	
	Song song3=new Song("sound2.mp3");
	
	Song song4=new Song("sound3.mp3");
	
	public _06_IPodShuffle() {
		// 1. Use the Song class the play the demo.mp3 file.
		songs.add(song1);
		songs.add(song2);
		songs.add(song3);
		songs.add(song4);
		frame.setVisible(true);
		frame.add(button);
		button.addActionListener(this);
		button.setText("Surprise Me!");
		frame.pack();
		/**
		 * 2. Congratulations on completing the sound check! * Now we want to make an
		 * iPod Shuffle that plays random music. * Create an ArrayList of Songs and a
		 * "Surprise Me!" button that will play a random song when it is clicked. * If
		 * you're really cool, you can stop all the songs, before playing a new one on
		 * subsequent button clicks.
		 */
		
	}
	
	public static void main(String[] args) {
		new _06_IPodShuffle();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		for (int i = 0; i < songs.size(); i++) {
			songs.get(i).stop();
		}
		songs.get(new Random().nextInt(3)).play();
		
	}
}