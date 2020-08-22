
import java.io.IOException;
import java.util.*;

import static java.util.Collections.reverseOrder;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n==0) return;
        if(n==1){
            System.out.println(1);
            return;
        }
        int[][] res = new int[n][n];
        int[] progress = new int[n*n];

        progress[0]=1;
        progress[1]=1;
        for(int i=2;i<progress.length;i++){
            progress[i]=progress[i-1]+progress[i-2];
        }
        int idx = n*n;
        int rowStart = 0, rowEnd = n-1, colStart = 0, colEnd = n-1;
        while(rowStart<=rowEnd && colStart<=colEnd){
            for(int i=colStart;i<=colEnd;i++){
                res[rowStart][i]=progress[--idx];
            }
            rowStart++;

            for(int i=rowStart;i<=rowEnd;i++){
                res[i][colEnd]=progress[--idx];
            }
            colEnd--;

            for(int i=colEnd;i>=colStart;i--){
                res[rowEnd][i]=progress[--idx];
            }
            rowEnd--;

            for(int i=rowEnd;i>=rowStart;i--){
                res[i][colStart]=progress[--idx];
            }
            colStart++;
        }

        //Print
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
        /*
        Scanner sc = new Scanner(System.in);
        int groups = sc.nextInt();
        for(int i=0;i<groups;i++){
            int len = sc.nextInt(),max = 0, cur = 0, cnt = 0;
            int[] input = new int[len];
            for(int j=0;j<len;j++){
                input[j]=sc.nextInt();
            }
            Arrays.sort(input);
            for(int k=len-1;k>=0;k--){
                max+=input[k];
                if(cur<=0) cur+=input[k];
                else cur-=input[k];

                if(cur==0) cnt = max;
            }
            System.out.println(max-cnt);
        }
*/
        //System.out.println(0^1);
    }
}
