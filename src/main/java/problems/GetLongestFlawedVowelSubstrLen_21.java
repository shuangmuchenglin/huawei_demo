package problems; /**
 * @ClassName: problems.GetLongestFlawedVowelSubstrLen_21
 * @Author: Zuo
 * @Date 2022/4/21
 * @Version 1.0
 */

import java.util.*;
/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2020. All rights reserved.
 * Note: 提供的缺省代码仅供参考，可自行根据答题需要进行使用、修改或删除。
 */

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * OJ考题代码：最长带瑕疵的元音子串
 *
 * @author 命题组
 * @since 2020-3-3
 */
public class GetLongestFlawedVowelSubstrLen_21 {
    /**
     * main入口由OJ平台调用
     */
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int flaw = Integer.parseInt(cin.nextLine());
        String input = cin.nextLine();
        cin.close();

        System.out.println(getLongestFlawedVowelSubstrLen(flaw, input));
    }

    // 待实现函数，在此函数中填入答题代码
    private static int getLongestFlawedVowelSubstrLen(int flaw, String input) {
        List<Character> list = Arrays.asList('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U');
        int pre = 0, after;
        int flaw_count = 0;
        int res = 0;
        for (after = 0; after < input.length(); after++) {
            //先遍历右指针，右指针不是元音，flaw_count计数加1
            if (!list.contains(input.charAt(after))) {
                flaw_count++;
            }
            //右指针不包含元音或flaw_count未达到flaw,右指针继续右移
            if (!list.contains(input.charAt(after)) || flaw_count < flaw) {
                continue;
            }
            //（右指针包含元音）flaw_count达到flaw,且左指针为元音，满足条件更新res
            if (flaw_count == flaw && list.contains(input.charAt(pre))) {
                res = res > (after - pre + 1) ? res : (after - pre + 1);
                continue;
            }
            //（右指针包含元音）flaw_count超过flaw或左指针不为元音，需移动左指针
            while (flaw_count > flaw || !list.contains(input.charAt(pre))) {
                pre++;
                //判断原左指针指向非元音，右移后flaw_count减1
                if (!list.contains(input.charAt(pre - 1))) {
                    flaw_count--;
                }
                if (pre > after) {
                    pre = after;
                    break;
                }
            }
            //（右指针包含元音）左指针移动完成后检查是否符合条件，并更新res
            if (flaw_count == flaw && list.contains(input.charAt(pre))) {
                res = res > (after - pre + 1) ? res : (after - pre + 1);
            }
        }
        return res;
    }
}

