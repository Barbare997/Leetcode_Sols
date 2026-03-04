import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashMapSolutions {
    //Valid Anagram, solution with hashmap
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        if (s.length()!=t.length())
            return false;
        for (char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        for (char c : t.toCharArray()){
            if (map.getOrDefault(c,0)==0)
                return false;
            map.put(c, map.get(c)-1);
        }
        return true;
    }

    //Smallest Pair With Different Frequencies
    public static int[] minDistinctFreqPair(int[] nums) {
        Arrays.sort(nums);
        int a=-1; int b=-1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int i=1; i<nums.length; i++) {
            if (nums[i]!=nums[i-1]) {
                if (!Objects.equals(map.get(nums[i]), map.get(nums[i - 1]))) {
                    b = nums[i];
                    break;
                }
            }
        }
        if (b!=-1)
            a=nums[0];
        return new int[]{a,b};
    }

    //Majority Element
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > n / 2)
                return num;
        }
        return 0;
    }

    //Ransom Note
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i=0; i<magazine.length(); i++)
            map.put(magazine.charAt(i), map.getOrDefault(magazine.charAt(i), 0)+1);

        for (int i=0; i<ransomNote.length(); i++){
            if (map.getOrDefault(ransomNote.charAt(i), 0)==0)
                return false;
            else map.put(ransomNote.charAt(i), map.getOrDefault(ransomNote.charAt(i), 0)-1);
        }
        return true;
    }
}