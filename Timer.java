public class Timer {

  /**
  * Field defenitions
  */
  public static double elapsedTime = 0;
  public static double hour;
  public static double minute;
  public static double second;

   /**
   *  Method to calculate tick
   */
   public double tick() {
     elapsedTime += Ball.timeSlice;
     return elapsedTime;
   }

   /**
    *  Method to return a String representation of this clock
    */
    public String toStringClock() {
       hour = elapsedTime / 3600;
       minute = (elapsedTime % 3600) / 60;
       second = elapsedTime % 60;
       return Math.floor(hour) + ":" + Math.floor(minute) + ":" + second;
    }

  /**
  * Place to make tests for Timer class
  */
  public static void main(String[] args) {
    Timer testTimer = new Timer();
    int count = 0;
    while (count < 100) {
      testTimer.tick();
      System.out.println(testTimer.toStringClock());
      count++;
    }
  }
}
