package utils;

import java.util.Random;

public class RandomUtils {

    public static int randInt(int min, int max) {

        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    public static String getRandomMonth() {
        String[] listOfMonth = {
                "January",
                "February",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December"
        };
        return listOfMonth[randInt(0, 11)];
    }

    public static String getRandomDay() {
        return String.valueOf(randInt(1, 28));
    }

    public static String getRandomSubject() {
        String[] hobbies = {"Maths", "Chemistry", "Commerce", "Economics"};
        return hobbies[randInt(0, 3)];
    }

    public static String getRandomHobby() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        return hobbies[randInt(0, 2)];
    }
}
