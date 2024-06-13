import java.util.*;

/***
 Using BFS approach and topological sort
 TC - O(V+E), SC - O(V+E)
 */
class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if(numCourses == 0)
            return true;

        //create adjacency list
        Map<Integer, List<Integer>> adjMap = new HashMap<>();

        //Create in-degree array
        int[] indegrees = new int[numCourses];


        //add prerequisites[1] as the key and prerequisites[0] as the adjacent vertex
        for(int prerequisite[] : prerequisites) {
            int from = prerequisite[1];
            int to = prerequisite[0];
            indegrees[to]++;

            if(!adjMap.containsKey(from))
                adjMap.put(from, new ArrayList<>());

            adjMap.get(from).add(to);

        }

        //Queue to store vertex with in-degree=0
        Queue<Integer> q = new LinkedList<>();
        int count = 0;

        for(int i =0; i < numCourses; i++) {
            if(indegrees[i] == 0)
                q.add(i);
        }

        while(!q.isEmpty()) {
            int vertex = q.poll();
            count++;

            if(!adjMap.containsKey(vertex))
                continue;

            //decrement the in-degree for adjacent vertex of polled vertex

            for(int i : adjMap.get(vertex)) {
                if(--indegrees[i] == 0)
                    q.add(i);
            }
        }

        if(count == numCourses)
            return true;

        return false;

    }
}