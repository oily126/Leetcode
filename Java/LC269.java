public class Solution {
    public String alienOrder(String[] words) {
        Set<Character> chars = new HashSet<>();
        Map<Character, Set<Character>> graph = new HashMap<>();
        if (!buildGraph(words, graph, chars)) return "";
        String ans = topologicalSort(graph, chars);
        if (ans.length() != chars.size()) return ""; else return ans;
    }
    private boolean buildGraph(String[] words, Map<Character, Set<Character>> graph, Set<Character> chars) {
        String word0 = "";
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word0.length() != word.length() && word0.startsWith(word)) {
                return false;
            }
            for (int j = 0; j < word.length(); j++) chars.add(word.charAt(j));
            for (int j = 0; j < word.length() && j < word0.length(); j++) {
                if (word.charAt(j) != word0.charAt(j)) {
                    if (!graph.containsKey(word0.charAt(j))) {
                        graph.put(word0.charAt(j), new HashSet<>());
                    }
                    graph.get(word0.charAt(j)).add(word.charAt(j));
                    break;
                }
            }
            word0 = word;
        }
        return true;
    }
    private String topologicalSort(Map<Character, Set<Character>> graph, Set<Character> chars) {
        Map<Character, Integer> indegree = new HashMap<>();
        for (Character ch : graph.keySet()) {
            Set<Character> links = graph.get(ch);
            for (Character nextCh : links) {
                indegree.put(nextCh, indegree.getOrDefault(nextCh, 0) + 1);
            }
        }
        return BFS(indegree, graph, chars);
    }
    private String BFS(Map<Character, Integer> indegree, Map<Character, Set<Character>> graph, Set<Character> chars) {
        Queue<Character> next = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (Character ch : chars) {
            if (!indegree.containsKey(ch)) {
                next.offer(ch);
            }
        }
        while (next.size() > 0) {
            for (int size = next.size(); size > 0; size--) {
                Character ch = next.poll();
                Set<Character> links = graph.get(ch);
                sb.append(ch);
                if (links == null) continue;
                for (Character nextCh : links) {
                    Integer num = indegree.get(nextCh);
                    if (num == null) continue;
                    if (num > 1) {
                        indegree.put(nextCh, num - 1);
                    } else {
                        next.offer(nextCh);
                        indegree.remove(nextCh);
                    }
                }
            }
        }
        return sb.toString();
    }
}