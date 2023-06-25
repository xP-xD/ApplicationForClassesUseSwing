package applicationForClasses;

import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import contants.Constants;
import contants.Constants.EPLectureSelection;
import control.CLecture;
import valueObject.VLecture;

public class PLectureSelection extends JTable {

	private static final long serialVersionUID = 1L;

	private Vector<VLecture> vLectures;
	private CLecture cLecture;
	
	private DefaultTableModel tableModel;
	private PResult pPreRegisterForClasses;
	private PResult pRegisterForClasses;

	public PLectureSelection() {
		// data model
		Vector<String> header = new Vector<String>();
		
		for(EPLectureSelection title : Constants.EPLectureSelection.values()) {
			header.addElement(title.getText());
		}

		this.tableModel = new DefaultTableModel(header, 0);
		this.setModel(this.tableModel);
	}

	public void initialize(String fileName, PResult pPreRegisterForClasses, PResult pRegisterForClasses) {
		this.pPreRegisterForClasses = pPreRegisterForClasses;
		this.pRegisterForClasses = pRegisterForClasses;
		
		this.update(fileName);	
	}


	private void updateTableContents() {
		this.tableModel.setRowCount(0);
		
		
		
		for (VLecture vLecture : this.vLectures) {
			
			Vector<String> row = new Vector<String>();
			
			for(EPLectureSelection tableRow : EPLectureSelection.values()) {
				vLecture.setELectureContent();
				row.add(tableRow.getContent());
			}
						
			this.tableModel.addRow(row);
		}
		if (this.vLectures.size() > 0) {
			this.getSelectionModel().addSelectionInterval(0, 0);
		}

	}

	private void removeDuplicated(Vector<VLecture> vSelectedLectures) {
		for (int index = this.vLectures.size() - 1; index >= 0; index--) {
			for (VLecture vLecture : vSelectedLectures) {
				if (this.vLectures.get(index).getId().equals(vLecture.getId())) {
					this.vLectures.remove(index);
					break;
				}
			}
		}
	}

	public void update(String fileName) {
		this.cLecture = new CLecture();
		this.vLectures = this.cLecture.getData(fileName);
		
		this.removeDuplicated(this.pPreRegisterForClasses.getLectures());
		this.removeDuplicated(this.pRegisterForClasses.getLectures());
		
		this.updateTableContents();

	}

	public Vector<VLecture> removeSelectedLectures() {
		int[] indices = this.getSelectedRows();
		Vector<VLecture> vRemoveLectures = new Vector<VLecture>();

		for (int i = indices.length - 1; i >= 0; i--) {
			VLecture vRemoveLecture = this.vLectures.remove(indices[i]);
			vRemoveLectures.add(vRemoveLecture);
		}

		this.updateTableContents();
		
		return vRemoveLectures;
	}

}
