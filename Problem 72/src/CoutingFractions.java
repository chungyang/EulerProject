import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by chungyang on 10/5/16.
 */
public class CoutingFractions {

    private static int limit = 1000000;
    private static ArrayList<Integer> primeList = new ArrayList<Integer>();
    private static int[] counts = new int[limit + 1];
    private static long totalCounts = 0;



    public static void main(String[] args){

        long begin, stop, duration;

        getPrimes();

        Arrays.fill(counts,0);

        for(int i = 2; i < isprime.length; i++){

            if(isprime[i]){
                totalCounts += i - 1;
                counts[i] = i - 1;
                primeList.add(i);
            }

        }
        begin = System.nanoTime();
        for(int i = 2; i <= limit; i++){

            if(!isprime[i]) {
                if (counts[i] == 0) {

                    if (i % 2 == 0) {

                        int count = checkPrimeFactors(i);

                        for (int j = 1; j * i < counts.length; j *= 2) {
                            totalCounts += count * j;
                            counts[i * j] = count * j;
                        }

                    }
                    else{
                        int count = checkPrimeFactors(i);
                        totalCounts += count;
                        counts[i] = count;
                    }
                }
            }
        }

        stop = System.nanoTime();
        duration = stop - begin;

        System.out.println(totalCounts);
        System.out.println("it took " + (double) duration / 1000000000);

//        System.out.println(checkPrimeFactors(3*5*5*7));
    }

    //This method uses the fact that if a number is the product of unique prime numbers, its reduced proper fraction count
    //will be the product of the counts of those unique prime numbers.
    private static int checkPrimeFactors(int number){

        int previousFactor = 1;
        int count = 1;

        for(int i = 0; i < primeList.size();){

            int currentFactor = primeList.get(i);

            if(number % currentFactor == 0){

                number /= currentFactor;

                if(previousFactor == currentFactor){
                    count *= currentFactor;
                }
                else{
                    count *= counts[currentFactor];
                    previousFactor = currentFactor;
                }

            }
            else{
                i++;
            }
        }

        return count;
    }


    private static boolean isprime[] = new boolean[limit + 1];

    private static void getPrimes() {

        int n = limit + 1;
        Arrays.fill(isprime, true);
        isprime[0] = false;
        isprime[1] = false;
        isprime[2] = true;
        isprime[3] = true;
        for (int i = 4; i < n; i += 2) isprime[i] = false;
        for (int i = 3; i < n; i += 2) {
            for (int j = i + i; j < n; j += i) {
                isprime[j] = false;
            }
        }
    }

}