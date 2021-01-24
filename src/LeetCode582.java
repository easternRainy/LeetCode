import java.util.*;

/**
 * 2020-08-23
 * LeetCode Problem 582
 * https://eugenejw.github.io/2017/07/leetcode-582
 * Tags: #Queue #BFS
 */
public class LeetCode582 {
    public static List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> results = new ArrayList<>();
        HashMap<Integer, List<Integer>> children = new HashMap<>();
        for(int i=0; i<pid.size(); i++) {
            int currPpid = ppid.get(i);
            if(currPpid > 0) {
                List<Integer> tmp = children.get(ppid.get(i));
                if(tmp == null) {
                    tmp = new ArrayList<>();
                }

                tmp.add(pid.get(i));
                children.put(currPpid, tmp);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(kill);
        while(!queue.isEmpty()) {
            int currPid = queue.poll();
            results.add(currPid);
            List<Integer> currChildren = children.get(currPid);
            if(currChildren != null) {
                for(Integer child: currChildren) {
                    queue.add(child);
                }
            }

        }

        return results;
    }

    public static void main(String[] args) {
        List<Integer> pid = new ArrayList<>();
        List<Integer> ppid = new ArrayList<>();
        pid.add(1);
        ppid.add(3);

        pid.add(3);
        ppid.add(0);

        pid.add(10);
        ppid.add(5);

        pid.add(5);
        ppid.add(3);

        System.out.println(killProcess(pid, ppid, 3));
    }

}
