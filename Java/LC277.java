/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        boolean[] famous = new boolean[n];
        int i, j;
        for (i = 0; i < n; i++) {
            famous[i] = true;
        }
        i = 0;
        j = 1;
        while (i < n) {
            if (!famous[i]) i++;
            else {
                if (j <= i) j = i + 1;
                while (j < n && !famous[j]) j++;
                if (j == n) break;
                
                if (knows(i, j)) {
                    famous[i] = false;
                    i++;
                } else {
                    famous[j] = false;
                    j++;
                }
            }
        }

        for (j = 0; j < n; j++) {
            if (i != j) {
                if (!knows(j, i) || knows(i, j)) return -1;
            }
        }
        return i;
    }
}