import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArraySolutions {

    // Problem: Single Number
    // Find the single number that appears only once in an array where every other element appears twice
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    // Problem: Height Checker
    // Return the number of indices where heights[i] != expected[i] after sorting
    public int heightChecker(int[] heights) {
        int[] expected = heights.clone();
        Arrays.sort(expected);
        int result = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                result++;
            }
        }
        return result;
    }

    // Problem: How Many Numbers Are Smaller Than the Current Number
    // For each number, count how many numbers in the array are smaller than it
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int cnt = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    cnt++;
                }
            }
            result[i] = cnt;
        }
        return result;
    }

    // Problem: Concatenation of Array
    // Return an array formed by concatenating the array with itself
    public int[] getConcatenation(int[] nums) {
        int[] result = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i];
        }
        for (int i = nums.length; i < result.length; i++) {
            result[i] = nums[i - nums.length];
        }
        return result;
    }

    // Problem: Squares of a Sorted Array
    // Return an array of the squares of each number sorted in non-decreasing order
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        return Arrays.stream(nums).sorted().toArray();
    }

    // Problem: Final Value of Variable After Performing Operations
    // Start with X = 0, perform operations (++X, X++, --X, X--) and return final value
    public int finalValueAfterOperations(String[] operations) {
        int result = 0;
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].equals("X++") || operations[i].equals("++X")) {
                result++;
            } else {
                result--;
            }
        }
        return result;
    }

    // Shortest Distance to a Character
    // answer[i] = distance from index i to the closest occurrence of c in s
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] result = new int[n];
        int lastPos = -n;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) lastPos = i;
            result[i] = i - lastPos;
        }
        int nextPos = 2 * n;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == c) nextPos = i;
            result[i] = Math.min(result[i], nextPos - i);
        }
        return result;
    }

    //TwoSum
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            int complement = target-nums[i];
            if (map.containsKey(complement))
                return new int[] {i, map.get(complement)};
            map.put(nums[i], i);
        }
        return null;
    }

    //Two Sum II - Input Array Is Sorted
    public int[] twoSum2(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;
        while (left<right) {
            if (numbers[left]+numbers[right]==target)
                return new int[]{left+1, right+1};
            else if (numbers[left]+numbers[right]>target)
                right--;
                else left++;
        }
        return new int[0];
    }


    //Maximum Subarray
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i<nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum+nums[i]);
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }

    //Valid Anagram, better space complexity solution without Hashmap, using frequency array

    public boolean isAnagram(String s, String t) {
        int[] arr = new int[26];
        for (char c : s.toCharArray()){
            arr[c-'a'] += 1;
        }
        for (char c : t.toCharArray()){
            arr[c-'a']-=1;
        }
        for (int el : arr) {
            if (el!=0)
                return false;
        }
        return true;
    }

    //Best Time to Buy and Sell Stock, (greedy)
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minValue = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price<minValue)
                minValue = price;
            else 
                if (price - minValue > maxProfit)
                    maxProfit = price - minValue;
        }
        return maxProfit;
    }

    //Product of Array Except Self,  O(n) time, O(n) space
    public int[] productExceptSelf(int[] nums) {
        int[] prefixProduct = nums.clone();
        int[] suffixProduct = nums.clone();
        int[] result = new int[nums.length];
        for (int i=1; i<nums.length-1; i++) {
            prefixProduct[i] = prefixProduct[i-1] * nums[i];
            suffixProduct[nums.length-i-1] = suffixProduct[nums.length-i] * nums[nums.length-i-1];
        }
        result[0] = suffixProduct[1];
        result[nums.length-1] = prefixProduct[nums.length-2];
        for (int i=1; i<nums.length-1; i++) {
            result[i] = prefixProduct[i-1] * suffixProduct[i+1];
        }
        return result;
    }

    //Product of Array Except Self,  O(n) time, O(1) space
    public int[] productExceptSelf1(int[] nums) {
        int[] result = nums.clone();
        for (int i=1; i<nums.length-1; i++) {
            result[i] = result[i-1] * nums[i];
        }
        result[nums.length-1] = result[nums.length-2];
        int suffixProduct = nums[nums.length-1];
        for (int i = nums.length-2; i>0; i--) {
            result[i] = suffixProduct * result[i-1];
            suffixProduct *= nums[i];
        }
        result[0] = suffixProduct;
        return result;
    }
}
