package model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import valueObject.VLecture;

public class MLecture {

	private Scanner scanner;
	private FileWriter fileWriter;
	
	private String id;
	private String text;
	private String professor;
	private String credit;
	private String time;
	
	public MLecture(Scanner scanner) {
		this.scanner = scanner;
	}
	
	public MLecture(VLecture vLecture, FileWriter fileWriter) {
		this.fileWriter = fileWriter;
		
		this.id = vLecture.getId();
		this.text = vLecture.getText();
		this.professor = vLecture.getProfessor();
		this.credit = vLecture.getCredit();
		this.time = vLecture.getTime();
		
	}

	public void read() {
		this.id = scanner.next();
		this.text = scanner.next();
		this.professor = scanner.next();
		this.credit = scanner.next();
		this.time = scanner.next();
	}
	
	public void save() {
		try {
			this.fileWriter.write(this.id+" ");
			this.fileWriter.write(this.text+" ");
			this.fileWriter.write(this.professor+" ");
			this.fileWriter.write(this.credit+" ");
			this.fileWriter.write(this.time+"\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getId() {
		return this.id;
	}
	public String getProfessor() {
		return this.professor;
	}
	public String getText() {
		return this.text;
	}
	public String getTime() {
		return this.time;
	}

	public String getCredit() {
		return this.credit;
	}
	
}
