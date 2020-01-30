package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.*;
public class HangMan implements KeyListener{
	JFrame frame=new JFrame();
	JPanel panel=new JPanel();
	JLabel label=new JLabel();
	Utilities u=new Utilities();
	Stack<String> words=new Stack<String>();
	int lives=20;
	String currentWord;
	public static void main(String[] args) {
		HangMan h=new HangMan();
		h.start();
	}
	public void start() {
		lives=20;
		int wordNumber=Integer.parseInt(JOptionPane.showInputDialog("Enter a number"));
		for (int i = 0; i < wordNumber; i++) {
			String word=u.readRandomLineFromFile("dictionary.txt");
			while(words.contains(word)) {
				word=u.readRandomLineFromFile("dictionary.txt");
			}
			words.push(word);
		}
		frame.setVisible(true);
		frame.add(panel);
		panel.add(label);
		label.setText("");
		currentWord=words.pop();
		for (int i = 0; i < currentWord.length(); i++) {
			label.setText(label.getText()+"_");
		}
		frame.addKeyListener(this);
		frame.pack();
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		boolean replaced=false;
		for (int i = 0; i < currentWord.length(); i++) {
			if(currentWord.charAt(i)==e.getKeyChar()) {
				label.setText(label.getText().substring(0,i)+currentWord.charAt(i)+label.getText().substring(i+1));
				replaced=true;
			}
		}
		if(replaced==false) {
			lives--;
			if(lives==0) {
				JOptionPane.showMessageDialog(null, "Game over.");
				int ask=JOptionPane.showConfirmDialog(null, "Do you want to play again?");
				if(ask==JOptionPane.YES_OPTION) {
					start();
				}else {
					System.exit(0);
				}
			}
		}else if(!label.getText().contains("_")) {
			JOptionPane.showMessageDialog(null, "You won!");
			label.setText("");
			currentWord=words.pop();
			for (int i = 0; i < currentWord.length(); i++) {
				label.setText(label.getText()+"_");
			}
			frame.pack();
			lives=20;
		}
		
	}
}
