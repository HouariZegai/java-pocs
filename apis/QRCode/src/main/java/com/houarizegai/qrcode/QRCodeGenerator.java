package com.houarizegai.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.sun.corba.se.impl.orbutil.ObjectUtility;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class QRCodeGenerator {
    private static final String QRCODE_IMAGE_OUTPUT_PATH = "E:\\QRTest.jpg";

    public static void main(String[] args) {
        String data = "Hello, my name is Houari ZEGAI!";
        int size = 300;

        qrCodeGen(data, size, QRCODE_IMAGE_OUTPUT_PATH);
        System.out.println("Done!");
    }

    private static void qrCodeGen(String data, int size, String outputPath) {
        // encode
        BitMatrix bitMatrix = generateMatrix(data, size);

        // write in a file
        writeImage(QRCODE_IMAGE_OUTPUT_PATH, "png", bitMatrix);
    }

    private static BitMatrix generateMatrix(String data, int size) {
        try {
            BitMatrix bitMatrix = new QRCodeWriter().encode(data, BarcodeFormat.QR_CODE, size, size);
            return bitMatrix;
        } catch(WriterException we) {
            we.printStackTrace();
            return null;
        }
    }

    private static void writeImage(String outputFileName, String imageFormat, BitMatrix bitMatrix)  {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(outputFileName));
            MatrixToImageWriter.writeToStream(bitMatrix, imageFormat, fileOutputStream);
            fileOutputStream.close();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
