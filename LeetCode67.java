public class LeetCode67 {
    public String addBinary(String a, String b) {
        int p1 = a.length() - 1;
        int p2 = b.length() - 1;

        int carry = 0;

        StringBuilder sb = new StringBuilder();

        while(p1 >= 0 || p2 >= 0) {
            int d1 = (p1 >= 0) ? a.charAt(p1) - '0' : 0;
            int d2 = (p2 >= 0) ? b.charAt(p2) - '0' : 0;

            int sum = (d1 + d2 + carry) % 2;
            carry = (d1 + d2 + carry) / 2;

            sb.append(sum);

            p1--;
            p2--;
        }

        if (carry != 0) {
            sb.append(carry);
        }



        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        System.out.println(-108 % 10);
    }
}
