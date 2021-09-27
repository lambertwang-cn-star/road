package com.banlv.road.data.structure;

/**
 * @author ：Lambert Wang
 * @date ：Created in 2021/4/1 11:13
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
public class DataCreate {
    public static int[] create(int size) {
        int[] initInt = new int[size];
        for (int i = 0; i < size; i++) {
            initInt[i] = i + 1;
        }
        return initInt;
    }

    public static int[][] create(int colSize, int columnSize) {
        int[][] initInt = new int[colSize][columnSize];
        int init = 1;
        for (int i = 0; i < colSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                initInt[i][j] = init;
                init++;
            }
        }
        return initInt;
    }

    public static int[] arangeData(int[] init) {
        int dataSize = init.length;
        for (int i = 0; i < dataSize; i++) {
            int temp = init[i];
            if (i < dataSize - 3) {
                init[i] = init[i + 3];
                init[i + 3] = temp;
            } else {
                init[i] = init[dataSize - i + 3];
                init[dataSize - i + 3] = temp;
            }
        }
        return init;
    }

    public static int[][] arangeData(int[][] init) {
        int dataSize = init.length;
        for (int i = 0; i < dataSize; i++) {
            int[] initArray = init[i];
            int arraySize = initArray.length;
            for (int j = 0; j < arraySize; j++) {
                int temp = init[i][j];
                if (j < arraySize - 3) {
                    init[i][j] = init[i][j + 3];
                    init[i][j + 3] = temp;
                } else {
                    init[i][j] = init[i][arraySize - j + 3];
                    init[i][arraySize - j + 3] = temp;
                }
            }
        }
        return init;
    }

    public static void print(int[][] init) {
        int dataSize = init.length;
        for (int i = 0; i < dataSize; i++) {
            int[] initArray = init[i];
            int arraySize = initArray.length;
            for (int j = 0; j < arraySize; j++) {
                System.out.print(init[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public static void print(int[] init) {
        for (int i = 0; i < 100; i++) {
            System.out.print(init[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] initInt = create(100);
        System.out.println("Begin data is");
        print(initInt);
        initInt = arangeData(initInt);
        System.out.println("\nAfter data is");
        print(initInt);
//        int[][] initInt = create(10, 10);
//        System.out.println("The start data is:");
//        print(initInt);
//        arangeData(initInt);
//        System.out.println("The end data is:");
//        print(initInt);
    }
}
