package days;

import utils.DailyInput;

import java.util.List;

class DayNine extends DailyInput {

    public static void main(String[] args) {
        partOne(getLongList());
        partTwo(getLongList());
    }

    private static void partOne(List<Long> list) {
        for (int i = 25; i < list.size(); i++) {
            boolean isValid = false;

            for (int j = i - 25; j < i; j++) {
                for (int k = i - 24; k < i; k++) {
                    if (list.get(i) == list.get(j) + list.get(k)) {
                        isValid = true;
                        break;
                    }
                }
                if (isValid) {
                    break;
                }
            }
            if (!isValid) {
                System.out.println(list.get(i));
            }
        }
    }

    private static void partTwo(List<Long> list) {
        long min;
        long max = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            long acc = list.get(i);
            min = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (acc + list.get(j) < 1492208709) {
                    acc += list.get(j);
                } else if (acc + list.get(j) == 1492208709) {
                    for (int k = (int) min; k <= j; k++) {
                        max = Math.max(max, list.get(k));
                    }
                    System.out.println(list.get((int) min) + max);
                    return;
                } else {
                    break;
                }
            }
        }
    }
}
