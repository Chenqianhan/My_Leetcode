package Array;

import java.util.Arrays;

public class TenEightySix_HighFive {
    public int[][] highFive(int[][] items) {
        Arrays.sort(items, (a, b)->a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        int maxID = items[items.length-1][0];
        int[][] res = new int[maxID][2];

        int cnt=0,sum=0,ID=1;
        for(int i=0;i<items.length;i++){
            if(cnt!=5 && items[i][0]==ID){
                sum+=items[i][1];
                cnt++;
            }
            if(cnt==5){
                res[ID-1][0]=ID;
                res[ID++-1][1]=sum/5;
                cnt=0; sum=0;
            }
        }
        return res;
    }
}
