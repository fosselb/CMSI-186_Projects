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
    double width = (upperBound - lowerBound) / n;
    double functionValue = lowerBound + (((upperBound - lowerBound) / n) / 2);

    while (true) {
      //find approximation
      for (int i = 0; i < Riemann.coeff.length; i++) {
        currentApprox += functionValue * width;
        functionValue = (((upperBound - lowerBound) / n) / 2) + width;
      }

      if (1 - (currentApprox/previousApprox) <= Riemann.percent) {
        return currentApprox;
      } else {
        previousApprox = currentApprox;
        n++;
      }
    }





    //populate coeff array
    /*
    int numberOfCoeff = Riemann.argsLength - 4;
    coeff = new double[numberOfCoeff];
    for(int i = 0; i < numberOfCoeff; i++) {
      coeff[i] = Riemann.args[i + 1];
    }
    */

    //what's in the coeff array
    /*
    for (int i = 0; i < 3; i++) {
      System.out.println(coeff[i]);
    }
    */

  }

  public String polyToString() {
    return "The Riemann Sum approximation is " + currentApprox;
  }


  public static void main(String[] args) {

  }
}
