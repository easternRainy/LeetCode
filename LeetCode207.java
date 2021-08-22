import java.util.HashMap;
import Graph.Graph;

/**
 * Date: 2020-07-09
 * LeetCode Problem 207
 * Tags: #Graph
 *
 * [Course Schedule](https://leetcode.com/problems/course-schedule/)
 *
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 */
public class LeetCode207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Graph graph = new Graph(numCourses);
        int[] order = new int[numCourses];

        // Edge conditioin 1: no prerequsites
        if(prerequisites.length == 0) {
            return true;
        }

        // store course index->is is in prerequisites array?
        // for example, if numCourses = 3, prerequisites = [[0,1]], then course 0 and 1 is in prerequisites, but course 2 is not
        HashMap<Integer, Integer> isInPre = new HashMap<>();
        for(int i=0; i<numCourses; i++) {
            isInPre.put(i, 0); // 0 means not in prerequisites
        }

        // go through prerequisites array
        for(int i=0; i<prerequisites.length; i++) {
            isInPre.put(prerequisites[i][1], 1);
            isInPre.put(prerequisites[i][0], 1);
            graph.addEdge(prerequisites[i][1], prerequisites[i][0]);
        }

        // go through map isInPre, put those not in preArray into order
        int orderIndex = 0;
        int curr;
        int numNotInPre = 0;
        int numInPre = 0;
        for(int i=0; i<numCourses; i++) {
            if((curr = isInPre.get(i)) == 0) {
                order[orderIndex] = i;
                orderIndex++;
                numNotInPre++;
            } else {
                numInPre++;
            }
        }

        System.out.println(graph.numConnectedComponents());
        if(graph.numConnectedComponents() != numCourses) {
            return false;
        } else {

            return true;
        }
    }
}
