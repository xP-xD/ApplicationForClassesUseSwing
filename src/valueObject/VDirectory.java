package valueObject;

public class VDirectory {

	private String name;
	private String fileName;
	
	//immutable Value 값을 설정하면 변하지 않음
	public VDirectory(String name, String fileName) {
		this.name = name;
		this.fileName = fileName;
	}
	
	public String getName() {
		return name;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	
	
	
}
