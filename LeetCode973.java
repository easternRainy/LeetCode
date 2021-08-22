import java.util.PriorityQueue;

public class LeetCode973 {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(
                (n1, n2) -> {
                    double dist = distance(n1) - distance(n2);
                    if (dist < 0) {
                        return -1;
                    } else if (dist == 0) {
                        return 0;
                    } else {
                        return 1;
                    }
                }
        );

        for(int i=0; i<points.length; i++) {
            heap.add(points[i]);
        }

        int[][] result = new int[K][2];
        for(int i=0; i<K; i++) {
            result[i] = heap.remove();
        }

        return result;
    }

    public static double distance(int[] point) {
        return Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2));
    }
}
