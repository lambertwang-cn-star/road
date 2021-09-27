package com.banlv.road.data.structure.BPlus;

import java.util.*;
/**
 * @author ：Lambert Wang
 * @date ：Created in 2021/3/17 14:34
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
public class BNode {
    //节点的子节点
    private List<BNode> nodes;
    //节点的键值对
    private List<KeyAndValue> keyAndValue;
    //节点的后节点
    private BNode nextNode;
    //节点的前节点
    private BNode previousNode;
    //节点的父节点
    private BNode parantNode;

    public BNode( List<BNode> nodes, List<KeyAndValue> keyAndValue, BNode nextNode,BNode previousNode, BNode parantNode) {
        this.nodes = nodes;
        this.keyAndValue = keyAndValue;
        this.nextNode = nextNode;
        this.parantNode = parantNode;
        this.previousNode = previousNode;
    }

    boolean isLeaf() {
        return nodes==null;
    }

    boolean isHead() {
        return previousNode == null;
    }

    boolean isTail() {
        return nextNode == null;
    }

    boolean isRoot() {
        return parantNode == null;
    }


    List<BNode> getNodes() {
        return nodes;
    }

    void setNodes(List<BNode> nodes) {
        this.nodes = nodes;
    }


    List<KeyAndValue> getKeyAndValue() {
        return keyAndValue;
    }

//    public void setKeyAndValue(List<KeyAndValue> KeyAndValue) {
//        this.keyAndValue = KeyAndValue;
//    }

    BNode getNextNode() {
        return nextNode;
    }

    void setNextNode(BNode nextNode) {
        this.nextNode = nextNode;
    }

    BNode getParantNode() {
        return parantNode;
    }

    void setParantNode(BNode parantNode) {
        this.parantNode = parantNode;
    }

    BNode getPreviousNode() {
        return previousNode;
    }

    void setPreviousNode(BNode previousNode) {
        this.previousNode = previousNode;
    }
}
