/**
 * @ClassName: GetMinPeople_29
 * @Author: Zuo
 * @Date 2022/4/26
 * @Version 1.0
 */

import java.util.*;

/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 * Note: 提供的缺省代码仅供参考，可自行根据答题需要进行使用、修改或删除。
 */

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * OJ考题代码：完美答案收集
 *
 * @author 命题组
 * @since 2019-12-11
 */
public class GetMinPeople_29 {
    /**
     * main入口由OJ平台调用
     */
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int questionsCount = cin.nextInt();
        int peopleCount = cin.nextInt();
        int[][] correctRanges = new int[peopleCount][];
        for (int i = 0; i < peopleCount; i++) {
            correctRanges[i] = new int[2];
            correctRanges[i][0] = cin.nextInt();
            correctRanges[i][1] = cin.nextInt();
        }
        cin.close();

        System.out.println(getMinPeople(questionsCount, peopleCount, correctRanges));
    }


    private static int getMinPeople(int questionsCount, int peopleCount, int[][] correctRanges) {
        // 在此补充你的代码
        Arrays.sort(correctRanges, (o1, o2) -> {
            if (o1[0] == o2[0])
                return o2[1] - o1[1];
            else {
                return o1[0] - o2[0];
            }
        });
        System.out.println(Arrays.deepToString(correctRanges));
        int start = 1;
        int end = 1;
        int count = 1;
        for (int i = 0; i < peopleCount; i++) {
            int left = correctRanges[i][0];
            int right = correctRanges[i][1];
            //第一个子区间左端点大于需覆盖总区间的左端点，无法覆盖直接break
            if (i == 0 && correctRanges[i][0] > start)
                break;
            /**当前子区间的左端点小于等于待覆盖总区间的左端点（两区间可相连），此时待覆盖区间右区间端点取较大值(找最大延伸边的过程)，
            end表明此时能覆盖的区间右端点值，注意此时count不需要自增*/
            if (left <= start) {
                end = Math.max(end, right);
            } else {
            /**当前子区间的左端点大于待覆盖总区间的左端点（两区间断开），此时待覆盖区间根据上述找到的最大延伸边与端点值比较,判断能否连接
             注意此时count需要自增*/
                count++;
                start = end + 1;
                //最大延伸边也连接不上，直接break
                if (left > start) {
                    break;
                } else {
                //最大延伸边连接上，更新最大覆盖右端点值
                    end = Math.max(end, right);
                }
            }
            if (end >= questionsCount)
                break;
        }
        return end >= questionsCount ? count : -1;
    }

    private static int getMinPeople1(int questionsCount, int peopleCount, int[][] correctRanges) {
        // 在此补充你的代码
        Arrays.sort(correctRanges, (o1, o2) -> {
            if (o1[0] != o2[0])
                return o1[0] - o2[0];
            else {
                return o2[1] - o1[1];
            }
        });
        LinkedList<int[]> list = new LinkedList<>();
        LinkedList<LinkedList<int[]>> res = new LinkedList<>();
        backtrace(0, 0, peopleCount, questionsCount, correctRanges, list, res);
        int min = Integer.MAX_VALUE;
        for (LinkedList<int[]> temp : res) {
            for (int[] s : temp) {
                System.out.print(Arrays.toString(s) + "\t");
            }
            if (temp.size() < min)
                min = temp.size();
            System.out.println();
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private static void backtrace(int index, int endPoint, int peopleCount, int questionsCount, int[][] correctRanges, LinkedList<int[]> list, LinkedList<LinkedList<int[]>> res) {
        //总合并区间右端点达到总终点，添加到res并停止回溯
        if (endPoint == questionsCount) {
            res.add(new LinkedList(list));
            return;
        }
        //区间不连续或下标溢出，直接停止回溯
        if (index >= peopleCount || correctRanges[index][0] - endPoint > 1)
            return;
        for (int i = index; i < peopleCount; i++) {
            //当前合并总区间的右端点小于当前考虑的子区间的左端点，区间不连续，直接停止回溯
            if (correctRanges[i][0] - endPoint > 1)
                return;
            //当前合并总区间的右端点大于等于当前考虑的子区间的右端点，即包含此子区间，直接continue
            if (endPoint >= correctRanges[i][1])
                continue;
                //当前合并总区间的右端点位于子区间中间，可与此子区间合并
            else {
                int temp = endPoint;
                //更新总合并区间的右端点并将此区间加入list
                endPoint = correctRanges[i][1];
                list.add(correctRanges[i]);
                //回溯
                backtrace(i + 1, endPoint, peopleCount, questionsCount, correctRanges, list, res);
                //撤销该选择并重置总合并区间的右端点
                list.removeLast();
                endPoint = temp;
            }
        }
    }

}
