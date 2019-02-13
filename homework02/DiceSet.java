public class DiceSet {

  /**
   * private instance data
   */
   private int count;
   private int sides;
   private Die[] ds = null;


   // public constructor:
  /**
   * constructor
   * @param  count int value containing total dice count
   * @param  sides int value containing the number of sides on each die
   * @throws IllegalArgumentException if one or both arguments don't make sense
   * @note   parameters are checked for validity; invalid values throw "IllegalArgumentException"
   */
   public DiceSet( int count, int sides ) {
     if (count >= 1 && sides >= 4) {
       ds = new Die[ count ];
       for (int i = 0; i < count; i++) {
         ds[i] = new Die(sides);
       }
       this.count = count;
       this.sides = sides;
     } else {
       throw new IllegalArgumentException("Please enter a count larger than 1 and a number of dies greater than 4");
     }
   }

  /**
   * @return the sum of all the dice values in the set
   */
   public int sum() {
     int sumValue = 0;
     for (int i = 0; i < count; i++) {
       sumValue += ds[i].getValue();
     }
     return sumValue;
   }

  /**
   * Randomly rolls all of the dice in this set
   *  NOTE: you will need to use one of the "toString()" methods to obtain
   *  the values of the dice in the set
   */
   public void roll() {
     for (int i = 0; i < count; i++) {
       ds[i].roll();
       ds[i].toString();
     }
   }

  /**
   * Randomly rolls a single die of the dice in this set indexed by 'dieIndex'
   * @param  dieIndex int of which die to roll
   * @return the integer value of the newly rolled die
   * @throws IllegalArgumentException if the index is out of range
   */
   public int rollIndividual( int dieIndex ) {
     if (dieIndex < 0 || dieIndex > count) {
       throw new IllegalArgumentException("Please enter a valid dieIndex");
     }
     return ds[dieIndex].roll();
   }

  /**
   * Gets the value of the die in this set indexed by 'dieIndex'
   * @param  dieIndex int of which die to roll
   * @trhows IllegalArgumentException if the index is out of range
   */
   public int getIndividual( int dieIndex ) {
     if (dieIndex < 0 || dieIndex > count) {
       throw new IllegalArgumentException();
     }
      return ds[dieIndex].getValue();
   }

  /**
   * @return Public Instance method that returns a String representation of the DiceSet instance
   */
   public String toString() {
     String result = "";
     for (int i = 0; i < count; i++) {
       result += ds[i].toString();
     }
     return result;
   }

  /**
   * @return Class-wide version of the preceding instance method
   */
   public static String toString( DiceSet frank ) {
     String result = "";
     for (int i = 0; i < frank.ds.length; i++) {
       result += frank.ds[i].toString();
     }
     return result;
   }

  /**
   * @return  true iff this set is identical to the set passed as an argument
   */
   public boolean isIdentical( DiceSet jill ) {
     if (jill.ds.length == ds.length && jill.sum() == sum()) {
       for (int i = 0; i < jill.ds.length; i++) {
         if (jill.ds[i] == ds[i]) {
           return true;
         }
       }
     }
     return false;
   }
  /**
   * A little test main to check things out
   */
   public static void main( String[] args ) {
      DiceSet ds36 = new DiceSet( 3, 6 );
      //System.out.println( ds36.roll() );
      ds36.roll();
      System.out.println(ds36.toString());
   }

}
