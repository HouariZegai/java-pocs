package main.java.com.houarizegai.facedetection.imagetogray;

import main.java.com.houarizegai.facedetection.utils.Constants;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class ConvertToGray {
    public static void main(String[] args) {
        // load the OpenCV native library
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        // get the jpeg image from the internal resource folder
        Mat image = Imgcodecs.imread(Constants.RESOURCES_FOLDER + "avatar.png");

        // convert the image in gray scale
        Imgproc.cvtColor(image, image, Imgproc.COLOR_BGR2GRAY);

        // Write the new image on disk
        Imgcodecs.imwrite( Constants.RESOURCES_FOLDER + "\\avatar-gray.png", image);
        System.out.println("Done!");
    }
}