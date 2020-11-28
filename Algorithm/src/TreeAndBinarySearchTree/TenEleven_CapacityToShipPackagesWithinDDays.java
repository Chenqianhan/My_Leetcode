package TreeAndBinarySearchTree;

//It is totally equal to fourTen
public class TenEleven_CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int D) {
        long left = 0, right = 1;
        for(int i:weights){
            right += i;
            left = Math.max(left, i);
        }

        while(left < right){
            long mid = left + (right - left)/2, cur = 0;
            int num = 1;
            for(int i:weights){
                cur += i;
                if(cur > mid){
                    num++;
                    cur = i;
                }
            }

            if(num > D){
                left = mid+1;
            }else{
                right = mid;
            }
        }

        return (int)left;
    }
}
