public class Solution {
    public int trap(int[] height) {
        Stack<Integer> walls = new Stack<>();
        Stack<Integer> index = new Stack<>();
        int maxH = 0;
        int area = 0;
        for (int i = 0; i < height.length; i++) {
            while (!walls.empty() && height[i] > walls.peek()) {
                int h = walls.pop();
                int idx = index.pop();
                if (!walls.empty()) {
                    area += (Math.min(walls.peek(), Math.min(maxH, height[i])) - h) * (i - index.peek() - 1);
                }
                //System.out.println(i + " " + h + " " + idx + " " + area);
            }
            if (walls.empty() || height[i] < walls.peek()) {
                walls.push(height[i]);
                index.push(i);
            } else if (!walls.empty() && height[i] == walls.peek()) {
                index.pop();
                index.push(i);
            }
            maxH = Math.max(maxH, height[i]);
        }
        return area;
    }
}