package problems;
/**
 * @ClassName: problems.PhoneCaseInventoryManage_35
 * @Author: Zuo
 * @Date 2022/4/26
 * @Version 1.0
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2020. All rights reserved.
 * Description: 上机编程认证
 * Note: 缺省代码仅供参考，可自行决定使用、修改或删除
 */

import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * OJ考题代码：手机壳库存管理
 *
 * @author 命题组
 * @since 2021-01-30
 */

public class PhoneCaseInventoryManage_35 {
    /**
     * main入口由OJ平台调用
     */
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int cnt = cin.nextInt();
        float demand = cin.nextFloat();
        float[] inventory = new float[cnt];
        for (int i = 0; i < cnt; i++) {
            inventory[i] = cin.nextFloat();
        }
        float[] price = new float[cnt];
        for (int i = 0; i < cnt; i++) {
            price[i] = cin.nextFloat();
        }
        cin.close();
        String result = phoneCaseInventoryManage(demand, inventory, price);
        System.out.println(result);
    }

    // 待实现函数，在此函数中填入答题代码
    private static String phoneCaseInventoryManage(float demand, float[] inventory, float[] price) {
        Map<Integer, Float> map = new HashMap<>();
        float res = 0;
        for (int i = 0; i < inventory.length; i++) {
            map.put(i, price[i] / inventory[i]);
        }
        List<Map.Entry<Integer, Float>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> {
            if (o2.getValue() > o1.getValue())
                return 1;
            else
                return -1;
        });
        for (Map.Entry<Integer, Float> e : list) {
            if (demand > 0) {
                //库存大于需求，库存有剩余
                if (inventory[e.getKey()] > demand) {
                    res += price[e.getKey()] * demand / inventory[e.getKey()];
                    demand = 0;
                } else {
                    res += price[e.getKey()];
                    demand -= inventory[e.getKey()];
                }
            } else {
                break;
            }
        }
        return String.format("%.2f", res);
    }
}

