/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grid;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.*;


/** Data object which handles retrieving parameters from an input
 * file and methods to retrieve this data in String arrays.
 * @version 1.0
 * @since 1.0
 * @author Steve Cartwright
 */
public class Data {
    
  private static int gridX;
  private static int gridY;

  private ArrayList<String> receivers = new ArrayList<String>();
  private ArrayList<String> transmitters = new ArrayList<String>();
  
    /**
     *
     * @return
     */
    public static int getX() { return gridX; }

    /**
     *
     * @return
     */
    public static int getY() { return gridY; }

    /**
     *
     */
    public Data(){
      
    FileReader  fileReader = null;
    BufferedReader bufferedReader = null;
    String line = null;
    Matcher m = null;
    
    
    
    try {
      fileReader = new FileReader (Constants.InputFileName);
      bufferedReader = new BufferedReader (fileReader);  
            
      Pattern XYpattern = Pattern.compile(Constants.XYPattern);
      Pattern TxPattern = Pattern.compile(Constants.TransmitterPattern);
      Pattern RxPattern = Pattern.compile(Constants.ReceiverPattern);
      
      while ( (line = bufferedReader.readLine()) != null){
        if (XYpattern.matcher(line).find()){
            String[] xyStr = line.split(" ");
            gridX = Integer.parseInt(xyStr[0]);
            gridY = Integer.parseInt(xyStr[1]);
        
        } else if (TxPattern.matcher(line).find()) {
        
            transmitters.add(line);
            
        } else if (RxPattern.matcher(line).find()) {
            
            receivers.add(line);
            
        } else {
            System.out.println("Input File Format Error, exiting..");
            System.exit(0);
            
        }
      }
      
      //if correct create new tramsitter and receiver objects
    } catch (FileNotFoundException ex) {
        Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        System.out.println ("Unable to find input.txt");
    } catch (IOException ex){
        Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        System.out.println ("Unable to read from input.txt");
        
    }
    finally {
          try {
              fileReader.close();
          } catch (IOException ex) {
              Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
  }

  
  /**
 * Returns an ArrayList of Strings with Receiver data
 *
 * @return      an ArrayList of Strings
 * @see         String
 */
  
  public ArrayList<String> getReceivers(){
      return receivers;
  }
  
  /**
 * Returns an ArrayList of Strings with Transmitter data
 *
 * @return      an ArrayList of Strings
 * @see         String
 */
  public ArrayList<String> getTransmitters() { 
      return transmitters; 
  }
    
}
