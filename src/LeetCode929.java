import java.util.HashMap;
import java.util.HashSet;

/**
 * Tags: #String
 */
public class LeetCode929 {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> emailSet = new HashSet<>();
        for(String email: emails) {
            String processedEmail = processEmail(email);
            emailSet.add(processedEmail);
        }

        return emailSet.size();
    }

    public String processEmail(String email) {
        String[] tmp = email.split("@");

        String localName = tmp[0];
        int firstPlusIndex = localName.indexOf('+');

        if(firstPlusIndex != -1) {
            localName = tmp[0].substring(0, firstPlusIndex);

        }

        localName = localName.replaceAll("\\.", "");


        return localName+"@"+tmp[1];
    }

    public static void main(String[] args) {
        String[] test = "test.ema.il+bob@gmail.com".split("@");
        String local = test[0];
        System.out.println(local.replaceAll("\\.", ""));
        //System.out.println(test[0]);
        System.out.println("abc".indexOf('d'));

    }
}
