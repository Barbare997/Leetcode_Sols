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

    //Isomorphic Strings
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        if (s.length()!=t.length())
            return false;
        for (int i=0; i<s.length(); i++){
            if (!map.containsKey(s.charAt(i))) {
                if (map.containsValue(t.charAt(i)))
                    return false;
                map.put(s.charAt(i), t.charAt(i));
            }
            else if (map.get(s.charAt(i))!=t.charAt(i))
                return false;
        }
        return true;
    }


    //Contains Duplicate II
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            if (map.containsKey(nums[i]) && Math.abs(map.get(nums[i])-i)<=k)
                return true;
            map.put(nums[i], i);
        }
        return false;
    }

    //Word Pattern
    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");

        if (pattern.length() != arr.length) return false;

        HashMap<Character, String> map1 = new HashMap<>();
        HashMap<String, Character> map2 = new HashMap<>();

        for (int i=0; i<pattern.length(); i++) {
            if (map1.containsKey(pattern.charAt(i)))
                if (!Objects.equals(map1.get(pattern.charAt(i)), arr[i]))
                    return false;
            map1.put(pattern.charAt(i), arr[i]);
        }

        for (int i=0; i<arr.length; i++) {
            if (map2.containsKey(arr[i]))
                if (map2.get(arr[i])!= pattern.charAt(i))
                    return false;
            map2.put(arr[i], pattern.charAt(i));
        }
        return true;
    }
}