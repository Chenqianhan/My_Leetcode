package StackAndHeap;

import java.util.Collections;
import java.util.PriorityQueue;

public class ThreeSeventyEight_KthSmallestElementInSortedMatrix {public int kthSmallest(int[][] matrix, int k) {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    for(int[] row:matrix){
        for(int i:row){
            maxHeap.offer(i);
            if(maxHeap.size()>k) maxHeap.poll();
        }
    }

    return maxHeap.poll();
}
}
