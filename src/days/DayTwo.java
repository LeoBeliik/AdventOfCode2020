package days;

import utils.DailyInput;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class DayTwo extends DailyInput {

    private static final Pattern pattern = Pattern.compile("(\\d+)-(\\d+) (\\w): (\\w+)");

    public static void main(String[] args) {
        partOne(getStringList());
        partTwo(getStringList());
    }

    private static void partOne(List<String> input) {
        int total = 0;
        for (String s : input) {
            Matcher matcher = pattern.matcher(s);
            while (matcher.find()) {
                if (matcher.group(4).contains(matcher.group(3))) {
                    int charCount = 0;
                    for (char c : matcher.group(4).toCharArray()) {
                        if (c == matcher.group(3).charAt(0)) {
                            charCount++;
                        }
                    }
                    if (charCount >= Integer.parseInt(matcher.group(1)) && charCount <= Integer.parseInt(matcher.group(2))) {
                        total++;
                    }
                }
            }
        }
        System.out.println(total);
    }

    private static void partTwo(List<String> list) {
        int total = 0;
        for (String s : list) {
            Matcher matcher = pattern.matcher(s);
            while (matcher.find()) {
                if (matcher.group(4).charAt(Integer.parseInt(matcher.group(1)) - 1) == matcher.group(3).charAt(0) ^ matcher.group(4).charAt(Integer.parseInt(matcher.group(2)) - 1) == matcher.group(3).charAt(0)) {
                    total++;
                }
            }
        }
        System.out.println(total);
    }
}
