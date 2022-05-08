package problems; /**
 * @ClassName: problems.SimpleDhcpServer
 * @Author: Zuo
 * @Date 2022/5/2
 * @Version 1.0
 */

/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2020. All rights reserved.
 * Note: 提供的缺省代码仅供参考，可自行根据答题需要进行使用、修改或删除。
 */

import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * OJ考题代码：简易DHCP服务器
 *
 * @author 命题组
 * @since 2020-3-4
 */
public class SimpleDhcpServer {
    /**
     * main入口由OJ平台调用
     */
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        DhcpServer dhcpServer = new DhcpServer();
        int operationCnt = cin.nextInt();
        for (int i = 0; i < operationCnt; i++) {
            String[] operation = cin.next().split("=");
            if ("REQUEST".equals(operation[0])) {
                System.out.println(dhcpServer.request(operation[1]));
            } else {
                dhcpServer.release(operation[1]);
            }
        }
        cin.close();
    }

    static class DhcpServer {
        List<Integer> noUseList;
        Map<Integer, Boolean> usedMap;
        List<Integer> releases;
        Map<String, Integer> mac2IpMap;
        Map<String, Integer> recordsMap;

        DhcpServer() {
            // 在此补充你的代码
            noUseList = new ArrayList<>();
            usedMap = new HashMap<>();
            releases = new ArrayList<>();
            recordsMap = new HashMap<>();
            mac2IpMap = new HashMap<>();
            for (int i = 0; i <= 255; i++) {
                noUseList.add(i);
                usedMap.put(i, false);
            }
        }

        String request(String mac) {
            // 在此补充你的代码
            String prefix = "192.168.0.";
            if (mac2IpMap.containsKey(mac))
                return prefix + mac2IpMap.get(mac).toString();
            if (recordsMap.containsKey(mac)) {
                Integer ip = recordsMap.get(mac);
                if (!usedMap.get(ip)) {
                    usedMap.put(ip, true);
                    mac2IpMap.put(mac, ip);
                    releases.remove(ip);
                    return prefix + ip.toString();
                }
            }
            if (noUseList.size() > 0) {
                Integer ip = noUseList.get(0);
                recordsMap.put(mac, ip);
                usedMap.put(ip, true);
                mac2IpMap.put(mac, ip);
                noUseList.remove(0);
                return prefix + ip.toString();
            }
            if (releases.size() > 0) {
                int k = 0;
                for (int i = 0; i < releases.size(); i++) {
                    if (releases.get(k) > releases.get(i)) {
                        k = i;
                    }
                }
                Integer ip = releases.get(k);
                releases.remove(k);
                usedMap.put(ip, true);
                recordsMap.put(mac, ip);
                mac2IpMap.put(mac, ip);
                return prefix + ip.toString();
            }
            return "NA";
        }

        void release(String mac) {
            // 在此补充你的代码
            if (mac2IpMap.containsKey(mac)) {
                Integer ip = mac2IpMap.get(mac);
                usedMap.put(ip, false);
                releases.add(ip);
                mac2IpMap.remove(mac);
            }
        }
    }
}
