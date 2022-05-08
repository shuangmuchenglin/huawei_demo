package problems;
/**
 * @ClassName: problems.GetCountOfSubString_27
 * @Author: Zuo
 * @Date 2022/4/26
 * @Version 1.0
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2020. All rights reserved.
 * Note: 提供的缺省代码仅供参考，可自行根据答题需要进行使用、修改或删除。
 */

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * OJ考题代码：统计无重复字符的字符串
 *
 * @author 命题组
 * @since 2020-04-20
 */

public class GetCountOfSubString_27 {
    /**
     * main入口由OJ平台调用
     */
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        String input = cin.nextLine();
        cin.close();
        int result = getCountOfSubString(input);
        System.out.println(result);
    }

    private static int getCountOfSubString(String input) {
        // TODO 在此补充你的代码
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 1;
        map.put(input.charAt(0), 0);
        int[] dp = new int[input.length()];
        dp[0] = 1;
        for (int i = 1; i < input.length(); i++) {
            maxLen = getMaxLen(input, i, map, maxLen);
            dp[i] = dp[i - 1] + maxLen;
        }
        return dp[input.length() - 1];
    }

    private static int getMaxLen(String input, int index, HashMap<Character, Integer> map, int maxLen) {
        int temp = map.getOrDefault(input.charAt(index), -1);
        map.put(input.charAt(index), index);
        //与末尾字母相同的出现位置，则以该末尾字符结束的最大不重复子字符串长度如下
        if (index - temp > maxLen + 1) {
            maxLen = maxLen + 1;
        } else {
            maxLen = index - temp;
        }
        return maxLen;
    }
}
