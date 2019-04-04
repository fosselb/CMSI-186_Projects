public class Functions {


  /**
  * Field Declarations
  */
  public int n = 1;
  private static double currentApprox = 0.0;
  private static double previousApprox = 0.0;
  private static double[] newCoeff;

  /**
  * Methods
  */
  public double calculatePoly(double lowerBound, double upperBound, double[] coeff, int n) {
    System.out.println("Polynomial Function");
    double x;
    double functionValue = 0.0;
    System.out.println("lower bound = " + lowerBound);
    System.out.println("upper bound = " + upperBound);
    System.out.println("percent = " + Riemann.percent + " %");

    while (true) {

      //find approximation
      for (int i = 0; i < n; i++) {
        double width = (upperBound - lowerBound) / n;
        x = lowerBound + (((upperBound - lowerBound) / n) / 2) + (width * i);
        for (int j = 0; j < Riemann.coeff.length; j++) {
          functionValue += coeff[j] * Math.pow(x, j);
        }
        currentApprox += functionValue * width;
        functionValue = 0.0;
      }

      if (Math.abs(1 - (currentApprox/previousApprox)) <= Riemann.percent) {
        return currentApprox;
      } else {
        previousApprox = currentApprox;
        currentApprox = 0.0;
        n++;
      }
    }
  }

  public double calculateSine(double lowerBound, double upperBound, double[] coeff, int n) {
    System.out.println("Sinusoid Function");
    double x;
    double functionValue = 0.0;
    System.out.println("lower bound = " + lowerBound);
    System.out.println("upper bound = " + upperBound);
    System.out.println("percent = " + Riemann.percent + " %");
    //set new coeff array if no coefficients are entered
/*
    if (Riemann.argsLength <= 3) {
      newCoeff = new double[2];
      newCoeff[0] = 0.0;
      newCoeff[1] = 1.0;
    } else {
      newCoeff = Riemann.coeff;
    }
    System.out.println(newCoeff[0]);
    System.out.println(newCoeff[1]);
*/
    while (true) {
      //find approximation
      for (int i = 0; i < n; i++) {
        //System.out.println("n = " + n);
        double width = (upperBound - lowerBound) / n;
        x = lowerBound + (((upperBound - lowerBound) / n) / 2) + (width * i);
        for (int j = 0; j < Riemann.coeff.length; j++) {
          functionValue += coeff[j] * Math.pow(x, j);
        }
        double newFunctionValue = Math.sin(functionValue);
        //functionValue = Math.sin(x);
        currentApprox += newFunctionValue * width;
        functionValue = 0.0;
        newFunctionValue = 0.0;
        //System.out.println("currentApprox = " + currentApprox);
      }

      if (Math.abs(1 - (currentApprox/previousApprox)) <= Riemann.percent) {
        return currentApprox;
      } else {
        previousApprox = currentApprox;
        currentApprox = 0.0;
        n++;
      }
    }
  }

  public static void main(String[] args) {

  }
}
