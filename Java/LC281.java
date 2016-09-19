public class ZigzagIterator {
    List<List<Integer>> v;
    int x;
    int y;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        v = new ArrayList<>();
        v.add(v1);
        v.add(v2);
        getNext(-1, 0);
    }

    public int next() {
        if (x < 0) return -1;
        int tmpX = x, tmpY = y;
        getNext(x, y);
        return v.get(tmpX).get(tmpY);
    }

    public boolean hasNext() {
        return x >= 0;
    }
    
    private void getNext(int x, int y) {
        int cnt = 0;
        while (cnt++ < v.size()) {
            if (x == v.size() - 1) {
                y++;
            }
            x = (x + 1) % v.size();
            if (v.get(x).size() > y) {
                this.x = x;
                this.y = y;
                return;
            }
        }
        this.x = -2;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */