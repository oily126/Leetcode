public class Solution {
    public int lastRemaining(int n) {
        Stack<Integer> s = new Stack<>();
        int q = 0, m = 0, x = 1;
        if (n == 1) return 1;
        while (n > 1) {
            if (m % 2 == 1) {
                s.push(1 - n % 2);
                //System.out.println(1-n%2);
            } else {
                s.push(0);
                //System.out.println(0);
            }
            m++;
            n /= 2;
        }
        for (; m > 0; m--) {
            x = x * 2 - s.pop();
        }
        return x;
    }
}/*
9 4 2 1
227 113 56 28 14 7 3 1 
120 / 2
60 /2
30/2
15+1/2=1
8/2
4/2
2/2
1*/