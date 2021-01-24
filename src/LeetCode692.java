import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class LeetCode692 {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> freq = new HashMap<>();
        for(String s: words) {
            if (freq.get(s) != null) {
                freq.put(s, freq.get(s) + 1);
            } else {
                freq.put(s, 1);
            }
        }

        PriorityQueue<String> heap = new PriorityQueue<>(
                (n1, n2) -> {
                    int freq1 = freq.get(n1);
                    int freq2 = freq.get(n2);

                    if(freq1 < freq2) {
                        return 1;
                    } else if (freq1 == freq2) {
                        return orderOf(n1, n2);
                    } else {
                        return -1;
                    }
                }
        );

        for(String s: freq.keySet()) {
            heap.add(s);
        }

        List<String> result = new ArrayList<>();

        for(int i=0; i<k; i++) {
            result.add(heap.remove());
        }

        return result;
    }

    public static int orderOf(String n1, String n2) {
        int l1 = n1.length();
        int l2 = n2.length();

        int k = (l1 <= l2) ? l1 : l2;
        for(int i=0; i<k; i++) {
            char ch1 = n1.charAt(i);
            char ch2 = n2.charAt(i);

            if (ch1 < ch2) {
                return -1;
            } else if (ch1 == ch2) {
                continue;
            } else {
                return 1;
            }
        }

        return (l1 <= l2) ? -1 : 1;
    }
}
