import java.util.HashMap;

class Solution {
    public boolean isAnagram(String s, String t) {
        int sLength = s.length();
            int tLength = t.length();

            int[] alphbetFrequency = new int[26];

            for (int i = 0; i < sLength; i++) {
                alphbetFrequency[s.charAt(i) - 'a']++;
            }

            for (int i = 0; i < tLength; i++) {
                alphbetFrequency[t.charAt(i) - 'a']--;
            }

            for (int i : alphbetFrequency) {
                if (i != 0) return false;
            }
            
            return true;
    }   
}