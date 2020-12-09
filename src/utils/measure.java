package utils;

class measure {

    public static void main(String[] args) {
        int time;
        int avr = 0;
        int max = -1;
        for (int i = 0; i < 10000; i++) {
            long startTime = System.nanoTime();
    //TODO
            long stopTime = System.nanoTime();
            time = (int) (stopTime - startTime) / 100;
            System.out.println("Try: " + i + "\n  Took: " + time + " millis");
            avr = avr + time;
            max = Math.max(max, time);
        }
        System.out.println("Average = " + avr / 100);
        System.out.println("Max = " + max);
    }

    /*
     * Average = 33575 Average = 34237 Average = 32097
     * Max = 353388 Max = 355081 Max = 341412
     *
     * Average = 33611 Average = 33082 Average = 33396
     * Max = 325009 Max = 314397 Max = 305251
     * */
}
