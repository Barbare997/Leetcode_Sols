import java.util.HashMap;

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
}