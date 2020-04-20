
package project_ujji;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Gold extends State {
private double fee = 10;

    @Override
    public void onlinePurchase(CustomerHomepageController d) {
     if(d.getBalancee()>=20000){
            d.setState(new Platinum());
        }
        if(d.getBalancee()<10000){
            d.setState(new Silver());
        }
        else{
          double s = d.getpurchaseamt() + 10;
        try {
            d.setBalance(d.getBalancee()-s);
        } catch (IOException ex) {
            Logger.getLogger(Silver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
         
    }

    @Override
    public double getFee() {
        return fee;
            }
   
  
}
