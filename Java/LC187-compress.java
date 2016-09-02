public class Solution {
    int dnaLen = 10;
    int[] trans;
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < dnaLen) return new ArrayList<String>();
        
        int i, code = 0, pos;
        long mask;
        List<String> ans = new ArrayList<>();
        int maxCode = 2 << 20;
        long[] bitMap = new long[maxCode >> 6];
        long[] ansMap = new long[maxCode >> 6];
        trans = new int[26];
        trans['A' - 'A'] = 0;
        trans['C' - 'A'] = 1;
        trans['G' - 'A'] = 2;
        trans['T' - 'A'] = 3;
        for (i = 0; i < dnaLen - 1; i++) {
            code = (code << 2) + trans[s.charAt(i) - 'A'];
        }
        for (i = dnaLen - 1; i < s.length(); i++) {
            code = (code << 2) + trans[s.charAt(i) - 'A'];
            code %= 1 << (dnaLen << 1);
            pos = code / 64;
            mask = 1L << (code % 64);
            if ((bitMap[pos] & mask) != 0) {
                if ((ansMap[pos] & mask) == 0) {
                    ansMap[pos] |= mask;
                    ans.add(s.substring(i - dnaLen + 1, i + 1));
                }
            } else {
                bitMap[pos] |= mask;
                //System.out.println(s.substring(i, i + 10) + " "+code);
                //System.out.println(bitMap[code / 64]);
            }
        }
        return ans;
    }
}