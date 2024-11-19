class Solution {
    public String mergeAlternately(String word1, String word2) {
        char[] wl1 = word1.toCharArray();
        char[] wl2 = word2.toCharArray();
        int wl1Length = wl1.length;
        int wl2Length = wl2.length;
        StringBuilder sb = new StringBuilder();

        int maxLength = wl1Length > wl2Length ? wl1Length : wl2Length;
        int i = -1;

        while (i++ < maxLength) {
            if (i < wl1Length) sb.append(wl1[i]);
            if (i < wl2Length) sb.append(wl2[i]);
        }
        return sb.toString();
    }
}