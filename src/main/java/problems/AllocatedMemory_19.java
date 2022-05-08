package problems; /**
 * @ClassName: problems.AllocatedMemory_19
 * @Author: Zuo
 * @Date 2022/4/20
 * @Version 1.0
 */
/*
 * Copyright (c) Huawei Technologies Co., Ltd.  All rights reserved.
 * Note: 提供的缺省代码仅供参考，可自行根据答题需要进行使用、修改或删除。
 */

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class AllocatedMemory_19 {
    static class AllocatedMemory {
        //记录已分配内存的起始地址和结束地址
        private TreeMap<Integer, Integer> allocatedMap;

        AllocatedMemory() {
            allocatedMap = new TreeMap<>();
        }

        // 返回分配的内存首地址(string)，失败返回字符串 "error"
        String request(int size) {
            // 在此补充你的代码
            int addressStart = 0;
            if (size <= 0 || size > 100) {
                return "error";
            }
            if (allocatedMap.isEmpty()) {
                allocatedMap.put(0, size);
            } else {
                List<Integer> headList = new ArrayList<>(allocatedMap.keySet());
                for (int i = 0; i < headList.size(); i++) {
                    if (headList.get(i) - addressStart >= size) {
                        allocatedMap.put(addressStart, addressStart + size);
                    } else {
                        addressStart = allocatedMap.get(headList.get(i));
                    }
                }
                if (size <= 100 - addressStart) {
                    allocatedMap.put(addressStart, addressStart + size);
                } else {
                    return "error";
                }
            }
            return Integer.toString(addressStart);
        }

        // 成功返回 true；失败返回 false，失败时框架会自动输出 "error"
        boolean release(int startAddress) {
            // 在此补充你的代码
            if (allocatedMap.containsKey(startAddress)) {
                allocatedMap.remove(startAddress);
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        AllocatedMemory allocatedMemory = new AllocatedMemory();
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int line = Integer.parseInt(cin.nextLine());
        String[][] ins = new String[line][2];
        for (int i = 0; i < line; i++) {
            ins[i] = cin.nextLine().split("=");
            if (ins[i][0].startsWith("REQUEST")) {
                System.out.println(allocatedMemory.request(Integer.parseInt(ins[i][1])));
            } else {
                boolean ret = allocatedMemory.release(Integer.parseInt(ins[i][1]));
                if (!ret) {
                    System.out.println("error");
                }
            }
        }

        cin.close();
    }
}
