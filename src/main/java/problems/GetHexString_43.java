package problems;
/**
 * @ClassName: problems.GetHexString_43
 * @Author: Zuo
 * @Date 2022/4/30
 * @Version 1.0
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2020. All rights reserved.
 * Description: 上机编程认证
 * Note: 缺省代码仅供参考，可自行决定使用、修改或删除
 */

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * OJ考题代码：大小端整数
 *
 * @author 命题组
 * @since 2021-02-10
 */

public class GetHexString_43 {
    // 待实现函数，在此函数中填入答题代码
    private static String getHexString(String num) {
        Long num1;
        try {
            num1 = Long.parseLong(num, 10);
        } catch (NumberFormatException e) {
            return "overflow";
        }
        Long min = -1L << 31;
        Long max = 1L << 32;
        if (num1 < min || num1 >= max) {
            return "overflow";
        }
        String res = Long.toHexString(num1).toUpperCase();
        while (res.length() < 8) {
            res = "0" + res;
        }
        String[] bytes = new String[4];
        for (int i = 0; i < 4; i++) {
            bytes[i] = res.substring(res.length() - 8 + 2 * i, res.length() + 2 * i - 6);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append(bytes[i]);
            if (i < 3) {
                sb.append(" ");
            }
        }
        sb.append("\n");
        for (int i = 3; i >= 0; i--) {
            sb.append(bytes[i]);
            if (i > 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    /**
     * main入口由OJ平台调用
     */
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        String num = cin.nextLine();
        cin.close();
        String result = getHexString(num);
        System.out.println(result);
    }
}

