
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
    }

}
