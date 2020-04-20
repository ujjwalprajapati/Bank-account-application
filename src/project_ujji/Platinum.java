
package project_ujji;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Platinum extends State {
private double fee=0;

    @Override
    public void onlinePurchase(CustomerHomepageController d) {
     if(d.getBalancee()<20000 && d.getBalancee()>=10000){
            d.setState(new Gold());
        }
        if(d.getBalancee()<10000){
            d.setState(new Silver());
        }
        else{
          double s = d.getpurchaseamt();
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
    
    