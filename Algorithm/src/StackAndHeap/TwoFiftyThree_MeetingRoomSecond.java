package StackAndHeap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class TwoFiftyThree_MeetingRoomSecond {
    //A little optimization.
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->a[0]-b[0]);
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int[] meeting:intervals){
            //Each meeting requires one room. If there is a meeting ended before it starts, poll it out. Replacing one room at most each time.
            if(!queue.isEmpty() && meeting[0]>=queue.peek())
                queue.poll();

            queue.offer(meeting[1]);
        }

        return queue.size(); //It is the number of cumulative rooms.
    }
    /*
    //7ms(50%), 39.7MB(21%). This solution is more inituitive.
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        int cnt = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(Integer.MIN_VALUE);
        for(int[] meeting:intervals){
            cnt = Math.max(cnt, queue.size());
            //Clean up those meetings that ended before this one.
            while(!queue.isEmpty() && meeting[0]>=queue.peek()){
                queue.remove();
            }

            queue.offer(meeting[1]);
            cnt = Math.max(cnt, queue.size());
        }
        return cnt;
    }
    */
}
