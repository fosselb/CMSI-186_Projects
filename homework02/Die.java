public class Die {

  /**
   * private instance data
   */
   private int sides;
   private int pips;
   private final int MINIMUM_SIDES = 4;

   // public constructor:
  /**
   * constructor
   * @param nSides int value containing the number of sides to build on THIS Die
   * @throws IllegalArgumentException
   * Note: parameter must be checked for validity; invalid value must throw "IllegalArgumentException"
   */

   public Die( int nSides ) {
     isValid(nSides);
     try {
       Math.toIntExact(nSides);
     } catch (IllegalArgumentException e) {
       System.out.println("Please enter a valid number");
     }
     this.sides = nSides;
     this.pips = 0;
   }

   public int isValid(int sides) {
     if (sides < MINIMUM_SIDES) {
       throw new IllegalArgumentException("Please enter a larger integer");
     }
     return sides;
   }

  /**
   * Roll THIS die and return the result
   * @return  integer value of the result of the roll, randomly selected
   */
   //instance method
   //Die d = new Die(...)
   //d.roll();
   public int roll() {
     this.pips = (int) ((Math.floor(Math.random() * this.sides)) + 1);
     return this.pips;
   }

  /**
   * Get the value of THIS die to return to the caller; note that the way
   *  the count is determined is left as a design decision to the programmer
   *  For example, what about a four-sided die - which face is considered its
   *  "value"?
   * @return the pip count of THIS die instance
   */
   public int getValue() {
     return this.pips;
   }

  /**
   * @param  int  the number of sides to set/reset for this Die instance
   * @return      The new number of sides, in case anyone is looking
   * @throws      IllegalArgumentException
   */
   public int setSides( int sides ) {
     isValid(sides);
     this.sides = sides;
     if (this.pips > sides) {
       this.pips = 1;
     }
     return this.sides;
   }

   public int getSides() {
     return this.sides;
   }

  /**
   * Public Instance method that returns a String representation of THIS die instance
   * @return String representation of this Die
   */
   public String toString() {
      return "[" + Integer.toString(this.pips) + "]";
   }

  /**
   * Class-wide method that returns a String representation of THIS die instance
   * @return String representation of this Die
   */
   public static String toString( Die d ) {
      return "[" + Integer.toString(d.sides) + "]";
   }

  /**
   * A little test main to check things out
   */
   public static void main( String[] args ) {
      System.out.println( "Hello world from the Die class..." );
   }

}
