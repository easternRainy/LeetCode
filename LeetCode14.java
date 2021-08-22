/**
 * Longest Common Prefix
 * Tags: #String
 */
public class LeetCode14 {
    public String longestCommonPrefix(String[] strs) {
        String prefix = "";

        if(strs.length == 0) {
            return prefix;
        }

        int minLen = 200;
        for (int i=0; i< strs.length; i++) {
            if (strs[i].length() < minLen) {
                minLen = strs[i].length();
            }
        }



        if (minLen == 0) {
            return prefix;
        }

        for (int j=0; j<minLen; j++) {
            char ch = strs[0].charAt(j);
            for (int i=0; i< strs.length; i++) {
                if (strs[i].charAt(j) != ch) {
                    return prefix;
                }
            }

            prefix += ch;
        }

        return prefix;
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        for(int i=1; i<strs.length; i++) {
            while(strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length()-1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        System.out.println("abcdf".indexOf("acb")); // return -1
    }
}
