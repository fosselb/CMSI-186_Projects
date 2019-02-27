/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  ClockSolver.java
 *  Purpose       :  The main program for the ClockSolver class
 *  @see
 *  @author       :  B.J. Johnson
 *  Date written  :  2017-02-28
 *  Description   :  This class provides a bunch of methods which may be useful for the ClockSolver class
 *                   for Homework 4, part 1.  Includes the following:
  *
 *  Notes         :  None right now.  I'll add some as they occur.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the input arguments are "hinky"
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-28  B.J. Johnson  Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class ClockSolver {
  /**
   *  Class field definintions go here
   */
   private static final double MAX_TIME_SLICE_IN_SECONDS   = 1800.00;
   private static final double DEFAULT_TIME_SLICE_SECONDS  = 60.0;
   private static final double EPSILON_VALUE               = 0.1;      // small value for double-precision comparisons
   private static final double MAX_ELAPSED_TIME_IN_SECONDS = 43200.0;
   private static double angleArg;

  /**
   *  Constructor
   *  This just calls the superclass constructor, which is "Object"
   */
   public ClockSolver() {
      super();
   }

  /**
   *  Method to handle all the input arguments from the command line
   *   this sets up the variables for the simulation
   */
   public void handleInitialArguments( String args[] ) {
     Clock testClock = new Clock();
     try {
       angleArg = testClock.validateAngleArg(args[0]);
     } catch (Exception e) {
       throw new IllegalArgumentException("Please input an Angle Argument that is a number between 0 and 360");
     }




     try {
       //Clock testClock = new Clock();
       if (args.length == 1) {
         testClock.timeSlice = DEFAULT_TIME_SLICE_SECONDS;
       } else {
         if (testClock.validateTimeSliceArg(args[1]) == -1.0) {
           throw new IllegalArgumentException("Please input a Time Slice argument that is a number between 0 and 1800");
         } else {
           testClock.timeSlice = Double.parseDouble(args[1]);
         }
       }
     } catch (Exception e) {
       throw new IllegalArgumentException("Please input a valid argument");
     }



     // args[0] specifies the angle for which you are looking
     //  your simulation will find all the angles in the 12-hour day at which those angles occur
     // args[1] if present will specify a time slice value; if not present, defaults to 60 seconds
     // you may want to consider using args[2] for an "angle window"

      System.out.println( "\n   Hello world, from the ClockSolver program!!\n\n" ) ;
      if( 0 == args.length ) {
         System.out.println( "   Sorry you must enter at least one argument\n" +
                             "   Usage: java ClockSolver <angle> [timeSlice]\n" +
                             "   Please try again..........." );
         System.exit( 1 );
      }
      Clock clock = new Clock();
   }

  /**
   *  The main program starts here
   *  remember the constraints from the project description
   *  @see  http://bjohnson.lmu.build/cmsi186web/homework04.html
   *  @param  args  String array of the arguments from the command line
   *                args[0] is the angle for which we are looking
   *                args[1] is the time slice; this is optional and defaults to 60 seconds
   */
   public static void main( String args[] ) {
      ClockSolver cs = new ClockSolver();
      Clock clock    = new Clock();
      double[] timeValues = new double[3];
      cs.handleInitialArguments( args );
      /*
      System.out.println("Tests: ");
      System.out.println("Tick 1: " + clock.tick());
      System.out.println("Tick 2: " + clock.tick());
      System.out.println("Total Elapsed Time: " + clock.getTotalSeconds());
      System.out.println(clock.toString());
      System.out.println("Hand Angle: " + clock.getHandAngle());
      */
      System.out.println("Here are the times in a 12-Hour day that correspond to your specified angle and time slice: ");
      while( clock.getTotalSeconds() <= MAX_ELAPSED_TIME_IN_SECONDS ) {
        clock.tick();
        if ((angleArg < (clock.getHandAngle() + EPSILON_VALUE)) && (angleArg > (clock.getHandAngle() - EPSILON_VALUE))) {
          System.out.println(clock.toString());
        }
        //System.out.println(clock.getHandAngle());
        /*
        if (clock.getTotalSeconds() > MAX_ELAPSED_TIME_IN_SECONDS) {
          break;
        }
        */
      }
      System.exit( 0 );
   }
}
