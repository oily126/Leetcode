public class Solution {
    public boolean isReflected(int[][] points) {
        if (points.length == 0) return true;
        long x = 0;
        int cnt = 0;
        Map<Long, Set<Integer>> m = new HashMap<>(); 
        for (int[] point : points) {
            long nx = point[0] * 2L;
            if (!m.containsKey(nx)) {
                m.put(nx, new HashSet<>());
            }
            if (m.get(nx).add(point[1])) {
                cnt++;
            }
        }
        for (Long key : m.keySet()) {
            x += m.get(key).size() * key;
        }
        if (x % cnt != 0) return false;
        x /= cnt;
        
        //System.out.println(cnt);       
        for (int[] point : points) {
            long nx = x * 2 - point[0] * 2L;
            if (m.containsKey(nx) && m.get(nx).contains(point[1])) {
                m.get(nx).remove(point[1]);
                cnt--;
            }
        }
        return cnt == 0;
    }
}