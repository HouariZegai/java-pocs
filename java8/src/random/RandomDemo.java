package random;

public class RandomDemo {
    public static void main(String[] args) {
        // Generate no repeat random numbers
        int[] tableRandom = GenerateRandom.generateUniqueRandomNumbers(10);

        for(int item : tableRandom) {
            System.out.print(item + "\t");
        }
    }
}
