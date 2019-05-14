/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  Dart.java
 * Purpose    :  To create a class that handles all methods associated with one dart
 * @author    :  Fosse Lin-Bianco
 * Date       :  2019-05-14
 * Description:
 * Notes      :  None
 * Warnings   :  None
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Revision History
 * ================
 *   Ver      Date     Modified by:      Reason for change or modification
 *  -----  ----------  ------------      ---------------------------------------------------------------------
 *  1.0.0  2019-05-14  Fosse Lin-Bianco  Started coding.
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class Dart {
  /**
   * Field Declarations
   */
  public double positionX;
  public double positionY;
  public double distanceFromOrigin;

  /**
   * Constructor to create a dart object
   * @return randomNum
   */
  public Dart(double x, double y) {
    this.positionX = x;
    this.positionY = y;
    this.distanceFromOrigin = Math.sqrt( Math.pow(this.positionX, 2) + Math.pow(this.positionY, 2) );
  }

  public static void main(String[] args) {
    System.out.println("TESTING");
    Dart d = new Dart(0.1, 0.1);
    System.out.println("X: " + d.positionX);
    System.out.println("Y: " + d.positionY);
    System.out.println("Distance: " + d.distanceFromOrigin);

  }

}
