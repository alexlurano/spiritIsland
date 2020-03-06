package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
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
	String[] startNames; //remove these once imagedataholder is working.
	ArrayList<String> allNames = new ArrayList<String>();
	JFrame f;
	JTextArea textArea;
	ComboBoxModel choices;
	String response;
	JLabel imageLabel;// remove once dataholder works
	ImageDataHolder myImages = new ImageDataHolder();
	EventHandler ehandle;
	ArrayList<JPanel> jPanelArr = new ArrayList<JPanel>();
	
	public FullCardListExplorer(JFrame theFrame) {

	    f = theFrame;
	    
	    jPanelArr.add(new JPanel(new GridBagLayout()));
	    jPanelArr.add(new JPanel());
	    jPanelArr.add(new JPanel(new GridBagLayout()));
	    jPanelArr.add(new JPanel());
	    ehandle = new EventHandler();
	}

	private void printJob(String args) { System.out.println(args);}
	
public void addInfoToList(String[] args,String[] args2,String[] args3) {//call this before anything
	minorNames = args;
	majorNames = args2;
	startNames = args3;
	for(String s:args)
		allNames.add(s);
	for(String s:args2)
		allNames.add(s);
	for(String s:args3)
		allNames.add(s);
	
}


public void assignListener(ActionListener args,int paneloc) {

		choices.getModel().addActionListener(args);
}

public void assignMouseListener(MouseListener args, int indx) {
//	jPanelArr.get(3).getComponent(indx).addMouseListener(args);
	jPanelArr.get(3).getComponent(indx).addMouseListener(ehandle.getSimpleMouseListener(true, false, false, false));
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
    image = new ImageIcon(getScaledImage(image.getImage(),image.getIconWidth()/2,image.getIconHeight()/2));
    imageLabel = new JLabel(image);
    imageLabel.setBounds(10, 10, 400, 400);
    imageLabel.addMouseListener(ehandle.getSimpleMouseListener(false, true, true, false));
    imageLabel.setVisible(true);
    jPanelArr.get(2).add(imageLabel);
}
public void createWindow() {

		    f.setSize(1000, 700);
		    f.setLocation(300,200);

		    JButton minorButton = new JButton("minor!");
		    minorButton.setBounds(100,100,140,40);
		    minorButton.setName("minor");
		    JButton majorButton = new JButton("major!");
		    majorButton.setName("major");
		    majorButton.setBounds(100,100,140,40);
		    JButton startButton = new JButton("start!");
		    startButton.setBounds(100,100,140,40);
		    startButton.setName("start");
		    myImages.prepareImages(allNames);
		    ImageIcon image = new ImageIcon(myImages.getImage(2));
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
	textArea.setText(args);
	//textArea.append(args+"\n");
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
	    c.gridy = i+1;
	    c.ipady = 20;
		text2.append(args[i]);
		jPanelArr.get(0).add(text2,c);
	}

	jPanelArr.get(0).setBounds(10, 10, 400, 400);
}
private Image getScaledImage(Image srcImg, int w, int h){
    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2 = resizedImg.createGraphics();

    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g2.drawImage(srcImg, 0, 0, w, h, null);
    g2.dispose();

    return resizedImg;
}

public void showWindow() {

    f.setVisible(true);
    while(
			mainEventLoop());
}

private void doubleSizeOfImage() {
	printJob("double");
	Image img = ((ImageIcon) imageLabel.getIcon()).getImage();
	ImageIcon img2 = new ImageIcon(img);

	jPanelArr.get(2).remove(imageLabel);
    imageLabel.removeAll();
	imageLabel = new JLabel(new ImageIcon(getScaledImage(img2.getImage(),img2.getIconWidth()*2,img2.getIconHeight()*2)));

    imageLabel.setBounds(10, 10, 400, 400);
    imageLabel.addMouseListener(ehandle.getSimpleMouseListener(false, true, true, false));
    imageLabel.setVisible(true);
   // jPanelArr.get(2).add(imageLabel);
	//    jPanelArr.get(2).
}

public boolean mainEventLoop() {
	//every 200ms ask ehande for any events fired.
	if(ehandle.getreadyForHelp())
		return eventDoor();
	try {
		Thread.sleep(500);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return true;
}
public boolean eventDoor() {
	String whatDoNow = ehandle.mouseEventsFired();
	
	if(whatDoNow.equalsIgnoreCase("grow"))
		doubleSizeOfImage();
	
	return true;
}


 }