package com.gdut.bbs.util;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class verificationTest {

    @Test
    public void test() throws IOException {
        String str = VerifyUtil.getVerificationString(4);
        System.out.println(str);
        BufferedImage img = VerifyUtil.getVerificationImage(str);
        ImageIO.write(img,"jpg",new FileOutputStream("c://test/1.jpg"));
    }
}
