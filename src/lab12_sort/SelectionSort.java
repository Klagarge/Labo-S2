package lab12_sort;

public abstract  class SelectionSort {
    static public int[] sort(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            int min = array[i];
            int iMin = i;
            for (int j = i; j < array.length; j++) {
                if(array[j] < min){
                    min = array[j];
                    iMin = j;
                }
            }
            int tmp = array[i];
            array[i] = array[iMin];
            array[iMin] = tmp;
        }
        return array;
    }
}
