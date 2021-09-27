package com.banlv.road.data.structure.BPlus;

import lombok.Data;

import java.util.Vector;

/**
 * @author ：Lambert Wang
 * @date ：Created in 2021/3/17 9:20
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
@Data
public class BPlusTreeLeafNode {
    static int k;
    Vector<Integer> keywords;//数据的键值
    Vector<Integer> dataAddress; //数据地址
    BPlusTreeLeafNode pre;//前驱节点
    BPlusTreeLeafNode next;//后记节点
}
