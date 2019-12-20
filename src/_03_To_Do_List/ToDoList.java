package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ToDoList implements ActionListener, Runnable {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save
	 * list, and load list.
	 * 
	 * When add task is clicked: ask the user for a task and save it to an array
	 * list
	 * 
	 * When the view tasks button is clicked: show all the tasks in the list
	 * 
	 * When the remove task button is clicked: prompt the user for which task to
	 * remove and take it off of the list.
	 * 
	 * When the save list button is clicked: Save the list to a file
	 * 
	 * When the load list button is clicked: Prompt the user for the location of the
	 * file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file
	 * into the list.
	 */
	JFrame f = new JFrame();
	JPanel p = new JPanel();
	JButton add = new JButton("add");
	JButton view = new JButton("view");
	JButton remove = new JButton("remove");
	JButton save = new JButton("save");
	JButton load = new JButton("load");

	ArrayList<String> list = new ArrayList<String>();

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new ToDoList());
	}

	private void JStuff() {
		f.add(p);
		p.add(add);
		p.add(view);
		p.add(remove);
		p.add(save);
		p.add(load);

		f.setVisible(true);
		f.pack();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add.addActionListener(this);
		view.addActionListener(this);
		remove.addActionListener(this);
		save.addActionListener(this);
		load.addActionListener(this);

	}

	public void run() {
		try {
			JStuff();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			BufferedReader bf = new BufferedReader(new FileReader("src/_03_To_Do_List/list.txt"));

			if (e.getSource() == add) {
				list.add(JOptionPane.showInputDialog("What would you like to add to your ToDoList?"));
			} else if (e.getSource() == view) {
				String show = "";
				for (int i = 0; i < list.size(); i++) {
					show += "\n" + list.get(i);
				}
				JOptionPane.showMessageDialog(null, "Here is your ToDoList: " + show);
			} else if (e.getSource() == remove) {
				String rem = JOptionPane.showInputDialog("What would you like to remove form your list");
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).equals(rem)) {
						list.remove(i);
					}
				}
			} else if (e.getSource() == save) {
				FileWriter fw = new FileWriter("src/_03_To_Do_List/list.txt");
				fw.write(list.size() + "\n");
				for (int i = 0; i < list.size(); i++) {
					fw.write(list.get(i) + "\n");
				}
				fw.close();
			} else if (e.getSource() == load) {
				int stop = Integer.parseInt(bf.readLine());
				for (int i = 0; i < stop; i++) {
					list.add(bf.readLine());
				}
			}

		} catch (Exception err) {
			err.printStackTrace();
		}
	}
}
