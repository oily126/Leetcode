public class ValidWordAbbr {
    Map<String, Integer> map;
    Set<String> set;
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<>();
        set = new HashSet<>();
        for (String word : dictionary) {
            String abb = abbreviate(word);
            if (!set.contains(word)) {
                map.put(abb, map.getOrDefault(abb, 0) + 1);
                set.add(word);
            }
        }
    }

    public boolean isUnique(String word) {
        if (word == null) return true;
        if (set.contains(word)) {
            if (map.get(abbreviate(word)) > 1) return false;
            else return true;
        } else {
            return !map.containsKey(abbreviate(word));
        }
    }
    
    private String abbreviate(String word) {
        StringBuilder sb = new StringBuilder();
        
        if (word.length() < 2) return word;
        sb.append(word.charAt(0)).append(word.length() - 2)
            .append(word.charAt(word.length() - 1));
        return sb.toString();
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");