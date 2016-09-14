/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int len = 4, offset = 0;
        char[] buf1 = new char[4];
        int i;
        while (len == 4) {
            len = read4(buf1);
            for (i = 0; i < len && offset + i < n; i++) {
                buf[offset + i] = buf1[i];
            }
            offset += i;
        }
        return offset;
    }
}