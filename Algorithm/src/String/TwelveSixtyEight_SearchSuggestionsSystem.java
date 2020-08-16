package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwelveSixtyEight_SearchSuggestionsSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        if (products == null || products.length == 0 || searchWord == null || searchWord.isEmpty()) {
            return res;
        }
        /*
        Arrays.sort(products,new Comparator(){
            public int compare(Object o1, Object o2){
                String a = (String)o1, b = (String)o2;
                int len = Math.min(a.length(),b.length());
                for(int i=0;i<len;i++){
                    char c1 = a.charAt(i);
                    char c2 = b.charAt(i);
                    if(c1<c2) return -1;
                    else if(c1>c2) return 1;
                }
                return a.length()<b.length()?-1:1;
            }
        });
        */
        Arrays.sort(products); //Actually I don't have to self define comparator;
        //Using StringBuilder is not beneficial.
        for(int i=1;i<=searchWord.length();i++){
            List<String> tmp = new ArrayList<>();
            String str = searchWord.substring(0,i);
            for(String pdt:products){
                if(pdt.startsWith(str)) tmp.add(pdt);
                if(tmp.size()==3) break;
            }
            res.add(tmp);
        }

        return res;
    }
}
