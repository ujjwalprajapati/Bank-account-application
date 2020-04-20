
package project_ujji;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.File;
import java.io.PrintWriter;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
 

public class AddCustomerController implements Initializable {
   @FXML
   private TextField name;
   @FXML
   private TextField pass;
   @FXML
   private TextField passconf;
   @FXML
   private TextField balance;
   @FXML
   private Label message;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    public void goback(ActionEvent event) throws IOException{
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
          Parent cust = FXMLLoader.load(getClass().getResource("ManagerHomepage.fxml"));
           Scene scene2 = new Scene(cust);
           stage.setScene(scene2);
           stage.show();
    }
    public void addcustomer(ActionEvent event) throws IOException{
        String str1 = "";
        if(str1.equals(passconf.getText()) || str1.equals(name.getText()) || str1.equals(pass.getText()) || str1.equals(balance.getText())){
             message.setText("Can't Add Customer, Please input for all fields"); 
        }
        else if (!((passconf.getText()).equals(pass.getText()))){
            message.setText("Password Confirmation doesn't match");
        }
        
        else if(!(str1.equals(balance.getText()))){
           try{
            double bal = Double.parseDouble(balance.getText());
                    if(bal<100){
                message.setText("Minimum balance of $100 is required to add Customer");
            }
            else{
               File file = new File(name.getText());
               if(file.exists()){
               message.setText("This username is already taken");
        }
                if(!file.exists()){
                file.createNewFile();
                PrintWriter pw = new PrintWriter(file);
                pw.println(name.getText());
                pw.println(pass.getText());
                pw.println(balance.getText());
                pw.close();
                message.setText("New Customer Added");
            
        }
            }
           }
           catch(NumberFormatException e){
               message.setText("Please enter a valid number for BALANCE Field");
           }
    
        }
       
       
}
}
