
package project_ujji;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class DeleteCustomerController implements Initializable {
    @FXML
    private TextField userN; 
    @FXML
    private Label stat;
    
    
     public void backM(ActionEvent event) throws IOException{
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
          Parent cust = FXMLLoader.load(getClass().getResource("ManagerHomepage.fxml"));
           Scene scene2 = new Scene(cust);
           stage.setScene(scene2);
           stage.show();
    }
     public void dlt (ActionEvent event) throws IOException{
         File file = new File(userN.getText());
      if(file.delete()) 
        { 
            stat.setText(userN.getText() + " deleted successfully.");
        } 
        else
        { 
            stat.setText(userN.getText() + " could not be deleted. File not found");
        } 
      }

   
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
