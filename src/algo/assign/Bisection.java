package algo.assign;

/**
 * Written By Hemraj Rana
 * Student ID: M23W7252
 */
import java.util.Scanner;

public class Bisection {
	private static double f(double[] coef,  double x) {
		// f(x) = coef[i] * x^n + coef[i + 1] x^(n-1) + ... + coef[i + n] * x + coef[n] = 0
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