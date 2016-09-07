import java.util.*;

public class TenThousandstPrime{
   
    public static int nthPrime = 2;
    public static int number = 3;
    
    public static void main(String args[]){
       
	while(true){
	    
	    if(isPrime(number)){

		if(nthPrime == Integer.parseInt(args[0])){
			System.out.println(number);
			break;
		}
		
		nthPrime++;
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
}