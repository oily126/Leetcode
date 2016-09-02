public class Solution {
    class TrieNode {
        public boolean isEnd;
        public Map<Character, TrieNode> next;
        public TrieNode() {
            isEnd = false;
            next = new HashMap<>();
        }
        public TrieNode(String[] words) {
            isEnd = false;
            next = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                add(words[i]);
            }
        }
        public void add(String s) {
            TrieNode node = this, ptr;
            for (int i = 0; i < s.length(); i++) {
                ptr = node.next.get(s.charAt(i));
                if (ptr == null) {
                    ptr = new TrieNode();
                    node.next.put(s.charAt(i), ptr);
                }
                node = ptr;
            }
            node.isEnd = true;
        }
        public TrieNode getNext(char ch) {
            return next.get(ch);
        }
        public boolean hasNext(char ch) {
            return next.containsKey(ch);
        }
    }
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode head = new TrieNode(words);
        boolean[][] visited = new boolean[board.length][board[0].length];
        Set<String> ans = new HashSet<>();
        int i, j;
        for (i = 0; i < board.length; i++) {
            for (j = 0; j < board[0].length; j++) {
                dfs(i, j, board, head, visited, new StringBuilder(), ans);
            }
        }
        List<String> ansArr = new ArrayList<>(ans.size());
        for (String s : ans) {
            ansArr.add(s);
        }
        return ansArr;
    }
    private void dfs(int x, int y, char[][] board, 
        TrieNode head, boolean[][] visited, 
        StringBuilder buf, Set<String> ans) {
        
        if (head == null) {
            return;
        }
        if (head.isEnd) {
            ans.add(buf.toString());
        }
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return;
        }
        
        if (visited[x][y]) {
            return;
        }
        
        if (head.hasNext(board[x][y])) {
            visited[x][y] = true;
            buf.append(board[x][y]);
            dfs(x + 1, y, board, head.getNext(board[x][y]), visited, buf, ans);
            dfs(x - 1, y, board, head.getNext(board[x][y]), visited, buf, ans);
            dfs(x, y + 1, board, head.getNext(board[x][y]), visited, buf, ans);
            dfs(x, y - 1, board, head.getNext(board[x][y]), visited, buf, ans);
            buf.setLength(buf.length() - 1);
            visited[x][y] = false;
        }
    }
}