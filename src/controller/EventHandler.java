package controller;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

public class EventHandler {
	boolean readyForHelp = false;
	String mouseEventStuff = "";
	int comboBoxIndexChosen = -1;
	int eventIndex = -1;
	
	public EventHandler() {
		
	}

	private void printJob(String args) { System.out.println(args);}
	
	public void mouseEventHandling() {
		
	}
	
	public void comboBoxEvent() {
		
	}
	
	public void buttonEventHandler() {
		
	}
	
	public Image imageResizeEvent(Image srcImg, int w, int h){
	    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = resizedImg.createGraphics();

	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(srcImg, 0, 0, w, h, null);
	    g2.dispose();

	    return resizedImg;
		
	}
	
	public MouseListener getSimpleMouseListener(boolean click, boolean down, boolean up,boolean enter) {
		MouseListener myMouseListener = new MouseListener(){
			boolean a = click;
			boolean b = down;
			boolean c = up;
			boolean d = enter;
			@Override
			public void mouseClicked(MouseEvent e) {
				if(a) {
					setComboBoxStateRequest(e.getComponent().getName());
				readyForHelp = true;
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if(b) {
					imageEventFired();
			}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if(c) {
					mouseEventStuff = "grow";
				readyForHelp = true;	
			}}

			@Override
			public void mouseEntered(MouseEvent e) {
				if(d) {
					printJob(" ");
			}}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}
	    };
	    return myMouseListener;

	}
	
	private void imageEventFired() {
		readyForHelp = true;
		eventIndex = 0;
	}
	
	private void setComboBoxStateRequest(String args) {
		eventIndex = 1;
		readyForHelp = true;
		switch (args) {
		case "minor":
			comboBoxIndexChosen = 0;
			break;
		case "major":
			comboBoxIndexChosen = 1;
			break;
		case "start":
			comboBoxIndexChosen = 2;
			break;
		default:
			comboBoxIndexChosen = -1;
				
		}
	}
	
	public boolean getreadyForHelp(){ // 
		return readyForHelp;
	}
	public int getEventType() {
		int a = eventIndex;
		eventIndex = -1;
		return a;
	}
	
	public String mouseEventsFired() {
		String temp = mouseEventStuff;
		mouseEventStuff = "";
		readyForHelp = false;
		return temp;
	}
	
	public int comboBoxUpdate() {
		readyForHelp = false;
		return comboBoxIndexChosen;
	}

}
