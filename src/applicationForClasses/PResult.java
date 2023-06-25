package applicationForClasses;

import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import contants.Constants.EPLectureSelection;
import contants.Constants.EPResult;
import control.CResult;
import valueObject.VLecture;

public class PResult extends PLectureContanier {

	private static final long serialVersionUID = 1L;

	private JTable table;
	private DefaultTableModel tableModel;
	private Vector<VLecture> vLectures;
	

	public PResult() {

		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		this.table = new JTable();
		JScrollPane scrollpane = new JScrollPane();
		scrollpane.setViewportView(this.table);
		this.add(scrollpane);
		
		//data model
		Vector<String> header = new Vector<String>();
		
		for(EPResult title : EPResult.values()) {
			header.addElement(title.getText());
		}
		
		this.tableModel = new DefaultTableModel(header,0);
		this.table.setModel(this.tableModel);
		
		this.vLectures = new Vector<VLecture>();
	}

	public void initialize(String fileName) {
		CResult cResult = new CResult();
		this.vLectures = cResult.get(fileName);
		this.updateTableData();
	}
	
	public Vector<VLecture> getLectures() {
		// TODO Auto-generated method stub
		return this.vLectures;
	}
	
	public void save(String fileName) {
		CResult cResult = new CResult();
		cResult.save(fileName, this.vLectures);
	}
	
	private void updateTableData() {
		this.tableModel.setRowCount(0);
		for(VLecture vLecture : this.vLectures) {
			Vector<String> row = new Vector<String>();
			
			for(EPResult tableRow : EPResult.values()) {
				vLecture.setEPResultContent();
				row.add(tableRow.getContent());
			}
			this.tableModel.addRow(row);
		}
		if(this.vLectures.size() > 0) {
			this.table.getSelectionModel().addSelectionInterval(0, 0);
		}
	}
	
	public void addLectures(Vector<VLecture> vSelectedLectures) {
		
		this.vLectures.addAll(vSelectedLectures);
		this.updateTableData();
		
	}

	public Vector<VLecture> removeSelectedLectures() {
		int[] indices = this.table.getSelectedRows();
		Vector<VLecture> vRemoveLectures = new Vector<VLecture>();
		
		for(int i = indices.length-1; i >= 0 ; i --) {
			VLecture vRemoveLecture = this.vLectures.remove(indices[i]);
			vRemoveLectures.add(vRemoveLecture);
		}
		
		this.updateTableData();
		return vRemoveLectures;
		
	}

}
