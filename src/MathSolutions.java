import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MathSolutions {
    //Number of Steps to Reduce a Number to Zero
public int numberOfSteps(int num) {
        int result =0;
        while (num!=0) {
            if (num%2==0)
                num/=2;
            else
                num--;
            result++;
        }
        return result;
}

//Fibonacci Number
public int fib(int n) {
    if (n==0) return 0;
    if (n==1) return 1;
    return fib(n-1) + fib(n-2);
}

    // Self Dividing Numbers
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int i =left; i<=right; i++) {
            if (isSelfDividing(i)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean isSelfDividing(int num) {
    int original = num;
    while (num > 0) {
        int digit = num % 10;
        if (digit == 0 || original % digit != 0) {
            return false;
        }
        num /= 10;
    }
        return true;
    }

    // Calculate Delayed Arrival Time
    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime + delayedTime) % 24;
    }

    //Missing Number
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i=0; i<nums.length; i++) {
            if (nums[i]!=i)
              return i;
    }
    return nums.length;
    }

    //Maximum 69 Number
    public int maximum69Number (int num) {
        String numStr = String.valueOf(num);
        numStr = numStr.replaceFirst("6", "9");
        return Integer.parseInt(numStr);
    }

    //Fizz Buzz
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            }
            else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }

    // Count Partitions with Even Sum Difference
    // Count how many ways to split array so that (leftSum - rightSum) is even
    public int countPartitions(int[] nums) {
        int total = 0;
        for (int num : nums) total += num;
        if (nums.length < 2) return 0;
        // leftSum - rightSum = 2*leftSum - total; even when total is even
        return total % 2 == 0 ? nums.length - 1 : 0;
    }

    //Happy number
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = squareSum(slow);
            fast = squareSum(squareSum(fast));
        } while (slow != fast);
        return slow == 1;
    }
    private int squareSum(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    //Number of Good Pairs
    public int numIdenticalPairs(int[] nums) {
    int res = 0;
    for (int i=0; i<nums.length; i++) {
        for (int j=i+1; j<nums.length; j++) {
            if (nums[i]==nums[j])
                res++;
        }
    }
    return res;
    }

    //Minimum Time Visiting All Points
    public int minTimeToVisitAllPoints(int[][] points) {
    int res = 0;
    for (int i=1; i<points.length; i++) {
        res += Math.max(Math.abs(points[i][0]-points[i-1][0]) , Math.abs(points[i][1]-points[i-1][1]));
    }
    return res;
    }

    //Sum of K-Digit Numbers in a Range
    static final long MOD = 1_000_000_007L;
    public long sumOfNumbers(int l, int r, int k) {
        long count = r - l + 1;
        long sumOfDigits = (count % MOD) * ((l + r) % MOD) % MOD * modInverse(2, MOD) % MOD;
        long waysForOtherPositions = modPow(count % MOD, k - 1, MOD);
        long sumOfPlaceValues = (modPow(10L, k, MOD) - 1 + MOD) % MOD * modInverse(9, MOD) % MOD;
        return sumOfDigits * waysForOtherPositions % MOD * sumOfPlaceValues % MOD;
    }
    private long modPow(long base, long exp, long mod) {
        long result = 1;
        base %= mod;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = result * base % mod;
            }
            base = base * base % mod;
            exp >>= 1;
        }

        return result;
    }
    private long modInverse(long value, long mod) {
        return modPow(value, mod - 2, mod);
    }

    // Convert the Temperature
    public double[] convertTemperature(double celsius) {
        double f = celsius * 1.80 + 32.00;
        double k = celsius + 273.15;
        return new double[] {k, f};
    }

    //Smallest Even Multiple
    public int smallestEvenMultiple(int n) {
        if (n%2==1)
            return n*2;
        else return n;
    }

    //Number of Common Factors
    public int commonFactors(int a, int b) {
        int count = 0 ;
        for (int i=1; i<=a && i<=b; i++) {
            if (a%i==0 & b%i==0)
                count++;
        }
        return count;
    }

    //Determine Color of a Chessboard Square
    public boolean squareIsWhite(String coordinates) {
        return (coordinates.charAt(0)%2==1 && coordinates.charAt(1)%2==0)
                || (coordinates.charAt(0)%2==0 && coordinates.charAt(1)%2==1);
    }


    //Calculate Money in Leetcode Bank
    public int totalMoney(int n) {
        int cnt = 0;
        int currMonday=1;
        int sum = 0;
        for (int i=0; i<n; i++) {
            sum+=currMonday+(i%7);
            cnt++;
            if (cnt==7) {
                cnt = 0;
                currMonday++;
            }
        }
        return sum;
    }

    //A Number After a Double Reversal
    public boolean isSameAfterReversals(int num) {
        return num%10!=0 || num/10==0;
    }


    //Mirror Distance of an Integer
    public int mirrorDistance(int n) {
        return Math.abs(n-reverse(n));
    }
    public int reverse (int n) {
        int result = 0;
        while (n!=0) {
            int digit =n%10;
            result=result*10+digit;
            n/=10;
        }
        return result;
    }


    //GCD of Odd and Even Sums
    public int gcdOfOddEvenSums(int n) {
        int oddSum = 0;
        int evenSum = 0;
        for (int i=1; i<=2*n; i++) {
            if (i%2==0)
                evenSum+=i;
            else oddSum+=i;
        }
        int gcd = 1;
        int result = 1;
         while (gcd<=Math.min(evenSum, oddSum)){
             gcd++;
             if (evenSum%gcd==0 && oddSum%gcd==0)
                 result = gcd;
         }
         return result;
    }

    public int gcdOfOddEvenSums1(int n) {
        return n;
    }


    //Minimum Moves to Equal Array Elements III
    public int minMoves(int[] nums) {
        int max = Integer.MIN_VALUE;
        int result = 0;

        for (int num: nums) {
            if (num>max)
                max=num;
        }
        for (int num:nums){
            result+=max-num;
        }
        return result;
    }

}
