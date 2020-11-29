package Tiktok;

import java.util.Arrays;

public class SixEightyOne_NextClosestTime {
    public String nextClosestTime(String time) {
        char[] res = time.toCharArray();
        char[] digits = new char[]{res[0], res[1], res[3], res[4]};
        Arrays.sort(digits);

        res[4] = nextAvail(res[4], '9', digits);
        if(res[4] > time.charAt(4)) return String.valueOf(res);

        res[3] = nextAvail(res[3], '5', digits);
        if(res[3] > time.charAt(3)) return String.valueOf(res);

        res[1] = res[0]=='2' ? nextAvail(res[1], '4', digits) : nextAvail(res[1], '9', digits);
        if(res[1] > time.charAt(1)) return String.valueOf(res);

        res[0] = nextAvail(res[0], '2', digits);

        return String.valueOf(res);
        //Why res.toString() is wrong.
    }

    public char nextAvail(char cur, char limit, char[] digits){
        if(cur == limit) return digits[0];

        int position = Arrays.binarySearch(digits, cur) + 1;

        while(position < 4 && (digits[position] == cur || digits[position] > limit)){
            position++;
        }

        return position==4?digits[0]:digits[position];
    }
}
