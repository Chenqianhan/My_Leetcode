
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.io.IOException;
import java.util.*;

import static com.sun.xml.internal.xsom.impl.UName.comparator;
import static java.util.Collections.reverseOrder;

public class Main {
    public static void main(String[] args) {

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
        /*
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
    */


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

        /*
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt(), Q = sc.nextInt();
        boolean[] isLocked = new boolean[N+2];
        boolean[] isLean = new boolean[M+1];
        isLocked[0] = true;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<Q;i++){
            int op = sc.nextInt();
            int x, y;
            switch(op){
                case 1:
                    x = sc.nextInt(); y = sc.nextInt();
                    if(!isLocked[y] && !isLean[x] && !isLocked[map.getOrDefault(x,N+1)]) {
                        map.put(x, y);
                        //System.out.println(y);
                    }
                    break;
                case 2:
                    y = sc.nextInt();
                    isLocked[y] = true;
                    break;
                case 3:
                    y = sc.nextInt();
                    isLocked[y] = false;
                    break;
                case 4:
                    x = sc.nextInt();
                    if(!isLean[x] && !isLocked[map.getOrDefault(x,0)]){
                        isLean[x] = true;

                        y = map.get(x); //if returned but not place, is N+1;
                        map.put(x,0);
                        //System.out.println(y);
                        System.out.println(y==0?-1:y);
                    }else{
                        //System.out.println(map.getOrDefault(x,0));
                        System.out.println(-1);
                    }
                    break;
                case 5:
                    x = sc.nextInt();
                    isLean[x] = false;
                    break;
            }
        }
         */

        /*
        Pair<Integer, Integer> e = new Pair(0, sc.nextInt());
        Pair<Integer, Integer> f = new Pair(1, sc.nextInt());
        Pair<Integer, Integer> g = new Pair(2, sc.nextInt());
        PriorityQueue<Pair<Integer,Integer>> queue = new PriorityQueue<>((a,b)->b.value()-a.value());
        */
        /*
        Map<Integer, Integer> price =new TreeMap<Integer,Integer>(new Comparator<Map.Entry<Integer,Integer>>(){
                         public int compare(Entry<Integer,Integer> e1,Entry<Integer,Integer> e2){
            				return e2.getValue().compareTo(e1.getValue());
        }
                         });
        price.put(0,sc.nextInt());
        price.put(1,sc.nextInt());
        price.put(2,sc.nextInt());
        */
/*
		Collections.sort(price, new Comparator<Map.Entry<Integer,Integer>>(){
                         public int compare(Entry<Integer,Integer> e1,Entry<Integer,Integer> e2){
            				return e2.getValue().compareTo(e1.getValue());
        }
                         });
                         */

        /*
        ArrayList<int[]> queue = new ArrayList<>();
        queue.add(new int[]{0, sc.nextInt()});
        queue.add(new int[]{1, sc.nextInt()});
        queue.add(new int[]{2, sc.nextInt()});
        queue.sort((a, b) -> b[1] - a[1]);

        int interest = 0;
        int b = 3;
        //for(Pair<Integer, Integer> pair:queue)){
        for(int[] combo:queue){
            System.out.println(combo[0]+" "+combo[1]);
            //int p = pair.value();
            //int a = pair.key();
            //int p = price.get(a);
            int amount = Math.min(arr[b], arr[combo[0]]);
            System.out.println("amount="+amount);
            interest += combo[1]*amount;
            //System.out.println();
            System.out.println("interest="+interest);
            arr[b] -= amount;
        }

        System.out.println(interest);

         */

        /*
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //不能sort. 递归解决不了重复.
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        int MIN = Integer.MIN_VALUE;
        //int MIN = -999999;
        Set<int[]> set = new HashSet<>();
        helper(nums, 0, MIN, MIN, MIN, set, MIN);

        System.out.println(set.size());

        for(int[] i:set){
            System.out.println(i[0]+" "+i[1]+" "+i[2]);
        }
        */

        /*
         loop1: for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(j==5) continue loop1;

                System.out.println(j);
            }
         }
         int i = -5;
         System.out.println(i&(1<<1));
         */
        /*
        String str = "3496";
        str = new StringBuilder(str).reverse().toString();
        int sum = 0;
        for(int i = str.length()-1; i>=0 ; i--){
            char c = str.charAt(i);
            if(i%2>0){
                int tmp = c - '0';
                tmp *= 2;
                sum += tmp/10;
                sum += tmp%10;
            }else{
                sum += c - '0';
            }
        }

        System.out.println(sum);

        String a = "3413289830", b = "a-bcdefghij";
        int[] map = new int[a.length()];
        for(int i=0; i<a.length();i++){
            map[i] = a.charAt(i)-'0';
        }

        System.out.println(calculator(b,map));

         */
        Float f1 = new Float("3.0");
        int x = f1.intValue();
        byte b = f1.byteValue();
        double d = f1.doubleValue();
        System.out.println(x+b+d);
    }

    public static int calculator(String s, int[] map){
        int sum = 0, curNum = 0, num = 0;
        char op = '+';
        for(char c:s.toCharArray()){
            if(Character.isLetter(c)){
                curNum = curNum*10 + map[c-'a'];
            }else if(c!=' '){
                num = cal(num, curNum, op);
                if(c == '+' || c== '-'){
                    sum+=num;
                    num = 0;
                }
                curNum = 0;
                op = c;
            }
        }

        return sum + cal(num, curNum, op);
    }

    public static int cal(int a, int b, char op){
        switch (op){
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b;
            case '/':
                return a/b;
        }
        return 0;
    }
}
