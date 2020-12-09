package days;

import utils.DailyInput;

import java.util.ArrayList;
import java.util.List;

class DayFour extends DailyInput {

    private static final String[] validators = {"ecl:", "pid:", "eyr:", "hcl:", "byr:", "iyr:", "hgt:"};
    private static final String[] eyeColor = {"amb", "blu", "brn", "gry", "grn", "hzl", "oth"};
    private static final List<String> documents = new ArrayList<>();

    public static void main(String[] args) {
        partOne(getStringList());
        partTwo();
    }

    private static void partOne(List<String> list) {
        StringBuilder doc = new StringBuilder();
        int validDocs = 0;

        for (String data : list) {
            if (!data.equals("")) {
                doc.append(data).append(" ");
            } else {
                int validFields = 0;
                for (String validator : validators) {
                    if (doc.toString().contains(validator)) {
                        validFields++;
                    }
                }
                if (validFields == 7) {
                    documents.add(doc.toString());
                    validDocs++;
                }
                doc = new StringBuilder();
            }
        }
        System.out.println("Valid docs: " + validDocs);
    }

    private static void partTwo() {
        int validDocs = 0;
        for (String document : documents) {
            int valid = 0;
            for (String s : document.split(" ")) {
                String data = s.substring(s.indexOf(":") + 1);
                for (int i = 0; i < validators.length; i++) {
                    String validator = validators[i];
                    if (s.contains(validator)) {
                        switch (i) {
                            case 0:
                                for (String s1 : eyeColor) {
                                    if (data.contains(s1)) {
                                        valid++;
                                        break;
                                    }
                                }
                                break;
                            case 1:
                                if (data.matches("[0-9]{9}")) {
                                    valid++;
                                }
                                break;
                            case 2:
                                if (Integer.parseInt(data) >= 2020 && Integer.parseInt(data) <= 2030) {
                                    valid++;
                                }
                                break;
                            case 3:
                                if (data.matches("#(\\w){6}")) {
                                    valid++;
                                }
                                break;
                            case 4:
                                if (Integer.parseInt(data) >= 1920 && Integer.parseInt(data) <= 2002) {
                                    valid++;
                                }
                                break;
                            case 5:
                                if (Integer.parseInt(data) >= 2010 && Integer.parseInt(data) <= 2020) {
                                    valid++;
                                }
                                break;
                            case 6:
                                if (data.contains("cm")) {
                                    if (Integer.parseInt(data.replaceAll("cm", "")) >= 150 && Integer.parseInt(data.replaceAll("cm", "")) <= 193) {
                                        valid++;
                                    }
                                } else if (data.contains("in")) {
                                    if (Integer.parseInt(data.replaceAll("in", "")) >= 59 && Integer.parseInt(data.replaceAll("in", "")) <= 76) {
                                        valid++;
                                    }
                                }
                                break;
                        }

                    }
                }
            }
            if (valid == 7) {
                validDocs++;
            }
        }
        System.out.println(validDocs);
    }
}
