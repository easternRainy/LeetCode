/**
 * Date: 2020-07-01
 *
 * [Course Schedule](https://leetcode.com/problems/course-schedule-ii/)
 *
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
 *
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
 */
import Graph.Graph;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * 2020-07-09
 * LeetCode Problem 210
 * Tags: #Graph
 */

public class LeetCode210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Graph graph = new Graph(numCourses);
        int[] order = new int[numCourses];

        // Edge conditioin 1: no prerequsites
        if(prerequisites.length == 0) {
            for(int i=0; i<numCourses; i++) {
                order[i] = i;
            }
            return order;
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
            return new int[0];
        } else {
            int[] tmp = graph.topologicalSort();
            for(int i=0; i<tmp.length; i++) {
                if(isInPre.get(tmp[i]) == 1) {
                    order[orderIndex] = tmp[i];
                    orderIndex++;
                }
            }
            return order;
        }
    }

    public static void main(String[] args) {
        int numCourses = 3;
        int[][] preArray = new int[2][2];
        preArray[0][0] = 2;
        preArray[0][1] = 0;
        preArray[1][0] = 2;
        preArray[1][1] = 1;



        LeetCode210 solution = new LeetCode210();
        int[] order = solution.findOrder(numCourses, preArray);
        for(int i=0; i<order.length; i++) {
            System.out.println(order[i]);
        }

    }
}
