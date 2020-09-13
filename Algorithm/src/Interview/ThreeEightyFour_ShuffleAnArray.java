package Interview;

import java.util.Random;

public class ThreeEightyFour_ShuffleAnArray {
    private int[] array;
    private int[] original;
    private Random rand = new Random();

    private void swap(int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private int randRange(int left, int right){
        return rand.nextInt(right-left) + left;
    }

    public ThreeEightyFour_ShuffleAnArray(int[] nums) {
        array = nums;
        original = nums.clone();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        array = original.clone();
        return array;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for(int i=0;i<array.length;i++){
            //It has to be array.length but not array.length-1. Cuz rand.nextInt(X), X must larger than 0;
            swap(i, randRange(i, array.length));
        }
        return array;
    }
}
