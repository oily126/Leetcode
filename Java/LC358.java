public class Solution {
    class Pair {
        char ch;
        int count;
        public Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
    public String rearrangeString(String str, int k) {
        if (k == 0) return str;
        
        int[] nums = new int[26];
        StringBuilder sb = new StringBuilder(str.length());
        PriorityQueue<Pair> pq = new PriorityQueue<>(10, new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                if (b.count != a.count) return b.count - a.count;
                return a.ch - b.ch;
            } 
        });
        int i;
        for (i = 0; i < str.length(); i++) {
            nums[str.charAt(i) - 'a']++;
        }
        for (i = 0; i < nums.length; i++) {
            if (nums[i] > 0) pq.offer(new Pair((char)(i + 'a'), nums[i]));
        }
        int len = str.length();
        while (pq.size() > 0) {
            int cnt = Math.min(k, len);
            List<Pair> update = new ArrayList<>(cnt);
            for (i = 0; i < cnt; i++) {
                if (pq.size() == 0) return "";
                Pair tmp = pq.poll();
                sb.append(tmp.ch);
                tmp.count--;
                if (tmp.count > 0) {
                    update.add(tmp);
                }
                len--;
            }
            for (Pair p : update) {
                pq.offer(p);
            }
        }
        return sb.toString();
    }
}