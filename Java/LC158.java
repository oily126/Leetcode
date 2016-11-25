/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    
    int len = 4;
    char[] buf4 = new char[4];
    int offset = 4;
    public int read(char[] buf, int n) {
        int total = 0;
        System.out.println(offset+" "+len);
        while (total < n) {
            if (offset >= len) {
                len = read4(buf4);
                offset = 0;
            }
            if (len > 0) {
                buf[total++] = buf4[offset++];
            } else {
                offset = 4;
                break;
            }
        }
        
        return total;
    }
}