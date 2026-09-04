import java.util.HashSet;
import java.util.Set;

public class SlidingWindow {
    //Longest Substring Without Repeating Characters
    public int lengthOfLongestSubstring(String s) {
        int substringStartI = 0;
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        for (int current=0; current<s.length(); current++){
            if (!set.contains(s.charAt(current)))
                set.add(s.charAt(current));
            else {
                while (s.charAt(substringStartI)!=s.charAt(current)) {
                    set.remove(s.charAt(substringStartI));
                    substringStartI++;
                }
                substringStartI++;
            }
            maxLength = Math.max(maxLength, current-substringStartI+1);
        }
        return maxLength;
    }

    //Minimum Size Subarray Sum, this one time limitted
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int result = 0;
        int cnt=0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                cnt++;
                if (sum >= target) {
                    if (result==0)
                        result=cnt;
                    else {
                        result = Math.min(result, cnt);
                        break;
                    }
                }
            }
            sum=0;
            cnt=0;
        }
        return result;
    }

    //Minimum Size Subarray Sum using sliding window
    public int minSubArrayLen1(int target, int[] nums) {
        int l=0; int r=0;
        int sum=0;
        int result=0;
        while (l<=r && r<nums.length) {
            sum+=nums[r];
            if (sum>=target) {
                if (result == 0)
                    result = r-l+1;
                else
                    result = Math.min(r-l+1, result);

                //slide the window from the left
                sum-=nums[l];
                sum-=nums[r];
                l++;

            } else
            {
                r++;
            }

        }
        return result;
    }
}
