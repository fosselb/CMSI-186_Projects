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
 *  1.0.1  2019-05-14  Fosse Lin-Bianco  Created method to generate random numbers.
 *  1.0.2  2019-05-14  Fosse Lin-Bianco  Change version numbers.
 *  1.0.3  2019-05-14  Fosse Lin-Bianco  Add estimate pi method.
 *  1.0.4  2019-05-14  Fosse Lin-Bianco  Formatting changes.
 *  1.0.5  2019-05-14  Fosse Lin-Bianco  Add to throwDart() method.
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class PiSolver {
   /**
   * Field Declarations
   */
   public static double dartsInCircle;
   public static double totalDarts;
   public static int numberOfDarts = 0;

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
   public static void throwDart() {
     double x = generateRandomValues();
     double y = generateRandomValues();
     Dart d = new Dart(x, y);
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

    //simulating throwing darts
    // while (numberOfDarts < 1000) {
    //   p.throwDart();
    // }

    System.out.println("Testing: ");
    Dart d1 = new Dart(0.2, 0.2);
    System.out.println("X: " + d1.positionX);
    System.out.println("Y: " + d1.positionY);
    System.out.println("Distance: " + d1.distanceFromOrigin);
  }

}
