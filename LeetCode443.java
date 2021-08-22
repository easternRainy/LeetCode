import java.util.ArrayList;

public class LeetCode443 {
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }

        ArrayList<Character> result = new ArrayList<>();
        char curr = chars[0];
        int count = 0;

        for(int i=0; i<chars.length; i++) {
            if (chars[i] == curr) {
                count++;
            } else {
                result.add(curr);
                appendInt(result, count);
                curr = chars[i];
                count = 1;
            }
        }

        result.add(curr);
        appendInt(result, count);

        for(int i=0; i<result.size(); i++) {
            chars[i] = result.get(i);
        }
        return result.size();

    }

    public void appendInt(ArrayList<Character> result, int count) {
        if (count <= 1) {
            return;
        }
        String str = Integer.toString(count);
        char[] ch = str.toCharArray();
        for(int i=0; i<ch.length; i++) {
            result.add(ch[i]);
        }
    }
}
