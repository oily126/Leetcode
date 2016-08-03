public class Solution {
    public String intToRoman(int num) {
        int i;
        int[] val = new int[] {1, 5, 10, 50, 100, 500, 1000, 5000};
        char[] roman = new char[] {'I', 'V', 'X', 'L', 'C', 'D', 'M', ' '};
        StringBuilder sb = new StringBuilder();
        
        for (i = val.length - 1; i >= 0; i--) {
            if (num >= val[i]) {
                while (num >= val[i]) {
                    sb.append(roman[i]);
                    num -= val[i];
                }
            }
            if (i > 0 && num >= val[i] - val[i - 1] && num > val[i - 1] * 2) {
                sb.append(roman[i - 1])
                    .append(roman[i]);
                num -= val[i] - val[i - 1];
            }
            if (i > 1 && num >= val[i] - val[i - 2]) {
                sb.append(roman[i - 2])
                    .append(roman[i]);
                num -= val[i] - val[i - 2];
            }
        }
        
        return sb.toString();
    }
}