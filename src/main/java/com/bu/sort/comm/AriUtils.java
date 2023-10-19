package com.bu.sort.comm;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author haizhuangbu
 * @date 2023/10/17 10:51
 * @mark AriUtils
 */
public class AriUtils {


    /**
     * @param idx
     * @return 生成随机数组
     */
    public static int[] randomMakeArrays(int idx) {

        Random random = new Random();
        int[] arr = new int[idx];
        for (int i = 0; i < idx; i++) {
            arr[i] = random.nextInt(100);
        }
        return arr;
    }

    public static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }


    public static void print(int[] arr) {
        String arrList = Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(","));
        System.out.println(arrList);
    }


}
