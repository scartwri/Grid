/*
 */
package grid;

import java.util.logging.Level;
import java.util.logging.Logger;

/** Grid object contains the main section of code 
 * @version 1.0
 * @since 1.0
 * @author Steve Cartwright
 */
public class Grid {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            // gather the data from the input file
            Data gridData = new Data();
            
            // build receivers and transmitters objects
            Receivers r = new Receivers(gridData.getReceivers());
            Transmitters t = new Transmitters(gridData.getTransmitters());
            
            // calculate which transmitter is allocated to each receiver
            for (Receiver receiver : r.getReceiversList()){
                receiver.findTransmitter(t);
                
                // if this receiver isnt close enough to a transmitter
                // audit the tranmitters to find the closest and figure out the
                // boost required
                
                if (receiver.getTransmitterIndex() == 0){
                    t.auditTransmitterRequiredPowerBoost(receiver.getX(), receiver.getY());
                }
            }
            // print out the receivers report
            System.out.println(r.receiversReport());
            // print out the transmitters report
            System.out.println(t.transmittersReport());
            
        }
        catch (Exception e){
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, e);
            
        }
        
        
    }
    
}
