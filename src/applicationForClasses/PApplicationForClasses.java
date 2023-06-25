package applicationForClasses;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import valueObject.VUser;

public class PApplicationForClasses extends JPanel {

	private static final long serialVersionUID = 1L;

	private PHeaderPanel pHeaderPanel;
	private PContentPanel pContentPanel;
	private PFooterPanel pFooterPanel;
	
	public PApplicationForClasses() {
		this.setLayout(new BorderLayout());
		
		this.pHeaderPanel = new PHeaderPanel();
		this.add(this.pHeaderPanel, BorderLayout.NORTH);
		this.pContentPanel = new PContentPanel();
		this.add(this.pContentPanel, BorderLayout.CENTER);
		this.pFooterPanel = new PFooterPanel();
		this.add(this.pFooterPanel, BorderLayout.SOUTH); 
		
	}

	public void initialize(VUser vUser) {
		this.pHeaderPanel.initialize(vUser);
		this.pContentPanel.initialize(vUser);
		this.pFooterPanel.initialize();
	}

	public void save() {
		this.pContentPanel.save();
	}

}
