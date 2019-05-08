/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  DynamicChangeMaker.java
 * Purpose    :  To create a program that uses the dynamic programming algorithm to make the minimal amount\
                 of change for a target amount
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
 *  1.0.0  2019-04-26  Fosse Lin-Bianco  Started coding.
 *  1.0.1  2019-05-08  Fosse Lin-Bianco  Functioning makeChangeWithDynamicProgramming() method.
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.util.Arrays;

public class DynamicChangeMaker {
  /**
   * Field Declarations
   */
   public static int[] inputCoinDenominations = null;
   public static int inputTargetAmount;
   public static Tuple masterTuple = null;
   public static int rowCount;
   public static int columnCount;
   public static Tuple zeroTuple = null;
   private static final boolean DEBUG_ON = false;

   /**
    * Method that validates the arguments inputted into the command line.
    * @param an integer array of denominations
    * @param an integer containing the target amount of cents
    * @throws IllegalArgumentException if:
    *     - the coinDenominations cannot create the target targetAmount
    *     - the coinDenominations contiain a 0, negative number, or a duplicate of a number, not an integer
    *     - the targetAmount is a 0 or negative number
    */
    public static void validateArgs(int[] coinDenominations, int targetAmount) {
      //checking for 0, neagtive, or duplicate in targetAmount
      if (targetAmount <= 0) {
        throw new IllegalArgumentException("Please enter a non-zero, positive integer for the target amount.");
      }

      //checking for 0, neagtive, or duplicate in coinDenominations array
      for (int i = 0; i < coinDenominations.length; i++) {

        if (coinDenominations[i] <= 0) {
          throw new IllegalArgumentException("Please enter a non-zero, positive integer for the coin denominations");
        }

        for (int j = i + 1; j < coinDenominations.length; j++) {
          if (coinDenominations[i] == coinDenominations[j]) {
            throw new IllegalArgumentException("Please do not enter a duplicate number.");
          }
        }

      }
    }

  /**
   * Method that uses dynamic programming algorithm to make the minimal amount of change for a target amount
   * @param an integer array of denominations
   * @param an integer containing the target amount of cents
   * @throws IllegalArgumentException if the count argument is negative
   */
   public static Tuple makeChangeWithDynamicProgramming(int[] coinDenominations, int targetAmount) {
     validateArgs(coinDenominations, targetAmount);
     masterTuple = new Tuple( coinDenominations );
     zeroTuple = new Tuple( coinDenominations.length );
     rowCount = coinDenominations.length;
     columnCount = targetAmount + 1;
     if (DEBUG_ON) {
       System.out.println("Master Tuple: " + masterTuple.toString());
       System.out.println("Zero Tuple: " + zeroTuple.toString());
       System.out.println("rowCount: " + rowCount);
       System.out.println("columnCount: " + columnCount);
     }
     Tuple[][] table = new Tuple[rowCount][columnCount];

     for (int i = 0; i < rowCount; i++) {
       for (int j = 0; j < columnCount; j++) {

         if (j == 0) {
           //placing a tuple full of zeros in this first column
           //System.out.println("***zero tuple: " + zeroTuple);
           table[i][j] = new Tuple( coinDenominations.length );
         } else {

           if (masterTuple.getElement(i) <= j) {
             //CAN take one thing out of current value
             table[i][j] = new Tuple( coinDenominations.length );
             table[i][j].setElement(i, 1);

             //Now, look backwrds to see if there is a valid solution
             if (j - masterTuple.getElement(i) < 0) {
               //if looking backwards goes past the first column(the zero column), then add the IMPOSSIBLE tuple
               table[i][j] = Tuple.IMPOSSIBLE;
             } else {

               if (table[i][j - masterTuple.getElement(i)].isImpossible()) {
                 table[i][j] = Tuple.IMPOSSIBLE;
               } else {
                 table[i][j] = table[i][j].add(table[i][j - masterTuple.getElement(i)]);
               }

             }

             //Now, look at row above (after the first row) to see if there is a better solution
             if (i != 0) {
               //if it is not the first row
               if (!table[i - 1][j].isImpossible()) {
                 //if the row above is not impossible
                 if (table[i][j].isImpossible()) {
                   //if current tuple IS impossible, then take the tuple from the row above
                   table[i][j] = table[i - 1][j];
                 } else {
                   //if the current tuple is NOT impossible, then coompare totals with row above
                   if (table[i - 1][j].total() < table[i][j].total()) {
                     //if the total from the row above is less than the current total
                     //set current Tuple equal to Tuple from row above
                     table[i][j] = table[i - 1][j];
                   }
                 }

               }
             }

           } else {
             //CANNOT take one thing out
             //repeat from before, but no need to look backwards becasue it will always be impossible

             //Now, look at row above (after the first row) to see if there is a better solution
             if (i != 0) {

               //if it is not the first row
               if (!table[i - 1][j].isImpossible()) {
                 //if the row above is not impossible, set that to the current Tuple
                 table[i][j] = table[i - 1][j];
               } else {
                 table[i][j] = Tuple.IMPOSSIBLE;
               }

             } else {
               table[i][j] = Tuple.IMPOSSIBLE;
             }

           }

         }

       }
     }

     // if (table[rowCount - 1][columnCount - 1].isImpossible()) {
     //   throw new IllegalArgumentException("This is IMPOSSIBLE");
     // } else {
     //   return table[rowCount - 1][columnCount - 1];
     // }

     return table[rowCount - 1][columnCount - 1];

   }

  /**
   * Main method to get argumetn from command line
   */
   public static void main(String[] args) {
     try {
       //validating if there are more than 2 arguments
       if (args.length != 2) {
         throw new IllegalArgumentException("Please enter 2 arguments. Please follow this order <coin denominations> <target amount>");
       }

       //parsing arguemnts into Array and inputTargetAmount
       inputTargetAmount = Integer.parseInt(args[1]);
       String[] inputArgs = args[0].split(",");
       inputCoinDenominations = new int[inputArgs.length];
       for (int i = 0; i < inputCoinDenominations.length; i++) {
         inputCoinDenominations[i] = Integer.parseInt(inputArgs[i]);
       }

       //running programs
       DynamicChangeMaker dcm = new DynamicChangeMaker();
       Tuple result = dcm.makeChangeWithDynamicProgramming(inputCoinDenominations, inputTargetAmount);

       System.out.println("\n");
       System.out.println("Hello World from the Change Maker Program:");
       System.out.println("==========================================");

       //System.out.println(result.toString());

       if (result.isImpossible()) {
         System.out.println("\n" + "This is IMPOSSIBLE" + "\n");
         System.exit(0);
       }

       System.out.println(
       "\n" +
       inputTargetAmount + " cents can be made with " + result.total() + " coins as follows:");

       for (int i = 0; i < inputCoinDenominations.length; i++) {
         System.out.println(" -> " + result.getElement(i) + " x " + inputCoinDenominations[i] + " cent coins.");
       }
       System.out.println("");


     } catch (IllegalArgumentException iae) {
       System.out.println("\n" + "  " + iae + "\n");
       System.exit(0);
     }

   }

}
