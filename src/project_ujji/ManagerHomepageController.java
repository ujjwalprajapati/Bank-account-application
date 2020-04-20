
package project_ujji;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ManagerHomepageController {
  
    public void Logout(ActionEvent event) throws IOException{
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
          Parent login = FXMLLoader.load(getClass().getResource("ManagerLogin.fxml"));
           Scene scene1 = new Scene(login);
           stage.setScene(scene1);
           stage.show();
    }
    public void addCustomer(ActionEvent event) throws IOException{
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
          Parent customer = FXMLLoader.load(getClass().getResource("AddCustomer.fxml"));
           Scene scene3a = new Scene(customer);
           stage.setScene(scene3a);
           stage.show();
    }
    
    public void deleteCustomer(ActionEvent event) throws IOException{
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
          Parent cust = FXMLLoader.load(getClass().getResource("DeleteCustomer.fxml"));
           Scene scene3 = new Scene(cust);
           stage.setScene(scene3);
           stage.show();
    }
}
