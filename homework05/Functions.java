public class Functions {


  /**
  * Field Declarations
  */
  public int n = 1;
  private static double currentApprox = 0.0;
  private static double previousApprox = 0.0;

  /**
  * Methods
  */
  public double calculatePoly(double lowerBound, double upperBound, double[] coeff, int n) {
    System.out.println("Polynomial Function");
    double x;
    double functionValue = 0.0;

    while (true) {

      //find approximation
      for (int i = 0; i < n; i++) {
        //System.out.println("---- n = " + n);
        double width = (upperBound - lowerBound) / n;
        x = lowerBound + (((upperBound - lowerBound) / n) / 2) + (width * i);
        for (int j = 0; j < Riemann.coeff.length; j++) {
          functionValue += coeff[j] * Math.pow(x, j);
        }
        currentApprox += functionValue * width;
        //System.out.println(currentApprox);

        if (Math.abs(1 - (currentApprox/previousApprox)) <= Riemann.percent) {
          //System.out.println("ratio " + currentApprox/previousApprox);
          return currentApprox;
        } else {
          previousApprox = currentApprox;
          currentApprox = 0.0;
          n++;
        }
      }
    }
  }

  public double calculateSine(double lowerBound, double upperBound, double[] coeff, int n) {
    System.out.println("Sine Function");
    double x;
    double functionValue = 0.0;
    System.out.println("lower bound = " + lowerBound);
    System.out.println("upper bound = " + upperBound);

    while (true) {

      //find approximation
      for (int i = 0; i < n; i++) {
        //ystem.out.println("---- n = " + n);
        double width = (upperBound - lowerBound) / n;
        x = lowerBound + (((upperBound - lowerBound) / n) / 2) + (width * i);
        functionValue = Math.sin(x);
        currentApprox += functionValue * width;
        //System.out.println(currentApprox);

        if (Math.abs(1 - (currentApprox/previousApprox)) <= Riemann.percent) {
          //System.out.println("ratio " + currentApprox/previousApprox);
          return currentApprox;
        } else {
          previousApprox = currentApprox;
          currentApprox = 0.0;
          n++;
        }
      }
    }
  }

  public static void main(String[] args) {

  }
}
