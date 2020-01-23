package _04_HangMan;

import java.util.Stack;

import javax.swing.*;

public class HangMan{
	JFrame frame=new JFrame();
	JPanel panel=new JPanel();
	JLabel label=new JLabel();
	Utilities u=new Utilities();
	Stack<String> words=new Stack<String>();
	public static void main(String[] args) {
		HangMan h=new HangMan();
		h.start();
	}
	public void start() {
		int wordNumber=Integer.parseInt(JOptionPane.showInputDialog("Enter a number"));
		for (int i = 0; i < wordNumber; i++) {
			
		}
	}
}
