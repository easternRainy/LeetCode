public class LeetCode997 {
    public int findJudge(int N, int[][] trust) {
        Graph graph = new Graph(N);
        for(int i=0; i<trust.length; i++) {
            int from = trust[i][1];
            int to = trust[i][0];
            graph.add(from-1, to);
        }

        return graph.checkJudge(trust);
    }


    public class Graph {
        private ListNode[] buckets;
        private int[] nums;
        private int N;

        public Graph(int N) {
            this.N = N;
            this.buckets = new ListNode[N];
            this.nums = new int[N];
        }

        public void add(int from, int to) {
            ListNode head = this.buckets[from];
            if (head == null) {
                head = new ListNode(to);
            } else {
                ListNode p = head;
                while(p.next != null) {
                    p = p.next;
                }
                ListNode newNode = new ListNode(to);
                p.next = newNode;
            }

            this.nums[from] += 1;
        }

        public int checkJudge(int[][] trust) {
            int result = -1;
            for(int i=0; i<this.N; i++) {
                System.out.println(this.nums[i]);
                if (this.nums[i] == this.N-1) {
                    result = i;
                    break;
                }
            }

            if (result == -1) {
                return -1;
            } else {
                // check if he trust others
                for(int i=0; i<trust.length; i++) {
                    if (trust[i][0] == result + 1) {
                        return -1;
                    }
                }

                return result+1;
            }
        }




    }



    public class ListNode {
        int neighbor;
        ListNode next;

        public ListNode (int neighbor) {
            this.neighbor = neighbor;
        }
    }
}
