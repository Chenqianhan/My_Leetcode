package Tiktok;

public class ThreeNinetyFive_LongestSubstringWithKRepeatingChar {
    public int longestSubstring(String s, int k) {
        if(s == null || s.length() < 1 || s.length() < k) return 0;
        if(k < 2) return s.length();
        return helper(s, k, 0, s.length());
    }

    public int helper(String s, int k, int l, int r){
        if(l >= r) return 0;

        int[] letters = new int[26];
        for(int i=l;i<r;i++){
            letters[s.charAt(i) - 'a']++;
        }
        boolean flag = true;
        for(int i=0;i<26 && flag;i++){
            if(letters[i] > 0 && letters[i] < k) flag = false;
        }

        if(flag) return (r - l);

        int max = 0, idx = l;
        while(idx < r){
            if(letters[s.charAt(idx) - 'a'] < k){
                max = Math.max(max, helper(s, k, l, idx));
                l = idx+1;
            }
            idx++;
        }
        max = Math.max(max, helper(s, k, l, r));

        return max;
    }
}
