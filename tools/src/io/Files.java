package io;

import java.io.File;
import java.util.Scanner;

public class Files {

    public static void main(String[] args) {
        final String FILE_PATH = "C:\\Users\\Houari\\Desktop\\test.txt";

        String content = new Files().readStringFromFile(FILE_PATH);
        System.out.println(content);
    }

	private String readStringFromFile(String pathname) { // Read file and convert it to String
        try {
            File file = new File(pathname);

            StringBuilder fileContents = new StringBuilder((int) file.length());

            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    fileContents.append(scanner.nextLine() + System.lineSeparator());
                }
                return fileContents.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}