//Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 
//and 2, the first 10 terms will be: 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...By considering the terms 
//in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.

public class FibonacciEvenSum{

	public static int sum = 0;
	public static int fib = 0;
	public static void main(String args[]){

		int a = 1, b = 1;

		while(fib < 4000000){

			fib = a + b;
			a = b;
			b = fib;

			if(fib % 2 == 0){
				sum += fib;
			}

		}

		System.out.println(sum);
	}	

}