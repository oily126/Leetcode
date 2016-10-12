/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        boolean[] famous = new boolean[n];
        Map<Integer, Map<Integer, Boolean>> results = new HashMap<>();
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
                
                boolean result = knows(i, j);
                if (!results.containsKey(i)) {
                    results.put(i, new HashMap<>());
                }
                results.get(i).put(j, result);
                if (result) {
                    famous[i] = false;
                    i++;
                } else {
                    famous[j] = false;
                    j++;
                }
            }
        }
        //System.out.println(i);
        for (j = 0; j < n; j++) {
            if (i != j) {
                Map<Integer, Boolean> res1 = results.get(j);
                if (res1 != null) {
                    if (res1.containsKey(i)) {
                        //System.out.println(j+"+"+i);
                        if (!res1.get(i)) return -1;
                    } else {
                        if (!knows(j, i)) return -1;
                    }
                } else {
                    if (!knows(j, i)) return -1;
                }
                
                
                res1 = results.get(i);
                if (res1 != null) {
                    if (res1.containsKey(j)) {
                        //System.out.println(i+" "+j);
                        if (res1.get(j)) return -1;
                    } else {
                        if (knows(i, j)) return -1;
                    }
                } else {
                    if (knows(i, j)) return -1;
                } 
            }
        }
        return i;
    }
}