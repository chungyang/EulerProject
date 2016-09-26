//Find the sum of all primes under 2000000

import java.util.Arrays;
import java.util.Random;

/**
 * Created by chungyang on 9/23/16.
 */
public class SummationOfPrimes {

    public static void main(String[] args) {

        int n = 2000000;
        boolean isprime[] = new boolean[n + 1];
        Arrays.fill(isprime, true);
        isprime[2] = true;
        isprime[3] = true;
        for (int i = 4; i < n; i += 2) isprime[i] = false;
        for (int i = 3; i < n; i += 2) {
            for (int j = i + i; j < n; j += i) {
                isprime[j] = false;
            }
        }
        long sum = 0;
        for (int i = 2; i < n; ++i) {
            if (isprime[i]) sum += i;
        }
        System.out.println(sum);

    }


}


