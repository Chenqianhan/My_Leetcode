
import java.io.IOException;
import java.util.*;

import static com.sun.xml.internal.xsom.impl.UName.comparator;
import static java.util.Collections.reverseOrder;

public class Main {
    public static void main(String[] args) {
        int C = 5;
        System.out.println(~C);
        /*
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

         */
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
        /*
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int A = sc.nextInt(), B = sc.nextInt();
        char[] a = Integer.toString(A).toCharArray();
        char[] b = Integer.toString(B).toCharArray();
        Arrays.sort(b, Comparator.reverseOrder());
        for(int i = 0;i<n;i++){
            for(int j = 1;j<n-i;j++){
                if(b[j-1]>b[j]){
                    char tmp = b[j-1];
                    b[j-1] = b[j];
                    b[j] = tmp;
                    //true -> a>=b
                    if(compare(a, b)){
                        b[j] = b[j-1];
                        b[j-1] = tmp;
                        System.out.println(Integer.parseInt(new String(b)));
                        return;
                    }
                }
            }
        }
        System.out.println(-1);

         */

        char[] list = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t',
                'u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N',
                'O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        String raw_str = "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBeeeeeeeeeeFYHHnjHAPQQc";
        StringBuilder sb = new StringBuilder();
        int Length = raw_str.length()-1;
        for(int i=0;i<Length+1;i++){
            int idx = i;
            int len = 1;
            char c = raw_str.charAt(i);
            while(idx<Length && raw_str.charAt(idx)==raw_str.charAt(idx+1)){
                len++;
                idx++;
            }
            if(len>3){
                if(len>55){
                    idx -= len - 55;
                    len = 55;
                }
                //char charLen = list[len-4];
                sb.append("0").append(list[len - 4]).append(c);
            }else{
                while(len-->0){
                    sb.append(c);
                }
            }
            i = idx;
        }
        System.out.println(sb.toString());
        //System.out.println("0ZB0tB0geFYHHnjHAPQQc");



        /*
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //好大一坑, A,B可能大于Integer范围.
        String A = sc.next(), B = sc.next();
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();

        int idx = 0;
        //Find equal
        while(idx<b.length-1){
            for(int i=idx;i<b.length;i++){
                if(b[i]==a[idx]){
                    char tmp = b[i];
                    b[i] = b[idx];
                    b[idx] = tmp;
                    break;
                }
            }
            //No more equal number;
            if(b[idx]!=a[idx]) break;
            idx++;
        }

        char min = 'Z';
        int k = -1;
        //Find least larger number;
        for(int i=idx;i<b.length;i++){
            if(b[i]>a[idx] && b[i]<min){
                min = b[i];
                k = i;
            }
        }
        //Swap
        if(k!=-1) {
            char t = b[k];
            b[k] = b[idx];
            b[idx] = t;
            idx++;
        }

        //After that, the rest of it will be in order.
        //Bubble sort
        for(int i=idx;i<b.length;i++){
            for(int j=idx+1;j<b.length-i+idx;j++){
                if(b[j-1]>b[j]){
                    char tmp = b[j-1];
                    b[j-1] = b[j];
                    b[j] = tmp;
                }
            }
        }

        //int res = Integer.parseInt(new String(b));
        String res = new String(b);
        System.out.println(A.compareTo(res)<0?res:-1);

         */

    }
}
