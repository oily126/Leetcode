public class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        int i, x1, x2, y1, y2;
        x1 = y1 = Integer.MAX_VALUE;
        x2 = y2 = Integer.MIN_VALUE;
        Set<String> points = new HashSet<>();
        int area = 0;
        for (int[] rect : rectangles) {
            x1 = Math.min(x1, rect[0]);
            y1 = Math.min(y1, rect[1]);
            x2 = Math.max(x2, rect[2]);
            y2 = Math.max(y2, rect[3]);
            
            String e0 = new String(rect[0] + " " + rect[1]);
            String e1 = new String(rect[0] + " " + rect[3]);
            String e2 = new String(rect[2] + " " + rect[1]);
            String e3 = new String(rect[2] + " " + rect[3]);
            if (points.contains(e0)) points.remove(e0); else points.add(e0);
            if (points.contains(e1)) points.remove(e1); else points.add(e1);
            if (points.contains(e2)) points.remove(e2); else points.add(e2);
            if (points.contains(e3)) points.remove(e3); else points.add(e3);
            
            area += (rect[2] - rect[0]) * (rect[3] - rect[1]);
        }
        String e0 = new String(x1 + " " + y1);
        String e1 = new String(x1 + " " + y2);
        String e2 = new String(x2 + " " + y1);
        String e3 = new String(x2 + " " + y2);
        if (area != (x2 - x1) * (y2 - y1) || points.size() != 4 
        || !points.contains(e0) || !points.contains(e1) || !points.contains(e2) || !points.contains(e3)) return false;
        return true;
    }
}