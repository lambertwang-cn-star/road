package com.banlv.road.data.structure.mergesort;

/**
 * @author ：Lambert Wang
 * @date ：Created in 2021/4/1 14:17
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
public class MergeSort {
    public void sort(int[] init) {
        mergeSort(init, 0, init.length - 1);
    }

    private void mergeSort(int[] init, int start, int end) {
        if (start >= end) {
            return;
        }
        int middle = (start + end) / 2;
        mergeSort(init, middle, end);
        mergeSort(init, start, middle);
    }



    private int[] merge(int[] leftArr, int[] rightArr) {
        int i = 0;
        int j = 0;
        int k = 0;
        int leftSize = leftArr.length;
        int rightSize = rightArr.length;
        int allSize = leftSize + rightSize;
        int[] tempArr = new int[allSize];
        while (i <= leftSize && j <= rightSize) {
            if (leftArr[i] <= rightArr[j]) {
                tempArr[k++] = leftArr[i++];
            } else {
                tempArr[k++] = rightArr[j++];
            }
        }

        int start = i;
        int end = leftSize;
        int remain = 1;
        if (j <= rightSize) {
            start = j;
            remain = 2;
            end = rightSize;
        }

        while (start <= end) {
            if (remain == 1) {
                tempArr[k++] = leftArr[start++];
            } else {
                tempArr[k++] = rightArr[start++];
            }
        }
        return tempArr;
    }
}
