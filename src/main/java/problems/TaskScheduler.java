package problems;
/**
 * @ClassName: problems.TaskScheduler
 * @Author: Zuo
 * @Date 2022/5/2
 * @Version 1.0
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2020. All rights reserved.
 * Note: 提供的缺省代码仅供参考，可自行根据答题需要进行使用、修改或删除。
 */

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

/**
 * OJ考题代码：CI任务调度
 *
 * @author 命题组
 * @since 2020-06-20
 */

public class TaskScheduler {
    /**
     * main入口由OJ平台调用
     */
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int resourcesNum = cin.nextInt();
        int taskNums = cin.nextInt();
        int colNums = 2;
        int[][] taskAttributes = new int[taskNums][colNums];
        for (int row = 0; row < taskNums; row++) {
            for (int col = 0; col < colNums; col++) {
                taskAttributes[row][col] = cin.nextInt();
            }
        }
        cin.close();
        int result = taskScheduler(resourcesNum, taskAttributes);
        System.out.println(result);
    }

    private static int taskScheduler(int resourcesNum, int[][] taskAttributes) {
        // 在此补充你的代码
        int[] subFinishTime = new int[resourcesNum];
        Arrays.fill(subFinishTime, 0);
        Arrays.sort(taskAttributes, (o1, o2) -> {
            if (o1[1] == o2[1])
                return o2[0] - o1[0];
            else
                return o1[1] - o2[1];
        });
        for (int i = 0, taskLength = taskAttributes.length; i < taskLength; i++) {
            int min_index = 0;
            int temp = subFinishTime[0];
            for (int j = 0; j < resourcesNum; j++) {
                if (subFinishTime[j] < temp) {
                    temp = subFinishTime[j];
                    min_index = j;
                }
            }
            subFinishTime[min_index] = (subFinishTime[min_index] + taskAttributes[i][0]);
        }
        Arrays.sort(subFinishTime);
        return (subFinishTime[resourcesNum - 1]) % 1000000007;
    }
}

