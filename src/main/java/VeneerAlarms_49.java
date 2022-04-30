import java.util.*;

/**
 * @ClassName: VeneerAlarms_49
 * @Author: Zuo
 * @Date 2022/4/30
 * @Version 1.0
 */
public class VeneerAlarms_49 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arr1Len = Integer.parseInt(scanner.nextLine());
        String[] arr1=null, arr2=null;
        String s1 = scanner.nextLine();
        if(arr1Len!=0){
            arr1 = s1.split(" ");
        }
        int arr2Len = Integer.parseInt(scanner.nextLine());
        if (arr2Len != 0) {
            String s2 = scanner.nextLine();
            arr2 = s2.split(" ");
        }
        ArrayList<String> res = getVeneerAlarms(arr1, arr2);
        Collections.sort(res, (o1, o2) -> {
            if(Long.parseLong(o1,16) - Long.parseLong(o2,16)>0L)
                return 1;
            else
                return -1;
        });
        StringBuilder result = new StringBuilder();
        result.append("[");
        result.append(String.join(" ",res));
        result.append("]");
        System.out.println(result.toString());
        scanner.close();
    }

    private static ArrayList<String> getVeneerAlarms(String[] arr1, String[] arr2) {
        ArrayList<String> result = new ArrayList<>();
        if (arr1 != null) {
            for (String s : arr1) {
                if(!result.contains(s)){
                    result.add(s);
                }
            }
        }
        if (arr2 != null) {
            for (String s : arr2) {
                if(!result.contains(s)){
                    result.add(s);
                }
            }
        }
        return result;
    }

}
