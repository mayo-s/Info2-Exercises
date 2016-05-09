import java.math.*;
import java.util.*;

public class ExecutionTimes {

	public static void main(String[] args) {

		// runTimes();
		// checkPrimes();
		bigPrime(20);

	}

	public static void runTimes() {
		int n = 1000;
		long sum;
		long startTime;
		long endTime;

		System.out.println("O(N) : N = " + n + "\n");

		// Fragment #1
		sum = 0;
		startTime = System.currentTimeMillis();
		for (int i = 0; i < n; i++) {
			sum++;
		}
		endTime = System.currentTimeMillis();
		System.out.println("Fragment #1: " + sum + " ( " + (endTime - startTime) + "ms )");

		// Fragment #2
		sum = 0;
		startTime = System.currentTimeMillis();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sum++;
			}
		}
		endTime = System.currentTimeMillis();
		System.out.println("Fragment #2: " + sum + " ( " + (endTime - startTime) + "ms )");

		// Fragment #3
		sum = 0;
		startTime = System.currentTimeMillis();
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				sum++;
			}
		}
		endTime = System.currentTimeMillis();
		System.out.println("Fragment #3: " + sum + " ( " + (endTime - startTime) + "ms )");

		// Fragment #4
		sum = 0;
		startTime = System.currentTimeMillis();
		for (int i = 0; i < n; i++) {
			sum++;
			for (int j = 0; j < n; j++) {
				sum++;
			}
		}
		endTime = System.currentTimeMillis();
		System.out.println("Fragment #4: " + sum + " ( " + (endTime - startTime) + "ms )");

		// Fragment #5
		sum = 0;
		startTime = System.currentTimeMillis();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n * n; j++) {
				sum++;
			}
		}
		endTime = System.currentTimeMillis();
		System.out.println("Fragment #5: " + sum + " ( " + (endTime - startTime) + "ms )");

		// Fragment #6
		sum = 0;
		startTime = System.currentTimeMillis();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				sum++;
			}
		}
		endTime = System.currentTimeMillis();
		System.out.println("Fragment #6: " + sum + " ( " + (endTime - startTime) + "ms )");

		// Fragment #7
		sum = 0;
		startTime = System.currentTimeMillis();
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < n * n; j++) {
				if (j % i == 0) {
					for (int k = 0; k < j; k++) {
						sum++;
					}
				}
			}
		}
		endTime = System.currentTimeMillis();
		System.out.println("Fragment #7: " + sum + " ( " + (endTime - startTime) + "ms )");

		// Fragment #8
		sum = 0;
		startTime = System.currentTimeMillis();
		int i = n;
		while (i > 1) {
			i = i / 2;
			sum++;
		}
		endTime = System.currentTimeMillis();
		System.out.println("Fragment #8: " + sum + " ( " + (endTime - startTime) + "ms )");

	}

	public static void checkPrimes() {
		// int primeNum = 1;
		int primeNum = (int) (Math.pow(2, 31));
		System.out.println("Checking " + primeNum + " if it is prime.");
		if (isPrime(primeNum)) {
			System.out.println("Yeah... it's a prime#");
		} else {
			System.out.println("Nope... Not a prime#");
		}
	}

	public static boolean isPrime(int n) {

		long startTime;
		long endTime;

		startTime = System.currentTimeMillis();
		boolean isPrime = true;
		if (n == 1 || n == 2) {
			isPrime = true;
		} else {

			for (int num = 2; num < (n / 2) && isPrime; num++) {
				if (n % num == 0) {
					isPrime = false;
				}
			}
		}
		endTime = System.currentTimeMillis();
		System.out.println("Time needed: " + (endTime - startTime) + "ms");

		return isPrime;

	}

	public static void bigPrime(int bits) {

		long startTime;
		long endTime;

		BigInteger bigInt;
		Random rnd;

		for (int i = 1; i <= 100; i++) {
			bigInt = new BigInteger(bits, rnd = new Random());

			boolean isPrime = true;

			startTime = System.currentTimeMillis();
			if (bigInt.equals(BigInteger.valueOf(1)) || bigInt.equals(BigInteger.valueOf(2))) {
				System.out.println(bigInt + " is a prime");
			} else {
				for (int num = 2; bigInt.compareTo(BigInteger.valueOf(num)) > 0 && isPrime; num++) {
					if (bigInt.mod(BigInteger.valueOf(num)).equals(BigInteger.valueOf(0))) {
						isPrime = false;
					}
				}
				if (isPrime) {
					System.out.println(bigInt + " is a prime#");
				} else {
					System.out.println(bigInt + " is not a prime#");
				}
			}
			endTime = System.currentTimeMillis();
			System.out.println("Time needed: " + (endTime - startTime) + "ms");
		}

	}

}
