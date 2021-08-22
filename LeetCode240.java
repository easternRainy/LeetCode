/**
 * Problem 240
 */
public class LeetCode240 {
    public boolean searchMatrix(int[][] matrix, int target) {

        int row = matrix.length;
        int col = matrix[0].length;

        Index leftUp = new Index(0,0);
        Index rightUp = new Index(0, col);
        Index leftDown = new Index(row, 0);
        Index rightDown = new Index(row, col);

        while(leftUp.x < rightUp.x && leftDown.x < rightDown.x && leftUp.y < leftDown.y && rightUp.x < rightUp.y) {

        }

        return false;
    }

    public Index middle(Index a, Index b) {
        int x = (a.x + b.x)/2;
        int y = (a.y + b.y)/2;
        Index mid = new Index(x, y);
        return mid;
    }

    class Index {
        int x;
        int y;

        public Index(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int get(int[][] matrix) {
            return matrix[this.x][this.y];
        }


    }
}
