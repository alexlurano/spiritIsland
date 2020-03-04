package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import structural.ComboBoxModel;

public class AllCardsSelectorPanel extends JPanel {

	/** idk what this means
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel mainp = new JPanel(new GridBagLayout());
	JPanel leftp = new JPanel(new GridBagLayout());
	JPanel upp = new JPanel(new GridBagLayout());
	JPanel downp = new JPanel(new GridBagLayout());
	JPanel rightp = new JPanel(new GridBagLayout());
	JPanel centerp = new JPanel();

	public AllCardsSelectorPanel() {
		// TODO Auto-generated constructor stub


	}
	
	public void createPanels() {
	    GridBagConstraints c = new GridBagConstraints();
	    mainp.setSize(getMaximumSize());

	    this.add(mainp);
	    c.ipady = 3;
	    c.gridx = 0;
	    c.gridy = 0;
	    c.anchor = GridBagConstraints.NORTH;
	    mainp.add(upp,c);


		 //------------------------------------------------------------       
	    c.gridx = 0;
	    c.gridy = 1;
	    c.anchor = GridBagConstraints.WEST;
	    mainp.add(leftp,c);
		 //------------------------------------------------------------   
	    
	    c.gridx = 2;
	    c.gridy = 1;
	    c.anchor = GridBagConstraints.EAST;
	    mainp.add(rightp,c);
		 //------------------------------------------------------------   
	    
	    c.gridx = 100;
	    c.gridy = 100;
	    c.ipady = 40;
	    c.gridwidth = 100;
	    c.gridheight = 40;
	    c.anchor = GridBagConstraints.CENTER;
	    mainp.add(centerp,c);
		 //------------------------------------------------------------   
	    c.gridx = 0;
	    c.gridy = this.getHeight() - 40;
	    c.ipady = 3;
	    c.gridwidth = 100;
	    c.gridheight = 40;
	    c.anchor = GridBagConstraints.SOUTH;
	    mainp.add(downp,c);
	    c.ipady = 0;
	    mainp.setBackground(new Color(2));

	    this.add(mainp);
	}
	
	public void changeupPanel(String[] droplist) {
	    GridBagConstraints c = new GridBagConstraints();
	    c.gridx = 0;
	    c.gridy = 0;
		ComboBoxModel aList = new ComboBoxModel(droplist);
		upp.add(aList.getModel(),c);
		
		
	}
	
	public void changedownPanel() {

	    GridBagConstraints c = new GridBagConstraints();
	    c.gridx = 0;
	    c.gridy = 0;
	    JButton b1 = new JButton("modulo!");
	    downp.add(b1,c);
	}
	
	public void changerightPanel() {
		
	}
	
	public void changeleftPanel() {
		
	}
	
	public void changecenterPanel() {
	    GridBagConstraints c = new GridBagConstraints();
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 0;
	    c.gridy = 0;
	    JTextArea t1 = new JTextArea("modulo!"+this.getHeight(),10,40);
	    downp.add(t1,c);
	}

}
