public class Solution {
    public List<Integer> lexicalOrder(int n) {
        Stack<Integer> digit = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        int num, lastDigit;
        
        if (n == 0) return ans;
        digit.push(1);
        num = 0;
        lastDigit = 0;
        while (!digit.empty()) {
            lastDigit = digit.peek().intValue();
            if (num * 10 + lastDigit > n) {
                if (!digit.empty()) digit.pop();
                if (!digit.empty()) {
                    lastDigit = digit.pop().intValue();
                    if (lastDigit < 9) {
                        digit.push(lastDigit + 1);
                    } else {
                        while (!digit.empty() && lastDigit == 9) {
                            lastDigit = digit.pop().intValue();
                            if (lastDigit < 9) {
                                digit.push(lastDigit + 1);
                            }
                            num /= 10;
                        }
                    }
                    num /= 10;
                }
            } else {
                num = num * 10 + lastDigit;
                digit.push(0);
                ans.add(num);
            }
        }
        return ans;
    }
}