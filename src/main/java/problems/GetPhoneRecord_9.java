package problems;
/**
 * @ClassName: problems.GetPhoneRecord_9
 * @Author: Zuo
 * @Date 2022/4/18
 * @Version 1.0
 * Copyright (c) Huawei Technologies Co., Ltd.  All rights reserved.
 * Note: 提供的缺省代码仅供参考，可自行根据答题需要进行使用、修改或删除。
 */

import java.nio.charset.StandardCharsets;
import java.util.*;

public class GetPhoneRecord_9 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int recordNum = Integer.valueOf(cin.nextLine());
        List<String> records = new ArrayList<>(recordNum);
        for (int i = 0; i < recordNum; i++) {
            records.add(cin.nextLine());
        }
        cin.close();
        String[][] results = getPhoneRecord(records);
        for (String[] result : results) {
            System.out.println(String.join(" ", Arrays.asList(result)));
        }
    }

    private static String[][] getPhoneRecord(List<String> records) {
        // 在此补充你的代码
        LinkedHashMap<String, Integer> totalRecords = new LinkedHashMap<>();
        Set<String> whiteList = new HashSet<>();
        HashMap<String, Integer> callPass = new HashMap<>();
        HashMap<String, Integer> callRefuse = new HashMap<>();
        String[] temp = new String[2];
        for (String s : records) {
            temp = s.split(" ");
            boolean isMatch = false;
            if (temp[0].equals("C")) {
                //处理接听电话
                int count = totalRecords.getOrDefault(temp[1], 0);
                totalRecords.put(temp[1], count + 1);
                //1.检查该号码是否在白名单中
                Iterator<String> iter = whiteList.iterator();
                while (iter.hasNext()) {
                    String str = iter.next();
                    int index = str.indexOf("*");
                    if (index >= 0) {
                        //包含通配符的白名单匹配成功
                        if (temp[1].substring(0, index).equals(str.substring(0, index))) {
                            int passCount = callPass.getOrDefault(temp[1], 0);
                            callPass.put(temp[1], passCount + 1);
                            isMatch = true;
                            break;
                        }
                    } else {
                        //不包含通配符的白名单匹配成功
                        if (temp[1].equals(str)) {
                            int passCount = callPass.getOrDefault(temp[1], 0);
                            callPass.put(str, passCount + 1);
                            isMatch = true;
                            break;
                        }
                    }
                }
                //白名单匹配失败
                if (isMatch == false) {
                    int refuseCount = callRefuse.getOrDefault(temp[1], 0);
                    callRefuse.put(temp[1], refuseCount + 1);
                }
            } else {
                //处理添加白名单
                whiteList.add(temp[1]);
            }
        }
        //输出结果
        String[][] res = new String[totalRecords.size()][3];
        int index = 0;
        for (String s : totalRecords.keySet()) {
            res[index][0] = s;
            res[index][1] = Integer.toString(callPass.getOrDefault(s, 0));
            res[index][2] = Integer.toString(callRefuse.getOrDefault(s, 0));
            index++;
        }
        return res;
    }
}
