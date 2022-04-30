/**
 * @ClassName: FreeOrder_25
 * @Author: Zuo
 * @Date 2022/4/26
 * @Version 1.0
 */

import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * OJ考题代码：促销活动
 *
 * @author 命题组
 * @since 2021-01-30
 */

public class FreeOrder_25 {
    /**
     * main入口由OJ平台调用
     */
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int row = cin.nextInt();
        cin.nextLine();
        String[] orderTime = new String[row];
        for (int i = 0; i < row; i++) {
            orderTime[i] = cin.nextLine();
        }
        cin.close();
        int result = freeOrder(orderTime);
        System.out.print(result);
    }

    // 待实现函数，在此函数中填入答题代码
    private static int freeOrder(String[] orderTime) {
        int res = 1;
        if(orderTime.length==1) {
            return res;
        }
        Arrays.sort(orderTime);
        String ignoreMilltime=orderTime[0].substring(0,19);
        String totalTime=orderTime[0];
        for (int i = 1;i<orderTime.length;i++) {
            if(totalTime.equals(orderTime[i])){
                res++;
                continue;
            }
            if(!orderTime[i].substring(0,19).equals(ignoreMilltime)){
                res++;
                ignoreMilltime = orderTime[i].substring(0,19);
                totalTime = orderTime[i];
            }
        }
        return res;
    }
}

