package problems; /**
 * @ClassName: problems.ExecCommand_33
 * @Author: Zuo
 * @Date 2022/4/26
 * @Version 1.0
 */

import java.io.*;
import java.math.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2020. All rights reserved.
 * Description: 上机编程认证
 * Note: 缺省代码仅供参考，可自行决定使用、修改或删除
 */

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * OJ考题代码：遥控小车
 *
 * @author 命题组
 * @since 2021-02-04
 */

public class ExecCommand_33 {
    /**
     * main入口由OJ平台调用
     */
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        String commands = cin.nextLine();
        cin.close();
        String result = execCommand(commands);
        System.out.println(result);
    }

    // 待实现函数，在此函数中填入答题代码
    private static String execCommand(String commands) {
        int[] position = {0, 0};
        int directionIndex = 0;
        int[][] DirectionArr = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int i = 0; i < commands.length(); i++) {
            if (commands.charAt(i) == 'L') {
                directionIndex = (directionIndex - 1) % 4;
            } else if (commands.charAt(i) == 'R') {
                directionIndex = (directionIndex + 1) % 4;
            } else {
                position[0]+=DirectionArr[directionIndex][0];
                position[1]+=DirectionArr[directionIndex][1];
            }
        }
        return "("+position[0]+","+position[1]+")";
    }
}
