package days;

import utils.DailyInput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class DaySeven extends DailyInput {

    private static Map<String, List<Bags>> bagsMap;
    private static Map<String, Boolean> bagCache;

    public static void main(String[] args) {
        System.out.println(partOne(getStringList()));
        System.out.println(partTwo("shiny gold") - 1);
    }

    private static int partOne(List<String> input) {
        bagsMap = new HashMap<>();
        bagCache = new HashMap<>();
        for (String s : input) {

            String[] split1 = s.substring(0, s.length() - 1).split("bags contain");
            String outsideB = split1[0].trim();
            String[] insideB = split1[1].split(",");
            List<Bags> bags = new ArrayList<>();

            for (String internal : insideB) {

                internal = internal.replace("bags", "").replace("bag", "").trim();
                int index = internal.trim().indexOf(" ");
                String quantityStr = internal.substring(0, index);

                if (!quantityStr.equalsIgnoreCase("no")) {
                    Bags bag = new Bags();
                    bag.quantity = Integer.parseInt(quantityStr);
                    bag.bagName = internal.substring(index + 1);
                    bags.add(bag);
                }
            }

            bagsMap.put(outsideB, bags);
        }

        int count = 0;
        for (String bag : bagsMap.keySet()) {
            if (isGoldBag(bag)) {
                count++;
            }
        }

        return count;
    }

    private static boolean isGoldBag(String bag) {
        if (bagCache.containsKey(bag))
            return bagCache.get(bag);

        for (Bags subBag : bagsMap.get(bag)) {
            if (subBag.bagName.equalsIgnoreCase("shiny gold")) {
                bagCache.put(bag, true);
                return true;
            }
        }

        for (Bags subBag : bagsMap.get(bag)) {
            if (isGoldBag(subBag.bagName)) {
                bagCache.put(bag, true);
                return true;
            }
        }

        bagCache.put(bag, false);
        return false;
    }

    private static int partTwo(String bag) {
        return 1 + bagsMap.get(bag).stream().mapToInt(bagInfo -> (bagInfo.quantity * partTwo(bagInfo.bagName))).sum();
    }

    static class Bags {
        int quantity;
        String bagName;
    }
}