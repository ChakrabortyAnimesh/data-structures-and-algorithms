class Solution {
    public int lastStoneWeight(int[] stones) {
     // By default, Java's PriorityQueue is a Min-Heap.
        // We use Collections.reverseOrder() to turn it into a Max-Heap.
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        // Add all the stones into the Max-Heap
        for (int stone : stones) {
            maxHeap.offer(stone);
        }
        
        // Play the game until 1 or 0 stones remain
        while (maxHeap.size() > 1) {
            int y = maxHeap.poll(); // Get and remove the heaviest stone
            int x = maxHeap.poll(); // Get and remove the second heaviest stone
            
            // If y is heavier than x, the remaining weight goes back into the heap.
            // If they are equal, both are destroyed (we just don't add anything back).
            if (y != x) {
                maxHeap.offer(y - x);
            }
        }
        
        // If the heap is empty, all stones were destroyed, return 0.
        // Otherwise, return the weight of the single remaining stone.
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();   
    }
}