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
}
