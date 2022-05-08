package problems;
/**
 * @ClassName: problems.ComposeIpAddress_47
 * @Author: Zuo
 * @Date 2022/4/30
 * @Version 1.0
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2020. All rights reserved.
 * Note: 提供的缺省代码仅供参考，可自行根据答题需要进行使用、修改或删除。
 */

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Scanner;

/**
 * OJ考题代码：用给定的数字组成IP地址
 *
 * @author 命题组
 * @since 2020-3-3
 */
public class ComposeIpAddress_47 {
    static long composeIpAddress(String nums) {
        // 在此补充你的代码
        HashSet<String> set = new HashSet<>();
        StringBuilder res = new StringBuilder();
        if (nums.indexOf('0') >= 0) {
            set.add("0");
        }
        backtrace(nums, set, res);
        long result = 1L;
        int size = set.size();
        for (int i = 0; i < 4; i++) {
            result *= size;
        }
        System.out.println(set);
        return result;
    }

    private static void backtrace(String nums, HashSet<String> set, StringBuilder res) {
        if (res.length() > 0 && !set.contains(res) && Integer.parseInt(res.toString()) <= 255) {
            set.add(res.toString());
        }
        if (res.length() > 0 && Integer.parseInt(res.toString()) > 255) {
            return;
        }
        for (int i = 0; i < nums.length(); i++) {
            if (res.length() == 0 && nums.substring(i, i + 1).equals("0")) {
                continue;
            }
            StringBuilder temp = new StringBuilder(res);
            res.append(nums.substring(i, i + 1));
            backtrace(nums, set, res);
            res = temp;
        }
    }

    /**
     * main入口由OJ平台调用
     */
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        String nums = cin.nextLine();
        cin.close();

        System.out.println(composeIpAddress(nums));
    }
}

