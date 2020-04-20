
package project_ujji;

import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
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

public class CustomerHomepageController implements Initializable {
    
    @FXML
    private TextField userid;
    @FXML
    private TextField passid;
    @FXML
    private Label error;
    @FXML
    private Label bal;
    @FXML
    private Label status;
    @FXML
    private TextField amount;
    @FXML
    private boolean authenticated;
    @FXML
    private Label locked;  
    private State myState;
    private Scanner scan;
    private double balance;
    private double purchaseamt;
    private boolean login;
    
  public void onlinePurchase(ActionEvent event) throws IOException{
          String a2 = null,b2 = null,c2 = null;
        String s1 = "";
        String level = null;
          if(login==true){
         if(amount.getText().equals(s1)){
             status.setText("Amount field not entered");
            
         }
         else{
             try{
         purchaseamt = Double.parseDouble(amount.getText());
            
             if(purchaseamt>=50){
                 if(this.getBalancee()<10000){
                     myState = new Silver();
                     
                 }
                 if(this.getBalancee()>=10000 && this.getBalancee()<20000){
                     myState = new Gold();
                    
                 }
                 if(this.getBalancee()>=20000){
                     myState = new Platinum();
                 }
             double d =myState.getFee();
             
             if(purchaseamt + d <= this.getBalancee()){
            myState.onlinePurchase(this); 
            d = myState.getFee();
            
            if(d==20){
               level = "Silver"; 
            }
            else if(d==10){
                level = "Gold";
            }
            else if(d==0){
                 level= "Platinum";
             }
            String dd = Double.toString(d);
            
            status.setText("Level: "+level+" $"+dd+" fee charged. Purchase Succcess");
             }
             else{
                 status.setText("Not enough balance in account to make purchase");
             }
             }
             else{
                 status.setText("Online Purchase must be $50 or more");
             }
             }
                        catch(NumberFormatException e){
               status.setText("Please enter a valid number for Amount field");
           }

             
           
         }
       }
          
          
      else{
             status.setText("Please login first");  
          }
              
              
              
              
          }
    
  public double getBalancee(){
    try{
         scan = new Scanner(new File(userid.getText())); 
         
       }
          catch(FileNotFoundException e){
         error.setText("User not found"); 
       }
       while(scan.hasNext()){ 
         String a = scan.nextLine();
         String b = scan.nextLine();
         String c = scan.nextLine();
         balance = Double.parseDouble(c);
         }
       scan.close();
       return balance;
}
 /* public void setusername1(String s){
      username1= s;
  }*/
  public double getpurchaseamt(){
    return purchaseamt;
}
  public void setState(State l) {
        myState = l;
    }
  
  public void setBalance(double balance) throws IOException{
      String a=null,b=null,c=null;
      try{
          scan = new Scanner(new File(userid.getText()));
      }
      catch(FileNotFoundException e){
          error.setText("User not found");
      }
      while(scan.hasNext()){
         a = scan.nextLine();
         b = scan.nextLine();
         c = scan.nextLine();
          
      }
      scan.close();
      c = Double.toString(balance);
      
      File file = new File(userid.getText());
      if(file.delete()){
          System.out.print("");
      }
      
       
       File newFile = new File(userid.getText());
       newFile.createNewFile();
               PrintWriter pwd = new PrintWriter(newFile);
                pwd.println(a);
                pwd.println(b);
                pwd.println(balance);
                pwd.close();
         
  }
  public void login(ActionEvent event) throws IOException{
      try{
         scan = new Scanner(new File(userid.getText())); 
         
       }
          catch(FileNotFoundException e){
         error.setText("User not found"); 
       }
       while(scan.hasNext()){
         // While File has something in it  
         String a = scan.nextLine();
         String b = scan.nextLine();
         String c = scan.nextLine();
         if(passid.getText().equals(b)){
             error.setText("Login Success"); 
             login = true;
             locked.setText("(Unlocked)");
             
         }
         else{
             error.setText("Invalid Credentials");
             
         }
       }
       scan.close();
  }
    public void getBalance(ActionEvent event) throws IOException{
        String a1,b1,c1;
       if(login==true){
       scan = new Scanner(new File(userid.getText())); 
       while(scan.hasNext()){
         // While File has something in it  
         a1 = scan.nextLine();
         b1 = scan.nextLine();
         c1 = scan.nextLine();
         balance = Double.parseDouble(c1);
         bal.setText("$ "+c1);
       }
       scan.close();
       }
       else{
           bal.setText("Please Login First!");
       }
    }
    
    public void depositMoney(ActionEvent event) throws IOException{
        String a2 = null,b2 = null,c2 = null;
        String s1 = "";
          if(login==true){
              scan = new Scanner(new File(userid.getText()));
       while(scan.hasNext()){
          
         a2 = scan.nextLine();
         b2 = scan.nextLine();
         c2 = scan.nextLine();
          
         if(amount.getText().equals(s1)){
             status.setText("Amount field not entered");
         }
         else{
             try{
         balance = Double.parseDouble(c2) + Double.parseDouble(amount.getText());
         
             }
                        catch(NumberFormatException e){
               status.setText("Please enter a valid number for Amount field");
           }
         }
       }
       scan.close();
       
       
       c2 = Double.toString(balance);
      File file = new File(userid.getText());
      if(file.delete()){
          System.out.print("");
      }
      
       
       File newFile = new File(userid.getText());
       
               newFile.createNewFile();
               PrintWriter pwd = new PrintWriter(newFile);
                pwd.println(a2);
                pwd.println(b2);
                pwd.println(c2);
                pwd.close();
                  try{
         balance = Double.parseDouble(c2) + Double.parseDouble(amount.getText());
         status.setText("$"+amount.getText()+" deposited for "+userid.getText());
             }
                             catch(NumberFormatException e){
               status.setText("Please enter a valid number for Amount field");
           }
                
                
          }    
          else{
              status.setText("Please login first");
          }

       
    }
    
    public void withdrawMoney(ActionEvent event) throws IOException{
        String a2 = null,b2 = null,c2 = null;
        String s1 = "";
        if(login==true){
       scan = new Scanner(new File(userid.getText()));
       while(scan.hasNext()){ 
         a2 = scan.nextLine();
         b2 = scan.nextLine();
         c2 = scan.nextLine();
          
         if(amount.getText().equals(s1)){
             status.setText("Amount field not entered");
         }
         else{
             try{
         balance = Double.parseDouble(c2) - Double.parseDouble(amount.getText());
         
             }
                        catch(NumberFormatException e){
               status.setText("Please enter a valid number for Amount field");
           }
         }
       }
       scan.close();
       
       if(balance >= 0){
       c2 = Double.toString(balance);
      File file = new File(userid.getText());
      if(file.delete()){
          System.out.println("");
      }
      
       
       File newFile = new File(userid.getText());
       
               newFile.createNewFile();
               PrintWriter pwd = new PrintWriter(newFile);
                pwd.println(a2);
                pwd.println(b2);
                pwd.println(c2);
                pwd.close();
                       try{
         balance = Double.parseDouble(c2) + Double.parseDouble(amount.getText());
         status.setText("$"+amount.getText()+" withdrawed for "+userid.getText());
             }
                             catch(NumberFormatException e){
               status.setText("Please enter a valid number for Amount field");
           }
       

       
    }
       else{
           status.setText("Not enough balance in account");
       }
    }
        else{
              status.setText("Please login first");
          }
        
    }
    
          
    
    
    public void Logoutt (ActionEvent event) throws IOException{
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
          Parent login = FXMLLoader.load(getClass().getResource("Login.fxml"));
           Scene scene1 = new Scene(login);
           stage.setScene(scene1);
           stage.show();
    }
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }      
}
