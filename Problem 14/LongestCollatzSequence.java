//The following iterative sequence is defined for the set of positive longegers:
//
//        n → n/2 (n is even)
//        n → 3n + 1 (n is odd)
//
//        Using the rule above and starting with 13, we generate the following sequence:
//
//        13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
//        It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
//
//        Which starting number, under one million, produces the longest chain?
//
//        NOTE: Once the chain starts the terms are allowed to go above one million.


import java.util.Arrays;

public class LongestCollatzSequence {


    static long length = 0;
    static long longestLength = 0;
    static boolean[] produceLongest = new boolean[1000000];

    public static void main(String[] args){

        //This boolean array marks off numbers that won't produce the longest sequence. Notice the above example, 13
        //is guaranteed to produce longer chain than the numbers that are in the chain
        Arrays.fill(produceLongest,true);
        produceLongest[0] = false;
        produceLongest[1] = false;

        long answer = 0;

        for(int i = 2; i < 1000000; i++){

            if(!produceLongest[i]){
                continue;
            }
            produceNextNinChain(i);
            if(length > longestLength){
                longestLength = length;
                produceLongest[i] = true;
                answer = i;
            }
            length = 0;
        }
        System.out.println(answer);
    }

    //Given a number, this method produces the next number
    private static long produceNextNinChain(long n){

        if(n == 1){
            length++;
            return 1;
        }

        if(n < 1000000) {
            if(produceLongest[(int) n]){
                produceLongest[(int) n] = false;
            }
        }

        if(n % 2 == 0){
            length++;
            return produceNextNinChain(n / 2);
        }
        else{
            length++;
            return produceNextNinChain(3*n + 1);
        }
    }

}
