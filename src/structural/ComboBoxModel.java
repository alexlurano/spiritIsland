package structural;// wrapper for JComboBox

import javax.swing.JComboBox;

public class ComboBoxModel {
	JComboBox<String> wrappedModel;
	public  ComboBoxModel(String[] listForBox) {

		wrappedModel  = new JComboBox<String>(listForBox);
		// TODO Auto-generated constructor stub
	}
	
	public JComboBox<String> getModel(){
		return wrappedModel;
	}
	
	public void replaceAll(String[] newList) {
		wrappedModel.removeAllItems();
		for(int i=0;i<newList.length;i++)
			wrappedModel.addItem(newList[i]);
	}

}
