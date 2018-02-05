/*
 * This is the abstract Tower class.
 * Both Receiver and Tranmitter are a subclass of this
 * 
 * 
 */
package grid;

/**
 *
 * @author Steve Cartwright
 */
public abstract class Tower {
    
  private int xCoord=0;
  private int yCoord=0;
  private int index=0;

  Tower( int idx, int xco, int yco) {
    xCoord = xco;
    yCoord = yco;
    index = idx;
  }
  /**
 * Return the x coordinate of the tower  
 *
 * @return      int
 * 
 */
  int getX(){ return xCoord;}
  
  /**
 * Return the Y coordinate of the tower  
 *
 * @return      String
 * @see         String
 */
  int getY(){ return yCoord;}
  
  /**
 * Return the index of the tower  
 *
 * @return      int
 * 
 */
  int getIndex() { return index;}
 
}
