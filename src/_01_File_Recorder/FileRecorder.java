package _01_File_Recorder;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileRecorder {
	public static void main(String[] args) {

		// Create a program that takes a message from the user and saves it to a file.
		try {
			FileWriter fw = new FileWriter("src/_01_File_Recorder/text.txt");
			fw.write(JOptionPane.showInputDialog("What to write to file??"));
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
