public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\."), v2 = version2.split("\\.");
        int i1, i2, i = 0;
        while (v1.length > i || v2.length > i) {
            if (v1.length > i) {
                i1 = Integer.valueOf(v1[i]).intValue();
            } else {
                i1 = 0;
            }
            if (v2.length > i) {
                i2 = Integer.valueOf(v2[i]).intValue();
            } else {
                i2 = 0;
            }
            if (i1 > i2) return 1;
            else if (i1 < i2) return -1;
            i++;
        }
        return 0;
    }
}