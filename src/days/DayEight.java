package days;

import utils.DailyInput;

import java.util.ArrayList;
import java.util.List;

class DayEight extends DailyInput {

    public static void main(String[] args) {
        partOne(getStringList(), false);
        partTwo(getStringList());
    }

    private static void partOne(List<String> list, boolean fromP2) {
        int acc = 0;
        List<Integer> index = new ArrayList<>();

        for (int i = 0, listSize = list.size(); i < listSize; i++) {
            String[] op = list.get(i).split(" ");

            if (index.contains(i)) {
                if (!fromP2) {
                    System.out.println(acc);
                }
                return;
            }

            index.add(i);

            if (op[0].equals("acc")) {
                acc += Integer.parseInt(op[1]);
            } else if (op[0].equals("jmp")) {
                i += Integer.parseInt(op[1]) - 1;
            }
        }
        System.out.println(acc);
    }

    private static void partTwo(List<String> list) {
        for (int i = 0, listSize = list.size(); i < listSize; i++) {
            String[] op = list.get(i).split(" ");
            if (op[0].equals("jmp")) {
                list.set(i, "nop " + op[1]);
                partOne(list, true);
                list.set(i, "jmp " + op[1]);
            } else if (op[0].equals("nop")) {
                list.set(i, "jmp " + op[1]);
                partOne(list, true);
                list.set(i, "nop " + op[1]);
            }
        }
    }
}
