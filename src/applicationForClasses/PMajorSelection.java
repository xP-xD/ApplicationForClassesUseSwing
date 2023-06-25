package applicationForClasses;

import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import contants.Constants.EDirectory;
import contants.Constants.Econfiguration;
import control.CDirectory;
import valueObject.VDirectory;

public class PMajorSelection extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private PDirectory pCampus;
	private PDirectory pCollege;
	private PDirectory pMajor;
	
	private String fileName;
	public PMajorSelection(ListSelectionListener listSelectionHandler) {
		JScrollPane scrollPane;
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		scrollPane = new JScrollPane();
		this.pCampus = new PDirectory(EDirectory.campus.getText(), listSelectionHandler);
		scrollPane.setViewportView(this.pCampus);
		this.add(scrollPane);
		
		scrollPane = new JScrollPane();
		this.pCollege = new PDirectory(EDirectory.college.getText(), listSelectionHandler);
		scrollPane.setViewportView(this.pCollege);
		this.add(scrollPane);
		
		scrollPane = new JScrollPane();
		this.pMajor = new PDirectory(EDirectory.major.getText(), listSelectionHandler);
		scrollPane.setViewportView(this.pMajor);
		this.add(scrollPane);
		
//		this.pLecture = new PLecture();
//		this.add(this.pLecture);
		
	}
	
	public void initialize() {
		this.fileName = Econfiguration.rootFileName.getText();
		
		this.fileName = this.pCampus.initialize(this.fileName);
		this.fileName = this.pCollege.initialize(this.fileName);
		this.fileName = this.pMajor.initialize(this.fileName);
	}
	
	public String getFileName() {
		return this.fileName;
	}
	
	
	public String update(Object source) {
		if(source.equals(this.pCampus.getSelectionModel())) {
			this.fileName = this.pCampus.getSelectedFileName();
			this.fileName = this.pCollege.getData(this.fileName);
			this.fileName = this.pMajor.getData(this.fileName);
		}else if(source.equals(this.pCollege.getSelectionModel())) {
			this.fileName = this.pCollege.getSelectedFileName();
			this.fileName = this.pMajor.getData(this.fileName);
		}else if(source.equals(this.pMajor.getSelectionModel())) {
			this.fileName = this.pMajor.getSelectedFileName();
		}
		return this.fileName;
	}
	
	private class PDirectory extends JTable {

		private static final long serialVersionUID = 1L;

		private CDirectory cDirectory;
		private Vector<VDirectory> vDirectories;
		
		private ListSelectionListener listSelectionHandler;
		private DefaultTableModel tableModel;
		
		public PDirectory(String title, ListSelectionListener listSelectionHandler) {
			//attributes
			this.listSelectionHandler = listSelectionHandler;
			this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			this.getSelectionModel().addListSelectionListener(this.listSelectionHandler);
			//data model
			Vector<String> header = new Vector<String>();
			header.addElement(title); 
			this.tableModel = new DefaultTableModel(header,0);
			this.setModel(this.tableModel);
//			this.getSelectionModel().addListSelectionListener(listSelectionHandler);
		}

		public String getSelectedFileName() {
			int selectedIndex = this.getSelectedRow();
			String selectedFileName = this.vDirectories.get(selectedIndex).getFileName();
			return selectedFileName;
		}

		public String initialize(String fileName) {
			return this.getData(fileName);
		}

		public String getData(String fileName) {
			this.getSelectionModel().removeListSelectionListener(this.listSelectionHandler);
			this.cDirectory = new CDirectory();
			this.vDirectories = cDirectory.getData(fileName);
			this.tableModel.setRowCount(0);
			for(VDirectory vDirectory : this.vDirectories) { 
				Vector<String> row = new Vector<String>();
				row.add(vDirectory.getName());
				this.tableModel.addRow(row);
			}
		
			String selectedFileName = null;
			if(this.vDirectories.size() > 0) {
				this.getSelectionModel().addSelectionInterval(0, 0);
				selectedFileName = this.vDirectories.get(0).getFileName();
			}
			this.getSelectionModel().addListSelectionListener(this.listSelectionHandler);
			return selectedFileName;
		}


	}

	

}

