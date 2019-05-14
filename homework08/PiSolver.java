/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  PiSolver.java
 * Purpose    :  To create a program that estimates the value of PI by throwing random darts at a circle within a square
 * @author    :  Fosse Lin-Bianco
 * Date       :  2019-04-26
 * Description:
 * Notes      :  None
 * Warnings   :  None
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Revision History
 * ================
 *   Ver      Date     Modified by:      Reason for change or modification
 *  -----  ----------  ------------      ---------------------------------------------------------------------
 *  1.0.0  2019-04-13  Fosse Lin-Bianco  Started coding.
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class PiSolver {
  /**
   * Field Declarations
   */
   public static double positionX;
   public static double positionY;

   /**
    * Method that generates two random number between -1 and 1
    * @return randomNum
    */
   public static double generateRandomValues() {
     double randomNum = Math.random();
     randomNum *= ((Math.floor(Math.random() * 2)) == 1 ? 1 : -1);
     // System.out.println("randomNum: " + randomNum);
     return randomNum;
   }

   /**
    * Method that simulates throwing darts at a circle, radius 1, wihin a sqaure
    * @return ratio of darts in circle to total darts
    */
   public static double simulateDarts() {
     return 0.0;
   }


  public static void main(String[] args) {
    PiSolver p = new PiSolver();
    positionX = p.generateRandomValues();
    positionY = p.generateRandomValues();
    System.out.println("Pos X: " + positionX);
    System.out.println("Pos Y: " + positionY);
  }

}
