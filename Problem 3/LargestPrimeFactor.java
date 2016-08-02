//The prime factors of 13195 are 5, 7, 13 and 29.
//What is the largest prime factor of the number 600851475143 ?

import java.util.*;


public class LargestPrimeFactor{

	public static ArrayList<Double> primeFactorsCandidates = new ArrayList<Double>();
	public static double largetPrimeFactor = 0;

	public static void main(String args[]){
		
		FermatFactor(600851475143d);

		while(!primeFactorsCandidates.isEmpty()){

			FermatFactor(primeFactorsCandidates.get(0));
			primeFactorsCandidates.remove(0);
		
		}

		System.out.println(largetPrimeFactor);

	}

	public static void FermatFactor(double n){

		double a = Math.ceil(Math.sqrt(n));	
		double b = Math.pow(a,2) - n;

		while(Math.round(Math.sqrt(b)) != Math.sqrt(b)){
			a = a + 1;
			b = Math.pow(a,2) - n;

		}


		if((a - Math.sqrt(b)) == 1 && a != 1 && Math.sqrt(b) != 0){

			if(n > largetPrimeFactor){
				largetPrimeFactor = n;

			}

		}
		else if((a - Math.sqrt(b)) > 1) {
			if(a + Math.sqrt(b) == a - Math.sqrt(b)){
				primeFactorsCandidates.add( a + Math.sqrt(b));
			}
			else{
				primeFactorsCandidates.add( a + Math.sqrt(b));
				primeFactorsCandidates.add( a - Math.sqrt(b));	

			}

		}
	
	}

}