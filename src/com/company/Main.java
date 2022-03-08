package com.company;

import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {
	    Main main = new Main();
        main.enableTimeUpdates(60);
    }
    private void enableTimeUpdates(int updateEveryXSeconds) {
        boolean isDone = false;
        while (!isDone) {
            System.out.println(theTimeIsNow());
            try { Thread.sleep(updateEveryXSeconds * 1000L); } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
    private String theTimeIsNow(){
        String returnString = "The time is now: ";
        LocalTime now = LocalTime.now();
        returnString += numberToText(now.getHour()) + " ";
        returnString += numberToText(now.getMinute());
        return returnString;
    }
    private String numberToText(int number) {
        String[] belowTwenty = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
        String[] aboveTwenty = { "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };
        String returnString;
        if (number < 20) {
            returnString = belowTwenty[number];
        }
        else {
            int decaDigit = number / 10;
            returnString = aboveTwenty[decaDigit-2];
            int singleDigit = number % 10;
            if (singleDigit > 0) {
                returnString += belowTwenty[singleDigit];
            }
        }
        return returnString;
    }
}
