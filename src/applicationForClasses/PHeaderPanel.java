package applicationForClasses;

import javax.swing.JLabel;
import javax.swing.JPanel;

import valueObject.VUser;

public class PHeaderPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel welcomeLabel;
	
	public PHeaderPanel() {
		this.welcomeLabel = new JLabel();
		this.add(this.welcomeLabel);
	}

	public void initialize(VUser vUser) {
		this.welcomeLabel.setText(vUser.getUserName() + "님 안녕하세요.");
	}
	
}
 