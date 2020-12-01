
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.io.IOException;
import java.util.*;

import static com.sun.xml.internal.xsom.impl.UName.comparator;
import static java.util.Collections.reverseOrder;

public class Main {
    public static void main(String[] args) {
        String str = "ABCabc123";
        System.out.println(str.replace("ABC","CBA"));

        char[] c = new char[]{'1','2','3'};
        System.out.println(Arrays.toString(c));
        System.out.println(String.valueOf(c));

        int[][] i = new int[][]{{1,2},{3,4},{5,6},{7,8}};
        Arrays.sort(i, (a,b)->b[0]);
    }

}
