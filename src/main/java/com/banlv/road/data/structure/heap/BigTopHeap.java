package com.banlv.road.data.structure.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：Lambert Wang
 * @date ：Created in 2021/5/20 16:10
 * @description：大顶堆的运行
 * @modified By：
 * @version: 1.0.0
 */
public class BigTopHeap {
    private int[] a;
    // 总的存储个数
    private int n;
    // 已有个数
    private int count;

    private List<Byte> telephons;

    private byte[] tby;

    public BigTopHeap(int capacity) {
        a = new int[capacity+1];
        n = capacity;
        a[0] = 0;
        count = 0;
        telephons = new ArrayList<>();
        telephons.add(new Byte("0"));
//        tby[0] = 2;
    }

    public void insert(int data) {
        if(count >= n) {
            return;
        }
        ++count;
        a[count] = data;
        int i = count;
        if(count > 1 && count %2 == 1 && (a[count] < a[count -1])) {
            compact(count -1, count);
            i = count - 1;
        }
        while(a[i] > a[i/2] && i/2 >= 0 && i/2 > 0) {
            compact(i, i/2);
            i = i/2;
        }
    }

    public void compact(int t, int m) {
        int temp = a[t];
        a[t] = a[m];
        a[m] = temp;
    }

    public static void main(String[] args) {
        BigTopHeap heap = new BigTopHeap(20);
        heap.insert(3);
        heap.insert(6);
        heap.insert(8);
        heap.insert(10);
        heap.insert(1);
        heap.insert(9);
        heap.insert(5);
        heap.insert(20);
        heap.insert(18);
        heap.insert(30);
        heap.insert(15);
        System.out.print(Arrays.toString(heap.a));
    }
}
