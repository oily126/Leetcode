public class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            count.put(s.charAt(i), count.getOrDefault(s.charAt(i), 0) + 1);
        }
        Map<Integer, List<Character>> bucket = new TreeMap<>(Collections.reverseOrder());
        for (Character ch : count.keySet()) {
            Integer cnt = count.get(ch);
            if (!bucket.containsKey(cnt)) {
                bucket.put(cnt, new ArrayList<>());
            }
            bucket.get(cnt).add(ch);
        }
        StringBuilder sb = new StringBuilder();
        for (Integer cnt : bucket.keySet()) {
            List<Character> chars = bucket.get(cnt);
            for (Character ch : chars) {
                for (int i = 0; i < cnt; i++) {
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }
}