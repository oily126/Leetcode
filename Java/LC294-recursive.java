public class Solution {
    public boolean canWin(String s) {
        return canWin(s.toCharArray());
    }
    private boolean canWin(char[] sArr) {
        for (int i = 0; i < sArr.length - 1; i++) {
            if (sArr[i] == '+' && sArr[i + 1] == '+') {
                sArr[i] = '-';
                sArr[i + 1] = '-';
                if (!canWin(sArr)) {
                    sArr[i] = '+';
                    sArr[i + 1] = '+';
                    //System.out.println((new String(sArr)) + " true");
                    return true;
                }
                sArr[i] = '+';
                sArr[i + 1] = '+';
            }
        }
        //System.out.println((new String(sArr))+" false");
        return false;
    }
}