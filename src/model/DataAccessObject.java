package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import valueObject.VLecture;
import valueObject.VUser;

public class DataAccessObject {

	public MLogin getLogin(String userId) {

		Scanner scanner = null;

		try {
			scanner = new Scanner(new File("userInfo/userId"));
			MLogin mLogin = new MLogin(scanner, userId);
			while (scanner.hasNext()) {
				boolean found = mLogin.read();
				if (found) {
					return mLogin;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			scanner.close();
		}

		return null;
	}

	public VUser getUser(String userId) {
		
		Scanner scanner = null;

		try {
			scanner = new Scanner(new File("userInfo/"+ userId));
			MUser mUser = new MUser(scanner, userId);
			while (scanner.hasNext()) {
				VUser vUser = mUser.read();
				if (vUser != null) {
					return vUser;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			scanner.close();
		}

		return null;
	}

	public Vector<MDirectory> getDirectoies(String fileName) {
		Vector<MDirectory> mDirectories = new Vector<MDirectory>();
		try {
			Scanner scanner = new Scanner(new File("lectureInfo/"+ fileName));
			while(scanner.hasNext()) {
				MDirectory mDirectory = new MDirectory(scanner);
				mDirectory.read(); 
				mDirectories.add(mDirectory);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return mDirectories;
	}

	public Vector<MLecture> getVLectures(String fileName) {
		Vector<MLecture> mLectures = new Vector<MLecture>();
		try {
			Scanner scanner = new Scanner(new File("lectureInfo/"+ fileName));
			while(scanner.hasNext()) {
				MLecture mLecture = new MLecture(scanner);
				mLecture.read(); 
				mLectures.add(mLecture);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return mLectures;
	}

	public void saveResults(String fileName, Vector<VLecture> vLectures) {
		
		try {
			FileWriter fileWriter = new FileWriter(new File("userInfo/"+fileName));
			for(VLecture vLecture : vLectures) {
				MLecture mLecture = new MLecture(vLecture, fileWriter);
				mLecture.save();
			}
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public Vector<MLecture> getResults(String fileName) {
		Vector<MLecture> mLectures = new Vector<MLecture>();
		try {
			Scanner scanner = new Scanner(new File("userInfo/"+ fileName));
			while(scanner.hasNext()) {
				MLecture mLecture = new MLecture(scanner);
				mLecture.read(); 
				mLectures.add(mLecture);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return mLectures;
	}
	
}
