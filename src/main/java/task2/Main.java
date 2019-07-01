package task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(8554);
        list.add(-2324);
        list.add(3829507);

        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(7);

        Map<Integer, Integer> countDigits = getCountOfEntries(list, list2);
        for (int key : countDigits.keySet()) {
            System.out.print("Key: " + key);
            System.out.println(", Count: " + countDigits.get(key));
        }

    }

    public static Map<Integer, Integer> getCountOfEntries(List<Integer> integerList, List<Integer> digitsList) {
        Map<Integer, Integer> resultMap = new HashMap<>();

        for (int item : digitsList) {
            resultMap.put(item, 0);
        }

        for (int item : integerList) {

            item = Math.abs(item);
            while (item != 0) {
                int lastDigit = item % 10;
                item -= lastDigit;
                item /= 10;

                if (resultMap.containsKey(lastDigit)) {
                    resultMap.put(lastDigit, resultMap.get(lastDigit) + 1);
                }
            }

        }

        return resultMap;
    }
}
