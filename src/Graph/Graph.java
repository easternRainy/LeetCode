package Graph;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Knowledge, Basic Implementation, and Application of Graph
 */
public class Graph {

    private int numVertices;
    private Edge[] graph; // vertex that node_i points to
    private Edge[] from; // vertex that node_i is pointed to
    private int[][] startEndTable;

    /**
     * 00_Constructor
     * @param numVertices
     */
    public Graph(int numVertices) {
        this.numVertices = numVertices;
        this.graph = new Edge[numVertices];
        this.from = new Edge[numVertices];
    }

    /**
     * 01_01_add an edge for nodeId
     * @param nodeId
     * @param edge
     */
    private void addEdge(int nodeId, Edge edge, Edge[] table) {
        Edge p = table[nodeId];
        if(p == null) {
            table[nodeId] = edge;
            edge.next = null;
            return;
        }

        if(edge.neighbor < p.neighbor) {
            Edge tmp = p;
            table[nodeId] = edge;
            edge.next = tmp;
            return;
        }

        Edge back = p;
        while(p != null && p.neighbor < edge.neighbor) {
            back = p;
            p = p.next;
        }

        back.next = edge;
        edge.next = p;
    }

    /**
     * 01_02
     * add an edge for fromId to toId
     * @param fromId
     * @param toId
     */
    public void addEdge(int fromId, int toId) {
        Edge edge = new Edge(toId);
        Edge from = new Edge(fromId);
        this.addEdge(fromId, edge, this.graph);
        this.addEdge(toId, from, this.from);
    }

    /**
     * 01_03_assume childId and nodeId exist
     * @param toId, which is in hashtable
     * @param fromId, which is in linkedlist, Note: not reverse. no mistake here
     * @param table
     */
    private void removeEdge(int toId, int fromId, Edge[] table) {
        Edge p = table[toId];
        // if delet in the first postion of linked list
        if(p.neighbor == fromId) {
            Edge tmp = p.next;
            table[toId] = tmp;
            p.next = null;
            return;
        }

        Edge back;
        while(p != null) {
            back = p;
            p = p.next;

            if(p.neighbor == fromId) {
                back.next = p.next;
                p.next = null;
                return;
            }
        }

    }

    /**
     * 02_01_DFS called by user
     * @param vertex
     */
    public void recursionDFS(int vertex) {
        // prepare a table to store if the vertex is visited
        boolean visited[] = new boolean[this.numVertices];
        for(boolean visit: visited) {
            visit = false;
        }

        recursionDFS(this.graph, vertex, visited);
        for(int i=0; i<this.numVertices; i++) {
            if(visited[i] == false) {
                recursionDFS(this.graph, i, visited);
            }
        }
    }

    /**
     * 02_01_01_working function of recursion DFS
     * @param graph
     * @param vertex
     * @param visited
     */
    private void recursionDFS(Edge[] graph, int vertex, boolean visited[]) {
        Edge tmp;
        visited[vertex] = true;
        for (tmp = graph[vertex]; tmp != null; tmp = tmp.next) {
            if(!visited[tmp.neighbor]) {
                recursionDFS(graph, tmp.neighbor, visited);
            }
        }
    }

    /**
     * 02_02_DFS that could display the visiting information
     * @param vertex
     */
    public void recordDFS(int vertex) {
        // prepare a table to store if the vertex is visited
        boolean visited[] = new boolean[this.numVertices];
        for(boolean visit: visited) {
            visit = false;
        }

        recordDFS(this.graph, vertex, visited);
        for(int i=0; i<this.numVertices; i++) {
            if(visited[i] == false) {
                recordDFS(this.graph, i, visited);
            }
        }
    }

    /**
     * 02_02_01_working funciton of recordDFS
     * @param graph
     * @param vertex
     * @param visited
     */
    private void recordDFS(Edge[] graph, int vertex, boolean[] visited) {

        if (!visited[vertex]) {
            visited[vertex] = true;
            System.out.println("Visited " + vertex);
            Edge p = graph[vertex];
            if (p == null) {
                System.out.println("Done with neighbors of " + vertex);
                return;
            }

            while (p != null) {
                recordDFS(graph, p.neighbor, visited);
                p = p.next;
            }
            System.out.println("Backtracked to " + vertex);
            System.out.println("Done with neighbors of " + vertex);
        }
    }

    /**
     * 02_03_perform DFS and record start and end index
     * @param vertex
     */
    public void startEndDFS(int vertex) {

        this.startEndTable = new int[this.numVertices][2];

        boolean visited[] = new boolean[this.numVertices];
        for(boolean visit: visited) {
            visit = false;
        }

        Counter counter = new Counter();

        this.startEndDFS(this.graph, vertex, visited, counter);

        for(int i=0; i<this.numVertices; i++) {
            if(visited[i] == false) {
                this.startEndDFS(this.graph, i, visited, counter);
            }
        }
    }

    /**
     * 02_03_01_working function of startEndDFS
     * @param graph
     * @param vertex
     * @param visited
     * @param counter
     */
    private void startEndDFS(Edge[] graph, int vertex, boolean[] visited, Counter counter) {
        if (!visited[vertex]) {
            visited[vertex] = true;

            //System.out.println("Visited " + vertex);
            this.startEndTable[vertex][0] = counter.getIndex();
            counter.increase();

            Edge p = graph[vertex];
            if (p == null) {
                //System.out.println("Done with neighbors of " + vertex);
                this.startEndTable[vertex][1] = counter.getIndex();
                counter.increase();
                return;
            }

            while (p != null) {
                startEndDFS(graph, p.neighbor, visited, counter);
                p = p.next;
            }
            //System.out.println("Backtracked to " + vertex);
            //System.out.println("Done with neighbors of " + vertex);
            this.startEndTable[vertex][1] = counter.getIndex();
            counter.increase();
        }
    }

    // stack DFS


    // 03_BFS

    // record BFS

    // startEnd BFS

    // queue BFS

    // multiple time BFS


    /**
     * 04_01_topological Sort, running startEndDFS, sort the vertex by end time, large first.
     * @return
     */
    public int[] topologicalSort() {
        // run DFS and record end time
        this.startEndDFS(this.findFirstNodeNoIncoming());

        // go through the startEndTable, sorting the index by end time large
        // use Edge to create a linked list
        Edge result = null;
        for(int i=0; i<this.numVertices; i++) {
            Edge curr = new Edge(i);
            if(result == null) {
                result = curr;
                continue;
            }

            Edge p = result;
            if(this.startEndTable[i][1] > this.startEndTable[p.neighbor][1]) {
                Edge tmp = p;
                result = curr;
                curr.next = tmp;
                continue;
            }

            Edge back = p;
            while(p!=null && this.startEndTable[p.neighbor][1] > this.startEndTable[i][1]) {
                back = p;
                p = p.next;
            }
            back.next = curr;
            curr.next = p;
        }

        // Convert result to array
        int solution[] = new int[this.numVertices];
        Edge p = result;
        int i = 0;
        while(p != null) {
            solution[i] = p.neighbor;
            p = p.next;
            i++;
        }

        return solution;
    }

    /**
     * 04_02_topological sort using Kahn Algortim, removing node that has no incoming.
     * @return
     */
    public int[] topologicalSortKahn() {
        ArrayList<Integer> result = new ArrayList<>();
        int curr;
        while((curr = this.findFirstNodeNoIncoming()) != -1) {

            //System.out.println("Removing: " + curr);
            result.add(curr);
            this.removeNodeNoIncoming(curr);
        }

        int[] solution = new int[result.size()];
        for(int i=0; i<result.size(); i++) {
            solution[i] = result.get(i);
            //System.out.println(solution[i]);
        }
        return solution;
    }

    /**
     * 04_02_01_find the first node that has no incoming
     * @return
     */
    private int findFirstNodeNoIncoming() {
        for(int i=0; i<this.numVertices; i++) {
            if(this.from[i] == null) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 04_02_02_assume nodeId exist and has no incoming
     * @param nodeId
     */
    private void removeNodeNoIncoming(int nodeId) {
        // let from[nodeId] not null so next time this.findFirstNodeNoIncoming will treat it as not null
        this.from[nodeId] = new Edge(-1);

        // for each child of nodeId, for example, 7 |->5->6, remove (5,7) and (6,7) in this.from
        Edge p = this.graph[nodeId];
        while(p != null) {
            int childId = p.neighbor;
            this.removeEdge(childId, nodeId, this.from);
            p = p.next;
        }
    }

    /**
     * 04_02_03_return the transpose of graph
     * @return
     */
    public Graph getTranspose() {
        Graph transpose = new Graph(this.numVertices);
        for(int i=0; i<this.numVertices; i++) {
            Edge p = this.graph[i];
            while(p != null) {
                transpose.addEdge(p.neighbor, i);
                p = p.next;
            }
        }

        return transpose;
    }

    /**
     * return the number of connected components
     * @return
     */
    public int numConnectedComponents() {
        Graph transpose = this.getTranspose();
        int start = this.findFirstNodeNoIncoming();
        if(start == -1) {
            start = 0;
        }
        this.startEndDFS(start);

        // create a map: endTime -> vertexIndex
        HashMap<Integer, Integer> returnTime = new HashMap<>();
        for(int i=0; i<this.numVertices; i++) {
            returnTime.put(this.startEndTable[i][1], i);
        }

        // visited table
        boolean visited[] = new boolean[this.numVertices];
        for(boolean visit: visited) {
            visit = false;
        }

        // num of connected components
        int count = 0;

        for(int i = 2*this.numVertices; i > 0; i--) {
            int currVertex;
            if(returnTime.get(i) != null) {
                currVertex  = returnTime.get(i);
                if(visited[currVertex] == false) {
                    transpose.recursionDFS(transpose.graph, currVertex, visited);
                    count++;
                }
            }
        }

        return count;
    }

    /**
     * get last visited vertex
     * @return
     */
    private int getLastVisitedVertex() {
        int lastIndex = 2 * this.numVertices;
        for(int i=0; i<this.numVertices; i++) {
            if(this.startEndTable[i][1] == lastIndex) {
                return i;
            }
        }
        return -1;
    }

    //------------- Class Utils ---------------

    /**
     * display start end table
     */
    public void displayStartEndTable() {
        if(this.startEndTable == null) {
            System.out.println("The table is vacant");
            return;
        }

        for(int i=0; i<this.numVertices; i++) {
            System.out.println(i + ": " + this.startEndTable[i][0] + ", " + this.startEndTable[i][1]);
        }
    }

    /**
     * display graph information
     * @return
     */
    public String toString() {
        String result = "";
        for(int i=0; i<this.numVertices; i++) {
            result += i + ": ";
            Edge p = this.graph[i];
            while(p != null) {
                result += p.neighbor;
                if(p.next != null) {
                    result += "->";
                }
                p = p.next;
            }
            result += "\n";
        }

        return result;
    }

    /**
     * Class that is used to create Adjacency list
     */
    public static class Edge {
        private int neighbor;
        private Edge next;

        public Edge(int neighbor) {
            this.neighbor = neighbor;
            this.next = null;
        }
    }

    /**
     * counter class used when traversing the graph with start end time
     */
    public static class Counter {
        private int index;

        public Counter() {
            this.index = 1;
        }

        public void increase() {
            this.index += 1;
        }

        public int getIndex() {
            return this.index;
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
//        graph.addEdge(1,0);
//        graph.addEdge(2,1);
//        graph.addEdge(3,1);
//        graph.addEdge(5,2);
//        graph.addEdge(6,3);
//        graph.addEdge(5,4);
//        graph.addEdge(6,4);
//        graph.addEdge(7,5);
//        graph.addEdge(7,6);

//        graph.startEndDFS(7);
//        graph.displayStartEndTable();
//        int[] topologicalSort = graph.topologicalSort();
//        for(int i=0; i<topologicalSort.length; i++) {
//            System.out.print(topologicalSort[i] + ", ");
//        }
//
//        System.out.println();
//
//        System.out.println(graph.toString());
//
//        Graph tranpose = graph.getTranspose();
//
//        System.out.println(tranpose.toString());

//        System.out.println(graph.numConnectedComponents());

        // --------------------------------------------------

        graph.addEdge(0, 2);
        graph.addEdge(1, 2);

        System.out.println(graph.numConnectedComponents());


    }
    

}


