package mainFrame;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

import contants.Constants.EToolBar;

public class PToolBar extends JToolBar {

	private static final long serialVersionUID = 1L;

	public PToolBar() {
		this.setLayout(new GridLayout(EToolBar.values().length/2, EToolBar.values().length/2));
		for(EToolBar eToolBar : EToolBar.values() ) {
			ImageIcon imageIcon = new ImageIcon("imageFile/"+eToolBar.getText()+".jpeg");
			JButton button = new JButton(eToolBar.getText());
			button.setIcon(imageIcon);
			this.add(button);
		}
		
	}

	public void initialize() {
		// TODO Auto-generated method stub
		
	}
	
}
