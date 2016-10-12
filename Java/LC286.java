public class Solution {
    class Point {
        public int x;
        public int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0) return;
        
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[rooms.length][rooms[0].length];
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[i].length; j++) {
                if (rooms[i][j] == 0) {
                    visited[i][j] = true;
                    q.offer(new Point(i, j));
                } else if (rooms[i][j] == -1) {
                    visited[i][j] = true;
                }
            }
        }
        int len = 0;
        while (q.size() > 0) {
            int size = q.size();
            len++;
            for (int i = 0; i < size; i++) {
                Point p = q.poll();
                for (int j = 0; j < dir.length; j++) {
                    int x = p.x + dir[j][0];
                    int y = p.y + dir[j][1];
                    if (x >= 0 && x < rooms.length && y >= 0 && y < rooms[0].length
                        && !visited[x][y]) {
                        visited[x][y] = true;
                        q.offer(new Point(x, y));
                        if (rooms[x][y] != 0) rooms[x][y] = len;
                    }
                }
            }
        }
    }
}