public class Solution {
    public boolean validWordSquare(List<String> words) {
        int i, j;
        for (i = 0; i < words.size(); i++) {
            for (j = 0; j < words.get(i).length(); j++) {
                if (j >= words.size() || i >= words.get(j).length() || words.get(i).charAt(j) != words.get(j).charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}