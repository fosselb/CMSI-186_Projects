public class Riemann {

  /**
  * Field defenitions
  */
  public static double percent;
  private static final double DEFAULT_PERCENT = 1.0;
  public static double lowerBound;
  public static double upperBound;
  public static int argsLength;
  public static double[] coeff;

  /**
  * Methods
  */
  public void validateArgs(String args[]) throws IllegalArgumentException {
    argsLength = args.length;

    //check for run Tests
    if (args[0].equals("runtests")) {
      return;
    }

    //percent value
    if (args.length < 3) {
      throw new IllegalArgumentException("\nYou must have at least 3 arguemnts\nFormat: <functionName> <additionalDescriptors> <lowerBound> <upperBound> <percent%>");
    }

    //assign and check percent value
    if (args[args.length - 1].contains("%")) {
      percent = Double.parseDouble(args[args.length - 1].substring(0, args[args.length - 1].length() - 1));
      if (percent <= 0.0 || percent >= 100.0) {
        throw new IllegalArgumentException("\nPlease enter a percentage that is postive, greater than 0, and less than 100");
      }
      upperBound = Double.parseDouble(args[args.length - 2]);
      lowerBound = Double.parseDouble(args[args.length - 3]);
    } else {
      percent = DEFAULT_PERCENT;
      argsLength++;
      upperBound = Double.parseDouble(args[args.length - 1]);
      lowerBound = Double.parseDouble(args[args.length - 2]);
    }

    if (upperBound < lowerBound) {
      throw new IllegalArgumentException("\nPlease enter valid lower and upper bounds");
    }

    //create coeff array
    int numberOfCoeff = argsLength - 4;
    coeff = new double[numberOfCoeff];
    for(int i = 0; i < numberOfCoeff; i++) {
      coeff[i] = Double.parseDouble(args[i + 1]);
    }

  }

  private void resetValues() {
    lowerBound = 0.0;
    upperBound = 0.0;
    percent = 0.0;
    coeff = new double[0];
  }

  private void testPoly() {
    Riemann r = new Riemann();
    Functions f = new Functions();
    System.out.println("-- Test Polynomial Function --\n");
    System.out.println("Test 0: <poly> <0.0> <8.0> <-2.0> <1.0> <4.0> <1e-6%>");
    String[] testArgs0 = {"poly", "0.0", "8.0", "-2.0", "1.0", "4.0", "1e-6%"};
    r.validateArgs(testArgs0);
    System.out.println("The Riemann Sum approximation is " + f.calculatePoly(lowerBound, upperBound, coeff, f.n));
    System.out.println("-------------------------------------");
    //r.resetValues();
  }

  private void testSine() {
    Riemann r = new Riemann();
    Functions f = new Functions();
    System.out.println("-- Test Sine Function --\n");
    System.out.println("Test 1: <sin> <0.0> <1.0> <-3.45> <6.789> <1.5e-4%> ");
    String[] testArgs1 = {"0.0", "1.0", "-3.45", "6.789", "1.5e-4%"};
    r.validateArgs(testArgs1);
    System.out.println("The Riemann Sum approximation is " + f.calculateSine(lowerBound, upperBound, coeff, f.n));
    System.out.println("-------------------------------------");
  }

  public static void main(String[] args) {
    Riemann r = new Riemann();
    Functions f = new Functions();
    System.out.println("\n--- WELCOME TO THE RIEMANN INTEGRATION PROGRAM ---\n");

    try {
      r.validateArgs(args);
    } catch (IllegalArgumentException iae) {
      System.out.println(iae);
      //System.exit(0);
    }

    switch(args[0]) {
      case "runtests": r.testPoly();
        r.testSine();
        break;
      case "poly": System.out.println("The Riemann Sum approximation is " + f.calculatePoly(lowerBound, upperBound, coeff, f.n));
        break;
      case "sin": System.out.println("The Riemann Sum approximation is " + f.calculateSine(lowerBound, upperBound, coeff, f.n));
        break;
    }

  }
}
