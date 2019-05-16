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
 *  1.0.6  2019-05-15  Fosse Lin-Bianco  Create working program with inputs from command line.

 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class PiSolver {
   /**
   * Field Declarations
   */
   public static double[] position = new double[2];
   public static double dartsInCircle = 0;
   public static double totalDarts = 0;
   public static int numberOfDarts;
   public static final int DEFAULT_NUMBER_OF_DARTS = 1000;
   public static final double circleRadius = 1.0;

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
   public static double[] throwDart() {
     // double x = generateRandomValues();
     // double y = generateRandomValues();
     for (int i = 0; i < position.length; i++) {
       position[i] = generateRandomValues();
     }
     return position;
   }

   /**
    * Method that estimates pi
    * @return estimated pi value
    */
   public static double estimatePi() {
     System.out.println("");
     System.out.println("dartsInCircle = " + dartsInCircle);
     System.out.println("totalDarts = " + totalDarts);
     return (dartsInCircle / totalDarts) * 4;
   }


  public static void main(String[] args) {
    PiSolver p = new PiSolver();

    if (args.length == 0) {
      numberOfDarts = DEFAULT_NUMBER_OF_DARTS;
    } else {
      numberOfDarts = Integer.parseInt(args[0]);
    }

    //simulating throwing darts
    while (totalDarts < numberOfDarts) {
      double currentPosition[] = p.throwDart();

      // System.out.println("current position array: ");
      // for (int i = 0; i < currentPosition.length; i++) {
      //   System.out.println(currentPosition[i]);
      // }

      double currentDistance = Math.sqrt( Math.pow(currentPosition[0], 2) + Math.pow(currentPosition[1], 2) );

      //System.out.println("Distance: " + currentDistance);

      if (currentDistance <= circleRadius) {
        dartsInCircle++;
      }
      totalDarts++;
    }

    // System.out.println("dartsInCircle = " + dartsInCircle);
    // System.out.println("totalDarts = " + totalDarts);

    System.out.println("\n" + "WELCOME TO THE PI SOLVER PROGRAM:");
    System.out.println("================================" + "\n");
    System.out.println("Real value of PI is: " + Math.PI);
    System.out.println("\n" + "Your estimate of PI is: " + p.estimatePi() + "\n");

    // System.out.println("Testing: ");
    // Dart d1 = new Dart(0.2, 0.2);
    // System.out.println("X: " + d1.positionX);
    // System.out.println("Y: " + d1.positionY);
    // System.out.println("Distance: " + d1.distanceFromOrigin);
  }

}
