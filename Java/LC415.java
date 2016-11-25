public class Solution {
    public String addStrings(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int len = Math.max(m, n);
        char[] num = new char[len + 1];
        int sum, i;
        for (i = 0; i <= len; i++) num[i] = '0';
        for (i = 0; i < len; i++) {
            sum = (i < m ? num1.charAt(m - i - 1) - '0' : 0) 
                + (i < n ? num2.charAt(n - i - 1) - '0' : 0) + num[i] -'0';
            //System.out.println(sum);
            num[i] = (char) (sum % 10 + '0');
            num[i + 1] = (char) (num[i + 1] + sum / 10);
        }
        boolean startZero = true;
        StringBuilder sb = new StringBuilder();
        for (i = len; i >= 0; i--) {
            if (startZero) {
                if (num[i] != '0') {
                    startZero = false;
                    sb.append(num[i]);
                }
            } else {
                sb.append(num[i]);
            }
        }
        if (sb.length() == 0) sb.append("0");
        return sb.toString();
    }
}