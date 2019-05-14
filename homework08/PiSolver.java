/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  PiSolver.java
 * Purpose    :  To create a program that estimates the value of PI by throwing random darts at a circle within a square
 * @author    :  Fosse Lin-Bianco
 * Date       :  2019-05-13
 * Description:
 * Notes      :  None
 * Warnings   :  None
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Revision History
 * ================
 *   Ver      Date     Modified by:      Reason for change or modification
 *  -----  ----------  ------------      ---------------------------------------------------------------------
 *  1.0.0  2019-05-13  Fosse Lin-Bianco  Started coding.
 *  1.0.1  2019-05-14  Fosse Lin-Bianco
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class PiSolver {
   /**
   * Field Declarations
   */
   public double dartsInCircle;
   public double totalDarts;

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
    */
   public static double throwDart() {

   }

   /**
    * Method that estimates pi
    * @return estimated pi value
    */
   public static double estimatePi() {
     return (dartsInCircle / totalDarts) * 4;
   }


  public static void main(String[] args) {
    PiSolver p = new PiSolver();

    System.out.println("TESTING generateRandomValues(): ");
    positionX = p.generateRandomValues();
    positionY = p.generateRandomValues();
    System.out.println("Pos X: " + positionX);
    System.out.println("Pos Y: " + positionY);
  }

}
