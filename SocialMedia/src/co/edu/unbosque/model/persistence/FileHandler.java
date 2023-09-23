package co.edu.unbosque.model.persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileHandler {
	
public static boolean isEmpty(File file) {
		
		boolean resp = false;
		try {
            BufferedReader br = new BufferedReader(new FileReader("src\\co\\edu\\unbosque\\model\\persistence\\" + file));
            if (br.readLine() == null) {
            	resp = true;
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
		return resp;
		
	}

	public static Object readObject(File file) {
		File url = new File("src\\co\\edu\\unbosque\\model\\persistence\\" + file);
		if(!url.exists()) {
			try {
				url.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Object obj = null;
		try {

			FileInputStream fis = new FileInputStream(url);
			ObjectInputStream ois = new ObjectInputStream(fis);
			obj = ois.readObject();
			ois.close();
			fis.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;

	}
	
	public static void writeObject(Object obj, File file) {
		File url = new File("src\\co\\edu\\unbosque\\model\\persistence\\" + file);
		try {
		FileOutputStream fos = new FileOutputStream(url);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(obj);
		oos.close();
		fos.close();
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
