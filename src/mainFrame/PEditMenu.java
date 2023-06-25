package mainFrame;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import contants.Constants;
import contants.Constants.EEditMenu;

public class PEditMenu extends JMenu {

	private static final long serialVersionUID = 1L;

	public PEditMenu() {
		
		this.setText(Constants.EMenuBar.EDIT.getText());
		
		for (EEditMenu eEditMenu : Constants.EEditMenu.values()) {
			JMenuItem items = new JMenuItem(eEditMenu.getText());
			this.add(items);
		}
	}

	public void initialize() {
		// TODO Auto-generated method stub
		
	}
}
