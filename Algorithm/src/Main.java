import solutions.Assignment_kthSmallestTwoSortedArrays;
import solutions.Eight_StringToInteger;
import solutions.Thirteen_RomanToInteger;

public class Main {
    public static void main(String[] args){
        //Eight_StringToInteger sti=new Eight_StringToInteger();
        /*
        Thirteen_RomanToInteger thi=new Thirteen_RomanToInteger();
        String str="IX";
        System.out.print(thi.romanToInt(str));
        char a=66;
        System.out.print(a);
        */
        int []A={4,5,6};
        int []B={1,2,3,7,8,9,10};
        Assignment_kthSmallestTwoSortedArrays ass=new Assignment_kthSmallestTwoSortedArrays();
        System.out.println(ass.kth(A,B,4));
    }
}
