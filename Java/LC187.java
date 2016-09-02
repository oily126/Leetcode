public class Solution {
    int dnaLen = 10;
    
    public int encode(String s) {
        int code = 0;
        for (int i = 0; i < dnaLen; i++) {
            switch (s.charAt(i)) {
                case 'A':
                    code = (code << 2);
                    break;
                case 'C':
                    code = (code << 2) + 1;
                    break;
                case 'G':
                    code = (code << 2) + 2;
                    break;
                case 'T':
                    code = (code << 2) + 3;
                    break;
                default:
                    return 0;
            }
        }
        return code;
    }
    public List<String> findRepeatedDnaSequences(String s) {
        int i;
        List<String> ans = new ArrayList<>();
        int maxCode = 2 << 20;
        long[] bitMap = new long[maxCode / 64];
        long[] ansMap = new long[maxCode / 64];
        for (i = 0; i < s.length() - dnaLen + 1; i++) {
            int code = encode(s.substring(i, i + dnaLen));
            if ((bitMap[code / 64] & (1L << (code % 64))) != 0) {
                if ((ansMap[code / 64] & (1L << (code % 64))) == 0) {
                    ansMap[code / 64] |= 1L << (code % 64);
                    ans.add(s.substring(i, i + dnaLen));
                }
            } else {
                bitMap[code / 64] |= 1L << (code % 64);
                //System.out.println(s.substring(i, i + 10) + " "+code);
                //System.out.println(bitMap[code / 64]);
            }
        }
        return ans;
    }
}