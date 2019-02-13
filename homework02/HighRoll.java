import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class HighRoll {

  public static void main( String args[] ) {
    //System.out.println("\nWelcome to the High Roll Program!");
    //System.out.println("Press the 'q' key to quit the program.");
    //System.out.println("[1] ROLL ALL THE DICE\n[2] ROLL A SINGLE DIE\n[3] CALCULATE THE SCORE FOR THIS SET\n[4] SAVE THIS SCORE AS HIGH SCORE\n[5] DISPLAY THE HIGH SCORE\n[6] ENTER 'q' TO QUIT THE PROGRAM");

  // This line uses the two classes to assemble an "input stream" for the user to type
  // text into the program
    BufferedReader input = new BufferedReader( new InputStreamReader( System.in ) );
    int savedScore = 0;
    while( true ) {
      System.out.println("\nWelcome to the High Roll Program!");
      System.out.println("[1] ROLL ALL THE DICE\n[2] ROLL A SINGLE DIE\n[3] CALCULATE THE SCORE FOR THIS SET\n[4] SAVE THIS SCORE AS HIGH SCORE\n[5] DISPLAY THE HIGH SCORE\n[6] ENTER 'q' TO QUIT THE PROGRAM");
      System.out.print( ">>" );
      String inputLine = null;
      try {
        int count = Integer.parseInt(args[0]);
        int sides = Integer.parseInt(args[1]);
        DiceSet playerDiceSet = new DiceSet(count, sides);
        inputLine = input.readLine();
/*
        if ('q' == inputLine.charAt(0)) {
          System.out.println("\nThank you for playing!");
          break;
        }
*/
        if (inputLine.charAt(0) == 'q') {
          System.out.println("\nThank you for playing!");
          break;
        } else if (0 == inputLine.length() || Integer.parseInt(inputLine) > 5 || Integer.parseInt(inputLine) < 1) {
          System.out.println("enter a valid option number");
        } else {
          if (inputLine.charAt(0) == '1') {
            playerDiceSet.roll();
            System.out.println(playerDiceSet.toString());
          } else if (inputLine.charAt(0) == '2') {
            System.out.println("Which die would you like to roll?");
            int specficDie = Integer.parseInt(args[1]);
            playerDiceSet.rollIndividual(specficDie);
            playerDiceSet.getIndividual(specficDie);
          } else if (inputLine.charAt(0) == '3') {
            //playerDiceSet.sum();
            System.out.println(playerDiceSet.sum());
          } else if (inputLine.charAt(0) == '4') {
            savedScore = playerDiceSet.sum();
          } else if (inputLine.charAt(0) == '5') {
            System.out.println( "High Score is " + savedScore);
          }

        }
      } catch(Exception e) {
        System.out.println( "Error. Please check arguments." );
        break;
      }
   }
}
}
