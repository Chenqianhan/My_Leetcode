package Array;

public class SixSeventy_MaximumSwap {
    public int maximumSwap(int num) {
        char[] n = Integer.toString(num).toCharArray();
        for(int i=0;i<n.length-1;i++){
            int idx = i, max = 0;
            for(int j = n.length-1;j>i;j--){
                if(n[j]>max){
                    max = n[j];
                    idx = j;
                }
            }
            if(n[idx]>n[i]){
                char tmp = n[i];
                n[i] = n[idx];
                n[idx] = tmp;
                return Integer.parseInt(new String(n));
            }
        }
        return num;
    }
}
