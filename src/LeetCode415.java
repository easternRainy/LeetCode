public class LeetCode415 {
    public String addStrings(String num1, String num2) {
        int l1 = num1.length() - 1;
        int l2 = num2.length() - 1;

        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while( l1 >= 0 || l2 >= 0) {
            int c1 = l1 >= 0 ? num1.charAt(l1) - '0' : 0;
            int c2 = l2 >= 0 ? num2.charAt(l2) - '0' : 0;

            sb.append((c1+c2 + carry)%10);
            carry = (c1 + c2 + carry) / 10;

            l1--;
            l2--;
        }

        if ( carry > 0 ) { sb.append(carry); }

        return sb.reverse().toString();
    }
}
