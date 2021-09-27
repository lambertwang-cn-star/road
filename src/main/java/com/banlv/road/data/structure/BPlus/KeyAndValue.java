package com.banlv.road.data.structure.BPlus;

import lombok.Data;

/**
 * @author ：Lambert Wang
 * @date ：Created in 2021/3/17 14:00
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
@Data
public class KeyAndValue implements Comparable<KeyAndValue> {

    private int key;

    private Object value;


    @Override
    public int compareTo(KeyAndValue o) {
        return this.key - o.key;
    }

    KeyAndValue(int key, Object value) {
        this.key = key;
        this.value = value;
    }
}
