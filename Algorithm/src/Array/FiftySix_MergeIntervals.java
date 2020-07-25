package Array;

public class FiftySix_MergeIntervals {
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;

        for(int i=0;i<intervals.length;i++){
            int[] cur = intervals[i];
            for(int j=i+1;j<intervals.length;j++){
                int[] next = intervals[j];
                if(overlap(cur,next)){
                    intervals[j][0] = Math.min(cur[0],next[0]);
                    intervals[j][1] = Math.max(cur[1],next[1]);

                    intervals[i][0] = 0;
                    intervals[i][1] = -1;
                    len--;
                    //Add a break can drastically reduce runtime. To jump out this loop layer.
                    break;
                }
            }
        }
        int[][] res = new int[len][2];
        for(int i=intervals.length-1;i>=0;i--){
            if(intervals[i][0]<=intervals[i][1])
                res[--len] = intervals[i];
        }

        return res;
    }

    public boolean overlap(int[] a, int[] b){
        return a[0]<=b[1] && a[1]>=b[0];
    }
}
