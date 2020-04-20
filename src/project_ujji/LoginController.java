
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
import java.io.*;
import java.util.*;

/**
 *
 * @author Ujjwal Prajapati
 */

 /**
  * OVERVIEW:
  * This class represents the manager's login page and main login page for our application
  *
  * MUTABLE:
  * This class is mutable since you can change the states and fields after the
  * object is created
  * 
  * REP INVARIANT:
  * RI(c) = true if c.userid !=null, c.passord !=null
  * false otherwise
  * 
  * ABSTRACTION FUNCTION:
  * AF(c) = a mainController mainCont
  * c.id = mainCont.userid, c.pass = mainCont.password
  * .
  */

public class LoginController {
   @FXML
   private Label lblbank;
   @FXML
   private TextField txtusername;
   @FXML
   private TextField txtpassword;
   
   private Scanner x;

   
   
  /**Requires: String Username and Password that are not null
   * Modifies: NA
   *  Effects: Initializes the textField for txtusername and txtpassword, using User's Input for
               Username and Password. Checks if the credentials are correct and lets the manager access
               ManagerHomepage Scene of the application
     * @param event
     * @throws java.io.IOException
    */
   
  
          
   public void Login(ActionEvent event) throws IOException{
       
       if(txtusername.getText().equals("admin")&& txtpassword.getText().equals("admin")){
          lblbank.setText("Login Success"); 
         Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
          Parent homepage = FXMLLoader.load(getClass().getResource("ManagerHomepage.fxml"));
           Scene scene2 = new Scene(homepage);
           stage.setScene(scene2);
           stage.show();
       }

       
      else{
       lblbank.setText("Invalid credentials");
   }
  
}
   /** Requires: NA 
    *  Modifies: NA
    *  Effects: Opens the ManagerLogin Scene of the application. 
    * 
    * @param event
    * @throws java.io.IOException
    */
   public void ManagerLogin(ActionEvent event) throws IOException{
       Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
          Parent homepage = FXMLLoader.load(getClass().getResource("ManagerLogin.fxml"));
           Scene scene2 = new Scene(homepage);
           stage.setScene(scene2);
           stage.show();
   }
   
    
   /** Requires: NA
     *  Modifies: NA
     *  Effects:  Opens the CustomerHomepage Scene of the application. 
     * @param event
     * @throws java.io.IOException
     */
    public void CustomerLogin(ActionEvent event) throws IOException{
       Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
          Parent homepage = FXMLLoader.load(getClass().getResource("CustomerHomepage.fxml"));
           Scene scene2 = new Scene(homepage);
           stage.setScene(scene2);
           stage.show();
   }
    /** Requires: NA
    *   Modifies: NA
    *   Effects: Goes Back to the main Login Scene of the application 
     * @param event
     * @throws java.io.IOException
    */
          public void goBackk(ActionEvent event) throws IOException{
           Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
          Parent homepage = FXMLLoader.load(getClass().getResource("Login.fxml"));
           Scene scene2 = new Scene(homepage);
           stage.setScene(scene2);
           stage.show();
       }
          
        /** Requires: NA
         *  Modifies: NA
         *  Effects: Returns true if rep invariant holds true for this
         *  
     * @return 
         */
          
        public boolean repOK() {
        if (txtusername != null && txtpassword != null){
            return true;
        }
            else 
        {
            return false;
        }
        
    }
        /** Requires: NA
         *  Modifies: NA
         *  Effects: Returns a String representation of instance variables used. It implements
         * the abstraction function.
         *  
         * 
     * @return 
         */
        
        
   @Override
          public String toString(){
             return "Login Controller :  Label = "+lblbank+" Username = "+txtusername+
                     " Password = "+txtpassword+""; 
          }
          

}

