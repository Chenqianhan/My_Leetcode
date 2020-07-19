import DFSandRecursion.FortySix_permutations;
import DFSandRecursion.ThirtyNine_CombinationSum;
import TreeAndBST.FourTwentyEight_SerializeAndDeserializeNTree;
import dataStructure.Node;


import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FourTwentyEight_SerializeAndDeserializeNTree sd = new FourTwentyEight_SerializeAndDeserializeNTree();
        Node root = new Node(1);
        root.children = new ArrayList<>();
        root.children.add(new Node(2));
        root.children.add(new Node(3));
        //System.out.println(sd.serialize(root));
        //String s = sd.serialize(sd.deserialize("1 [ 3 [ 5 6 ] 2 4 ]"));
        String s = sd.serialize(sd.deserialize("1 [ 3 [ 4 [ 3 ] 5 ] 4 ]"));
        System.out.println(s);

        TreeMap<Integer,Integer> map = new TreeMap<>();
        map.put(1,1);
        map.put(3,2);
        map.put(2,4);
        for(int i:map.values()){
            System.out.println(i);
        }
        /*
        FortySix_permutations f = new FortySix_permutations();
        ThirtyNine_CombinationSum t = new ThirtyNine_CombinationSum();
        int[] a = {2,3,6,7};
        List<List<Integer>> res = t.combinationSum(a,7);
        for(List<Integer> l:res){
            System.out.println();
            for(int i:l){
                System.out.print(i);
            }
        }

        int i = -1;
        String s = String.valueOf(i);
        int j = -(s.charAt(1) - '0');
        s = "-1,,1";
        String[] ints=s.split(",");
        for(String x:ints){
            System.out.println(x);
        }
        System.out.println(!ints[1].equals(""));



        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        q.offer(2);
        System.out.println(q.peek());

         */

        //Eight_StringToInteger sti=new Eight_StringToInteger();
        /*
        Thirteen_RomanToInteger thi=new Thirteen_RomanToInteger();
        String str="IX";
        System.out.print(thi.romanToInt(str));
        char a=66;
        System.out.print(a);
        */
        /*
        int[] A = {4, 5, 6};
        //int[] B = {1, 2, 3, 7, 8, 9, 10};
        int[] B=A.clone();
        for(int i:B) System.out.println(i);

        A[0]=0;
        for(int i:A) System.out.println(i);
        for(int i:B) System.out.println(i);
*/
        //System.out.println(ass.kth(A,B,4));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String str = (String) br.readLine();
        //System.out.println(str);
        //String[] arr=str.split(",");
        //for(String a:arr) System.out.println(a);
        //int[] arr={0,0,1,1,1,2,2,2,2,3,3,3};
        //TwentySix_RemoveDuplicateFromSArray tr=new TwentySix_RemoveDuplicateFromSArray();
        //tr.removeDuplicates(arr);
        //String s="This";
        //System.out.println(s.substring(1,4));
        /*
        FortySix_permutations fp=new FortySix_permutations();
        int[] nums=new int[3];
        nums[0]=1;
        nums[1]=2;
        nums[2]=3;
        fp.permute(nums);
        int a=Integer.MIN_VALUE;
        //if(a==Integer.MIN_VALUE) int b=Integer.MAX_VALUE;
        System.out.println(-a);
        boolean[] tt=new boolean[10];
        System.out.println(tt[9]);
        HashMap<Integer, Integer> map=new HashMap<>();
        map.put(1,1);
        System.out.println(map.size());
        int[] arr={1,2,3,4,5,6};
        int[] brr=Arrays.copyOfRange(arr,3,3);
        System.out.println(brr.length);
*/
        /*
        int i = 9678562;
        char[] set=String.valueOf(i).toCharArray();
        boolean flag=true;
        int j=flag?1:-1;
        System.out.println(j);
        int count=0;
        int n=1;
        int preDigit=-1;
        for(char a:set){
            if(a==preDigit+1){
                n++;
            }else{
                count+=(n>1)?n*n:0;
                n=1;
            }
            preDigit=a;
        }
        int c=(4%2==0)?1:2;
        System.out.println(c);

        Stack<Integer> stack=new Stack<>();
        stack.push(1);
        System.out.println(stack.search(0));

        char e='5';
        int d=e-'0';
        int f=5;
        char g=(char)f;
        g+='0';

        System.out.println(String.valueOf(g));

         */
    }
}
