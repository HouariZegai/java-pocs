package dz.teletic.springfiledownloadclient.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.function.BiConsumer;

/**
 * @author HouariZegai, created on 22/12/2020
 */
public class FileUtils {

    public static BiConsumer<byte[], String> extractAndSaveToFolder = (data, path) -> {
        try {
            ZipHelper.unzip(data, path);
        } catch (IOException e) {
            System.out.println("Unzip exception: " + e.getMessage());
            e.printStackTrace();
        }
    };

    public static BiConsumer<byte[], String> saveToFile = (data, path) -> {
        try {
            File file = new File(path);

            OutputStream os = new FileOutputStream(file);
            os.write(data);
            os.close();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    };
}
