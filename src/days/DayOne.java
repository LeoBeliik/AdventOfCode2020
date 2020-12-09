package days;

import utils.DailyInput;

import java.util.List;

class DayOne extends DailyInput {

    public static void main(String[] args) {
        partOne(getIntegerList());
        partTwo(getIntegerList());
    }

    private static void partOne(List<Integer> list) {
        list.stream().filter(k -> list.contains(2020 - k)).findFirst().ifPresent(k -> System.out.println("part One: " + (k * 2020 - k)));
    }

    private static void partTwo(List<Integer> list) {
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
