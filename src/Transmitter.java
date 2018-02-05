
package grid;


/** Transmitter object 
 * @version 1.0
 * @since 1.0
 * @author Steve Cartwright
 */

public class Transmitter extends Tower{ 
  private int power=0;
  private boolean boostRequired=false;
  private int requiredBoost=0;
 
    /**
     *
     * @param idx
     * @param xco
     * @param yco
     * @param pow
     */
    public Transmitter (int idx, int xco, int yco, int pow){  
    super(idx, xco, yco);
    power = pow;
    
  }
  /**
 * Returns the boolean flag showing if a boost is required for this transmitter  
 *
 * @return      boolean
 * 
 */
  public boolean getBoostRequired() { 
      return boostRequired; 
  }
  /**
 * Sets the requiredBoost class variable
 * 
 * 
     * @param req
 * 
 */
  public void setRequiredBoost(int req){
      this.requiredBoost = req - this.power;
  }
  
  /**
 * Set the boost required flag  
 *
     * @param flag
 */
  
  public void setBoostRequired(boolean flag){
      this.boostRequired = flag;
  }
  /**
 * Gets the requiredBoost class variable contents  
 *
 * @return      int
 * 
 */
  public int getRequiredBoost(){
      return this.requiredBoost;
  }
  /**
 * Gets the power setting for a transmitter  
 *
 * @return      String
 * @see         String
 */
  public int getPower() {
      return power; 
  }
  
  
  /**
 * Finds distance between two vectors using Chebyshev distance equation
 * The x,y coordinates passed as parameters are compared against the xy
 * coordinates of the transmitter object.
 *
 * taken from http://cljavacode.blogspot.ie/2017/02/chebyshev-distance-between-two-points.html
 *     find  distance between two vectors A and B using 
 *     Chebyshev distance equation
 *     ||A-B||     =  max { abs(A[0]-B[0])  ,  abs(A[1]-B[1]) } 
 *       =  max { abs(2-4) , abs(6-1) };
 *       =  max { abs(-2) , abs(5) }; 
 *       =  max {2 , 5}; 
 *      ||A-B||     =  5 ;
 * <p>
     * @param xco
     * @param yco
 * @return      int
 * @see         String
 */
  public int getChebyshev(int xco, int yco)
  {
      
      int chebyshev = 
              Math.max(Math.abs(this.getX()-xco), Math.abs(this.getY()-yco));
      //System.out.println("rcvr " + xco + ":" + yco);
      //System.out.println("txmtr" + this.getX() + ":" + this.getY());
      //System.out.println("power=" + this.getPower());
      //System.out.println("chebyshev=" + chebyshev);
      return chebyshev;
  }
  
  /**
 * Returns boolean variable to indicate if coordinates are within range  
 *
     * @param xco
     * @param yco
     * @return 
 * @boolean     String
 * @see         String
 */
  public boolean withinChebyshev(int xco, int yco){
      
      return  (this.getChebyshev(xco, yco) <= this.getPower());  
      
  }
}

