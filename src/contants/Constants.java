package contants;

public class Constants {

	public enum Econfiguration{
		
		preRegisterForClassesFilePostfix("P"),
		registerForClassesFilePostfix("R"),
		rootFileName("root");
		
		private String text;

		Econfiguration(String text) {
			this.text = text;
		}

		public String getText() {
			return text;
		}

		public int getInt() {
			return Integer.parseInt(text);
		}
	}
	
	//loginDialog
	public enum ELoginDialog {

		WIDTH("300"), HEIGHT("200"), NAME_LABEL(" 아이디 "), SIZE_NAME_TEXT("10"), PASSWORD_LABEL("비밀번호"),
		SIZE_PASSWORD_TEXT("10"), OK_BUTTON_LABEL("Ok"), CANCEL_BUTTON_LABEL("Cancel"),
		noAccountInfo("회원정보가 존재하지 않습니다"),
		loginFailed("비밀번호가 틀렸습니다"),
		systemError("시스템 오류");

		private String text;

		ELoginDialog(String text) {
			this.text = text;
		}

		public String getText() {
			return text;
		}

		public int getInt() {
			return Integer.parseInt(text);
		}
	}

	// MainFrame
	public enum EMainFrame {

		WIDTH("1000"), HEIGHT("600");

		private String text;
		EMainFrame(String text) {
			this.text = text;
		}

		public String getText() {
			return text;
		}

		public int getInt() {
			return Integer.parseInt(text);
		}

	}

	// MenuBar
	public enum EMenuBar {

		FILE("File"), EDIT("Edit");

		private String text;

		EMenuBar(String text) {
			this.text = text;
		}

		public String getText() {
			return text;
		}

	}

	public enum EFileMenu {

		NEW("new"), OPEN("open"), SAVE("save"), SAVE_AS("save-as"), PRINT("print"), EXIT("exit");

		private String text;

		EFileMenu(String text) {
			this.text = text;
		}

		public String getText() {
			return text;
		}

	}

	public enum EEditMenu {

		COPY("copy"), CUT("cut"), PASTE("paste"), DELETE("delete");

		private String text;

		EEditMenu(String text) {
			this.text = text;
		}

		public String getText() {
			return text;
		}

	}

	// ToolBar
	public enum EToolBar {

		REAl_APPLICATION_ClASSES("RealApplicationClasses"), PRE_APPLICATION_ClASSES("PreApplicationForClasses"),
		PERSONALINFO("PersonalInfo"), GRADE("Grade");

		private String text;

		EToolBar(String text) {
			this.text = text;
		}

		public String getText() {
			return text;
		}

	}
	
	public enum EDirectory{
		
		campus("캠퍼스"),
		college("대학"),
		major("학과");
		
		private String text;

		EDirectory(String text) {
			this.text = text;
		}

		public String getText() {
			return text;
		}

		public int getInt() {
			return Integer.parseInt(text);
		}
	}
	
	public enum EPLectureSelection{
		
		lectureNum("강좌번호","getId"),
		lectureName("강좌명", "getText"),
		professor("담당교수", "getProfessor"),
		credit("학점", "getCredit"),
		time("시간", "getTime");
		
		private String text;
		private String content;

		EPLectureSelection(String text, String content) {
			this.text = text;
			this.content = content;
		}

		public String getText() {
			return text;
		}
		
		public String getContent() {
			return this.content;
		}
		
		public void setContent(String content) {
			this.content = content;
		}

		public int getInt() {
			return Integer.parseInt(text);
		}
		
	}
	
	public enum EPResult{
		lectureNum("강좌번호", "getId"),
		lectureName("강좌명", "getText");
		
		private String text;
		private String content;

		EPResult(String text, String content) {
			this.text = text;
			this.content = content;
		}

		public String getText() {
			return text;
		}
		
		public String getContent() {
			return this.content;
		}
		
		public void setContent(String content) {
			this.content = content;
		}

		public int getInt() {
			return Integer.parseInt(text);
		}
	}
	
//	public enum ELecture{
//		lectureNum("강좌번호","강좌명");
//		
//		private String text;
//		private String text2;
//
//		ELecture(String text, String text2) {
//			this.text = text;
//			this.text2 = text2;
//		}
//		
//		public void setText(String text) {
//			this.text = text;
//		}
//
//		public String getText() {
//			return text;
//		}
//
//		public int getInt() {
//			return Integer.parseInt(text);
//		}
//	}

	
}
