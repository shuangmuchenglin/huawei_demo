/**
 * @ClassName: GetMaxSendNumber_31
 * @Author: Zuo
 * @Date 2022/4/26
 * @Version 1.0
 */
/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2020. All rights reserved.
 * Description: 上机编程认证
 * Note: 缺省代码仅供参考，可自行决定使用、修改或删除
 */

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * OJ考题代码：话单发送
 *
 * @author 命题组
 * @since 2020-04-21
 */

public class GetMaxSendNumber_31 {
    // 待实现函数，在此函数中填入答题代码
    static class Bill {
        private int billPrior;
        private int billLen;

        public Bill(int billPrior, int billLen) {
            this.billPrior = billPrior;
            this.billLen = billLen;
        }
    }

    private static int getMaxSendNumber(int cap, int[] billLen, int[] billPrior) {
        Bill[] list = new Bill[billLen.length];
        for (int i = 0; i < billLen.length; i++) {
            list[i] = new Bill(billPrior[i], billLen[i]);
        }
        Arrays.sort(list, (o1, o2) -> {
            if (o1.billPrior == o2.billPrior)
                return o1.billLen - o2.billLen;
            else
                return o1.billPrior - o2.billPrior;
        });
        int res = 0;
        for (int i = 0; i < list.length; i++) {
            if (cap >= list[i].billLen) {
                cap -= list[i].billLen;
                res++;
            } else {
                break;
            }
        }
        return res;
    }

    /**
     * main入口由OJ平台调用
     */
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int cap = cin.nextInt();
        int line = cin.nextInt();
        int[] billLen = new int[line];
        for (int i = 0; i < line; i++) {
            billLen[i] = cin.nextInt();
        }
        int[] billPrior = new int[line];
        for (int i = 0; i < line; i++) {
            billPrior[i] = cin.nextInt();
        }
        cin.close();
        int result = getMaxSendNumber(cap, billLen, billPrior);
        System.out.println(result);
    }
}
