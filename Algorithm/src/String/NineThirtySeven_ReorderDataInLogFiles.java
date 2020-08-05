package String;

import java.util.Arrays;
//Seemingly easy but actually hard. It performs double 5%, can be further improved.
public class NineThirtySeven_ReorderDataInLogFiles {
    //Writing the comparator inside the Arrays.sort() is fine
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            //The latter parameter 2 means only split it into two Strings.
            //The first one is dig1, the second is "8 1 5 1".
            String[] str1 = log1.split("\\s", 2);
            String[] str2 = log2.split("\\s", 2);
            boolean isDig1 = Character.isDigit(str1[1].charAt(0));
            boolean isDig2 = Character.isDigit(str2[1].charAt(0));
            //Identifiers are not limited to "dig" or "letter", just ignore it.
            //boolean isDig1 = str1[0].charAt(0)=='d';
            //boolean isDig2 = str2[0].charAt(0)=='d';
            if(!isDig1 && !isDig2){
                int tmp = str1[1].compareTo(str2[1]);
                if(tmp!=0) return tmp;
                return str1[0].compareTo(str2[0]);
                //Cannot do so, cuz if str1[1]==str2[1], we have to compare the identifier, but it didn't mention that, bullshit.
                //return str1[1].compareTo(str2[1]);
            }
            //The digit-logs should be put in their original order.
            //Only three conditions, true:true, true:false, false:true
            //0 means stay the same cause both are digits.
            //return 1 means Dig2 is letter so put it forward to sort.
            return isDig1?(isDig2?0:1):-1;
        });

        return logs;
    }


}
