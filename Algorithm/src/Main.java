
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        char a = 'a';
        char b = 'b';
        System.out.println(a < b);
        for (int i = 0; i < 10; ++i) {
            System.out.println(i);
        }
        String c = "05";
        System.out.println(Integer.parseInt(c));

        String s = "dig1 8 1 5 1";
        String[] strs = s.split("\\s",2);
        for(String str:strs) System.out.println(str);
    }
}
