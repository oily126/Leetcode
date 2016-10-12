public class Solution {
    public boolean isSubsequence(String s, String t) {
        int l = 0;
        Map<Character, List<Integer>> indexes = new HashMap<>();
        if (s.length() == 0) return true;
        for (int i = 0; i < t.length(); i++) {
            if (!indexes.containsKey(t.charAt(i))) {
                indexes.put(t.charAt(i), new ArrayList<Integer>());
            }
            indexes.get(t.charAt(i)).add(i);
        }
        int prevIndex = 0, curIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!indexes.containsKey(s.charAt(i))) return false;
            List<Integer> indexI = indexes.get(s.charAt(i));
            //for (Integer ind : indexI) System.out.print(ind+",");
            curIndex = Collections.binarySearch(indexI, prevIndex);
            //System.out.println(curIndex);
            if (curIndex < 0) {
                curIndex = -1 - curIndex;
            }
            if (curIndex == indexI.size()) return false;
            prevIndex = indexI.get(curIndex) + 1;
        }
        return true;
    }
}