import java.util.HashMap;

public class LeetCode771 {

    public int numJewelsInStones(String J, String S) {
        HashMap<Character, Integer> jewel = new HashMap<>();
        for(int i=0; i<J.length(); i++) {
            jewel.put(J.charAt(i), 1);
        }

        int result = 0;
        for(int i=0; i<S.length(); i++) {
            if (jewel.get(S.charAt(i)) != null) {
                result += 1;
            }
        }

        return result;
    }
}
