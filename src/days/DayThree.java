package days;

import utils.DailyInput;

import java.util.List;

public class DayThree extends DailyInput {
    public static void main(String[] args) {
        System.out.println(partOne(3, 1));
        partTwo();
    }

    private static long partOne(int slopeX, int slopeY) {
        List<String> list = getStringList();
        int totalTrees = 0;
        for (int i = slopeY, j = slopeX; i < list.size(); i = i + slopeY, j = j + slopeX) {
            char[] chars = list.get(i).toCharArray();
            if (j >= chars.length) {
                j = j - chars.length;
            }
            if (chars[j] == '#') {
                totalTrees++;
            }
        }
        return totalTrees;
    }

    private static void partTwo() {
        System.out.println(partOne(1, 1) *
                partOne(3, 1) *
                partOne(5, 1) *
                partOne(7, 1) *
                partOne(1, 2));
    }
}