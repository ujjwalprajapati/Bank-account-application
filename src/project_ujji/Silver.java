
package project_ujji;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Silver extends State {
private double fee=20;
String a = "Silver";
    @Override
    public void onlinePurchase(CustomerHomepageController d) {
     if(d.getBalancee()>=20000){
            d.setState(new Platinum());
        }
        if(d.getBalancee()<20000 && d.getBalancee()>=10000){
            d.setState(new Gold());
        }
        else{

          double s = d.getpurchaseamt() + 20;
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
    