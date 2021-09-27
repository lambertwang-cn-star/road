package com.banlv.road.data.structure.BPlus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ：Lambert Wang
 * @date ：Created in 2021/3/17 17:14
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
public class BTreeCopy {
    int level;

    public BTreeCopy(int level) {
        this.level = level;
    }

    BNode root = null;
    BNode first = null;

    public void add(KeyAndValue entry) {
        List<KeyAndValue> keyAndValueList = new ArrayList<>();
        if (root == null) {
            keyAndValueList.add(entry);
            root = new BNode(null, keyAndValueList, null, null, null);
            first = new BNode(null, keyAndValueList, null, null, null);
            return;
        }
        // 如果存在的话， 就直接不执行
        BNode node = root;
        while (node != null) {
            List<KeyAndValue> keyAndValues = node.getKeyAndValue();
            for (KeyAndValue keyAndValue : keyAndValues) {
                if (keyAndValue.getValue() == entry.getValue()) {
                    return;
                }

            }
            if (node.getNextNode() == null || node.getNextNode().getKeyAndValue().get(0).getKey() > entry.getKey()) {
                splidNode(node, entry);
            }
            node = node.getNextNode();
        }
    }

    private void splidNode(BNode node, KeyAndValue addkeyAndValue) {
        int valueSize = node.getKeyAndValue().size();
        List<KeyAndValue> keyAndValues = node.getKeyAndValue();
        if (valueSize == level) {
            //先插入待添加的节点
            keyAndValues.add(addkeyAndValue);
            Collections.sort(keyAndValues);
            List<KeyAndValue> leftKeyAndValues = new ArrayList<>();
            List<KeyAndValue> rightKeyAndValues = new ArrayList<>();
            int mid = valueSize / 2;
            int midKey = keyAndValues.get(mid).getKey();
            KeyAndValue midKeyAndValue = new KeyAndValue(midKey, "");
            for (int i = 0; i < mid; i++) {
                leftKeyAndValues.add(keyAndValues.get(i));
            }
            int k;
            if(node.isLeaf()) {
                k = mid;
            } else {
                k = mid + 1;
            }
            for (int i = k; i < keyAndValues.size(); i++) {
                rightKeyAndValues.add(keyAndValues.get(i));
            }
            //对左右两边的元素重排序
            Collections.sort(leftKeyAndValues);
            Collections.sort(rightKeyAndValues);

        } else {
            keyAndValues.add(addkeyAndValue);
            Collections.sort(keyAndValues);
        }
    }
}
