
package grid;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/** Receivers object contains the group of receiver objects 
 * @version 1.0
 * @since 1.0
 * @author Steve Cartwright
 */
public class Receivers {
    
  private ArrayList<Receiver> receiversList = new ArrayList<Receiver>();
  int disconnectedReceivers=0;  
  
  Receivers (ArrayList<String> rxList){

    try{
  
      for (String receiver : rxList){

        //if (receiver.length() > Constants.MaxTxEntrySize) throw new Exception("Receiver Entry Values Invalid");
        // split each list of values into seperate integer values
     
	String[] splitArray = receiver.split("\\s+");
        if (receiver.length() == Constants.MaxRxEntrySize)
          receiversList.add(new Receiver(Integer.parseInt(splitArray[0]), 
                                         Integer.parseInt(splitArray[1]), 
				         Integer.parseInt(splitArray[2])));          
        
      }
    }
    catch (Exception ex)
    {
      Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  
  /**
 * How many receiving towers are in range of a transmitter  
 *
 * @return      String
 * @see         String
 */

  public String receiversReport(){

    String rep="";
    int numOfUnattached=0;
    try{
    
      // loop through receivers
      for (Receiver r : receiversList){
      // count receivers with tx idx of not zero
        if (r.getTransmitterIndex() == 0) numOfUnattached++;
      }
      rep = (receiversList.size()-numOfUnattached + " / " + receiversList.size());
    }
    catch (Exception e)
    {
      // log any errors
    }
    finally
    {
       // any required cleanup
    }
    return rep;

  }
  
  /**
 * Returns the ArrayList of Receivers  
 *
 * @return      ArrayList<Receiver>
 * @see         Receiver
 */
  public ArrayList<Receiver> getReceiversList() {
        return receiversList;
  }

  /**
 * Increments the DisconnectedReceivers class variable  
 *
 *
 */
  public void incrementDisconnectedReceivers() {
        disconnectedReceivers++;
  }
  
  /**
 * Returns the number of Receivers who are not in range of a transmitter  
 *
 * @return      int
 * 
 */
  public int getDisconnectedReceivers(){
        return disconnectedReceivers;
  }
    
}

    

