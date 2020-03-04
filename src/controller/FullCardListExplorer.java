package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import structural.ComboBoxModel;

// This is for viewing all the cards.
public class FullCardListExplorer {

    String displayedType = "minor";
	String[] minorNames;
	String[] majorNames;
	String[] startNames;
	JFrame f;
	JTextArea textArea;
	ComboBoxModel choices;
	String response;
	JLabel imageLabel;
	ArrayList<JPanel> jPanelArr = new ArrayList<JPanel>();
	
	public FullCardListExplorer(JFrame theFrame) {

	    f = theFrame;
	    
	    jPanelArr.add(new JPanel(new GridBagLayout()));
	    jPanelArr.add(new JPanel());
	    jPanelArr.add(new JPanel());
	    jPanelArr.add(new JPanel());
	}

	private void printJob(String args) { System.out.println(args);}
	
public void addInfoToList(String[] args,String[] args2,String[] args3) {
	minorNames = args;
	majorNames = args2;
	startNames = args3;
	
}


public void assignListener(ActionListener args,int paneloc) {

		choices.getModel().addActionListener(args);
}

public void assignMouseListener(MouseListener args, int indx) {
	jPanelArr.get(3).getComponent(indx).addMouseListener(args);
}


public void changeDropDown(String minorOrMajor) {
	// todo: make this method require a string[] input that it paints;
	displayedType = minorOrMajor;
	jPanelArr.get(1).remove(choices.getModel());
	if(minorOrMajor.equalsIgnoreCase("minor"))
		choices = new ComboBoxModel(minorNames);
	if(minorOrMajor.equalsIgnoreCase("major"))
		choices = new ComboBoxModel(majorNames);
	if(minorOrMajor.equalsIgnoreCase("start"))
		choices = new ComboBoxModel(startNames);

	jPanelArr.get(1).add(choices.getModel());
    SwingUtilities.updateComponentTreeUI(f);
	f.validate();
	f.repaint();
	f.setVisible(true);
}

public void addImage(String name) {
	jPanelArr.get(2).remove(imageLabel);
    imageLabel.removeAll();
    ImageIcon image = new ImageIcon(name);
    imageLabel = new JLabel(image);
    imageLabel.setBounds(10, 10, 400, 400);
    imageLabel.setVisible(true);
    jPanelArr.get(2).add(imageLabel);
}
public void createWindow() {

		    f.setSize(1000, 700);
		    f.setLocation(300,200);

		    JButton minorButton = new JButton("minor!");
		    minorButton.setBounds(100,100,140,40);
		    
		    JButton majorButton = new JButton("major!");
		    majorButton.setBounds(100,100,140,40);
		    JButton startButton = new JButton("start!");
		    startButton.setBounds(100,100,140,40);
		    ImageIcon image = new ImageIcon("C:\\Users\\agerh\\eclipse-workspace\\Spirit Island\\src\\data\\imgs\\a year of perfect stillness.jpg");
		    imageLabel = new JLabel(image);
		    imageLabel.setBounds(10, 10, 400, 400);
		    imageLabel.setVisible(true);
		    choices  = new ComboBoxModel(minorNames);
		     textArea = new JTextArea(10, 40);

			jPanelArr.get(0).add(textArea); // panel 0 is for responses
			jPanelArr.get(0).setBounds(10, 10, 400, 400);
			jPanelArr.get(1).add(choices.getModel()); // panel1 for dropdown
			jPanelArr.get(2).add(imageLabel);
			jPanelArr.get(3).add(majorButton);
			jPanelArr.get(3).add(minorButton);
			jPanelArr.get(3).add(startButton);
		    f.getContentPane().add(BorderLayout.EAST, jPanelArr.get(0));
		    
		    f.getContentPane().add(BorderLayout.NORTH, jPanelArr.get(1));
		    f.getContentPane().add(BorderLayout.WEST,jPanelArr.get(2));
		    
		    f.getContentPane().add(BorderLayout.SOUTH,jPanelArr.get(3));

			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
			//testingModularPanel(); // i made a class that should just be a jpanel containing 4 panels for looking at cards

		  }




public int getchoiceIndex() {
	return choices.getModel().getSelectedIndex();
}

public String getItemChoice() {

	String selctn = (String) choices.getModel().getSelectedItem();
	return selctn;
}

public void setresponse(String args) {
	response = args;
	textArea.append(args+"\n");
}

public void setCardValues(String[] args) {

    GridBagConstraints c = new GridBagConstraints();
    while(jPanelArr.get(0).getComponentCount() > 1)
    {
    	jPanelArr.get(0).remove(1);
    }
	for (int i = 0;i<args.length;i++) {

		JTextArea text2 = new JTextArea(5,40);
		c.gridx = 0;
	    c.gridy = i;
		text2.append(args[i]);
		jPanelArr.get(0).add(text2,c);
	}

	jPanelArr.get(0).setBounds(10, 10, 400, 400);
}

public void showWindow() {

    f.setVisible(true);
}
 }