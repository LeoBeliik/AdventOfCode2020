package days;

import utils.DailyInput;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DayFive extends DailyInput {

    private static Set<Integer> seats = new HashSet<>();

    public static void main(String[] args) {
        partOne(getStringList());
        partTwo();
    }

    private static void partOne(List<String> list) {
        int[] seat = new int[8];
        int max = 0;
        for (String s : list) {
            s = s.replaceAll("[F|L]", "0");
            s = s.replaceAll("[B|R]", "1");
            max = Math.max(max, Integer.parseInt(s, 2));
            seats.add(Integer.parseInt(s, 2)); //for Part Two
        }
        System.out.println(max);
    }

    private static void partTwo() {
        int myId = 0;
        for (int i = 0; i < seats.size(); i++) {
            if (!seats.contains(i))
                myId = i;
        }
        System.out.println(myId);
    }
}
