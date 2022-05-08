package problems; /**
 * @ClassName: problems.Calculate_39
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
import java.util.Scanner;
import java.util.Stack;

/**
 * OJ考题代码：四则运算求值
 *
 * @author 命题组
 * @since 2021-02-04
 */

public class Calculate_39 {
    /**
     * main入口由OJ平台调用
     */
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        String expression = cin.nextLine();
        cin.close();
        String result = calculate(expression);
        System.out.println(result);
    }

    // 待实现函数，在此函数中填入答题代码
    private static String calculate(String expression) {
        Stack<Character> charstack = new Stack<>();  //单调栈，保证栈外符号运算优先级高于栈顶时才入栈
        Stack<Integer> numStack = new Stack<>();   //数字栈
        String res = "";
        int num = 0;
        boolean flag = false;
        for (int i = 0; i < expression.length(); i++) {
            if (i == 0 && expression.charAt(i) == '-') {
                flag = true;
            } else if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*' || expression.charAt(i) == '/') {
                if (!charstack.isEmpty() && getPriority(expression.charAt(i)) > getPriority(charstack.peek()))
                    charstack.push(expression.charAt(i));
                else if (!charstack.isEmpty() && getPriority(expression.charAt(i)) <= getPriority(charstack.peek())) {
                    while (!charstack.isEmpty() && getPriority(expression.charAt(i)) <= getPriority(charstack.peek())) {
                        int tmp2 = numStack.pop();
                        int tmp1 = numStack.pop();
                        char sign = charstack.pop();
                        if (sign == '/' && tmp2 == 0) {
                            return "error";
                        } else {
                            numStack.push(calculate(tmp1, tmp2, sign));
                        }
                    }
                    charstack.push(expression.charAt(i));
                } else
                    charstack.push(expression.charAt(i));
                continue;
            }
            if (expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
                num = num * 10 + Integer.parseInt(expression.substring(i, i + 1));
                if (i + 1 < expression.length() && expression.charAt(i + 1) >= '0' && expression.charAt(i + 1) <= '9')
                    continue;
                else {
                    num = flag ? -num : num;
                    numStack.push(num);
                    num = 0;
                    flag = false;
                }
            }
        }
        while (numStack.size() > 1) {
            int num2 = numStack.pop();
            int num1 = numStack.pop();
            char sign = charstack.pop();
            if (sign == '/' && num2 == 0) {
                return "error";
            } else {
                numStack.push(calculate(num1, num2, sign));
            }
        }
        res = numStack.pop().toString();
        return res;
    }

    private static int calculate(int num1, int num2, char sign) {
        if (sign == '+')
            return num1 + num2;
        else if (sign == '-')
            return num1 - num2;
        else if (sign == '*')
            return num1 * num2;
        else
            return num1 / num2;
    }

    private static int getPriority(char c) {
        if (c == '+' || c == '-')
            return 0;
        else
            return 1;

    }
}