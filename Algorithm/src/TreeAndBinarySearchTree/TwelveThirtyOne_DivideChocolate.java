package TreeAndBinarySearchTree;

public class TwelveThirtyOne_DivideChocolate {
    public int maximizeSweetness(int[] sweetness, int K) {
        long left = 0, right = 0;
        for (int i : sweetness) {
            right += i;
        }
        right /= (K + 1);
        right++;

        while (left < right) {
            long mid = left + (right - left) / 2, cur = 0;
            int num = 0;
            for (int i : sweetness) {
                cur += i;
                if (cur >= mid) {
                    cur = 0;
                    num++;
                }
            }

            if (num >= K + 1) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return (int) (left - 1);
        //left meaning：
        //以前，我们求的是最小值，现在我们要求满足条件的最大值，
        //【11234145555555555】
    }
}
