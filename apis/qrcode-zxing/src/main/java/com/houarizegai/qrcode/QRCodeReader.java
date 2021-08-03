package com.houarizegai.qrcode;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class QRCodeReader {
    private static final String QRCODE_IMAGE_INPUT_PATH = "E:\\QRTest.jpg";

    public static void main(String[] args) {
        File file = new File(QRCODE_IMAGE_INPUT_PATH);

        String decodedText = decodeQRCode(file);

        if(decodedText != null) {
            System.out.println("Decoded text: " + decodedText);
        } else {
            System.out.println("There is no QR code in the image!");
        }
    }

    private static String decodeQRCode(File qrCodeimage) {
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(qrCodeimage);
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }

        LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

        try {
            Result result = new MultiFormatReader().decode(bitmap);
            return result.getText();
        } catch (NotFoundException nfe) {
            System.out.println("There is no QR code in the image!");
            return null;
        }
    }
}
