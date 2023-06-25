package applicationForClasses;

import java.util.Vector;

import javax.swing.JPanel;

import valueObject.VLecture;

public abstract class PLectureContanier extends JPanel {

	private static final long serialVersionUID = 1L;

	public abstract Vector<VLecture> removeSelectedLectures();
	public abstract void addLectures(Vector<VLecture> vSelectedLectures);

}
