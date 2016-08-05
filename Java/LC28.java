public class Solution {
    public int strStr(String haystack, String needle) {
        int i, j, len1 = haystack.length(), len2 = needle.length();
        
        for (i = 0; i < len1 - len2 + 1; i++) {
            for (j = 0; j < len2; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) break;
            }
            if (j >= len2) return i;
        }
        
        return -1;
    }
}