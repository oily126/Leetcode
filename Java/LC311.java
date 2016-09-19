public class Solution {
    class Node {
        public int num;
        public int x;
        public int y;
        public Node(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }
    public int[][] multiply(int[][] A, int[][] B) {
        int i, j;
        List<Node> AArr = new ArrayList<>();
        List<Node> BArr = new ArrayList<>();
        int[][] C = new int[A.length][B[0].length];
        buildArr(A, AArr);
        buildArr(B, BArr);
        for (i = 0; i < AArr.size(); i++) {
            for (j = 0; j < BArr.size(); j++) {
                if (AArr.get(i).y == BArr.get(j).x) {
                    C[AArr.get(i).x][BArr.get(j).y] += AArr.get(i).num * BArr.get(j).num;
                }
            }
        }
        return C;
    }
    private void buildArr(int[][] A, List<Node> AArr) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j] != 0) {
                    AArr.add(new Node(A[i][j], i, j));
                }
            }
        }
    }
}