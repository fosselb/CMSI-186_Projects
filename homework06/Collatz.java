/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  Collatz.java
 * Purpose    :  Running Collatz sequence and returning the number of steps it takes.
 * @author    :  Fosse Lin-Bianco
 * Date       :  2019-04-04
 * Description:  @see <a href='http://bjohnson.lmu.build/cmsi186web/homework06.html'>Assignment Page</a>
 * Notes      :  None
 * Warnings   :  None
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Revision History
 * ================
 *   Ver      Date     Modified by:      Reason for change or modification
 *  -----  ----------  ------------      ---------------------------------------------------------------------
 *  1.0.0  2019-04-10  Fosse Lin-Bianco  Initial writing and begin coding
 *
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class Collatz {
  //public static BrobInt arg = null;
  //private BrobInt count = new BrobInt("0");

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to validate arguments
   *  @param  bint
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public void validateArgs( String args ) {
     BrobInt b = new BrobInt(args);
     if (b.equals(BrobInt.ZERO)) {
       throw new IllegalArgumentException("\nERROR: This sequence will go on forever and it is impossible to reach 1");
     } else if (args == " ") {
       throw new IllegalArgumentException("ERROR: Please enter a number to begin");
     } else if (args.contains(".")) {
       throw new IllegalArgumentException("ERROR: Please enter a whole number to begin");
     }

   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to run the Collatz Sequence
   *  @param  bint         BrobInt to be placed into Collatz sequence
   *  @return BrobInt that is the number of steps needed to complete the sequence
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt runCollatz( BrobInt bint ) {
     BrobInt count = new BrobInt("0");
     BrobInt b = new BrobInt(bint.internalValue);
     b.sign = bint.sign;

     while (b.compareTo(BrobInt.ONE) == 1) {
       b = (b.remainder(BrobInt.TWO).equals(BrobInt.ZERO)) ? b.divide(BrobInt.TWO) : (b.multiply(BrobInt.THREE).add(BrobInt.ONE));
       count = count.add(BrobInt.ONE);
     }
     return count;
     //throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  the main method redirects the user to the test class
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public static void main( String[] args ) {
     System.out.println( "\n  Hello, world, from the Collatz program!!\n" );

     try {
       Collatz c = new Collatz();
       c.validateArgs(args[0]);
       BrobInt arg = new BrobInt(args[0]);

       System.out.println("Make new BrobInt : " + arg.toString());
       System.out.println("The number of steps in the Collatz sequence is " + c.runCollatz(arg).toString());
     } catch (Exception iae) {
       System.out.println(iae);
       System.exit(0);
     }

     }


   }
