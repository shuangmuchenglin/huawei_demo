/**
 * @ClassName: Recombine_11
 * @Author: Zuo
 * @Date 2022/4/18
 * @Version 1.0
 */
/*
 * Copyright (c) Huawei Technologies Co., Ltd. All rights reserved.
 * Note: 提供的缺省代码仅供参考，可自行根据答题需要进行使用、修改或删除。
 */

import java.nio.charset.StandardCharsets;
import java.util.*;

public class Recombine_11 {
    static class DataFragment {
        int dataType;
        int index;
        int endFlag;
        int len;
        String data;

        DataFragment(int dataType, int index, int endFlag, int len, String data) {
            this.dataType = dataType;
            this.index = index;
            this.endFlag = endFlag;
            this.len = len;
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int dataFragmentCnt = cin.nextInt();
        DataFragment[] dataFragments = new DataFragment[dataFragmentCnt];
        for (int i = 0; i < dataFragmentCnt; i++) {
            int dataType = cin.nextInt();
            int index = cin.nextInt();
            int endFlag = cin.nextInt();
            int len = cin.nextInt();
            String data = cin.next();
            dataFragments[i] = new DataFragment(dataType, index, endFlag, len, data);
        }
        int dstType = cin.nextInt();
        cin.close();

        System.out.println(recombine(dataFragments, dstType));
    }

    static String recombine(DataFragment[] dataFragments, int dstType) {
        // 在此补充你的代码
        List<DataFragment> dataFragmentlist = new ArrayList<>();
        StringBuilder res = new StringBuilder();
        for (DataFragment dataFragment : dataFragments) {
            if (dataFragment.dataType == dstType) {
                dataFragmentlist.add(dataFragment);
            }
        }
        Collections.sort(dataFragmentlist, (o1, o2) -> o1.index - o2.index);
        int start = 0;
        boolean success = true;
        boolean end = false;
        for (DataFragment dataFragment : dataFragmentlist) {
            if (dataFragment.index == start-1){
                continue;
            } else if(dataFragment.index == start){
                if (dataFragment.endFlag != 1){
                    res.append(dataFragment.data.substring(0,dataFragment.len));
                    start++;
                } else{
                    res.append(dataFragment.data.substring(0,dataFragment.len));
                    end =true;
                    break;
                }
            } else{
                success = false;
                break;
            }
        }
        return (success==true&&end==true)?res.toString():"NA";
    }
}

