
package grid;

import java.util.logging.Level;
import java.util.logging.Logger;

/** Receiver object models all the methods and class variables required
 * for a receiver.
 * @version 1.0
 * @since 1.0
 * @author Steve Cartwright
 */
public class Receiver extends Tower {

  private int transmitterIndex=0;
  
  Receiver (int idx, int xco, int yco){
    super(idx, xco, yco);
   
  }
  
  /**
 * Sets the transmitter index id which the receiver can reach
 *
 * @param       Transmitter
 * @return      void
 * @see         Transmitter
 */
  void findTransmitter (Transmitters tMitter){
    try {

      transmitterIndex  = tMitter.whatsMyTransmitter(getX(), getY());
    }
    catch (Exception e)
    {
       Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, e);
    }
    finally
    {
        // any cleanup
    }

  }
  
  /**
 * Gets the transmitter index id the receiver is configured with
 *
 * @return      int
 * @see         Transmitter
 */
  public int getTransmitterIndex(){ return transmitterIndex;}

}  
