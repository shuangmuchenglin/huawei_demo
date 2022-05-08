package problems;
/**
 * @ClassName: problems.Proc_15
 * @Author: Zuo
 * @Date 2022/4/19
 * @Version 1.0
 * Copyright (c) Huawei Technologies Co., Ltd.  All rights reserved.
 * Note: 提供的缺省代码仅供参考，可自行根据答题需要进行使用、修改或删除。
 */

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class Proc_15 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int diff = cin.nextInt();
        int line = cin.nextInt();
        int[] arr = new int[line];
        for (int i = 0; i < line; i++) {
            arr[i] = cin.nextInt();
        }
        cin.close();
        int result = proc(arr, diff);
        System.out.println(result);
    }

    // 待实现函数，在此函数中填入答题代码
    private static int proc(int[] arr, int diff) {
        if (arr.length < 2) {
            return 0;
        }
        Arrays.sort(arr);
        int res = 0;
        if (diff < 0)
            diff = -diff;
        for (int i = 0; i < arr.length - 1; i++) {
            if (Arrays.binarySearch(arr, i, arr.length, arr[i] + diff) >= 0)
                res++;
        }
        return res;
    }
}
