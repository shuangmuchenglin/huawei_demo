package problems;
/**
 * @ClassName: problems.GetLongestNum
 * @Author: Zuo
 * @Date 2022/5/2
 * @Version 1.0
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2020. All rights reserved.
 * Note: 提供的缺省代码仅供参考，可自行根据答题需要进行使用、修改或删除。
 */

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * OJ考题代码：二进制序列中最长的重复位数
 *
 * @author 命题组
 * @since 2020-04-09
 */

public class GetLongestNum {
    // 待实现函数，在此函数中填入答题代码
    private static int getLongestNum(long num) {
        // 在此补充你的代码
        String s = Long.toBinaryString(num);
        if (s.length() < 2)
            return 1;
        int[] dp = new int[s.length()];
        dp[0] = 1;
        int res = dp[0];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
            res = res > dp[i] ? res : dp[i];
        }
        return res;
    }

    /**
     * main入口由OJ平台调用
     */
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        long num = cin.nextLong();
        cin.close();
        int result = getLongestNum(num);
        System.out.println(result);
    }
}
