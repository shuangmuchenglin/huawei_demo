package problems; /**
 * @ClassName: problems.GetNormalDeviceNum_7
 * @Description: 7。设备编号
 * @Author: Zuo
 * @Date 2022/4/16
 * @Version 1.0
 */

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class GetNormalDeviceNum_7 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int start = cin.nextInt();
        int end = cin.nextInt();
        cin.close();

        System.out.println(getNormalDeviceNum(start, end));
    }

    // 待实现函数，在此函数中填入答题代码
    public static int getNormalDeviceNum(int start, int end) {
        int result = end - start + 1;
        for (int i = start; i <= end; i++) {
            if (Integer.toString(i).lastIndexOf("4") >= 0 || Integer.toString(i).lastIndexOf("18") >= 0) {
                result--;
            }
        }
        return result;
    }
}

