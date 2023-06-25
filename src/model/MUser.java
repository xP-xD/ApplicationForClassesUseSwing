package model;

import java.util.Scanner;

import valueObject.VUser;

public class MUser {

	private String userId;
	private String userName;
	private String address;
	private Scanner scanner;
	
	public MUser(Scanner scanner, String userId) {
		this.userId = userId;
		this.scanner = scanner;
	}

	public VUser read() {
		String userId = scanner.next();
		this.userName = scanner.next();
		this.address = scanner.next();
		
		if(this.userId.contentEquals(userId)) {
			VUser vUser = new VUser(this.userId, this.userName, this.address);
			return vUser;
		}
		
		return null;
	}

	
}
