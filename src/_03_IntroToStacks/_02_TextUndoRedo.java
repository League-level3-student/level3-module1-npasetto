package _03_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.*;

public class _02_TextUndoRedo implements KeyListener {
	/* 
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character is erased from the JLabel.
	 * Save that deleted character onto a Stack of Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed, the top Character is popped 
	 * off the Stack and added back to the JLabel.
	 * 
	 * */
	JFrame frame=new JFrame();
	JPanel panel=new JPanel();
	JLabel label=new JLabel();
	Stack<Character> characters=new Stack<Character>();
	public static void main(String[] args) {
		_02_TextUndoRedo t=new _02_TextUndoRedo();
		t.setup();
	}
	public void setup() {
		frame.setVisible(true);
		label.setText("");
		panel.add(label);
		frame.add(panel);
		frame.addKeyListener(this);
		frame.pack();
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode()==KeyEvent.VK_BACK_SPACE) {
			if(!label.getText().equals("")) {
			characters.push(label.getText().charAt(label.getText().length()-1));
			label.setText(label.getText().substring(0, label.getText().length()-1));
			}
			}else if(arg0.getKeyCode()==KeyEvent.VK_SHIFT){
				if(characters.size()>0) {
				label.setText(label.getText()+characters.pop());
				}
			}else {
			label.setText(label.getText()+arg0.getKeyChar());
			}
		
		frame.pack();
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}
}
