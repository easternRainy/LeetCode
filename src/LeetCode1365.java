import java.util.HashMap;

public class LeetCode1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {

        int max = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> count = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            if(nums[i] > max) {max = nums[i];}

            if (map.get(nums[i]) != null) {
                map.put(nums[i], 1+map.get(nums[i]));
            } else {
                map.put(nums[i], 1);
            }
        }

        int pre = -1;
        for(int i=0; i<=max; i++) {
            if(map.get(i) != null) {
                if(pre == -1) {
                    count.put(i, 0);
                    pre = i;
                } else {
                    count.put(i, map.get(pre));
                    map.put(i, map.get(pre) + map.get(i));
                    pre = i;
                }
            }
        }

        int[] result = new int[nums.length];
        for(int i=0; i<result.length; i++) {
            result[i] = count.get(nums[i]);
        }

        return result;

    }
}
