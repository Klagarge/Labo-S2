package lab12_sort;

import java.io.FileOutputStream;
import java.io.PrintWriter;

import tools.Chrono;

public class SortApplication {
    public static void main(String[] args) {
        long[][][] selection = new long[3][451][10];
        long[][][] bubble = new long[3][451][10];
        long[][][] yShort = new long[3][451][10];
        long[][][] fusion = new long[3][451][10];
        //final String chemin = "./sort/"; // linux
        final String chemin = "C://tmp//sort//"; // Windows

        PrintWriter selectionWriter = null;
        PrintWriter bubbleWriter = null;
        PrintWriter yShortWriter = null;
        PrintWriter fusionWriter = null;

        try {
            FileOutputStream selectionFile = new FileOutputStream(chemin + "selection.txt", true);
            FileOutputStream bubbleFile = new FileOutputStream(chemin + "bubble.txt", true);
            FileOutputStream yShortFile = new FileOutputStream(chemin + "yShort.txt", true);
            FileOutputStream fusionFile = new FileOutputStream(chemin + "fusion.txt", true);
            selectionWriter = new PrintWriter(selectionFile);
            bubbleWriter = new PrintWriter(bubbleFile);
            yShortWriter = new PrintWriter(yShortFile);
            fusionWriter = new PrintWriter(fusionFile);
        } catch (Exception e) {
            System.out.println("File can't be create");
            e.printStackTrace();
        }

        for (int iValue = 0; iValue <= 450; iValue++) {
            int value = iValue*200 + 10000;
            //int value = iValue*10 + 100;
            Chrono valueChrono = new Chrono();

            for (int iAttempt = 0; iAttempt < 10; iAttempt++) {
                for (int iTable = 0; iTable < 3; iTable++){
                    int[] array;
                    switch (iTable) {
                        case 0:
                            array = ArrayFactory.createRandomArray(value, value);
                            break;
                        case 1:
                            array = ArrayFactory.createInvertedSortedArray(value);
                            break;
                        case 2:
                            array = ArrayFactory.createShuffleArray(value);
                            break;
                    
                        default:
                            array = null;
                            break;
                    }

                    int[] arraySelection = array.clone();
                    int[] arrayBubble = array.clone();
                    int[] arrayYSort = array.clone();
                    int[] arrayFusion = array.clone();

                    Chrono selectionChrono = new Chrono();
                    SelectionSort.sort(arraySelection);
                    selection[iTable][iValue][iAttempt] = selectionChrono.stop();

                    Chrono bubbleChrono = new Chrono();
                    BubbleSort.sort(arrayBubble);
                    bubble[iTable][iValue][iAttempt] = bubbleChrono.stop();

                    Chrono yShortChrono = new Chrono();
                    YSort.sort(arrayYSort);
                    yShort[iTable][iValue][iAttempt] = yShortChrono.stop();

                    Chrono fusionChrono = new Chrono();
                    FusionSort.sort(arrayFusion);
                    fusion[iTable][iValue][iAttempt] = fusionChrono.stop();
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
            write(selectionWriter, selectionAverage[0][iValue], selectionAverage[1][iValue], selectionAverage[2][iValue]);
            write(bubbleWriter, bubbleAverage[0][iValue], bubbleAverage[1][iValue], bubbleAverage[2][iValue]);
            write(yShortWriter, yShortAverage[0][iValue], yShortAverage[1][iValue], yShortAverage[2][iValue]);
            write(fusionWriter, fusionAverage[0][iValue], fusionAverage[1][iValue], fusionAverage[2][iValue]);
            System.out.println("Total time for " + value + ": " + valueChrono.stop()/1000000.0 + " s");
            System.out.println("---------- ---------- ----------\n");
        }

        try {
            selectionWriter.close();
            bubbleWriter.close();
            yShortWriter.close();
            fusionWriter.close();
        } catch (Exception e) {
            System.out.println("File can't be close");
            e.printStackTrace();
        }
    }

    static void print(int value, int iTable, String name, long average){
        System.out.print(name + "");
        System.out.print("\tTable: " + iTable + " | Value: " + value);
        System.out.print(" -> [us] " + average);
        System.out.print("\n");
    }

    static void write(PrintWriter writer, long averageT1, long averageT2, long averageT3){
        String s = "";
        s += averageT1;
        s += ", ";
        s += averageT2;
        s += ", ";
        s += averageT3;
        try {
            writer.println(s);
        } catch (Exception e) {
            System.out.println("File can't be written");
            e.printStackTrace();
        }
        
    }

    /*
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
    */
}
