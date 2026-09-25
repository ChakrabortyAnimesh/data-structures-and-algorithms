import java.util.*;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // Edge case: if we are already at the destination
        if (source == destination) return true;

        // 1. Build the Adjacency List (The Map)
        // We use an array of ArrayLists for fast lookups
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // Populate the map (since it's bi-directional, add both ways)
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        // 2. Setup the Queue and Visited Tracker
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n]; // Tracks where we've been

        // Start at the source
        queue.offer(source);
        visited[source] = true;

        // 3. Explore (The BFS Loop)
        while (!queue.isEmpty()) {
            int current = queue.poll(); // Take the first node in line

            // If we reached our goal, stop and return true
            if (current == destination) {
                return true;
            }

            // Look at all neighbors of the current node
            for (int neighbor : graph[current]) {
                // If we haven't visited this neighbor yet
                if (!visited[neighbor]) {
                    visited[neighbor] = true; // Mark as visited so we don't go in circles
                    queue.offer(neighbor);    // Put it in the line to explore later
                }
            }
        }

        // 4. If the queue is empty and we never found the destination
        return false;
    }
}