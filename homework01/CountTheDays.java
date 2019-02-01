public class CountTheDays {
  public static void main( String args[] ) {
    long month1 = Long.parseLong(args[0]);
    long day1 = Long.parseLong(args[1]);
    long year1 = Long.parseLong(args[2]);
    long month2 = Long.parseLong(args[3]);
    long day2 = Long.parseLong(args[4]);
    long year2 = Long.parseLong(args[5]);

    String month1String = CalendarStuff.toMonthString(Math.toIntExact(month1));
    String day1String = CalendarStuff.toDayOfWeekString(Math.toIntExact(day1));
    String month2String = CalendarStuff.toMonthString(Math.toIntExact(month2));
    String day2String = CalendarStuff.toMonthString(Math.toIntExact(day2));


    try {
      System.out.println(
        "There are " +
        CalendarStuff.daysBetween(month1, day1, year1, month2, day2, year2) +
        " days between " +
        month1String +
        " " +
        day1 +
        " , " +
        year1 +
        " and " +
        month2String +
        " " +
        day2 +
        " , " +
        year2
      );
    }
    catch(Exception e) {
      System.out.println("Please enter a valid date.");
    }
/*
    System.out.println(
      "There are " +
      CalendarStuff.daysBetween(month1, day1, year1, month2, day2, year2) +
      " days between " +
      month1String +
      " " +
      day1 +
      " , " +
      year1 +
      " and " +
      month2String +
      " " +
      day2 +
      " , " +
      year2
    );
    */
  }
}
