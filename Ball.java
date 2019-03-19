public class Ball {

  /**
  * Field defenitions
  */
  private static double x;
  private static double y;
  private static double dx;
  private static double dy;
  public static double timeSlice = 1.0;
  private static final double BALL_RADIUS_IN_FEET = 0.370833;
  private static final double VELOCITY_AT_REST_IN_FEET_PER_SECOND = 0.0833;
  private static final double MAX_FIELD_SIZE = 500;


  /**
  * Constructor
  */
  public Ball(double x, double y, double dx, double dy) {
    this.x = x;
    this.y = y;
    this.dx = dx;
    this.dy = dy;
  }

  /**
  * Method to move ball
  */
  public void moveBall() {
    this.x += (this.dx * timeSlice);
    this.y += (this.dy * timeSlice);
    slowDown();
  }

  /**
  * Method to slow down ball
  */
  public void slowDown() {
    this.dx *= 0.99 * timeSlice;
    this.dy *= 0.99 * timeSlice;
  }

  /**
  * Method to get position of Ball (Encapsulation?)
  */
  public double[] getBallPosition() {
    double[] location = new double[2];
    location[0] = this.x;
    location[1] = this.y;
    return location;
  }

  /**
  * Method to get X position of Ball (Encapsulation?)
  */
  public double getXPosition() {
    return this.x;
  }

  /**
  * Method to get Y position of Ball (Encapsulation?)
  */
  public double getYPosition() {
    return this.y;
  }

  /**
  * Method to get X velocity of Ball (Encapsulation?)
  */
  public double getXVelocity() {
    return this.dx;
  }

  /**
  * Method to get Y velocity of Ball (Encapsulation?)
  */
  public double getYVelocity() {
    return this.dy;
  }

  /**
  * Method to get velocity of Ball in vector format(Encapsulation?)
  */
  public double[] getBallVelocity() {
    double[] velocity = new double[2];
    velocity[0] = this.dx;
    velocity[1] = this.dy;
    return velocity;
  }

  /**
  * Method to output string of position
  */
  public String toStringPosition() {
    return "Location: < " + this.x + ", " + this.y + " > feet";
  }

  /**
  * Method to output string of velocity
  */
  public String toStringVelocity() {
    return "Velocity: < " + this.dx + ", " + this.dy + " > feet/second";
  }

  /**
  * Method to check if a ball is still moving
  */
  public boolean isStillMoving() {
    return (Math.abs(this.dx) > VELOCITY_AT_REST_IN_FEET_PER_SECOND && Math.abs(this.dy) > VELOCITY_AT_REST_IN_FEET_PER_SECOND) ? true : false;
  }

  /**
  * Method to check if ball is in the bounds of the field
  */
  public boolean isInBounds() {
    return (Math.abs(this.x) < MAX_FIELD_SIZE && Math.abs(this.y) < MAX_FIELD_SIZE) ? true : false;
  }

  /**
  * Method to check is balls have collided
  */
  public boolean hasCollided(Ball ball2) {
    if ( Math.sqrt(Math.pow(this.x - ball2.x, 2) + Math.pow(this.y - ball2.y, 2))  < 0.74166 ) {
      return true;
    } else {
      return false;
    }


/*
    double differenceOfX = Math.abs(ballSetTest[0].getXPosition - ballSetTest[1].getXPosition);
    double differenceOfY = Math.abs(ballSetTest[0].getYPosition - ballSetTest[1].getYPosition);
    System.out.println("diff of X: " + differenceOfX);
    System.out.println("diff of Y: " + differenceOfY);
    double lengthBetweenBalls = Math.sqrt(Math.pow(differenceOfX, 2) + Math.pow(differenceOfY, 2));
    return (lengthBetweenBalls < )
    */
  }

  /**
  * Place to make tests for Ball class
  */
  public static void main(String[] args) {
    Ball testBall = new Ball(-300, 300, -20.0, 20.0);
    System.out.println("\n ---WELCOME TO BALL CLASS TEST---\n");
    System.out.println("INITIAL POSITION & VELOCITY:");
    //System.out.println("Ball Location: < " + testBall.getBallPosition()[0] + ", " + testBall.getBallPosition()[1] + " > feet");
    //System.out.println("Ball Velocity: < " + testBall.getBallVelocity()[0] + ", " + testBall.getBallVelocity()[1] + " > feet/second");
    System.out.println(testBall.toStringPosition());
    System.out.println(testBall.toStringVelocity());

    //System.out.println("MOVE BALL 1 time");
    while (testBall.isStillMoving()) {
      testBall.moveBall();
      //System.out.println("Ball Location: < " + testBall.getBallPosition()[0] + ", " + testBall.getBallPosition()[1] + " > feet");
      //System.out.println("Ball Velocity: < " + testBall.getBallVelocity()[0] + ", " + testBall.getBallVelocity()[1] + " > feet/second");
      System.out.println(testBall.toStringPosition());
      System.out.println(testBall.toStringVelocity());
      if (!testBall.isInBounds()) {
        System.out.println("Ball is not in bounds");
        System.exit(0);
      }
    }
    /*
    System.out.println(Math.abs(testBall.dx));
    System.out.println(Math.abs(testBall.dy));
    System.out.println("Is the ball still moving? " + testBall.isStillMoving());
    System.out.println("Is the ball in bounds of field? " + testBall.isInBounds());
    */
    System.out.println("Ball is at rest");
    System.exit(0);
  }
}
