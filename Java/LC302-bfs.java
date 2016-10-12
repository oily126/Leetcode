public class Solution {
    public int minArea(char[][] image, int x, int y) {
        int m = image.length;
        if (m == 0) return 0;
        int n = image[0].length;
        Queue<Long> next = new LinkedList<>();
        Set<Long> reach = new HashSet<>();
        int[] dir = {-n, n, -1, 1};
        next.add(getIndex(x, y, n));
        reach.add(next.peek());
        int minX = x, minY = y, maxX = x, maxY = y;
        while (next.size() > 0) {
            for (int size = next.size(); size > 0; size--) {
                long index = next.poll(), nindex;
                int nx, ny;
                for (int i = 0; i < dir.length; i++) {
                    nindex = index + dir[i];
                    nx = getX(nindex, n);
                    ny = getY(nindex, n);
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n 
                    && image[nx][ny] == '1' && !reach.contains(nindex)) {
                        reach.add(nindex);
                        next.add(nindex);
                        minX = Math.min(minX, nx);
                        minY = Math.min(minY, ny);
                        maxX = Math.max(maxX, nx);
                        maxY = Math.max(maxY, ny);
                    }
                }
            }
        }
        return (maxX - minX + 1) * (maxY - minY + 1);
    }
    private long getIndex(int x, int y, int n) {
        return x * n + y;
    }
    private int getX(long index, int n) {
        return (int) (index / n);
    }
    private int getY(long index, int n) {
        return (int) (index % n);
    }
}