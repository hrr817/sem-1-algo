package algo.assign;

/**
 * Written By Hemraj Rana
 * Student ID: M23W7252
 */
import java.util.Scanner;

public class Bisection {
	// just formats equation in human readable form
	private static void displayEquation(double[] coef) {
		System.out.printf("\nPolynomial equation: ");
		for(int i = 0, j = coef.length - 1; i < coef.length; i++, j--) {
			if(coef[i] != 0) {
				boolean whole = coef[i] % 1 == 0;
				
				if(j == 0) {
					System.out.printf(whole ? "%.0f" : "%.2f", Math.abs(coef[i]), j);
				} else {
					if(Math.abs(coef[i]) == 1) {
						System.out.printf("x^%d", j);
					} else {
						System.out.printf(whole ? "%.0fx^%d" : "%.2fx^%d", Math.abs(coef[i]), j);
					}
				}
				
				if(i < coef.length - 1) {
					int k = i + 1;

					while(coef[k] == 0 && k < coef.length - 1) k++; // ignore 0 coefficients
					
					System.out.printf(coef[k] > 0 ? " + " : " - ");
				}
			}
		}
		System.out.printf("\n");
	}
	
	// computes polynomial function when x is given
	private static double f(double[] coef,  double x) {
		// f(x) = (coef[i] * x^deg) + (coef[i + 1] x^(deg - 1)) + ... +  (coef[deg - 2] x^2) + coef[deg -1]

		double r = 0;

		for(int i = 0, j = coef.length - 1; i < coef.length; i++, j--) {
			r += coef[i] * Math.pow(x, j);
		}
		
		return r;
	}
	
	private static double bisectionMethod(double[] coef, double start, double end, double tolerance) {
		double mid, value;
		
		do {
			mid = (start + end) / 2.0;
			value = f(coef, mid);

			if(value >= (-1 * tolerance) && value <= tolerance) {
				break; // mid is root
			} else if(f(coef, start)  * value < 0) { 
				end = mid;
			} else {
				start = mid;
			}
		} while(Math.abs(start - end) > tolerance);
		
		return mid;
	}
	
	public static void main(String[] args) {
		double[] coef;
		double a, b, tolerance = 0.000001; // interval and tolernace
		
		System.out.println("Enter degree of the polynomial equation:");

		Scanner scan = new Scanner(System.in);
		int deg = scan.nextInt();
		coef = new double[deg + 1];

		for(int i = 0; i <= deg; i++) {
			System.out.printf("Enter coefficient (Place: %d/%d):", i + 1, deg + 1);
			coef[i] = scan.nextDouble();
		}
		
		displayEquation(coef);

		System.out.println("Enter start of interval:");
		a = scan.nextDouble();
		System.out.println("Enter end of interval:");
		b = scan.nextDouble();

		// use default tolerance
		 System.out.println("Enter tolerance: (e.g.: 0.0001)");
		 tolerance = scan.nextDouble();
		
		double root = bisectionMethod(coef, a, b, tolerance);
		System.out.printf("Root is %f", root);
		

		scan.close();
	}

}