import solutions.Assignment_kthSmallestTwoSortedArrays;
import solutions.Eight_StringToInteger;
import solutions.Thirteen_RomanToInteger;
import solutions.Twenty_validParentheses;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
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

        Twenty_validParentheses t=new Twenty_validParentheses();
        if(t.isValid("[]")){
            System.out.println("True");
        }else System.out.println("False");

        String[] str="{()}".split("");
        for(String s:str) System.out.println(s);
    }
}
