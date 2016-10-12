public class SnakeGame {
    class Point {
        public int x;
        public int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object b) {
            //System.out.println("equal");
            if (!(b instanceof Point)) return false;
            Point b1 = (Point) b;
            return x == b1.x && y == b1.y;
        }
        @Override
        public int hashCode() {
            //System.out.println(x * 10000 + y);
            return x * 10000 + y;
        }
    }
    Queue<Point> snake;
    Point cur;
    Set<Point> set;
    int[][] food;
    int foodIndex;
    int width, height;
    int score;
    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        snake = new LinkedList<>();
        set = new HashSet<>();
        cur = new Point(0, 0);
        snake.offer(cur);
        set.add(cur);
        this.food = food;
        this.width = width;
        this.height = height;
        score = 0;
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        for (int i = 0; i < direction.length(); i++) {
            char dir = direction.charAt(i);
            int x = cur.x, y = cur.y;
            if (dir == 'U') {
                x--;
            } else if (dir == 'L') {
                y--;
            } else if (dir == 'R') {
                y++;
            } else if (dir == 'D') {
                x++;
            }
            //System.out.println(x+" "+y);
            //System.out.println(set.size());
            if (x >= 0 && x < height && y >= 0 && y < width) {
                cur = new Point(x, y);
                if (foodIndex < food.length && food[foodIndex][0] == cur.x && food[foodIndex][1] == cur.y) {
                    foodIndex++;
                    snake.offer(cur);
                    set.add(cur);
                    score++;
                } else {
                    set.remove(snake.poll());
                    if (set.contains(cur)) return -1;
                    snake.offer(cur);
                    set.add(cur);
                }
            } else {
                return -1;
            }
        }
        return score;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */