package days;

import utils.DailyInput;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DaySix extends DailyInput {

    public static void main(String[] args) {
        partOne(getStringList());
        partTwo(getStringList());
    }

    private static void partOne(List<String> list) {
        Set<Character> chars = new HashSet<>();
        int total = 0;
        for (String s : list) {
            if (!s.equals("")) {
                for (char c : s.toCharArray()) {
                    chars.add(c);
                }
            } else {
                total = total + chars.size();
                chars.clear();
            }
        }
        System.out.println(total);
    }

    private static void partTwo(List<String> input) {
        List<Character> group = new ArrayList<>();
        int total = 0;
        boolean first = true;

        for (String s : input) {
            if (!s.trim().isEmpty()) {
                if (first) {
                    for (char c : s.trim().toCharArray()) {
                        group.add(c);
                    }
                } else {
                    for (int i = group.size() - 1; i >= 0; i--) {
                        char c = group.get(i);
                        boolean contains = false;
                        for (char ch : s.trim().toCharArray()) {
                            if (ch == c) {
                                contains = true;
                                break;
                            }
                        }
                        if (!contains) {
                            group.remove(i);
                        }
                    }
                }
                first = false;
            } else {
                total = total + group.size();
                first = true;
                group.clear();
            }
        }
        System.out.println(total + group.size());
    }

}
