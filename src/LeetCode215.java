import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 2020-08-20
 * LeetCode Problem 215
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class LeetCode215 {
    public int findKthLargest(int[] nums, int k) {
        return findKthLargestQueue(nums, k);
    }

    /**
     * using java built-in priority queue, which is a minheap
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargestQueue(int[] nums, int k) {
        PriorityQueue queue = new PriorityQueue();

        for(Integer num: nums) {
            queue.add(num);
        }

        int result = 0;
        for(int i=0; i < nums.length + 1 - k; i++) {
            result = (int)queue.poll();

        }

        return result;
    }

    /**
     * turn java built-in priority queue into a max heap
     */
    public int findKthLargestMaxHeap(int[] nums, int k) {


      PriorityQueue<Integer> queue = new PriorityQueue<>(nums.length, Collections.reverseOrder());

        for(Integer num: nums) {
            queue.add(num);
        }

        int result = 0;
        for(int i=0; i <  k; i++) {
            result = queue.poll();

        }

        return result;
    }

    /**
     * using quick sort to find k-th largest element
     * https://www.programcreek.com/2014/05/leetcode-kth-largest-element-in-an-array-java/
     */
    public int findKthLargestQuickSort(int[] nums, int k) {
        return 0;
    }


}
