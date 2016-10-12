public class Solution {
    public String toHex(int num) {
        StringBuilder sb = new StringBuilder();
        if (num == 0) return "0";
        while (num != 0) {
            sb.append(toChar(num & 0xf));
            num >>>= 4;
        }
        return sb.reverse().toString();
    }
    private char toChar(int num) {
        if (num < 10) {
            return (char) (num + '0');
        } else {
            return (char) (num - 10 + 'a');
        }
    }
}