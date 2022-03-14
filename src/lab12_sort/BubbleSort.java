package lab12_sort;

public abstract class BubbleSort {
    static public int[] sort(int[] array){
        boolean shorted = false;
        while (shorted == false) {
            shorted = true;
            for (int i = 0; i < array.length-1; i++) {
                if (array[i] > array[i+1]) {
                    int tmp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = tmp;
                    shorted = false;
                }
            }
        }
        return array;
    }
}
