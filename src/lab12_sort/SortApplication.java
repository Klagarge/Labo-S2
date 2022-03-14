package lab12_sort;

import tools.Chrono;

public class SortApplication {
    public static void main(String[] args) {
        long[][][] selection = new long[3][451][10];
        long[][][] bubble = new long[3][451][10];
        long[][][] yShort = new long[3][451][10];
        long[][][] fusion = new long[3][451][10];

        for (int iValue = 450; iValue >= 0; iValue--) {
            int value = iValue*200 + 10000;
            //int value = iValue*10 + 100;
            Chrono valueChrono = new Chrono();
            long sortTime = 0;

            for (int iAttempt = 0; iAttempt < 10; iAttempt++) {
                for (int iTable = 0; iTable < 3; iTable++){
                    int[] arrayIN;
                    switch (iTable) {
                        case 0:
                            arrayIN = ArrayFactory.createRandomArray(value, value);
                            break;
                        case 1:
                            arrayIN = ArrayFactory.createInvertedSortedArray(value);
                            break;
                        case 2:
                            arrayIN = ArrayFactory.createShuffleArray(value);
                            break;
                    
                        default:
                            arrayIN = null;
                            break;
                    }
                    Chrono sort = new Chrono();

                    Chrono selectionChrono = new Chrono();
                    SelectionSort.sort(arrayIN);
                    selection[iTable][iValue][iAttempt] = selectionChrono.stop();

                    Chrono bubbleChrono = new Chrono();
                    BubbleSort.sort(arrayIN);
                    bubble[iTable][iValue][iAttempt] = bubbleChrono.stop();

                    Chrono yShortChrono = new Chrono();
                    YSort.sort(arrayIN);
                    yShort[iTable][iValue][iAttempt] = yShortChrono.stop();

                    Chrono fusionChrono = new Chrono();
                    FusionSort.sort(arrayIN);
                    fusion[iTable][iValue][iAttempt] = fusionChrono.stop();

                    sortTime = sort.stop();
                }
            }

            long[][] selectionAverage = new long[3][451];
            long[][] bubbleAverage = new long[3][451];
            long[][] yShortAverage = new long[3][451];
            long[][] fusionAverage = new long[3][451];

            for(int iTable = 0; iTable < 3; iTable++){
                for(int j = 0; j < 10; j++){
                    selectionAverage[iTable][iValue] += selection[iTable][iValue][j];
                    bubbleAverage[iTable][iValue] += bubble[iTable][iValue][j];
                    yShortAverage[iTable][iValue] += yShort[iTable][iValue][j];
                    fusionAverage[iTable][iValue] += fusion[iTable][iValue][j];
                }
                selectionAverage[iTable][iValue] /= 10.0;
                bubbleAverage[iTable][iValue] /= 10.0;
                yShortAverage[iTable][iValue] /= 10.0;
                fusionAverage[iTable][iValue] /= 10.0;

                print(value, iTable, "Selection", selectionAverage[iTable][iValue]);
                print(value, iTable, "Bubble   ", bubbleAverage[iTable][iValue]);
                print(value, iTable, "YShort   ", yShortAverage[iTable][iValue]);
                print(value, iTable, "Fusion   ", fusionAverage[iTable][iValue]);
                System.out.println("");
            }
            System.out.println("Total time for sort " + value + ": " + sortTime/1000000.0 + " s");
            System.out.println("Total time for " + value + ": " + valueChrono.stop()/1000000.0 + " s");
            System.out.println("---------- ---------- ----------\n");
        }
    }

    static void print(int value, int iTable, String name, long average){
        System.out.print(name + "");
        System.out.print("\tTable: " + iTable + " | Value: " + value);
        System.out.print(" -> [us] " + average);
        System.out.print("\n");
    }

    static  void  displayArray(int[]  array){
        int size = array.length;
        String s = "Size ";
        s += size;
        s += ": {";
        for (int i = 0; i < array.length-1; i++) {
            s += array[i];
            s += ", ";
        }
        s += array[size-1];
        s += "}";
        System.out.println(s);
    }
}
