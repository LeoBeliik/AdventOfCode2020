package days;

import utils.dailyInput;

import java.util.List;
import java.util.Set;

public class DayOne extends dailyInput {

    public static void main(String[] args) {
        partOne(getIntegerList());
        partTwo(getIntegerList());
    }

    public static void partOne(List<Integer> list) {
        list.stream().filter(k -> list.contains(2020 - k)).findFirst().ifPresent(k -> System.out.println("part One: " + (k * 2020 - k)));
    }

    public static void partTwo(List<Integer> list) {
        for (int k : list) {
            for (int j : list) {
                if (list.contains(2020 - (k + j))) {
                    System.out.println("Part two: " + (k * j * (2020 - (k + j))));
                    return;
                }
            }
        }
    }
}
