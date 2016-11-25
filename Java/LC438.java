public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> nums = new HashMap<>(), pNums = new HashMap<>();
        int len = p.length();
        int begin = 0;
        for (int i = 0; i < len; i++) {
            pNums.put(p.charAt(i), pNums.getOrDefault(p.charAt(i), 0) + 1);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            nums.put(ch, nums.getOrDefault(ch, 0) + 1);
            if (nums.get(ch) > pNums.getOrDefault(ch, 0)) {
                while (begin <= i) {
                    nums.put(s.charAt(begin), nums.get(s.charAt(begin)) - 1);
                    if (ch.equals(s.charAt(begin))) {
                        begin++;
                        break;
                    } else {
                        begin++;
                    }
                }
            }
            if (nums.get(ch).intValue() == 0) {
                nums.remove(ch);
            } else {
                if (nums.get(ch).equals(pNums.getOrDefault(ch, 0))) {
                    if (i - begin + 1 == len) {
                        ans.add(begin);
                    }
                }
            }
        }
        return ans;
    }
}