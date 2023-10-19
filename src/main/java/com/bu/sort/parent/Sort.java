package com.bu.sort.parent;

import com.bu.sort.comm.AriUtils;

/**
 * @author haizhuangbu
 * @date 2023/10/17 11:13
 * @mark Sort
 */
public interface Sort {

    void sort(int[] arr);

    default void sort() {
        int[] arr = AriUtils.randomMakeArrays(10);
        sort(arr);
        System.out.println(mark());
        AriUtils.print(arr);
    }


    default void sort(int idx) {
        int[] arr = AriUtils.randomMakeArrays(20);
        sort(arr);
    }

    String mark();


}
