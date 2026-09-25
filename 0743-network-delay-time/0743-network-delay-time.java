import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // 1. Build the adjacency list
        // We use an array of lists. Indices are 1 to n to match node labels.
        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : times) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            graph[u].add(new int[]{v, w}); // Store {neighbor, weight}
        }

        // 2. Min-heap stores arrays of {cumulative_time, current_node}
        // Ordered by the minimum cumulative time
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        
        // 3. Track visited nodes
        boolean[] visited = new boolean[n + 1];
        int nodesVisited = 0;

        // Start from node k at time 0
        pq.offer(new int[]{0, k});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int time = current[0];
            int node = current[1];

            // If we've already found the shortest path to this node, skip it
            if (visited[node]) {
                continue;
            }

            visited[node] = true;
            nodesVisited++;

            // If we have visited all nodes, we are done
            if (nodesVisited == n) {
                return time;
            }

            // Push all unvisited neighbors into the heap
            for (int[] neighborInfo : graph[node]) {
                int neighbor = neighborInfo[0];
                int weight = neighborInfo[1];
                
                if (!visited[neighbor]) {
                    pq.offer(new int[]{time + weight, neighbor});
                }
            }
        }

        // If the loop finishes and not all nodes were reached
        return -1;
    }
}