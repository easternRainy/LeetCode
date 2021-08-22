import java.util.HashMap;

public class LeetCode13 {
    public int romanToInt(String s) {

        HashMap<String, Integer> table = new HashMap<>();
        table.put("I", 1);
        table.put("IV", 4);
        table.put("V", 5);
        table.put("IX", 9);
        table.put("X", 10);
        table.put("XL", 40);
        table.put("L", 50);
        table.put("XC", 90);
        table.put("C", 100);
        table.put("CD", 400);
        table.put("D", 500);
        table.put("CM", 900);
        table.put("M", 1000);

        if(s.length() == 1) {
            return table.get(s);
        }

        int result = 0;
        for(int i=0; i<s.length(); ) {
            if (i == s.length() - 1) {
                result += table.get(s.substring(i,i+1));
                i = i+1;
                continue;
            }

            Integer tmp = table.get(s.substring(i,i+2));
            if (tmp != null) {
                result += tmp;
                i = i + 2;
            } else {
                result += table.get(s.substring(i,i+1));
                i = i+1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        HashMap<String, Integer> table = new HashMap<>();
        table.put("s", 1);
        Integer tmp = table.get("a");
        System.out.println(tmp);
    }
}
