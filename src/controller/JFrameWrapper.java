package controller;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class JFrameWrapper {

	JFrame f;
	public JFrameWrapper() {

    f = new JFrame("A JFrame");
	}
	
	public void update() {

	    SwingUtilities.updateComponentTreeUI(f);
		f.validate();
		f.repaint();
		f.setVisible(true);
	}
	
	public void createWindow() {

	    f.setSize(1000, 700);
	    f.setLocation(300,200);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	}
	
	public JFrame getJFrame() {
		return f;
	}

}
