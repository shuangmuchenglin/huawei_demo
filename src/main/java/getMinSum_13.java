/**
 * @ClassName: getMinSum_13
 * @Author: Zuo
 * @Date 2022/4/18
 * @Version 1.0
 */
/*
 * Copyright (c) Huawei Technologies Co., Ltd.  All rights reserved.
 * Note: 提供的缺省代码仅供参考，可自行根据答题需要进行使用、修改或删除。
 */

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Scanner;

public class getMinSum_13 {
    static class Pair {
        int index1;
        int index2;
        int sum;

        public Pair(int index1, int index2, int sum) {
            this.index1 = index1;
            this.index2 = index2;
            this.sum = sum;
        }
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int size1 = cin.nextInt();
        int[] array1 = new int[size1];
        for (int i = 0; i < size1; i++) {
            array1[i] = cin.nextInt();
        }
        int size2 = cin.nextInt();
        int[] array2 = new int[size2];
        for (int i = 0; i < size2; i++) {
            array2[i] = cin.nextInt();
        }
        int pairTarget = cin.nextInt();
        cin.close();

        System.out.println(getMinSum(array1, array2, pairTarget));
    }

    private static int getMinSum(int[] array1, int[] array2, int pairTarget) {
        // 在此补充你的代码
        int res = 0, count = 0, index1 = 0, index2 = 0;
        Pair temp;
        if (array1.length * array2.length < pairTarget)
            return 0;

        PriorityQueue<Pair> heap = new PriorityQueue<>((o1, o2) -> o1.sum - o2.sum);
        HashSet<String> set = new HashSet<>();
        while (count < pairTarget) {
            if (heap.size() == 0) {
                temp = new Pair(0, 0, array1[0] + array2[0]);
                heap.offer(temp);
                set.add(temp.index1 +"\t"+temp.index2);
            } else {
                temp = heap.poll();
                res += temp.sum;
                count++;
                index1 = temp.index1;
                index2 = temp.index2;
                if (index1 + 1 < array1.length) {
                    temp = new Pair(index1 + 1, index2, array1[index1 + 1] + array2[index2]);
                    if (!set.contains(temp.index1 +"\t"+temp.index2)) {
                        heap.offer(temp);
                        set.add(temp.index1 +"\t"+temp.index2);
                    }
                }
                if (index2 + 1 < array2.length) {
                    temp = new Pair(index1, index2 + 1, array1[index1] + array2[index2 + 1]);
                    if (!set.contains(temp.index1 +"\t"+temp.index2)) {
                        heap.offer(temp);
                        set.add(temp.index1 +"\t"+temp.index2);
                    }
                }
            }
        }
        return res;
    }
}

