public class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < s.length() && !isAlphanumeric(s.charAt(l))) l++;
        while (r >= 0 && !isAlphanumeric(s.charAt(r))) r--;
        while (l < r) {
            if (!s.substring(l, l + 1).toLowerCase().equals(s.substring(r, r + 1).toLowerCase())) return false;
            l++;
            r--;
            while (l < s.length() && !isAlphanumeric(s.charAt(l))) l++;
            while (r >= 0 && !isAlphanumeric(s.charAt(r))) r--;
        }
        return true;
    }
    public boolean isAlphanumeric(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')
            || (ch >= '0' && ch <= '9');
    }
}