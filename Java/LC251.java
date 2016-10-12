public class Vector2D implements Iterator<Integer> {
    Integer nextNum;
    Queue<Iterator> iters;
    public Vector2D(List<List<Integer>> vec2d) {
        nextNum = null;
        iters = new LinkedList<>();
        for (List<Integer> list : vec2d) {
            iters.offer(list.iterator());
        }
        findNext();
    }

    @Override
    public Integer next() {
        Integer next = nextNum.intValue();
        findNext();
        return next;
    }

    @Override
    public boolean hasNext() {
        return nextNum != null;
    }
    
    private void findNext() {
        if (iters.isEmpty()) return;
        Iterator iter = iters.peek();
        while (!iters.isEmpty() && !iter.hasNext()) {
            iters.poll();
            if (iters.isEmpty()) break;
            iter = iters.peek();
            //System.out.println("Del");
        }
        if (iters.isEmpty()) nextNum = null;
        else {
            nextNum = (Integer) iter.next();
        }
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */