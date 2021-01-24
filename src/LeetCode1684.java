import java.util.HashMap;

public class LeetCode1684 {
    public int countConsistentStrings(String allowed, String[] words) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<allowed.length(); i++) {
            map.put(allowed.charAt(i), 1);
        }

        int result = 0;

        for(String w: words) {
            int isConsistent = 1;
            for(int j=0; j<w.length(); j++) {
                if (map.get(w.charAt(j)) == null) {
                    isConsistent = 0;
                    break;
                }
            }

            result += isConsistent;
        }

        return result;
    }
}
