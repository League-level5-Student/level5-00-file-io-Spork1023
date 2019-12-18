package _02_File_Encrypt_Decrypt;

import java.io.FileReader;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;

public class FileDecryptor {
	// Create a program that opens the file created by FileEncryptor and display
	// the decrypted message to the user in a JOptionPane.
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("src/_02_File_Encrypt_Decrypt/text.txt");
			int c = fr.read();
			String encrypted = "";
			while(c != -1) {
				encrypted += "" + (char) c;
				c = fr.read();
			}
			String decrypted = decrypt(encrypted, "key");
			JOptionPane.showMessageDialog(null, "The decrypted message is " + decrypted);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static String decrypt(String strEncrypted, String strKey) throws Exception {
		String strData = "";

		try {
			SecretKeySpec skeyspec = new SecretKeySpec(strKey.getBytes(), "Blowfish");
			Cipher cipher = Cipher.getInstance("Blowfish");
			cipher.init(Cipher.DECRYPT_MODE, skeyspec);
			byte[] decrypted = cipher.doFinal(strEncrypted.getBytes());
			strData = new String(decrypted);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return strData;
	}
}
