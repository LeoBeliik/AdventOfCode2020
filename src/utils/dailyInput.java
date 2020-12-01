package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class dailyInput {

    private static final Path today = Path.of("src\\inputs\\" + "Day_" + LocalDate.EPOCH.getDayOfMonth() + ".txt");
    private static Set<String> todayList = new HashSet<>();

    public static void loadInput() {
        try {
            if (todayList.isEmpty()) {
                todayList = Files.readAllLines(today).stream().map(String::toString).collect(Collectors.toSet());
            }
        } catch (IOException e) {
            System.out.println("ERROR: can't read file.\n" + e);;
        }
    }


    protected static Set<Integer> getIntegerList() {
        loadInput();
        return todayList.stream().map(Integer::parseInt).collect(Collectors.toSet());
    }

    public static Set<String> getStringList() {
        loadInput();
        return todayList;
    }
}
