public class Solution {
    public boolean validUtf8(int[] data) {
        int l, r, mask, mask1, num, cnt;
        l = r = 0;
        while (r < data.length) {
            l = r;
            if ((data[l] & 0x80) == 0) {
                r++;
            } else if ((data[l] & 0xC0 ^ 0x80) == 0) {
                return false;
            } else {
                cnt = 0;
                num = 0x80;
                mask1 = mask = num;
                while (num >= 0x10) {
                    num >>= 1;
                    mask += num;
                    mask1 = mask + (num >> 1);
                    cnt++;
                    //System.out.println(data[l] & mask1 ^ mask);
                    //System.out.println(data[l] +" "+ mask1 +" "+ mask);
                    
                    if ((data[l] & mask1 ^ mask) == 0) {
                        for (r = l + 1; r <= l + cnt; r++) {
                            System.out.println(r + " "+ cnt);
                            if (r >= data.length) return false;
                            if ((data[r] & 0xC0 ^ 0x80) != 0) return false;
                        }
                    }
                }
                if (l == r) {
                    return false;
                }
            }
        }
        return true;
    }
}