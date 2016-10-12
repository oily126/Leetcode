public class Solution {
    public List<String> findStrobogrammatic(int n) {
        int[] r = {0, 1, -1, -1, -1, -1, 9, -1, 8, 6};
        List<StringBuilder> buf = new ArrayList<>();
        int i, j, k;
        if (n > 1) {
            for (j = 1; j < 10; j++) {
                if (r[j] > 0) {
                    buf.add(new StringBuilder().append(j));
                    //System.out.println(j);
                }
            }
        } else {
            buf.add(new StringBuilder());
        }
        for (i = 1; i < n / 2; i++) {
            int size = buf.size();
            for (k = 0; k < size; k++) {
                for (j = 1; j < 10; j++) {
                    if (r[j] >= 0) {
                        buf.add(new StringBuilder(buf.get(k)).append(j));
                    }
                }
                buf.get(k).append(0);
            }
        }
        if (n % 2 == 1) {
            int size = buf.size();
            for (k = 0; k < size; k++) {
                for (i = 1; i < 10; i++) {
                    if (r[i] == i) {
                        buf.add(new StringBuilder(buf.get(k)).append(i));
                    }
                }
                buf.get(k).append(0);
            }
        }
        for (k = 0; k < buf.size(); k++) {
            StringBuilder sb = buf.get(k);
            int len = sb.length() - n % 2;
            //System.out.println(sb.length());
            for (i = len - 1; i >= 0; i--) {
                sb.append(r[sb.charAt(i) - '0']);
            }
        }
        List<String> ans = new ArrayList<>(buf.size());
        for (StringBuilder sb : buf) ans.add(sb.toString());
        return ans;
    }
}