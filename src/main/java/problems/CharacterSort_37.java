package problems; /**
 * @ClassName: problems.CharacterSort_37
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
import java.util.*;

/**
 * OJ考题代码：字符排序
 *
 * @author 命题组
 * @since 2021-02-04
 */

public class CharacterSort_37 {
    /**
     * main入口由OJ平台调用
     */
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        String inputStr = cin.nextLine();
        cin.close();
        String result = characterSort(inputStr);
        System.out.println(result);
    }

    // 待实现函数，在此函数中填入答题代码
    private static String characterSort(String inputStr) {
        ArrayList<Character> digitArr = new ArrayList<>();
        ArrayList<Character> letterArr = new ArrayList<>();
        ArrayList<Integer> digitIndexArr = new ArrayList<>();
        for (int i = 0; i < inputStr.length(); i++) {
            if (Character.isDigit(inputStr.charAt(i))) {
                digitIndexArr.add(i);
                digitArr.add(inputStr.charAt(i));
            } else {
                letterArr.add(inputStr.charAt(i));
            }
        }
        Collections.sort(digitArr);
        Collections.sort(letterArr, (o1, o2) -> {
            int num1 = Character.getNumericValue(o1);
            int num2 = Character.getNumericValue(o2);
            if(Character.isLowerCase(o1))
                num1-=58;
            if(Character.isLowerCase(o2))
                num2-=58;
            return num1-num2;
        });
        System.out.println(digitArr);
        System.out.println(letterArr);
        StringBuilder s = new StringBuilder();
        int indexdigit = 0, indexletter = 0;
        for (int i = 0; i < inputStr.length(); i++) {
            if (digitIndexArr.contains(i)) {
                s.append(digitArr.get(indexdigit));
                indexdigit++;
            } else{
                s.append(letterArr.get(indexletter));
                indexletter++;
            }
        }
        return s.toString();
    }
}
