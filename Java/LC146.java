public class LRUCache {
    public class Node {
        public int val;
        public int key;
        public Node prev, next;
        public Node() {
            val = 0;
            prev = next = null; 
        }
    };
    Map<Integer, Node> m;
    Node list, end;
    int capacity;
    
    public LRUCache(int capacity) {
        m = new HashMap<>();
        list = null;
        end = null;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Node ptr = m.get(key);
        if (ptr == null) return -1;
        moveForward(ptr);
        return ptr.val;
    }
    
    public void set(int key, int value) {
        Node ptr = m.get(key);
        if (ptr != null) {
            ptr.val = value;
            moveForward(ptr);
        } else {
            if (m.size() < capacity) {
                if (list == null) {
                    list = new Node();
                    end = list;
                } else {
                    ptr = new Node();
                    ptr.next = list;
                    list.prev = ptr;
                    list = ptr;
                }
                list.val = value;
                list.key = key;
                m.put(key, list);
            } else {
                if (end != null) {
                    m.remove(end.key);
                    //System.out.println("removed "+end.key+" "+end.val);
                    end.key = key;
                    end.val = value;
                    m.put(key, end);
                    moveForward(end);
                }
            }
        }
    }
    
    public void moveForward(Node ptr) {
        //System.out.println("move "+ptr.key+" "+ptr.val);
        if (ptr.prev != null) {
            ptr.prev.next = ptr.next;
            if (end == ptr) end = ptr.prev;
        }
        if (ptr.next != null && ptr != list) {
            ptr.next.prev = ptr.prev;
        }
        if (ptr != list) {
            ptr.next = list;
            ptr.prev = null;
            list.prev = ptr;
            list = ptr;
        }
        //System.out.println("end is "+end.key+" "+end.val);
    }
}