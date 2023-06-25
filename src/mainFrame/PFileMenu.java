package mainFrame;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import contants.Constants;
import contants.Constants.EFileMenu;

public class PFileMenu extends JMenu {

	private static final long serialVersionUID = 1L;

	public PFileMenu() {
		//set attributes
		this.setText(Constants.EMenuBar.FILE.getText());
	
		//create and register components
		for (EFileMenu eFilMenu : Constants.EFileMenu.values()) {
			JMenuItem items = new JMenuItem(eFilMenu.getText());
			this.add(items);
		}
		
	}

	public void initialize() {
		// TODO Auto-generated method stub
		
	}
	
}
