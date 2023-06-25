package applicationForClasses;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import applicationForClasses.PContentPanel.ActionHandler;

public class PMove extends JPanel {

	private static final long serialVersionUID = 1L;

	private JButton moveRightButton;
	private JButton moveLeftButton;
	
	public PMove(ActionHandler actionHandler) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS ));
		this.moveRightButton = new JButton(">>");
		this.moveRightButton.addActionListener(actionHandler);
		this.add(moveRightButton);
		
		this.moveLeftButton = new JButton("<<");
		this.moveLeftButton.addActionListener(actionHandler);
		this.add(moveLeftButton);
	}

	public void initialize() {
		// TODO Auto-generated method stub
		
	}

	public Object getMoveRightButton() {
		// TODO Auto-generated method stub
		return this.moveRightButton;
	}
	public Object getMoveLeftButton() {
		// TODO Auto-generated method stub
		return this.moveLeftButton;
	}


}
