package algo.assign;

import java.util.Scanner;

/**
 * Written By Hemraj Rana
 * Student ID: M23W7252
 */
public class NewtonRaphson {
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
	private static double f(double x, double[] coef) {
		// f(x) = (coef[i] * x^deg) + (coef[i + 1] x^(deg - 1)) + ... +  (coef[deg - 2] x^2) + coef[deg -1]
		double r = 0;

		for(int i = 0, j = coef.length - 1; i < coef.length; i++, j--) {
			r += coef[i] * Math.pow(x, j);
		}
		
		return r;
	}
	
	// newton-raphson method
	private static double newtonRaphson(double x, double[] f, double[] fi) {
		return x - (f(x, f) / f(x, fi));
	}
	
	// gives derivative
	private static double[] derivative(double[] coef) {
		double[] newCoef = new double[coef.length - 1];
		
		for(int i = 0, j = coef.length - 1; i < coef.length - 1; i++, j--) {
			newCoef[i] = coef[i] * j;
		}
		
		return newCoef;
	}

	public static void main(String[] args) {
		// inputs: continuous function, initial root guess, precision
		double[] coef;
		double x, // for root approximation
			   x0, // for initial guess
			   tolerance = 0.000001; // initial root guess and tolerance
		
		System.out.println("Enter degree of the polynomial equation:");

		Scanner scan = new Scanner(System.in);
		int deg = scan.nextInt();
		coef = new double[deg + 1];

		for(int i = 0; i <= deg; i++) {
			System.out.printf("Enter coefficient (Place: %d/%d):", i + 1, deg + 1);
			coef[i] = scan.nextDouble();
		}
		
		displayEquation(coef);

		System.out.println("Enter initial root guess: (If too far, it may fail)");
		x0 = scan.nextDouble();
		
		// System.out.println("Enter tolerance: (e.g.: 0.0001)");
		// tolerance = scan.nextDouble();
		
		double val;
		double[] coefi = derivative(coef);;
		
		do {
			val = f(x0, coef);
			if(Math.abs(val) < tolerance) break;
			x = newtonRaphson(x0, coef, coefi);
			x0 = x;
		} while(Math.abs(val) > tolerance);
		
		System.out.printf("Root is %f (Approximation)", x0);
		scan.close();
	}

}
