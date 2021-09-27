package com.banlv.road.data.structure.BPlus;

/**
 * @author ：Lambert Wang
 * @date ：Created in 2021/3/17 9:51
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
public class BPlusTreeManager {
    BPlusTreeNode bPlusTreeNode = null;

//    public BPlusTreeManager(BPlusTreeNode bPlusTreeNode) {
//        this.bPlusTreeNode = bPlusTreeNode;
//    }

    /**
     * 计算M叉数的最大值
     *
     * @param childSize   子节点的数量
     * @param keywordSize 键的数量
     * @return
     */
    public int getMaxNodes(int childSize, int keywordSize) {
        int maxNodes = 0;
        int pageSize = 4048;
        int predicateSize = 0;
        int maxPageSize = 0;
        while (maxNodes <= 20000 && predicateSize <= maxPageSize) {
            maxNodes++;
            maxPageSize = pageSize + maxNodes * keywordSize;
            int maxChildSize = maxNodes * 8 * childSize;
            int maxKeySize = 4 * maxNodes * keywordSize;
            predicateSize = maxKeySize + maxChildSize;
        }
        return maxNodes;
    }

    public int getMaxLeafNode(int keywordSize, int dataAddSize) {
        int maxLeafs = 0;
        int pageSize = 4048;
        int predicateSize = 0;
        while (maxLeafs <= 20000 && predicateSize <= pageSize) {
            maxLeafs++;
            int maxChildSize = maxLeafs * 8 * dataAddSize;
            int maxKeySize = 4 * maxLeafs * keywordSize;
            int preNext = (4 + 4 * keywordSize + 8 * dataAddSize) * 2;
            predicateSize = maxKeySize + maxChildSize + preNext;
        }
        return maxLeafs;
    }

    public void addLeafNode(int addData) {
        if (this.bPlusTreeNode == null) {
            BPlusTreeNode bPlusTreeNode = new BPlusTreeNode();
            bPlusTreeNode.children.add(bPlusTreeNode);
        }
    }

    public static void main(String[] args) {
        BPlusTreeManager bPlusTreeManager = new BPlusTreeManager();
        int maxNodes = bPlusTreeManager.getMaxNodes(12, 5);
        int maxLeafs = bPlusTreeManager.getMaxLeafNode(10, 10);
        System.out.println("maxNodes is " + maxNodes);
        System.out.println("maxLeafs is " + maxLeafs);
    }
}
