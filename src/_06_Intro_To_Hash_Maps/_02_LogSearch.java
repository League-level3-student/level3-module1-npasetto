package _06_Intro_To_Hash_Maps;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.*;

public class _02_LogSearch implements ActionListener {
  /* 
	 * Crate a HashMap of Integers for the keys and Strings for the values.
	 * Create a GUI with three buttons. 
	 * Button 1: Add Entry
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				After an ID is entered, use another input dialog to ask the user to enter a name.
	 * 				Add this information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				If that ID exists, display that name to the user.
	 * 				Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List
	 * 				When this button is clicked, display the entire list in a message dialog in the following format:
	 * 				ID: 123  Name: Harry Howard
	 * 				ID: 245  Name: Polly Powers
	 * 				ID: 433  Name: Oliver Ortega
	 * 				etc...
	 * 
	 * When this is complete, add a fourth button to your window.
	 * Button 4: Remove Entry
	 * 				When this button is clicked, prompt the user to enter an ID using an input dialog.
	 * 				If this ID exists in the HashMap, remove it. Otherwise, notify the user that the ID
	 * 				is not in the list. 
	 *
	 * */
	HashMap<Integer,String> map=new HashMap<Integer,String>();
	JFrame frame=new JFrame();
	JPanel panel=new JPanel();
	JButton button1=new JButton();
	JButton button2=new JButton();
	JButton button3=new JButton();
	JButton button4=new JButton();
	public static void main(String[] args) {
		_02_LogSearch l = new _02_LogSearch();
		l.start();
	}
	public void start() {
		frame.setVisible(true);
		frame.add(panel);
		button1.setPreferredSize(new Dimension(150,30));
		button1.addActionListener(this);
		button2.setPreferredSize(new Dimension(150,30));
		button2.addActionListener(this);
		button3.setPreferredSize(new Dimension(150,30));
		button3.addActionListener(this);
		button4.setPreferredSize(new Dimension(150,30));
		button4.addActionListener(this);
		button1.setText("Add Entry");
		button2.setText("Search by ID");
		button3.setText("View List");
		button4.setText("Remove Entry");
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		frame.pack();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==button1) {
			int id=Integer.parseInt(JOptionPane.showInputDialog("Enter an id"));
			String name=JOptionPane.showInputDialog("Enter a name");
			map.put(id, name);
		}else if(arg0.getSource()==button2) {
			int id=Integer.parseInt(JOptionPane.showInputDialog("Enter an id"));
			String answer=map.get(id);
			if(answer==null) {
				JOptionPane.showMessageDialog(null, "Id not found");
			}else {
				JOptionPane.showMessageDialog(null, answer);
			}
		}else if(arg0.getSource()==button3) {
			String str="";
			for (int key : map.keySet()) {
				str+="ID: "+key+" Name: "+map.get(key)+"\n";
			}
			JOptionPane.showMessageDialog(null, str);
		}else if(arg0.getSource()==button4) {
			int id=Integer.parseInt(JOptionPane.showInputDialog("Enter an id"));
			if(map.containsKey(id)) {
				map.remove(id);
			}else {
				JOptionPane.showMessageDialog(null, "Id not found");
			}
		}
		
	}
}
