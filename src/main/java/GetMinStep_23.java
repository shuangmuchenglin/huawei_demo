/**
 * @ClassName: GetMinStep_23
 * @Author: Zuo
 * @Date 2022/4/25
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
 * OJ考题代码：简易文本编辑器
 *
 * @author 命题组
 * @since 2020-3-3
 */
public class GetMinStep_23 {
    /**
     * main入口由OJ平台调用
     */
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int num = cin.nextInt();
        int[] steps = new int[num];
        for (int i = 0; i < num; i++) {
            steps[i] = cin.nextInt();
        }
        cin.close();

        System.out.println(getMinStep(steps));
    }

    static int getMinStep(int[] steps) {
        // 在此补充你的代码
        int res = steps[0];
        for (int i = 1; i < steps.length; i++) {
            if (steps[i] > steps[i - 1]) {
                res += steps[i] - steps[i - 1];
            }
        }
        return res;
    }
}
