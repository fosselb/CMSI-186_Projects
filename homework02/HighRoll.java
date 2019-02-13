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
    int count = Integer.parseInt(args[0]);
    int sides = Integer.parseInt(args[1]);
    DiceSet playerDiceSet = new DiceSet(count, sides);

    while( true ) {
      System.out.println("\nWelcome to the High Roll Program!");
      System.out.println("[1] ROLL ALL THE DICE\n[2] ROLL A SINGLE DIE\n[3] CALCULATE THE SCORE FOR THIS SET\n[4] SAVE THIS SCORE AS HIGH SCORE\n[5] DISPLAY THE HIGH SCORE\n[6] ENTER 'q' TO QUIT THE PROGRAM");
      System.out.print( ">>" );
      String inputLine = null;
      try {

        inputLine = input.readLine();
/*
        if (0 == inputLine.length() || Integer.parseInt(inputLine) > 5 || Integer.parseInt(inputLine) < 1) {
          throw new IllegalArgumentException("enter a valid option number");
        }
*/
        if (inputLine.charAt(0) == 'q') {
          System.out.println("\nThank you for playing!");
          break;
        } else {

          if (inputLine.charAt(0) == '1') {
            playerDiceSet.roll();
            System.out.println(playerDiceSet.toString());
          } else if (inputLine.charAt(0) == '2') {
            System.out.println("Which die do you want to roll?");
            System.out.println("\n>>");
            int specficDie = Integer.parseInt(input.readLine()) - 1;
            System.out.println("Your inidivdual roll is: " + playerDiceSet.rollIndividual(specficDie));
            System.out.println(playerDiceSet.toString());
          } else if (inputLine.charAt(0) == '3') {
            playerDiceSet.sum();
            System.out.println("Your current score is " + playerDiceSet.sum());
          } else if (inputLine.charAt(0) == '4') {
            if (playerDiceSet.sum() > savedScore) {
              savedScore = playerDiceSet.sum();
            } else {
              System.out.println("Your current high score is better than this current score.");
              savedScore = savedScore;
            }
          } else if (inputLine.charAt(0) == '5') {
            System.out.println( "High Score is " + savedScore);
          }

        }

      } catch(IOException e) {
        throw new IllegalArgumentException("Error. Please check arguments.");
        //System.out.println("ERROR catch error");
      }
   }
}
}
