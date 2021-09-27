package com.banlv.road.data.structure.BPlus;

import java.util.*;

/**
 * @author ：Lambert Wang
 * @Date ：Created in 2021/3/17 14:22
 * @Description：
 * @Modified By：
 * @Version: 1.0.0
 */
public class Btree {
    private static final String NODE = "NODE";
    static final String INT = "INT";
    private static final String PRENODE = "PRENODE";
    private static final String NEXTNODE = "NEXTNODE";
    //B+树的阶数
    private int rank;
    //根节点
    private BNode root;
    //头结点
    private BNode head;

    Btree(int rank) {
        this.rank = rank;
    }

    public BNode getRoot() {
        return root;
    }

    public void insert(KeyAndValue entry) {
        List<KeyAndValue> keyAndValues1 = new ArrayList<>();
        //插入第一个节点
        if (head == null) {
            keyAndValues1.add(entry);
            head = new BNode(null, keyAndValues1, null, null, null);
            root = new BNode(null, keyAndValues1, null, null, null);
        } else {
            BNode node = head;
            //遍历链表，找到插入键值对对应的节点
            while (node != null) {
                List<KeyAndValue> keyAndValues = node.getKeyAndValue();
                int exitFlag = 0;
                //如果插入的键的值和当前节点键值对集合中的某个键的值相等，则直接替换value
                for (KeyAndValue KV : keyAndValues) {
                    if (KV.getKey() == entry.getKey()) {
                        KV.setValue(entry.getValue());
                        exitFlag = 1;
                        break;
                    }
                }
                //如果插入的键已经有了，则退出循环
                if (exitFlag == 1) {
                    break;
                }
                //如果当前节点是最后一个节点或者要插入的键值对的键的值小于下一个节点的键的最小值，则直接插入当前节点
                if (node.getNextNode() == null || node.getNextNode().getKeyAndValue().get(0).getKey() >= entry.getKey()) {
                    splidNode(node, entry);
                    break;
                }
                //移动指针
                node = node.getNextNode();
            }
        }
    }


    //判断是否需要拆分节点
    private void splidNode(BNode node, KeyAndValue addkeyAndValue) {
        List<KeyAndValue> keyAndValues = node.getKeyAndValue();

        if (keyAndValues.size() == rank - 1) {
            //先插入待添加的节点
            keyAndValues.add(addkeyAndValue);
            Collections.sort(keyAndValues);
            //取出当前节点的键值对集合
            //取出原来的key-value集合中间位置的下标
            int mid = keyAndValues.size() / 2;
            //取出原来的key-value集合中间位置的键
            int midKey = keyAndValues.get(mid).getKey();
            //构造一个新的键值对，不是叶子节点的节点不存储value的信息
            KeyAndValue midKeyAndValue = new KeyAndValue(midKey, "");
            //将中间位置左边的键值对封装成集合对象
            List<KeyAndValue> leftKeyAndValues = new ArrayList<>();
            for (int i = 0; i < mid; i++) {
                leftKeyAndValues.add(keyAndValues.get(i));
            }
            //将中间位置右边边的键值对封装成集合对象
            List<KeyAndValue> rightKeyAndValues = new ArrayList<>();
            //如果是叶子节点则在原节点中保留上移的key-value，否则原节点删除上移的key-value
            int k;
            if (node.isLeaf()) {
                k = mid;
            } else {
                k = mid + 1;
            }
            for (int i = k; i < rank; i++) {
                rightKeyAndValues.add(keyAndValues.get(i));
            }
            //对左右两边的元素重排序
            Collections.sort(leftKeyAndValues);
            Collections.sort(rightKeyAndValues);
            //以mid为界限将当前节点分列成两个节点，维护前指针和后指针
            BNode rightNode;
            BNode leftNode;
//            if (node.isLeaf()) {
            //如果是叶子节点维护前后指针
            rightNode = new BNode(null, rightKeyAndValues, node.getNextNode(), null, node.getParantNode());
            leftNode = new BNode(null, leftKeyAndValues, rightNode, node.getPreviousNode(), node.getParantNode());
            rightNode.setPreviousNode(leftNode);
//            } else {
//                //如果不是叶子不维护前后指针
//                rightNode = new Node(null, rightKeyAndValues, null, null, node.getParantNode());
//                leftNode = new Node(null, leftKeyAndValues, null, null, node.getParantNode());
//            }
            //如果当前分裂的节点有孩子节点,设置分裂后节点和孩子节点的关系
            if (node.getNodes() != null) {
                //取得所有地孩子节点
                List<BNode> nodes = node.getNodes();
                List<BNode> leftNodes = new ArrayList<>();
                List<BNode> rightNodes = new ArrayList<>();
                for (BNode childNode : nodes) {
                    //取得当前孩子节点的最大键值
                    int max = childNode.getKeyAndValue().get(childNode.getKeyAndValue().size() - 1).getKey();
                    if (max < midKeyAndValue.getKey()) {
                        //小于mid处的键的数是左节点的子节点
                        leftNodes.add(childNode);
                        childNode.setParantNode(leftNode);
                    } else {
                        //大于mid处的键的数是右节点的子节点
                        rightNodes.add(childNode);
                        childNode.setParantNode(rightNode);
                    }
                }
                leftNode.setNodes(leftNodes);
                rightNode.setNodes(rightNodes);
            }

            //当前节点的前节点
            BNode preNode = node.getPreviousNode();
            //分裂节点后将分裂节点的前节点的后节点设置为左节点
            if (preNode != null) {
                preNode.setNextNode(leftNode);
            }

            //当前节点的后节点
            BNode nextNode = node.getNextNode();
            //分裂节点后将分裂节点的后节点的前节点设置为右节点
            if (nextNode != null) {
                nextNode.setPreviousNode(rightNode);
            }

            //如果由头结点分裂，则分裂后左边的节点为头节点
            if (node == head) {
                head = leftNode;
            }

            //父节点的子节点
            List<BNode> childNodes = new ArrayList<>();
            childNodes.add(rightNode);
            childNodes.add(leftNode);
            //分裂
            //当前节点无父节点
            if (node.getParantNode() == null) {
                //父节点的键值对
                List<KeyAndValue> parentKeyAndValues = new ArrayList<>();
                parentKeyAndValues.add(midKeyAndValue);
                //构造父节点
                BNode parentNode = new BNode(childNodes, parentKeyAndValues, null, null, null);
                //将子节点与父节点关联
                rightNode.setParantNode(parentNode);
                leftNode.setParantNode(parentNode);
                //当前节点为根节点
                root = parentNode;
            } else {
                BNode parentNode = node.getParantNode();
                //将原来的孩子节点（除了被拆分的节点）和新的孩子节点（左孩子和右孩子）合并之后与父节点关联
                childNodes.addAll(parentNode.getNodes());
                //移除正在被拆分的节点
                childNodes.remove(node);
                //将子节点与父节点关联
                parentNode.setNodes(childNodes);
                rightNode.setParantNode(parentNode);
                leftNode.setParantNode(parentNode);
                if (parentNode.getParantNode() == null) {
                    root = parentNode;
                }
                //当前节点有父节点,递归调用拆分的方法,将父节点拆分
                splidNode(parentNode, midKeyAndValue);
            }
        } else {
            keyAndValues.add(addkeyAndValue);
            //排序
            Collections.sort(keyAndValues);
        }
    }


    //打印B+树
    void printBtree(BNode root) {
        if (root == this.root) {
            //打印根节点内的元素
            printNode(root);
            System.out.println();
        }
        if (root == null) {
            return;
        }

        //打印子节点的元素
        if (root.getNodes() != null) {
            //找到最左边的节点
            BNode leftNode = null;
            BNode tmpNode = null;
            List<BNode> childNodes = root.getNodes();
            for (BNode node : childNodes) {
                if (node.getPreviousNode() == null) {
                    leftNode = node;
                    tmpNode = node;
                }
            }

            while (leftNode != null) {
                //从最左边的节点向右打印
                printNode(leftNode);
                System.out.print("|");
                leftNode = leftNode.getNextNode();
            }
            System.out.println();
            printBtree(tmpNode);
        }
    }

    //打印一个节点内的元素
    private void printNode(BNode node) {
        List<KeyAndValue> keyAndValues = node.getKeyAndValue();
        for (int i = 0; i < keyAndValues.size(); i++) {
            if (i != (keyAndValues.size() - 1)) {
                System.out.print(keyAndValues.get(i).getKey() + ",");
            } else {
                System.out.print(keyAndValues.get(i).getKey());
            }
        }
    }

    public Object search(int key, BNode node, String mode) {

        //如果是叶子节点则直接取值
        if (node.isLeaf()) {
            List<KeyAndValue> keyAndValues = node.getKeyAndValue();
            for (KeyAndValue keyAndValue : keyAndValues) {
                if (keyAndValue.getKey() == key) {
                    switch (mode) {
                        case NODE:
                            return node;
                        case INT:
                            return keyAndValue.getValue();
                    }
                }
            }
            return null;
        }


        List<BNode> nodes = node.getNodes();
        //如果寻找的key小于节点的键的最小值
        int minKey = node.getKeyAndValue().get(0).getKey();
        if (key < minKey) {
            for (BNode n : nodes) {
                List<KeyAndValue> keyAndValues = n.getKeyAndValue();
                //找到子节点集合中最大键小于父节点最小键节点
                if (keyAndValues.get(keyAndValues.size() - 1).getKey() < minKey) {
                    return search(key, n, mode);
                }
            }
        }
        //如果寻找的key大于节点的键的最大值
        int maxKey = getMaxKeyInNode(node);
        if (key >= maxKey) {
            for (BNode n : nodes) {
                List<KeyAndValue> keyAndValues = n.getKeyAndValue();
                //找到子节点集合中最小键大于等于父节点最小大键节点
                if (keyAndValues.get(0).getKey() >= maxKey) {
                    return search(key, n, mode);
                }
            }
        }

        //如果寻找的key在最大值和最小值之间，首先定位到最窄的区间
        int min = getLeftBoundOfKey(node, key);
        int max = getRightBoundOfKey(node, key);


        //去所有的子节点中找键的范围在min和max之间的节点
        for (BNode n : nodes) {
            List<KeyAndValue> kvs = n.getKeyAndValue();
            //找到子节点集合中键的范围在min和max之间的节点
            if (kvs.get(0).getKey() >= min && kvs.get(kvs.size() - 1).getKey() < max) {
                return search(key, n, mode);
            }
        }
        return null;
    }


    public boolean delete(int key) {
        System.out.println("delete:" + key);
        System.out.println();

        //首先找到要删除的key所在的节点
        BNode deleteNode = (BNode) search(key, root, NODE);
        //如果没找到则删除失败
        if (deleteNode == null) {
            return false;
        }

        if (deleteNode == root) {
            delKeyAndValue(root.getKeyAndValue(), key);
            return true;
        }

        if (deleteNode == head && isNeedMerge(head)) {
            head = head.getNextNode();
        }

        return merge(deleteNode, key);
    }


    //平衡当前节点和前节点或者后节点的数量，使两者的数量都满足条件
    private boolean balanceNode(BNode node, BNode bratherNode, String nodeType) {
        if (bratherNode == null) {
            return false;
        }
        List<KeyAndValue> delKeyAndValues = node.getKeyAndValue();
        if (isMoreElement(bratherNode)) {
            List<KeyAndValue> bratherKeyAndValues = bratherNode.getKeyAndValue();
            int bratherSize = bratherKeyAndValues.size();
            //兄弟节点删除挪走的键值对
            KeyAndValue keyAndValue = null;
            KeyAndValue keyAndValue1;
            switch (nodeType) {
                case PRENODE:
                    keyAndValue = bratherKeyAndValues.remove(bratherSize - 1);
                    keyAndValue1 = getKeyAndValueinMinAndMax(node.getParantNode(), keyAndValue.getKey(), getMinKeyInNode(node));
                    keyAndValue1.setKey(keyAndValue.getKey());
                    break;
                case NEXTNODE:
                    keyAndValue = bratherKeyAndValues.remove(0);
                    keyAndValue1 = getKeyAndValueinMinAndMax(node.getParantNode(), getMaxKeyInNode(node), keyAndValue.getKey());
                    keyAndValue1.setKey(bratherKeyAndValues.get(0).getKey());
                    break;
            }
            //当前节点添加从前一个节点得来的键值对
            delKeyAndValues.add(keyAndValue);

            //对键值对重排序
            Collections.sort(delKeyAndValues);
            return true;
        }
        return false;
    }

    public boolean merge(BNode node, int key) {
        List<KeyAndValue> delKeyAndValues = node.getKeyAndValue();
        //首先删除该key-vaule
        delKeyAndValue(delKeyAndValues, key);
        //如果要删除的节点的键值对的数目小于节点最大键值对数目*填充因子
        if (isNeedMerge(node)) {
            Boolean isBalance;
            //如果左节点有富余的键值对，则取一个到当前节点
            BNode preNode = getPreviousNode(node);
            isBalance = balanceNode(node, preNode, PRENODE);
            //如果此时已经平衡，则已经删除成功
            if (isBalance) return true;

            //如果右兄弟节点有富余的键值对，则取一个到当前节点
            BNode nextNode = getNextNode(node);
            isBalance = balanceNode(node, nextNode, NEXTNODE);

            return isBalance || mergeNode(node, key);
        } else {
            return true;
        }
    }

    //合并节点
    //key 待删除的key
    private boolean mergeNode(BNode node, int key) {
        if (node.isRoot()) {
            return false;
        }
        BNode preNode;
        BNode nextNode;
        BNode parentNode = node.getParantNode();
        List<BNode> childNodes = parentNode.getNodes();
        List<BNode> childNodes1 = node.getNodes();
        List<KeyAndValue> parentKeyAndValue = parentNode.getKeyAndValue();
        List<KeyAndValue> keyAndValues = node.getKeyAndValue();

        if (node.isLeaf()) {
            if (parentKeyAndValue.size() == 1 && parentNode != root) {
                return true;
            }
            preNode = getPreviousNode(node);
            nextNode = getNextNode(node);
            if (preNode != null) {
                List<KeyAndValue> preKeyAndValues = preNode.getKeyAndValue();
                keyAndValues.addAll(preKeyAndValues);
                if (preNode.isHead()) {
                    head = node;
                    node.setPreviousNode(null);
                } else {
                    preNode.getPreviousNode().setNextNode(node);
                    node.setPreviousNode(preNode.getPreviousNode());
                }
                //将合并后节点的后节点设置为当前节点的后节点
                preNode.setNextNode(node.getNextNode());
                KeyAndValue keyAndValue = getKeyAndValueinMinAndMax(parentNode, getMinKeyInNode(preNode), key);
                delKeyAndValue(parentKeyAndValue, keyAndValue.getKey());
                if (parentKeyAndValue.isEmpty()) {
                    root = node;
                } else {
                    //删除当前节点
                    childNodes.remove(preNode);
                }
                Collections.sort(keyAndValues);
                merge(parentNode, key);
                return true;
            }

            if (nextNode != null) {
                List<KeyAndValue> nextKeyAndValues = nextNode.getKeyAndValue();
                keyAndValues.addAll(nextKeyAndValues);
                if (nextNode.isTail()) {
                    node.setPreviousNode(null);
                } else {
                    nextNode.getNextNode().setPreviousNode(node);
                    node.setNextNode(nextNode.getNextNode());
                }

                KeyAndValue keyAndValue = getKeyAndValueinMinAndMax(parentNode, key, getMinKeyInNode(nextNode));
                delKeyAndValue(parentKeyAndValue, keyAndValue.getKey());
                if (parentKeyAndValue.isEmpty()) {
                    root = node;
                    node.setParantNode(null);
                } else {
                    //删除当前节点
                    childNodes.remove(nextNode);
                }
                Collections.sort(keyAndValues);
                merge(parentNode, key);
                return true;
            }
            //前节点和后节点都等于null那么是root节点
            return false;
        } else {
            preNode = getPreviousNode(node);
            nextNode = getNextNode(node);
            if (preNode != null) {
                //将前一个节点和当前节点还有父节点中的相应Key-value合并
                List<KeyAndValue> preKeyAndValues = preNode.getKeyAndValue();
                preKeyAndValues.addAll(keyAndValues);
                int min = getMaxKeyInNode(preNode);
                int max = getMinKeyInNode(node);
                //父节点中移除这个key-value
                KeyAndValue keyAndValue = getKeyAndValueinMinAndMax(parentNode, min, max);
                parentKeyAndValue.remove(keyAndValue);
                if (parentKeyAndValue.isEmpty()) {
                    root = preNode;
                    node.setParantNode(null);
                    preNode.setParantNode(null);
                } else {
                    childNodes.remove(node);
                }
                assert nextNode != null;
                preNode.setNextNode(nextNode.getNextNode());
                //前节点加上一个当前节点的所有子节点中最小key的key-value
                KeyAndValue minKeyAndValue = getMinKeyAndValueInChildNode(node);
                assert minKeyAndValue != null;
                KeyAndValue keyAndValue1 = new KeyAndValue(minKeyAndValue.getKey(), minKeyAndValue.getValue());
                preKeyAndValues.add(keyAndValue1);
                List<BNode> preChildNodes = preNode.getNodes();
                preChildNodes.addAll(node.getNodes());
                //将当前节点的孩子节点的父节点设为当前节点的后节点
                for (BNode node1 : childNodes1) {
                    node1.setParantNode(preNode);
                }
                Collections.sort(preKeyAndValues);
                merge(parentNode, key);
                return true;
            }

            if (nextNode != null) {
                //将后一个节点和当前节点还有父节点中的相应Key-value合并
                List<KeyAndValue> nextKeyAndValues = nextNode.getKeyAndValue();
                nextKeyAndValues.addAll(keyAndValues);

                int min = getMaxKeyInNode(node);
                int max = getMinKeyInNode(nextNode);
                //父节点中移除这个key-value
                KeyAndValue keyAndValue = getKeyAndValueinMinAndMax(parentNode, min, max);
                parentKeyAndValue.remove(keyAndValue);
                childNodes.remove(node);
                if (parentKeyAndValue.isEmpty()) {
                    root = nextNode;
                    nextNode.setParantNode(null);
                } else {
                    childNodes.remove(node);
                }
                nextNode.setPreviousNode(node.getPreviousNode());
                //后节点加上一个当后节点的所有子节点中最小key的key-value
                KeyAndValue minKeyAndValue = getMinKeyAndValueInChildNode(nextNode);
                assert minKeyAndValue != null;
                KeyAndValue keyAndValue1 = new KeyAndValue(minKeyAndValue.getKey(), minKeyAndValue.getValue());
                nextKeyAndValues.add(keyAndValue1);
                List<BNode> nextChildNodes = nextNode.getNodes();
                nextChildNodes.addAll(node.getNodes());
                //将当前节点的孩子节点的父节点设为当前节点的后节点
                for (BNode node1 : childNodes1) {
                    node1.setParantNode(nextNode);
                }
                Collections.sort(nextKeyAndValues);
                merge(parentNode, key);
                return true;
            }
            return false;
        }
    }

    //得到当前节点的前节点
    private BNode getPreviousNode(BNode node) {
        if (node.isRoot()) {
            return null;
        }

        BNode parentNode = node.getParantNode();
        //得到兄弟节点
        List<BNode> nodes = parentNode.getNodes();
        List<KeyAndValue> keyAndValues = new ArrayList<>();
        for (BNode n : nodes) {
            List<KeyAndValue> list = n.getKeyAndValue();
            int maxKeyAndValue = list.get(list.size() - 1).getKey();
            if (maxKeyAndValue < getMinKeyInNode(node)) {
                keyAndValues.add(new KeyAndValue(maxKeyAndValue, n));
            }
        }
        Collections.sort(keyAndValues);
        if (keyAndValues.isEmpty()) {
            return null;
        }
        return (BNode) keyAndValues.get(keyAndValues.size() - 1).getValue();
    }


    //得到当前节点的后节点
    private BNode getNextNode(BNode node) {
        if (node.isRoot()) {
            return null;
        }

        BNode parentNode = node.getParantNode();
        //得到兄弟节点
        List<BNode> nodes = parentNode.getNodes();
        List<KeyAndValue> keyAndValues = new ArrayList<>();
        for (BNode n : nodes) {
            List<KeyAndValue> list = n.getKeyAndValue();
            int minKeyAndValue = list.get(0).getKey();
            if (minKeyAndValue > getMaxKeyInNode(node)) {
                keyAndValues.add(new KeyAndValue(minKeyAndValue, n));
            }
        }
        Collections.sort(keyAndValues);
        if (keyAndValues.isEmpty()) {
            return null;
        }
        return (BNode) keyAndValues.get(0).getValue();
    }


    private int getMinKeyInNode(BNode node) {
        List<KeyAndValue> keyAndValues = node.getKeyAndValue();
        return keyAndValues.get(0).getKey();
    }

    private int getMaxKeyInNode(BNode node) {
        List<KeyAndValue> keyAndValues = node.getKeyAndValue();
        return keyAndValues.get(keyAndValues.size() - 1).getKey();
    }


    private int getLeftBoundOfKey(BNode node, int key) {
        int left = 0;
        List<KeyAndValue> keyAndValues = node.getKeyAndValue();
        for (int i = 0; i < keyAndValues.size(); i++) {
            if (keyAndValues.get(i).getKey() <= key && keyAndValues.get(i + 1).getKey() > key) {
                left = keyAndValues.get(i).getKey();
                break;
            }
        }
        return left;
    }

    private int getRightBoundOfKey(BNode node, int key) {
        int right = 0;
        List<KeyAndValue> keyAndValues = node.getKeyAndValue();
        for (int i = 0; i < keyAndValues.size(); i++) {
            if (keyAndValues.get(i).getKey() <= key && keyAndValues.get(i + 1).getKey() > key) {
                right = keyAndValues.get(i + 1).getKey();
                break;
            }
        }
        return right;
    }


    private void delKeyAndValue(List<KeyAndValue> keyAndValues, int key) {
        for (KeyAndValue keyAndValue : keyAndValues) {
            if (keyAndValue.getKey() == key) {
                keyAndValues.remove(keyAndValue);
                break;
            }
        }
    }

    //找到node的键值对中在min和max中的键值对
    private KeyAndValue getKeyAndValueinMinAndMax(BNode node, int min, int max) {
        if (node == null) {
            return null;
        }
        List<KeyAndValue> keyAndValues = node.getKeyAndValue();
        KeyAndValue keyAndValue = null;
        for (KeyAndValue k : keyAndValues) {
            if (k.getKey() > min && k.getKey() <= max) {
                keyAndValue = k;
                break;
            }
        }
        return keyAndValue;
    }

//    private KeyAndValue getMaxKeyAndValueInChildNode(BNode node) {
//        if (node.getNodes() == null || node.getNodes().isEmpty()) {
//            return null;
//        }
//        List<KeyAndValue> sortKeyAndValues = new ArrayList<>();
//        List<BNode> childNodes = node.getNodes();
//        for (BNode childNode : childNodes) {
//            List<KeyAndValue> keyAndValues = childNode.getKeyAndValue();
//            KeyAndValue maxKeyAndValue = keyAndValues.get(keyAndValues.size() - 1);
//            sortKeyAndValues.add(maxKeyAndValue);
//        }
//        Collections.sort(sortKeyAndValues);
//        return sortKeyAndValues.get(sortKeyAndValues.size() - 1);
//    }

    private KeyAndValue getMinKeyAndValueInChildNode(BNode node) {
        if (node.getNodes() == null || node.getNodes().isEmpty()) {
            return null;
        }
        List<KeyAndValue> sortKeyAndValues = new ArrayList<>();
        List<BNode> childNodes = node.getNodes();
        for (BNode childNode : childNodes) {
            List<KeyAndValue> keyAndValues = childNode.getKeyAndValue();
            KeyAndValue minKeyAndValue = keyAndValues.get(0);
            sortKeyAndValues.add(minKeyAndValue);
        }
        Collections.sort(sortKeyAndValues);
        return sortKeyAndValues.get(0);
    }

    private boolean isNeedMerge(BNode node) {
        if (node == null) {
            return false;
        }
        List<KeyAndValue> keyAndValues = node.getKeyAndValue();
        return keyAndValues.size() < rank / 2;
    }

    //判断一个节点是否有富余的键值对
    private boolean isMoreElement(BNode node) {
        return node != null && (node.getKeyAndValue().size() > rank / 2);
    }

    public static void main(String[] args) {
        Btree btree = new Btree(4 );
        KeyAndValue keyAndValue = new KeyAndValue(1,"123");
        KeyAndValue keyAndValue1 = new KeyAndValue(2,"123");
        KeyAndValue keyAndValue2 = new KeyAndValue(3,"123");
        KeyAndValue keyAndValue3 = new KeyAndValue(4,"123");
        KeyAndValue keyAndValue4 = new KeyAndValue(5,"123");
        KeyAndValue keyAndValue5 = new KeyAndValue(6,"123");
        KeyAndValue keyAndValue6 = new KeyAndValue(7,"12300");
        KeyAndValue keyAndValue7 = new KeyAndValue(8,"546");
        KeyAndValue keyAndValue8 = new KeyAndValue(9,"123");
        KeyAndValue keyAndValue9 = new KeyAndValue(10,"123");
        KeyAndValue keyAndValue10 = new KeyAndValue(11,"123");
        KeyAndValue keyAndValue11 = new KeyAndValue(12,"123");
        KeyAndValue keyAndValue12 = new KeyAndValue(13,"123");
        KeyAndValue keyAndValue14 = new KeyAndValue(15,"12345");
        KeyAndValue keyAndValue15 = new KeyAndValue(16,"12345");
        KeyAndValue keyAndValue16 = new KeyAndValue(17,"12345");
        KeyAndValue keyAndValue17 = new KeyAndValue(18,"12345");
        KeyAndValue keyAndValue18 = new KeyAndValue(19,"12345");
        KeyAndValue keyAndValue19 = new KeyAndValue(20,"12345");
        KeyAndValue keyAndValue20 = new KeyAndValue(21,"12345");

        btree.insert(keyAndValue);
        btree.insert(keyAndValue5);
        btree.insert(keyAndValue9);
        btree.insert(keyAndValue1);
        btree.insert(keyAndValue7);
        btree.insert(keyAndValue10);
        btree.insert(keyAndValue17);
        btree.insert(keyAndValue2);
        btree.insert(keyAndValue14);
        btree.insert(keyAndValue16);
        btree.insert(keyAndValue11);
        btree.insert(keyAndValue12);
        btree.insert(keyAndValue3);
        btree.insert(keyAndValue8);
        btree.insert(keyAndValue18);
        btree.insert(keyAndValue15);
        btree.insert(keyAndValue4);
        btree.insert(keyAndValue19);
        btree.insert(keyAndValue6);
        btree.insert(keyAndValue20);


        btree.printBtree(btree.getRoot());

        btree.delete(1);
        btree.printBtree(btree.getRoot());

        btree.delete(0);
        btree.printBtree(btree.getRoot());

        btree.delete(2);
        btree.printBtree(btree.getRoot());

        btree.delete(11);
        btree.printBtree(btree.getRoot());

        btree.delete(3);
        btree.printBtree(btree.getRoot());

        btree.delete(4);
        btree.printBtree(btree.getRoot());

        btree.delete(5);
        btree.printBtree(btree.getRoot());

        btree.delete(9);
        btree.printBtree(btree.getRoot());

        btree.delete(6);
        btree.printBtree(btree.getRoot());

        btree.delete(13);
        btree.printBtree(btree.getRoot());

        btree.delete(7);
        btree.printBtree(btree.getRoot());

        btree.delete(10);
        btree.printBtree(btree.getRoot());

        btree.delete(18);
        btree.printBtree(btree.getRoot());

        btree.delete(8);
        btree.printBtree(btree.getRoot());

        btree.delete(12);
        btree.printBtree(btree.getRoot());

        btree.delete(20);
        btree.printBtree(btree.getRoot());

        btree.delete(19);
        btree.printBtree(btree.getRoot());

        btree.delete(15);
        btree.printBtree(btree.getRoot());

        btree.delete(17);
        btree.printBtree(btree.getRoot());
    }
}
