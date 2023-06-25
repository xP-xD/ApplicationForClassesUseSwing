package valueObject;

import contants.Constants.EPLectureSelection;
import contants.Constants.EPResult;

public class VLecture {

	//immutable
	private String id;
	private String text;
	private String professor;
	private String credit;
	private String time;
	
	public VLecture(String id, String text, String professor, String credit,String time) {
		this.id = id;
		this.professor = professor;
		this.text = text;
		this.credit = credit;
		this.time = time;
	}
	
	public String getCredit() {
		return this.credit;
	}
	
	public String getId() {
		return id;
	}
	public String getProfessor() {
		return professor;
	}
	public String getText() {
		return text;
	}
	public String getTime() {
		return time;
	}
	
	public void setELectureContent() {
		EPLectureSelection.lectureNum.setContent(this.id);
		EPLectureSelection.lectureName.setContent(this.text);
		EPLectureSelection.professor.setContent(this.professor);
		EPLectureSelection.credit.setContent(this.credit);
		EPLectureSelection.time.setContent(this.time);
	}
	
	public void setEPResultContent() {
		EPResult.lectureName.setContent(this.text);
		EPResult.lectureNum.setContent(this.id);
	}
}
