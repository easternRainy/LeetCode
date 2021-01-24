import java.util.ArrayList;
import java.util.List;

/**
 * subset problem
 */
public class LeetCode78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<Integer>());
        for(int i=0; i<nums.length; i++) {
            int curr = nums[i];

            int resultSize = result.size();
            for(int j=0; j<resultSize; j++) {
                List<Integer> currArr = result.get(j);
                List<Integer> newArray = new ArrayList<>();
                for(int k=0; k<currArr.size(); k++) {
                    newArray.add(currArr.get(k));
                }
                newArray.add(curr);
                result.add(newArray);
            }
        }

        return result;
    }
}
