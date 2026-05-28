import java.util.HashMap;
import java.util.Map;

public class TwoPointersSolutions {
    //Remove Duplicates from Sorted Array 1
    public int removeDuplicates1(int[] nums) {
        int k = 0;
        for (int i=1; i<nums.length; i++) {
            if (nums[i]!=nums[i-1]) {
                k++;
                nums[k] = nums[i];
            }
        }
        return k+1;
    }

    //Remove Duplicates from Sorted Array 2
    public int removeDuplicates2(int[] nums) {
        int n = nums.length;
        if (n<=2)
            return n;
        int result = 2;
        for (int i=2; i<nums.length; i++) {
            if (nums[i]!=nums[result-2]) {
                nums[result] = nums[i];
                result++;
            }
        }
        return result;
    }

    //Move Zeroes
    public void moveZeroes(int[] nums) {
        int k = 0;
        for (int i=0; i<nums.length; i++){
            if (nums[i]!=0) {
                nums[k] = nums[i];
                k++;
            }
        }
        for (int i=k; i<nums.length; i++){
            nums[i] = 0;
        }
    }

    //Merge Sorted Array
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int firstPointer = m-1;
        int secondPointer = n-1;
        int bothPointer = nums1.length - 1;
        while (firstPointer>=0 && secondPointer>=0 && bothPointer>=0){
            if (nums1[firstPointer]>nums2[secondPointer]){
                nums1[bothPointer] = nums1[firstPointer];
                firstPointer--;
            } else {
                nums1[bothPointer] = nums2[secondPointer];
                secondPointer--;
            }
            bothPointer--;
        }
        for (int i = secondPointer; i>=0; i--){
            nums1[bothPointer] = nums2[i];
            bothPointer--;
        }
    }

    //Container With Most Water
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxVALUE = (height.length-1)*Math.min(height[left], height[right]);
        while (left<right) {
            if (height[left]<height[right]){
                left++;
            } else
                right--;
            maxVALUE=Math.max(maxVALUE, (right-left)*Math.min(height[left], height[right]));
        }
        return maxVALUE;
    }

    //Remove Element
    public int removeElement(int[] nums, int val) {
        int result = 0;
        for (int i=0; i<nums.length; i++){
            if (nums[i]!=val) {
                nums[result] = nums[i];
                result++;
            }
        }
        return result;
    }

    //Is Subsequence
    public boolean isSubsequence(String s, String t) {
        int sPointer = 0;
        for (int i=0; i<t.length(); i++) {
            if (sPointer==s.length()) {
                return true;
            }
            if (s.charAt(sPointer)==t.charAt(i)) {
                sPointer++;
            }
        }
        return sPointer==s.length();
    }

    //Valid Palindrome
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0; int right = s.length()-1;
        while (left<right) {
            while (left<right && !Character.isLetterOrDigit(s.charAt(left)))
                left++;
            while (left<right && !Character.isLetterOrDigit(s.charAt(right)))
                right--;
            if (s.charAt(left)!=s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }


}
