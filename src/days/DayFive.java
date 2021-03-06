package days;

import utils.DailyInput;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

class DayFive extends DailyInput {

    private static final Set<Integer> seats = new HashSet<>();

    public static void main(String[] args) {
        partOne(getStringList());
        partTwo();
    }

    private static void partOne(List<String> list) {
        int[] seat = new int[8];
        int max = 0;
        for (String s : list) {
            s = s.replaceAll("[F|L]", "0").replaceAll("[B|R]", "1");
            max = Math.max(max, Integer.parseInt(s, 2));
            seats.add(Integer.parseInt(s, 2)); //for Part Two
        }
        System.out.println(max);
    }

    private static void partTwo() {
        IntStream.iterate(seats.size(), i -> i > 1, i -> i - 1)
                .filter(i -> !seats.contains(i))
                .findFirst()
                .ifPresent(System.out::println);
    }
}
