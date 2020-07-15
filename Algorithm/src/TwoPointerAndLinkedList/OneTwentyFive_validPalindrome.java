package TwoPointerAndLinkedList;

public class OneTwentyFive_validPalindrome {
    public boolean isPalindrome(String s){
    if(s==null || s.length()<1)
        return true;

    int[] map = new int[256];
    for(int i=0;i<10;i++)
        map[i+'0'] = 1+i;
    for(int i=0;i<26;i++)
        map[i+'A']=map[i+'a']=11+i;

    char[] list = s.toCharArray();
    for(int left=0,right=list.length-1;left<right;){
        if(map[list[left]]==0){
            left++;
        }else if(map[list[right]]==0){
            right--;
        }else if(map[list[right--]]!=map[list[left++]]){
            return false;
        }
    }
    return true;
}
    /*
    public boolean isPalindrome(String s) {
        //Two-pointer
        if(s==null || s.length()<1)
            return true;

        char[] list = s.toCharArray();
        int i=0,j=list.length-1;
        while(i<j){
            while(i<j && !Character.isLetterOrDigit(list[i]))
                i++;
            while(i<j && !Character.isLetterOrDigit(list[j]))
                j--;
            if(i<j && Character.toLowerCase(list[i])!=Character.toLowerCase(list[j]))
                return false;
            i++;
            j--;
        }

        return true;
    }
    */
}
