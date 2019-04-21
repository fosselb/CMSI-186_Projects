/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  BrobInt.java
 * Purpose    :  Learning exercise to implement arbitrarily large numbers and their operations
 * @author    :  Fosse Lin-Bianco
 * Date       :  2019-04-10
 * Description:  @see <a href='http://bjohnson.lmu.build/cmsi186web/homework06.html'>Assignment Page</a>
 * Notes      :  None
 * Warnings   :  None
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Revision History
 * ================
 *   Ver      Date     Modified by:      Reason for change or modification
 *  -----  ----------  ------------      ---------------------------------------------------------------------
 *  1.0.0  2017-04-04  B.J. Johnson      Initial writing and begin coding
 *  1.1.0  2017-04-13  B.J. Johnson      Completed addByt, addInt, compareTo, equals, toString, Constructor,
 *                                         validateDigits, two reversers, and valueOf methods; revamped equals
 *                                         and compareTo methods to use the Java String methods; ready to
 *                                         start work on subtractByte and subtractInt methods
 *  1.1.1  2019-04-13  Fosse Lin-Bianco  Begin coding
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BrobInt {

   public static final BrobInt ZERO     = new BrobInt(  "0" );      /// Constant for "zero"
   public static final BrobInt ONE      = new BrobInt(  "1" );      /// Constant for "one"
   public static final BrobInt TWO      = new BrobInt(  "2" );      /// Constant for "two"
   public static final BrobInt THREE    = new BrobInt(  "3" );      /// Constant for "three"
   public static final BrobInt FOUR     = new BrobInt(  "4" );      /// Constant for "four"
   public static final BrobInt FIVE     = new BrobInt(  "5" );      /// Constant for "five"
   public static final BrobInt SIX      = new BrobInt(  "6" );      /// Constant for "six"
   public static final BrobInt SEVEN    = new BrobInt(  "7" );      /// Constant for "seven"
   public static final BrobInt EIGHT    = new BrobInt(  "8" );      /// Constant for "eight"
   public static final BrobInt NINE     = new BrobInt(  "9" );      /// Constant for "nine"
   public static final BrobInt TEN      = new BrobInt( "10" );      /// Constant for "ten"

  /// Some constants for other intrinsic data types
  ///  these can help speed up the math if they fit into the proper memory space
   public static final BrobInt MAX_INT  = new BrobInt( Integer.valueOf( Integer.MAX_VALUE ).toString() );
   public static final BrobInt MIN_INT  = new BrobInt( Integer.valueOf( Integer.MIN_VALUE ).toString() );
   public static final BrobInt MAX_LONG = new BrobInt( Long.valueOf( Long.MAX_VALUE ).toString() );
   public static final BrobInt MIN_LONG = new BrobInt( Long.valueOf( Long.MIN_VALUE ).toString() );

  /// These are the internal fields
   public  String internalValue = "";        // internal String representation of this BrobInt
   public  byte   sign          = 0;         // "0" is positive, "1" is negative
   private String reversed      = "";        // the backwards version of the internal String representation
   private int[] numsReversed = null;
   //private int[] carryArray = null;
   //private BrobInt newBint = null;

   private static BufferedReader input = new BufferedReader( new InputStreamReader( System.in ) );
   private static final boolean DEBUG_ON = false;

  /**
   *  Constructor takes a string and assigns it to the internal storage, checks for a sign character
   *   and handles that accordingly;  it then checks to see if it's all valid digits, and reverses it
   *   for later use
   *  @param  value  String value to make into a BrobInt
   */
   public BrobInt( String value ) {
      super();			// replace this with the appropriate code to accomplish what is in the javadoc text

      try {
        //assigns parameter to internal storage
        this.internalValue = value;

        //checks for a sign character
        if (this.internalValue.charAt(0) == '-') {
          this.sign = 1;
          this.internalValue = this.internalValue.substring(1);
        } else if (this.internalValue.charAt(0) == '+') {
          this.internalValue = this.internalValue.substring(1);
        }

        //reverses internal value
        this.reversed = new StringBuilder(internalValue).reverse().toString();

        //creates array of integers
        this.numsReversed = new int[this.internalValue.length()];

        //populates Array
        for (int i = 0; i < this.numsReversed.length; i++) {
          this.numsReversed[i] = Integer.parseInt(this.reversed.substring(i, i + 1));
        }


      } catch (IllegalArgumentException iae) {
        System.out.println(iae);
        System.exit(0);
      }

      if (false) {
        System.out.println("DEBUGGING");
        System.out.println(internalValue);
        System.out.println(reversed);
        System.out.println(this.numsReversed[0]);
      }

   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to validate that all the characters in the value are valid decimal digits
   *  @return  boolean  true if all digits are good
   *  @throws  IllegalArgumentException if something is hinky
   *  note that there is no return false, because of throwing the exception
   *  note also that this must check for the '+' and '-' sign digits
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public boolean validateDigits() throws IllegalArgumentException {
      throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to reverse the value of this BrobInt
   *  @return BrobInt that is the reverse of the value of this BrobInt
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt reverser() {
     throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
/*
     String value = ;
     BrobInt bi = new BrobInt(String value);
     String reversedValue = new StringBuilder(value).reverse().toString();
     bi.internalValue = reversedS;
     return bi;
*/
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to reverse the value of a BrobIntk passed as argument
   *  Note: static method
   *  @param  bint         BrobInt to reverse its value
   *  @return BrobInt that is the reverse of the value of the BrobInt passed as argument
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public static BrobInt reverser( BrobInt bint ) { //???
      throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to add the value of a BrobInt passed as argument to this BrobInt using byte array
   *  @param  bint         BrobInt to add to this
   *  @return BrobInt that is the sum of the value of this BrobInt and the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt add( BrobInt bint ) {
     int[] newBintArray = null;
     int[] carryArray = null;

     if (this.numsReversed.length < bint.numsReversed.length) {
       int[] temp = this.numsReversed;
       this.numsReversed = bint.numsReversed;
       bint.numsReversed = temp;
     }

     newBintArray = new int[this.numsReversed.length];
     for (int i = 0; i < bint.numsReversed.length; i++) {
       newBintArray[i] = bint.numsReversed[i];
     }

     int[] resultArray = new int[this.numsReversed.length + 1];
     carryArray = new int[this.numsReversed.length + 1];

     if ((this.sign == 0 && bint.sign == 0) || (this.sign == 1 && bint.sign == 1)) {
       for (int i = 0; i < this.numsReversed.length; i++) {
         int result = this.numsReversed[i] + newBintArray[i] + carryArray[i];
         if (result >= 10) {
           resultArray[i] = result % 10;
           carryArray[i + 1] = 1;
         } else {
           resultArray[i] = result;
         }

         if (i + 1 == this.numsReversed.length && carryArray[i + 1] == 1) {
           resultArray[i + 1] = 1;
         }
       }
     }

     StringBuilder stringBuilder = new StringBuilder();
     for (int j = resultArray.length - 1; j >= 0; j--) {
       stringBuilder.append(resultArray[j]);
     }
     String joinedString = stringBuilder.toString();

     if (this.sign == 1 && bint.sign == 1) {

       BrobInt b = new BrobInt( joinedString );
       b = b.removeLeadingZeros(b);
       return new BrobInt( "-" + b.internalValue );
     }

     BrobInt b = new BrobInt( joinedString );
     return b.removeLeadingZeros(b);
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to subtract the value of a BrobIntk passed as argument to this BrobInt using bytes
   *  @param  bint         BrobInt to subtract from this
   *  @return BrobInt that is the difference of the value of this BrobInt and the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt subtract( BrobInt bint ) {
     throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to multiply the value of a BrobIntk passed as argument to this BrobInt
   *  @param  bint         BrobInt to multiply this by
   *  @return BrobInt that is the product of the value of this BrobInt and the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt multiply( BrobInt bint ) {
      throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to divide the value of this BrobIntk by the BrobInt passed as argument
   *  @param  bint         BrobInt to divide this by
   *  @return BrobInt that is the dividend of this BrobInt divided by the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt divide( BrobInt bint ) {
      throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to get the remainder of division of this BrobInt by the one passed as argument
   *  @param  bint         BrobInt to divide this one by
   *  @return BrobInt that is the remainder of division of this BrobInt by the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt remainder( BrobInt bint ) {
      throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to compare a BrobInt passed as argument to this BrobInt
   *  @param  bint  BrobInt to add to this
   *  @return int   that is one of neg/0/pos if this BrobInt precedes/equals/follows the argument
   *  NOTE: this method does not do a lexicographical comparison using the java String "compareTo()" method
   *        It takes into account the length of the two numbers, and if that isn't enough it does a
   *        character by character comparison to determine
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public int compareTo( BrobInt bint ) {

     // handle the signs here
      if( 1 == sign && 0 == bint.sign ) {
         return -1;
      } else if( 0 == sign && 1 == bint.sign ) {
         return 1;
      }

     // the signs are the same at this point
     // check the length and return the appropriate value
     //   1 means this is longer than bint, hence larger
     //  -1 means bint is longer than this, hence larger
      if( internalValue.length() > bint.internalValue.length() ) {
         return 1;
      } else if( internalValue.length() < bint.internalValue.length() ) {
         return (-1);

     // otherwise, they are the same length, so compare absolute values
      } else {
         for( int i = 0; i < internalValue.length(); i++ ) {
            Character a = Character.valueOf( internalValue.charAt(i) );
            Character b = Character.valueOf( bint.internalValue.charAt(i) );
            if( Character.valueOf(a).compareTo( Character.valueOf(b) ) > 0 ) {
               return 1;
            } else if( Character.valueOf(a).compareTo( Character.valueOf(b) ) < 0 ) {
               return (-1);
            }
         }
      }
      return 0;
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to check if a BrobInt passed as argument is equal to this BrobInt
   *  @param  bint     BrobInt to compare to this
   *  @return boolean  that is true if they are equal and false otherwise
   *  NOTE: this method performs a similar lexicographical comparison as the "compareTo()" using the
   *        java String "equals()" method -- THAT was easy..........
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public boolean equals( BrobInt bint ) {
      return (internalValue.equals( bint.toString() ));
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to return a BrobInt given a long value passed as argument
   *  @param  value    long type number to make into a BrobInt
   *  @return BrobInt  which is the BrobInt representation of the long
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public static BrobInt valueOf( long value ) throws NumberFormatException {
      BrobInt bi = null;
      try { bi = new BrobInt( Long.valueOf( value ).toString() ); }
      catch( NumberFormatException nfe ) { throw new NumberFormatException( "\n  Sorry, the value must be numeric of type long." ); }
      return bi;
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to return a String representation of this BrobInt
   *  @return String  which is the String representation of this BrobInt
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public String toString() {
     //BrobInt b = new BrobInt(this.internalValue);
     //BrobInt result = b.removeLeadingZeros(b);
     //return (result.sign == 0) ? (result.internalValue) : ("-" + result.internalValue);
     return (this.sign == 0) ? (this.internalValue) : ("-" + this.internalValue);
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to remove leading zeros from a BrobInt passed as argument
   *  @param  gint     BrobInt to remove zeros from
   *  @return BrobInt that is the argument BrobInt with leading zeros removed
   *  Note that the sign is preserved if it exists
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt removeLeadingZeros( BrobInt gint ) {
      Character sign = null;
      String returnString = gint.toString();
      int index = 0;
      if( allZeroDetect( gint ) ) {
         return gint;
      }
      if( ('-' == returnString.charAt( index )) || ('+' == returnString.charAt( index )) ) {
         sign = returnString.charAt( index );
         index++;
      }
      if( returnString.charAt( index ) != '0' ) {
         return gint;
      }
      while( returnString.charAt( index ) == '0' ) {
         index++;
      }
      returnString = gint.toString().substring( index, gint.toString().length() );
      if( sign != null ) {
         returnString = sign.toString() + returnString;
      }
      return new BrobInt( returnString );
   }
  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to return a boolean if a BrobInt is all zeros
   *  @param  gint     BrobInt to compare to this
   *  @return boolean  that is true if the BrobInt passed is all zeros, false otherwise
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public boolean allZeroDetect( BrobInt gint ) {
      for( int i = 0; i < gint.toString().length(); i++ ) {
         if( gint.toString().charAt(i) != '0' ) {
            return false;
         }
      }
      return true;
   }
  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to display an Array representation of this BrobInt as its bytes
   *  @param   d  byte array from which to display the contents
   *  NOTE: may be changed to int[] or some other type based on requirements in code above
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public void toArray( byte[] d ) {
      System.out.println( "Array contents: " + Arrays.toString( d ) );
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to display a prompt for the user to press 'ENTER' and wait for her to do so
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public void pressEnter() {
      String inputLine = null;
      try {
         System.out.print( "      [Press 'ENTER' to continue]: >> " );
         inputLine = input.readLine();
      }
      catch( IOException ioe ) {
         System.out.println( "Caught IOException" );
      }
   }
  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  the main method redirects the user to the test class
   *  @param  args  String array which contains command line arguments
   *  NOTE:  we don't really care about these, since we test the BrobInt class with the BrobIntTester
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public static void main( String[] args ) {
      System.out.println("=========================================");
      System.out.println( "\n  Hello, world, from the BrobInt program!!\n" );
      System.out.println( "\n   You should run your tests from the BrobIntTester...\n" );
      System.out.println("TEST 1:");
      BrobInt b = new BrobInt("-1234567890");
      System.out.println("Make new BrobInt : " + b.toString());
      System.out.println("Internal Value: " + b.internalValue);
      System.out.println("Sign Value: " + b.sign);
      System.out.print("numsReversed array: ");
      for (int i = 0; i < b.numsReversed.length; i++) {
        System.out.print(b.numsReversed[i] + " ");
      }
      System.out.println("\nTEST 2:");
      BrobInt b1 = new BrobInt("-0000003");
      System.out.println("Make new BrobInt : " + b1.toString());
      BrobInt b2 = new BrobInt("-0007053");
      System.out.println("Make new BrobInt : " + b2.toString());
      System.out.println("Add b1 and b2: " + b1.add(b2));

      System.out.println("\nTEST 3:");
      BrobInt b3 = new BrobInt("479");
      System.out.println("Make new BrobInt : " + b3.toString());
      BrobInt b4 = new BrobInt("322441");
      System.out.println("Make new BrobInt : " + b4.toString());
      /*
      System.out.print("numsReversed b3 = ");
      for (int i = 0; i < b3.numsReversed.length; i++) {
        System.out.print(b3.numsReversed[i]);
      }
      System.out.print("\nnumsReversed b4 = ");
      for (int i = 0; i < b4.numsReversed.length; i++) {
        System.out.print(b4.numsReversed[i]);
      }
      System.out.println("\nInternal value = " + b4.internalValue);
      */
      System.out.println("\nAdd b3 and b4: " + b3.add(b4));

      System.out.println("\nTEST 4:");
      BrobInt b5 = new BrobInt("00001");
      System.out.println("Make new BrobInt and remove leading zeros: " + b5.removeLeadingZeros(b5));
      System.exit( 0 );
   }
}
