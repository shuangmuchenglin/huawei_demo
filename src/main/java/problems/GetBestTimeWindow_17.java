package problems;
/**
 * @ClassName: problems.GetBestTimeWindow_17
 * @Author: Zuo
 * @Date 2022/4/20
 * @Version 1.0
 * Copyright (c) Huawei Technologies Co., Ltd.  All rights reserved.
 * Note: 提供的缺省代码仅供参考，可自行根据答题需要进行使用、修改或删除。
 */

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class GetBestTimeWindow_17 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int pvErrorTolerance = Integer.parseInt(cin.nextLine());
        int[] pvByHourWeekly = new int[7 * 24];
        for (int i = 0; i < pvByHourWeekly.length; i++) {
            pvByHourWeekly[i] = cin.nextInt();
        }
        cin.close();
        int[] results = getBestTimeWindow(pvByHourWeekly, pvErrorTolerance);
        String[] strResult = Arrays.stream(results).mapToObj(String::valueOf).toArray(String[]::new);
        System.out.println(String.join(" ", strResult));
    }

    private static int[] getBestTimeWindow(int[] pvByHourWeekly, int pvErrorTolerance) {
        // 在此补充你的代码
        int[] res = {-1, -1};
        int pre_index = 0;
        int longestLength = 0;
        long sum;
        int arrLength = pvByHourWeekly.length;
        while (pre_index < arrLength) {
            int after_index = pre_index;
            sum = pvByHourWeekly[pre_index];
            int add_count = 1;
            while (sum <= pvErrorTolerance) {
                after_index = (after_index + 1) % arrLength;
                sum += pvByHourWeekly[after_index];
                add_count++;
                if (add_count > arrLength)
                    return new int[]{0, arrLength - 1};
            }
            if (after_index == pre_index && add_count == 1) {
                pre_index++;
                continue;
            }
            after_index = (after_index + arrLength - 1) % arrLength;
            if (after_index >= pre_index) {
                if (longestLength < (after_index - pre_index + 1)) {
                    longestLength = after_index - pre_index + 1;
                    res[0] = pre_index;
                    res[1] = after_index;
                }
            } else {
                if (longestLength < (arrLength - pre_index + after_index + 1)) {
                    longestLength = arrLength - pre_index + after_index + 1;
                    res[0] = pre_index;
                    res[1] = after_index;
                }
            }
            pre_index++;
        }
        return res;
    }
}

