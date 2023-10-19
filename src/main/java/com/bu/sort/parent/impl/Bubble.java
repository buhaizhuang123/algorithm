package com.bu.sort.parent.impl;

import com.bu.sort.comm.AriUtils;
import com.bu.sort.parent.Sort;

/**
 * @author haizhuangbu
 * @date 2023/10/17 11:17
 * @mark Bubble 冒泡排序
 */
public class Bubble implements Sort {


    /**
     * @param arr 排序数组
     *            交换相邻的位置
     *            每一轮循环
     *            找出最大的值,交换最后的位置
     */
    @Override
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {

            int j = 0;
            while (j + 1 < arr.length - i) {
                if (arr[j] > arr[j + 1]) {
                    AriUtils.swap(arr, j, j + 1);
                }
                j++;
            }
        }
    }

    @Override
    public String mark() {
        return "冒泡排序";
    }


    public static void main(String[] args) {
        Bubble bubble = new Bubble();
        bubble.sort();
    }

}
