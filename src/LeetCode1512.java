import java.util.HashMap;

public class LeetCode1512 {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            int curr = nums[i];
            Integer count = map.get(curr);
            if (count == null) {
                map.put(curr, 1);
            } else {
                map.put(curr, count+1);
            }
        }

        int numPair = 0;
        for(Integer k: map.keySet()) {
            int count = map.get(k);
            if (count > 1) {
                numPair += count * (count - 1) / 2;
            }
        }

        return numPair;
    }
}
