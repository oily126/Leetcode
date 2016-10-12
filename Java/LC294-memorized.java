public class Solution {
    public boolean canWin(String s) {
        Map<String, Boolean> result = new HashMap<>();
        return canWin(s.toCharArray(), result);
    }
    private boolean canWin(char[] sArr, Map<String, Boolean> result) {
        String s = new String(sArr);
        Boolean res = result.get(s);
        if (res != null) return res;
        for (int i = 0; i < sArr.length - 1; i++) {
            if (sArr[i] == '+' && sArr[i + 1] == '+') {
                sArr[i] = '-';
                sArr[i + 1] = '-';
                if (!canWin(sArr, result)) {
                    sArr[i] = '+';
                    sArr[i + 1] = '+';
                    result.put(s, true);
                    //System.out.println((new String(sArr)) + " true");
                    return true;
                }
                sArr[i] = '+';
                sArr[i + 1] = '+';
            }
        }
        result.put(s, false);
        //System.out.println((new String(sArr))+" false");
        return false;
    }
}