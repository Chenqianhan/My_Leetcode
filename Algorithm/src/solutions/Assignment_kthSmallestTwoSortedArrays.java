package solutions;

import java.util.Arrays;

public class Assignment_kthSmallestTwoSortedArrays {
    public int kth(int A[],int B[],int k){

        int lenA=A.length;
        int lenB=B.length;

        if(lenA==0) return B[k];
        if(lenB==0) return A[k];
        /*
        if(lenA+lenB==k) return

        if((lenA+lenB)/2<k){
            if(A[lenA/2]>B[lenB/2])
        }
        */
        if(A[lenA/2]>B[lenB/2]){
            if(k<(lenA+lenB)/2) return kth(Arrays.copyOfRange(A,0,lenA/2),B,k);
            else return kth(A,Arrays.copyOfRange(B,(lenB/2)-1,lenB),k-(lenB/2));
        }
        else{
            if(k<(lenA+lenB)/2) return kth(A,Arrays.copyOfRange(B,0,lenB/2),k);
            else return kth(Arrays.copyOfRange(A,(lenA/2)-1,lenA),B,k-(lenB/2));
        }
    }
}
