import java.util.HashMap;

public class StringSolutiona {
    //Jewels and Stones
    public int numJewelsInStones(String jewels, String stones) {
        int result = 0;
        for (int i=0; i<stones.length(); i++) {
            if (jewels.contains(Character.toString(stones.charAt(i))))
                result++;
        }
        return result;
    }

    //Count the Number of Consistent Strings
    public int countConsistentStrings(String allowed, String[] words) {
        int cnt=0;
        for (String word : words) {
            if (isConsistent(allowed, word))
                cnt++;
        }
        return cnt;
    }
    public boolean isConsistent (String allowed, String word) {
        for (int i=0; i<word.length(); i++) {
            if (!allowed.contains(Character.toString(word.charAt(i))))
                return false;
        }
        return true;
    }

    //Defanging an IP Address
    public String defangIPaddr(String address) {
        StringBuilder result = new StringBuilder();
        for (int i=0; i<address.length(); i++) {
            if (address.charAt(i)!='.')
                result.append(address.charAt(i));
            else
                result.append("[.]");
        }
        return result.toString();
    }

    //Score of a String
    public int scoreOfString(String s) {
        int result = 0;
        for (int i=1; i<s.length(); i++) {
            result+=Math.abs(s.charAt(i)-s.charAt(i-1));
        }
        return result;
    }

    //Goal Parser Interpretation
    public String interpret(String command) {
        StringBuilder result = new StringBuilder();
        int i=0;
        while (i<command.length()) {
            if (command.charAt(i)=='G') {
                result.append('G');
                i++;
            }
            else if (command.charAt(i+1)==')') {

                    result.append('o');
                    i+=2;
            }
            else {
                result.append("al");
                i+=4;
                }

        }
        return result.toString();
    }

    //Split a String in Balanced Strings
    public int balancedStringSplit(String s) {
        int l = 0;
        int r = 0;
        int result = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i)=='L')
                l++;
            else
                r++;
            if (l==r && l!=0) {
                result++;
                l=0;
                r=0;
            }
        }
        return result;
    }

    //Permutation Difference between Two Strings
    public int findPermutationDifference(String s, String t) {
        int result=0;
        for (int i=0; i<s.length(); i++) {
            result+=Math.abs(i-t.indexOf(s.charAt(i)));
        }
        return result;
    }

    //Truncate Sentence
    public String truncateSentence(String s, int k) {
        int cnt = 0;
        StringBuilder res = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i)==' ')
                cnt++;

            if (cnt==k)
                break;
            else
                res.append(s.charAt(i));

        }
        return res.toString();
    }

    //Valid Palindrome
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left =0;
        int right = s.length()-1;
        while (left<right) {
            while (left<right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left<right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (s.charAt(left)==s.charAt(right)) {
                left++;
                right--;
            } else
                return false;
        }
        return true;
    }

    //Reverse String
    public void reverseString(char[] s) {
        for (int i=0; i<s.length/2; i++) {
            char helper = s[i];
            s[i] = s[s.length-i-1];
            s[s.length-i-1] = helper;
        }
    }

    //First Unique Character in a String
    public int firstUniqChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            String before = (i == 0) ? "" : s.substring(0, i);
            String after = (i == s.length() - 1) ? "" : s.substring(i + 1, s.length());
            if (!before.contains(Character.toString(s.charAt(i)))
                    && !after.contains(Character.toString(s.charAt(i))))
                return i;
        }
        return -1;
    }



    public int firstUniqChar1(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }





}
