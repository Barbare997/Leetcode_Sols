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

}
