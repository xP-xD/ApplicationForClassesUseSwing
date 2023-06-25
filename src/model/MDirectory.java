package model;

import java.util.Scanner;

public class MDirectory {

	private Scanner scanner;
	
	private String id;
	private String name;
	private String fileName;
	
	public MDirectory(Scanner scanner) {
		this.scanner = scanner;
	}
	
	public void read() {
		this.id = scanner.next();
		this.name = scanner.next();
		this.fileName = scanner.next();
	}
	
	public String getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public String getFileName() {
		return this.fileName;
	}
	
}
