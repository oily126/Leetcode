public class Solution {
    public String convert(String s, int numRows) {
        int i, j;
        StringBuilder sb = new StringBuilder();
        if (numRows == 1) {
            return s;
        }
        char[] sArr = new char[s.length()];
        int idx = 0;
        for (i = 0; i < numRows; i++) {
            for (j = 0; j + i < s.length(); j += (numRows - 1) * 2) {
                sArr[idx++] = s.charAt(i + j);
                if (i > 0 && i < numRows - 1) {
                    if (j + (numRows - 1) * 2 - i < s.length()) {
                        sArr[idx++] = s.charAt(j + (numRows - 1) * 2 - i);
                    }
                }
            }
        }
        return new String(sArr);
    }
}