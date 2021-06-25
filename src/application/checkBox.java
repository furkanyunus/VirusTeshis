package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

class checkBox {
	 @FXML
	    protected CheckBox CheckP;
	 @FXML
	 protected CheckBox CheckN;
	   @FXML
	   protected TextField teshis;
	 
	   
	    @FXML
	    private void CheckBoxNegatif(ActionEvent event) {
	        if(CheckN.isSelected()) {
	        	CheckP.setSelected(false);
	        }
	       this.teshis.setText("Negatif");

	    }
	    
	    @FXML
	    private void CheckBoxPozitif(ActionEvent event) {
	       if(CheckP.isSelected()) {
	    	   CheckN.setSelected(false);
	       }
	       this.teshis.setText("Pozitif");
}

}
 
