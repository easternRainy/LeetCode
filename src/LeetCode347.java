import java.util.HashMap;
import java.util.PriorityQueue;

public class LeetCode347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for(Integer i: nums) {
            if (freq.get(i) != null) {
                freq.put(i, freq.get(i) + 1);
            } else {
                freq.put(i, 1);
            }
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(
                (n1, n2) -> freq.get(n2) - freq.get(n1)
        );

        for(Integer i: freq.keySet()) {
            heap.add(i);

        }

        int[] result = new int[k];
        for(int i=0; i<k; i++) {
            result[i] = heap.remove();
        }

        return result;
    }

}
