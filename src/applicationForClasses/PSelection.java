package applicationForClasses;

import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;

import valueObject.VLecture;

public class PSelection extends PLectureContanier {

	private static final long serialVersionUID = 1L;

	private PMajorSelection pMajorSelection;
	private PLectureSelection pLectureSelection;

	public PSelection(ListSelectionListener listSelectionHandler ) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.pMajorSelection = new PMajorSelection(listSelectionHandler);
		this.add(pMajorSelection);
		
		JScrollPane scrollPane = new JScrollPane();
		this.pLectureSelection = new PLectureSelection();
		scrollPane.setViewportView(this.pLectureSelection);
		this.add(scrollPane);
	}
	
	public void initialize(PResult pPreRegisterForClasses, PResult pRegisterForClasses) {
		this.pMajorSelection.initialize();
		String fileName = this.pMajorSelection.getFileName();
		this.pLectureSelection.initialize(fileName, pPreRegisterForClasses, pRegisterForClasses);
	}
	
	public void updateLectures(Object source) {
		String majorFileName = this.pMajorSelection.update(source);
		this.pLectureSelection.update(majorFileName);
	}
	
	@Override
	public void addLectures(Vector<VLecture> vSelectedLectures) {
		String fileName = this.pMajorSelection.getFileName();
		this.pLectureSelection.update(fileName);
	}
	
	@Override
	public Vector<VLecture> removeSelectedLectures() {
		return this.pLectureSelection.removeSelectedLectures();
	}

}
