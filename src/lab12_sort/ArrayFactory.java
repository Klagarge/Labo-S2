package lab12_sort;

import java.util.Random;

public abstract class ArrayFactory {
    static int[] createRandomArray(int size, int maxValue){
        int[] array = new int[size];
        Random r = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(maxValue);
        }
        return array;
    }

    static int[] createInvertedSortedArray(int size){
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = size-i-1;
        }
        return array;
    }

    static int[] createShuffleArray(int size){
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            if(i%2 == 0){
                array[i] = i/2;
            } else {
                array[i] = (size-1)-(i/2);
            }
        }
        return array;
    }
}
