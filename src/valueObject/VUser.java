package valueObject;

public class VUser {

	private String userId;
	private String userName;
	private String address;
	
	public VUser(String userId, String userName, String address) {
		this.userId = userId;
		this.userName = userName;
		this.address = address;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getAddress() {
		return address;
	}
	
}
