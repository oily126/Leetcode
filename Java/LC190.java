class Solution {
public:
    uint32_t reverseBits(uint32_t n) {
        uint32_t ans = 0, bit = 0;
        uint32_t mid = 0xFFFF;
        int i = 32;
        while (i-- > 0) {
            bit = n % 2;
            ans <<= 1;
            ans |= bit;
            n >>= 1;
        }
        return ans;
    }
};