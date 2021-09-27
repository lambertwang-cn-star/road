package com.banlv.road.data.structure.BPlus;

import lombok.Data;

import java.util.Vector;

/**
 * @author ：Lambert Wang
 * @date ：Created in 2021/3/17 9:17
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
@Data
public class BPlusTreeNode {
    static int m;
    Vector<Integer> keywords;//区间
    Vector<BPlusTreeNode> children;//保存子节点指针
}
