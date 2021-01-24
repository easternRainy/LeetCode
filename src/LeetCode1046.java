import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode1046 {
    public int lastStoneWeight(int[] stones) {

        //max heap
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0; i<stones.length; i++) {
            heap.add(stones[i]);
        }

        while(heap.size() > 1) {
            int stone1 = heap.remove();
            int stone2 = heap.remove();

            if (stone1 != stone2) {
                heap.add(stone1 - stone2);
            }
        }

        return heap.isEmpty()? 0 : heap.remove();
    }
}
