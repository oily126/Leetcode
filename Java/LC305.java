public class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int islandNum = 0;
        int[] union = new int[m * n];
        boolean[][] map = new boolean[m][n];
        List<Integer> ans = new ArrayList<>(positions.length);
        for (int i = 0; i < positions.length; i++) {
            islandNum = updateUnionSet(positions[i][0], positions[i][1], m, n, map, union, islandNum);
            ans.add(islandNum);
        }
        return ans;
    }
    private int updateUnionSet(int i, int j, int m, int n, boolean[][] map, int[] union, int islandNum) {
        if (map[i][j]) return islandNum;
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int[] indexes = new int[4];
        int top = getIndex(i, j, m);
        map[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int x = i + dir[k][0];
            int y = j + dir[k][1];
            indexes[k] = -1;
            if (x >= 0 && x < m && y >= 0 && y < n && map[x][y]) {
                indexes[k] = find(getIndex(x, y, m), union);
            }
            if (indexes[k] >= 0 && indexes[k] < top) {
                top = indexes[k];
            }
        }
        //System.out.println(top);
        if (top == getIndex(i, j, m)) islandNum++;
        for (int k = 0; k < 4; k++) {
            if (indexes[k] >= 0) {
                if (union[indexes[k]] != top) {
                    union[indexes[k]] = top;
                    islandNum--;
                }
            }
        }
        union[getIndex(i, j, m)] = top;
        return islandNum;
    }
    private int find(int index, int[] union) {
        if (union[index] != index) {
            union[index] = find(union[index], union);
        }
        return union[index];
    }
    private int getIndex(int x, int y, int m) {
        return x + y * m;
    }
}