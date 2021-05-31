import java.util.ArrayList;
import java.util.Arrays;

/**
 * Tags: #Sort
 */

public class LeetCode56 {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int n = intervals.length;
        ArrayList<int[]> results = new ArrayList<>();

        for(int i=0; i<intervals.length; i++) {
            System.out.println(intervals[i][0] + ", " + intervals[i][1]);
        }

        int i = 0;
        int j = i+1;
        for(i=0; i<n; ) {
            if (i==n-1) {
                results.add(intervals[i]);
                break;
            }

            System.out.println("i=" + i);
            Interval pre = new Interval(intervals[i]);

            for(j=i+1; j<n; j++) {

                System.out.println("j=" + j);
                Interval after = new Interval(intervals[j]);

                if(j==n-1) {
                    if(pre.merge(after) == true) {
                        int[] result = pre.toArray();
                        results.add(result);
                        i = j+1;
                        break;
                    }
                }


                if (pre.merge(after) == false) {
                    System.out.println(pre.toString());

                    int[] result = pre.toArray();
                    results.add(result);
                    i = j;
                    break;
                }

            }

        }

        int n2 = results.size();
        int[][] arrayResults = new int[n2][2];

        for(i=0; i<n2; i++) {
            arrayResults[i] = results.get(i);
        }

        return arrayResults;
    }

    class Interval {
        int a;
        int b;

        public Interval(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public Interval(int[] interval) {
            this.a = interval[0];
            this.b = interval[1];
        }

        public boolean isOverlap(Interval other) {
            return this.b >= other.a;
        }

        public boolean merge(Interval other) {
            if(this.isOverlap(other)) {
                this.a = Integer.min(this.a, other.a);
                this.b = Integer.max(this.b, other.b);
                return true;
            }

            return false;
        }

        public int[] toArray() {
            int[] interval = new int[2];
            interval[0] = this.a;
            interval[1] = this.b;

            return interval;
        }

        public String toString() {
            return "(" + this.a + ", " + this.b + ")";
        }
    }
}
