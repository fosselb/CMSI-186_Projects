public class SoccerSim {

  /**
  * Field defenitions
  */
  private static double x;
  private static double y;
  private static double dx;
  private static double dy;
  //private static double timeSlice = 1.0;
  private static int numberOfBallsOnField = 0;
  private static int numberOfCollisions = 0;

  /**
  * methods
  */
/*
  public void moveAllBalls(Ball b) {
    for (int i = 0; i < numberOfBallsOnField; i++) {
      b[i].moveBall();
    }
  }
*/

  public Ball[] validateArgs(String[] args) {
    int argsLength = args.length;
    Ball[] b;

      //checking length of arguments
      if (argsLength % 4 == 1) {
        Ball.timeSlice = Double.parseDouble(args[argsLength - 1]);
      } else if (argsLength % 4 == 0) {
        argsLength++;
      } else {
        throw new IllegalArgumentException("\nPlease enter a valid number of arguments." +
        "\n The first 2 arguments will describe the ball position, respectively." +
        "\n The next set of arguments will describe the ball velocity in x and y direction, respectively." +
        "\n The finally argument will describe the time Slice. (This is optional)" +
        "\n Example of valid argument input: 300 300 -1.0 1.0 10.0");

      }

      numberOfBallsOnField = (argsLength - 1) / 4;

      b = new Ball[numberOfBallsOnField];

    try {
      //populate array
      int count = 0;
      for (int i = 0; i < argsLength - 1; i += 4) {
        b[count] = new Ball(Double.parseDouble(args[i]), Double.parseDouble(args[i + 1]), Double.parseDouble(args[i + 2]), Double.parseDouble(args[i + 3]));
        count++;
      }

    } catch (IllegalArgumentException e) {
      System.out.println("Please enter a number as a valid arguments");
      System.exit(0);
    }

    return b;
  }

  /**
  * Place to make tests for SoccerSim class
  */
  public static void main(String[] args) {
    SoccerSim ss = new SoccerSim();
    Ball[] b = null;
    b = ss.validateArgs(args);
    Timer simulationTimer = new Timer();

    System.out.println("\n--- WELCOME TO SOCCER SIMULATION ---\n");
    System.out.println("The size of the soccer field is <-500, 500> in the x direction and <-500, 500> in the y direction\n");
    System.out.println(b[0].toStringPosition());
    System.out.println(b[0].toStringVelocity());
    System.out.println(b[1].toStringPosition());
    System.out.println(b[1].toStringVelocity());
    System.out.println(Ball.timeSlice);
    System.out.println("test end\n");

    while ( true ) {
      simulationTimer.tick();

      //moves all the balls 1 time slice
      //ss.moveAllBalls();
      System.out.println("Progress report at " + simulationTimer.toStringClock());
      for (int i = 0; i < b.length; i++) {
        System.out.println("Ball " + i + ": " + b[i].toStringPosition() + "      " + b[i].toStringVelocity());
      }

      for (int i = 0; i < b.length; i++) {
        b[i].moveBall();
        System.out.println("Progress report at " + simulationTimer.toStringClock());
        System.out.println("Ball " + i + ": " + b[i].toStringPosition() + "      " + b[i].toStringVelocity());
      }


      //checking for collision
      for (int i = 0; i < b.length - 1; i++) {
        for (int j = i + 1; j < b.length; j++) {
          if (b[i].hasCollided(b[j])) {
            numberOfCollisions++;
            System.out.println("A collision has occured between ball " + i + " and ball " + j + " at: " + b[i].toStringPosition());
            System.exit(0);
          }
        }
      }

      //checking if all balls are moving and in bounds
      for (int i = 0; i < b.length; i++) {
        if(!b[i].isInBounds() || !b[i].isStillMoving()) {
          System.out.println("All soccer balls have stopped moving. No collision possible");
          System.exit(0);
        }
      }

    }

  }
}
