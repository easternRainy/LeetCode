public class LeetCode1041 {
    public boolean isRobotBounded(String instructions) {
        Point point = new Point(0, 0);

        for(int i=0; i<instructions.length(); i++) {
            char c = instructions.charAt(i);

            if (c == 'G') {
                point.forward();
                System.out.println(point.toString());
            }

            if (c == 'L') {
                point.rotateLeft();
                System.out.println(point.toString());
            }

            if (c == 'R') {
                point.rotateRight();
                System.out.println(point.toString());
            }
        }

        return point.isOnCircle();
    }

    class Point {
        // position
        int x;
        int y;

        // direction
        int dx;
        int dy;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;

            this.dx = 0;
            this.dy = 1;
        }

        public void forward() {
            this.x += dx;
            this.y += dy;
        }

        public void rotateLeft() {
            int tmp = this.dx;
            this.dx = -this.dy;
            this.dy = tmp;
        }

        public void rotateRight() {
            int tmp = this.dx;
            this.dx = this.dy;
            this.dy = -tmp;
        }

        public boolean isOrigin() {
            return (this.x == 0 && this.y == 0);
        }

        public boolean isNorth() {
            return (this.dx == 0 && this.dy == 1);
        }

        public boolean isOnCircle() {
            return this.isOrigin() || !this.isNorth();
        }

        public String toString() {
            return this.x + " " + this.y + " " + this.dx + " " + this.dy;
        }
    }
}
