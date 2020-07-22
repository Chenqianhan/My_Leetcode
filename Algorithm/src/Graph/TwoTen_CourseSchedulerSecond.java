package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
//Quite easy based on 207
public class TwoTen_CourseSchedulerSecond {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //Basic framework is same as 207. Only couples of difference.
        //This problem is based on 207, it requires not only output course schedule, but also identify if schedule can be initialized.
        ArrayList[] graph = new ArrayList[numCourses];
        int[] res = new int[numCourses];
        int[] degree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<numCourses;i++)
            graph[i] = new ArrayList<>();

        //Here the degree is the number of prerequisites that a course requires.
        for(int[] pre: prerequisites){
            degree[pre[0]]++;
            graph[pre[1]].add(pre[0]);
        }

        int index = 0, count = 0;
        for(int i=0;i<numCourses;i++){
            //Begin from those requested course.
            if(degree[i]==0){
                queue.add(i);
                count++;
            }
        }

        while(!queue.isEmpty()){
            int course = queue.poll();
            res[index++] = course;
            for(Object o: graph[course]){
                int succeeding = (int)o;
                //Cuz course is taken, the succeeding's number of prerequisites minus one;
                degree[succeeding]--;
                if(degree[succeeding]==0){
                    queue.add(succeeding);
                    count++;
                }
            }
        }

        return count==numCourses?res:new int[0];
    }
}
