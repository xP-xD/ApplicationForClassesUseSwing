package applicationForClasses;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import contants.Constants.Econfiguration;
import valueObject.VLecture;
import valueObject.VUser;

public class PContentPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private VUser vUser;
	
	private ListSelectionListener listSelectionHandler;
	private PSelection pSelection;
	
	private PResult pPreRegisterForClasses;
	private PResult pRegisterForClasses;
	
	private ActionHandler actionHandler;
	private PMove pMove1;
	private PMove pMove2;
	
	
	public PContentPanel() {
		JScrollPane scrollPane;
		
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		this.listSelectionHandler = new ListSelectionHandler();
		this.pSelection = new PSelection(this.listSelectionHandler);
		this.add(pSelection);
		
		this.actionHandler = new ActionHandler();
		this.pMove1 = new PMove(this.actionHandler);
		this.add(pMove1);
		
		this.pPreRegisterForClasses = new PResult();
		this.add(this.pPreRegisterForClasses);
		
		this.pMove2 = new PMove(this.actionHandler);
		this.add(pMove2);
		
		this.pRegisterForClasses = new PResult();
		this.add(this.pRegisterForClasses);
	}

	public void initialize(VUser vUser) {
		this.vUser = vUser;
		
		this.pMove1.initialize();
		this.pPreRegisterForClasses.initialize(this.vUser.getUserId()+Econfiguration.preRegisterForClassesFilePostfix.getText());
		this.pMove2.initialize();
		this.pRegisterForClasses.initialize(this.vUser.getUserId()+Econfiguration.registerForClassesFilePostfix.getText());
		
		this.pSelection.initialize(this.pPreRegisterForClasses, this.pRegisterForClasses);
	}
	
	public void save() {
		this.pPreRegisterForClasses.save( this.vUser.getUserId()+Econfiguration.preRegisterForClassesFilePostfix.getText());
		this.pRegisterForClasses.save(this.vUser.getUserId()+Econfiguration.registerForClassesFilePostfix.getText());
	}
	
	
	/////////////////////////////////////////////////
	//table event handling
	/////////////////////////////////////////////////
	private void updateLectures(Object source) {
		this.pSelection.updateLectures(source);
	}
		
	public class ListSelectionHandler implements ListSelectionListener{

		@Override
		public void valueChanged(ListSelectionEvent event) {
			updateLectures(event.getSource());
		}
		
	}
	
	/////////////////////////////////////////////////
	//button event handling (moveLecture)
	/////////////////////////////////////////////////
	private void moveLectures(PLectureContanier source,PLectureContanier target){
		Vector<VLecture> vSelectedLectures = source.removeSelectedLectures();
		
		target.addLectures(vSelectedLectures);	
	}
	
	private void moveLectures(Object source) {
		if(source.equals(this.pMove1.getMoveRightButton())) {
			this.moveLectures(this.pSelection, this.pPreRegisterForClasses);
		}else if(source.equals(pMove1.getMoveLeftButton())) {
			this.moveLectures(this.pPreRegisterForClasses, this.pSelection);
		}if(source.equals(this.pMove2.getMoveRightButton())) {
			this.moveLectures(this.pPreRegisterForClasses, this.pRegisterForClasses);
		}else if(source.equals(pMove2.getMoveLeftButton())) {
			this.moveLectures(this.pRegisterForClasses, this.pPreRegisterForClasses);
		}
	}
	
	public class ActionHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			moveLectures(event.getSource());
		}
		
	}
	
}
