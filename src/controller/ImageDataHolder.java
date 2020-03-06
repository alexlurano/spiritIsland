package controller;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class ImageDataHolder {
	ArrayList<Image> loadedImages = new ArrayList<Image>();
	public ImageDataHolder() {
		// TODO Auto-generated constructor stub
	}
	
	public void addImage(Image args) {
		
	}
	
	public Image getImage(int index) {
		if(loadedImages.isEmpty())
			return new ImageIcon().getImage();
		if(index >= loadedImages.size())
			return loadedImages.get(loadedImages.size()-1);
		return loadedImages.get(index);
	}
	
	public void prepareImages(ArrayList<String> fileNames) {
		for(String s:fileNames) {
			String rawPath = s;
			rawPath = rawPath.strip();
			rawPath = rawPath.toLowerCase();
			rawPath = rawPath.replaceAll("'", "");

			rawPath = System.getProperty("user.dir") + "\\src\\data\\imgs\\" + rawPath +".jpg";
			loadedImages.add((new ImageIcon(rawPath)).getImage());
			//ImageIcon image = new ImageIcon(System.getProperty("user.dir") + "\\src\\data\\imgs\\a year of perfect stillness.jpg");

		}
	}
}
