package days;

import utils.DailyInput;

import java.util.*;

public class Day10 extends DailyInput {
    private static Map<String, Long> cache = new HashMap<>();

    public static void main(String[] args) {
        List<Long> list = getLongList();
        list.sort(Comparator.naturalOrder());
        partOne(list);
        System.out.println(partTwo(list) * 2);
    }

    private static void partOne(List<Long> list) {
        long prevAdapter = 0;
        int countOne = 0;
        int countThree = 0;

        for (Long adapter : list) {
            if (adapter - prevAdapter == 1) {
                countOne++;
            } else if (adapter - prevAdapter == 3) {
                countThree++;
            }
            prevAdapter = adapter;
        }

        System.out.println(countOne * (countThree + 1));
    }

    public static long partTwo(List<Long> list) {

        if (list.size() == 1) {
            return 1;
        }

        long total = 0;
        int i = 1;
        long current = list.get(0);

        while (list.size() > i && list.get(i) - current < 4) {

            List<Long> subList = list.subList(i, list.size());
            String subArray = Arrays.toString(subList.toArray());

            if (cache.containsKey(subArray)) {
                total += cache.get(subArray);
            } else {
                long subTotal = partTwo(subList);
                cache.put(subArray, subTotal);
                total += subTotal;
            }

            i++;
        }

        return total;
    }
}
