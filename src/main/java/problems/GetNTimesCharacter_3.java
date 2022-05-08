package problems; /**
 * @ClassName: problems.GetNTimesCharacter_3
 * @Description: 3. 公共字符
 * @Author: Zuo
 * @Date 2022/4/16
 * @Version 1.0
 */

import java.nio.charset.StandardCharsets;
import java.util.*;


public class GetNTimesCharacter_3 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int nValue = cin.nextInt();
        int mValue = cin.nextInt();
        cin.nextLine();
        String[] strings = new String[mValue];
        for (int i = 0; i < mValue; i++) {
            strings[i] = cin.nextLine();
        }
        cin.close();

        char[] results = getNTimesCharacter(nValue, strings);

        System.out.print("[");
        for (int i = 0; i < results.length; i++) {
            if (i == 0) {
                System.out.print(results[i]);
            } else {
                System.out.print(" " + results[i]);
            }
        }
        System.out.print("]");
    }

    // 待实现函数，在此函数中填入答题代码
    public static char[] getNTimesCharacter(int nValue, String[] strings) {
        Set<Character> result = new HashSet<>();
        for (int i = 0; i < strings[0].length(); i++) {
            result.add(strings[0].charAt(i));
        }
        Iterator<Character> iter = result.iterator();
        while (iter.hasNext()) {
            Character c = iter.next();
            for (int j = 0; j < strings.length; j++) {
                if (countTimes(c, strings[j]) < nValue) {
                    iter.remove();
                    break;
                }
            }
        }
        char[] res = new char[result.size()];
        int index = 0;
        for (Character c : result) {
            res[index] = c;
            index++;
        }
        Arrays.sort(res);
        return res;
    }

    private static int countTimes(Character c, String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c)
                count++;
        }
        return count;
    }

}

