
package grid;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/** Transmitters object which is a wrapper object for all the transmitters 
 * @version 1.0
 * @since 1.0
 * @author Steve Cartwright
 */
public class Transmitters {
 
  private ArrayList<Transmitter> transmittersList;

  Transmitters (ArrayList<String> txList){

    try{
        
      transmittersList = new ArrayList<Transmitter>();
  
      for (String transmitter : txList){

        // can assume string length is correct as validation done in processInput
        // split up string into invididual int values  
        
	//if (transmitter.length() > Constants.MaxTxEntrySize ) throw new Exception("Transmitter Entry Values Invalid");
        
        String[] splitArray = transmitter.split("\\s+");
        
        transmittersList.add(new Transmitter(Integer.parseInt(splitArray[0]),
                                   Integer.parseInt(splitArray[1]), 
                                   Integer.parseInt(splitArray[2]), 
			           Integer.parseInt(splitArray[3])));          
        
      }
    }
    catch (Exception ex)
    {
      Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  /**
 * Returns an integer containing the id of the transmitter that can reach the
 * xy coordinates
 *
 * @param       int xco
 * @param       int yco
 * @returns     int
 * 
 */
      
  int whatsMyTransmitter(int xco, int yco){
      
    int index=0;   // by default 0 will be returned
    try{
        // loop through transmitters to find one that is close enough
        for (Transmitter t: transmittersList) {
            
            if (t.withinChebyshev(xco, yco))
            {
                index = t.getIndex();
                break;
            }       
        }
    }
    catch (Exception e)
    {
       Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, e);
    }
    return index;
  }

  /**
 * With the given xy coordinates, works out if any of the transmitters
 * require a boost of power to be able to reach this receiver
 *
 * @param       int xco
 * @param       int yco
 * @boolean     String
 * @see         String
 */
  void auditTransmitterRequiredPowerBoost(int xco, int yco){
    
      int latestIndex=0;
      int latestCheb=Constants.BigNumber;
      int newCheb=0;
      int newIndex=0;
      
      try {

      // loop through transmitters
      for (Transmitter t: transmittersList)
      // get the latest index and cheb
      {
          newCheb = t.getChebyshev(xco, yco);
          newIndex = t.getIndex();
           // is the new cheb lower than the latest, if so, latest= new cheb
          if (newCheb < latestCheb) {
              latestCheb = newCheb;
              latestIndex = newIndex;
          } 
     
      }
      // at end of loop
      // set the txmitter with lowest cheb boost required to requiresboost
      // set the boost amount required to diff between current boost and required cheb
      // if it is already set to boost required only change it if required boost is
      // more than the already set required boost ie dont reduc it
      
      if (transmittersList.get(newIndex-1).getRequiredBoost() < latestCheb){
        transmittersList.get(newIndex-1).setRequiredBoost(latestCheb);
      }
      
      transmittersList.get(newIndex-1).setBoostRequired(true);
      
      
      
      
      // take care with situation where two or more receivers want to boost this transmitter 
    }
    catch (Exception e){

      Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, e);

    }
    finally
    {
      // any cleanup required
    }
  }

  /**
 * Returns a string containing the Transmitter report details.  
 *
 * 
     * @return 
 * @returns     String
 * @see         String
 */
  public String transmittersReport(){

    String repline="";
    
    try{
    // loop through transmitters
      for (Transmitter t : transmittersList){
      // each time one is found with requiredBoost is true
        if (t.getBoostRequired()){
           // println ID and BoostRequired
           repline += t.getIndex() + " " + 
                   (t.getRequiredBoost() + t.getPower()) + "\n";  
        }
     
      }
    }
    catch (Exception ex){

      Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
  
    }
    finally
    {
      // any cleanup required
    }
    return repline;
  }

}
