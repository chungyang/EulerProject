//Find the 10001st prime number

import java.util.*;
import java.math.BigInteger;

public class TenThousandstPrime{
   
    public static int nthPrime = 2;
    public static int number = 3;
    
    public static void main(String args[]){
       
	while(true){
	    
	    if(isProbablePrime(new BigInteger(Integer.toString(number)),10)){
	    if(isPrime(number)){

		if(nthPrime == Integer.parseInt(args[0])){
			System.out.println(number);
			break;
		}
		
		nthPrime++;
	    }
	}

	    number += 2;
	   
	}
	
    }

    public static Boolean isPrime(double n){
	
	double a = Math.ceil(Math.sqrt(n));
	double b = Math.pow(a,2) - n;

	while(Math.round(Math.sqrt(b)) != Math.sqrt(b)){
	    
	    a += 1;
	    b = Math.pow(a,2) - n;

        }

	if((a - Math.sqrt(b)) == 1){
	    return true;
	}
	else{
	    return false;
	}
    }

    private static final BigInteger ZERO = BigInteger.ZERO;
	private static final BigInteger ONE = BigInteger.ONE;
	private static final BigInteger TWO = new BigInteger("2");
	private static final BigInteger THREE = new BigInteger("3");

	public static boolean isProbablePrime(BigInteger n, int k) {
		if (n.compareTo(THREE) < 0)
			return true;
		int s = 0;
		BigInteger d = n.subtract(ONE);
		while (d.mod(TWO).equals(ZERO)) {
			s++;
			d = d.divide(TWO);
		}
		for (int i = 0; i < k; i++) {
			BigInteger a = uniformRandom(TWO, n.subtract(ONE));
			BigInteger x = a.modPow(d, n);
			if (x.equals(ONE) || x.equals(n.subtract(ONE)))
				continue;
			int r = 1;
			for (; r < s; r++) {
				x = x.modPow(TWO, n);
				if (x.equals(ONE))
					return false;
				if (x.equals(n.subtract(ONE)))
					break;
			}
			if (r == s) // None of the steps made x equal n-1.
				return false;
		}
		return true;
	}

	private static BigInteger uniformRandom(BigInteger bottom, BigInteger top) {
		Random rnd = new Random();
		BigInteger res;
		do {
			res = new BigInteger(top.bitLength(), rnd);
		} while (res.compareTo(bottom) < 0 || res.compareTo(top) > 0);
		return res;
	}
}