public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> wList = new ArrayList<>(), lList;
        Set<String> ans = new HashSet<>();
        int i, j, k;
        wList.add(word);
        while (wList.size() > 0) {
            lList = wList;
            ans.addAll(lList);
            wList = new ArrayList<>();
            for (String w : lList) {
                for (j = 0; j < w.length(); j++) {
                    char ch = w.charAt(j);
                    if ((ch < '0' || ch > '9')
                        && (j == 0 || w.charAt(j - 1) < '0' 
                        || w.charAt(j - 1) > '9')) {
                        int num = 0;
                        for (k = j + 1; k < w.length(); k++) {
                            if (w.charAt(k) < '0' || w.charAt(k) > '9') {
                                break;
                            } else {
                                num = num * 10 + w.charAt(k) - '0';
                            }
                        }
                        if (k >= w.length()) {
                            StringBuilder sb = new StringBuilder();
                            String s;
                            sb.append(w.substring(0, j)).append(num + 1);
                            s = sb.toString();
                            if (ans.add(s)) {
                                wList.add(s);
                            }
                        } else {
                            StringBuilder sb = new StringBuilder();
                            String s;
                            sb.append(w.substring(0, j)).append(num + 1).append(w.substring(k, w.length()));
                            s = sb.toString();
                            if (ans.add(s)) {
                                wList.add(s);
                            }
                        }
                    }
                }
            }
        }
        return new ArrayList<String>(ans);
    }
}