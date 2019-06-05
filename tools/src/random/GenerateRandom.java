package random;

import java.util.Random;

public class GenerateRandom {

    public static int[] generateUniqueRandomNumbers(int tableLength) { // This function generate table of random unique (no repeat numbers)
        int[] tableNumbers = new int[tableLength];
        for(int i = 0; i < tableLength; i++)
            tableNumbers[i] = i;


        int[] result = new int[tableLength];

        Random random = new Random();
        int counter = tableLength;

        for(int i = 0; i < tableLength; i++) {
            int index = random.nextInt(counter);
            result[i] = tableNumbers[index];
            tableNumbers[index] = tableNumbers[--counter];
        }

        return result;
    }
}
