package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;

public class FileEncryptor {
	public static void main(String[] args) {

		// Create a program that takes a message from the user.
		// Use the methods in the String and Character classes to save
		// an encrypted form of the message to a file

		try {

			FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/text.txt", true);
			String write = JOptionPane.showInputDialog("What do you want to encrypt?");
			String enc = encrypt(write, "key");
			fw.write(enc);
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String encrypt(String strClearText, String strKey) throws Exception {
		String strData = "";

		try {
			SecretKeySpec skeyspec = new SecretKeySpec(strKey.getBytes(), "Blowfish");
			Cipher cipher = Cipher.getInstance("Blowfish");
			cipher.init(Cipher.ENCRYPT_MODE, skeyspec);
			byte[] encrypted = cipher.doFinal(strClearText.getBytes());
			strData = new String(encrypted);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return strData;
	}

}
