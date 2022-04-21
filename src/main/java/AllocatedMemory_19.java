/**
 * @ClassName: AllocatedMemory_19
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
        private TreeMap<Integer, Integer> hasAllocated;
        private int ADDRESS_DEFAULT_HEAD = 0;
        private int ADDRESS_DEFAULT_END = 100;
        AllocatedMemory() {
            hasAllocated = new TreeMap<>();
        }

        // 返回分配的内存首地址(string)，失败返回字符串 "error"
        String request(int size) {
            // 在此补充你的代码
            int addressHead = ADDRESS_DEFAULT_HEAD;
            if (size <= 0 || size > 100) {
                return "error";
            }
            if (hasAllocated.isEmpty()) {
                hasAllocated.put(ADDRESS_DEFAULT_HEAD, size);
            } else {
                List<Integer> headList = new ArrayList<>(hasAllocated.keySet());
                for (int i=0; i<headList.size(); i++) {
                    if (headList.get(i) - addressHead >= size) {
                        hasAllocated.put(addressHead, addressHead + size);
                    } else {
                        addressHead = hasAllocated.get(headList.get(i));
                    }
                }
                if (size <= ADDRESS_DEFAULT_END - addressHead) {
                    hasAllocated.put(addressHead, addressHead + size);
                } else {
                    return "error";
                }
            }
            return String.valueOf(addressHead);
        }

        // 成功返回 true；失败返回 false，失败时框架会自动输出 "error"
        boolean release(int startAddress) {
            // 在此补充你的代码
            if (hasAllocated.containsKey(startAddress)) {
                hasAllocated.remove(startAddress);
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
