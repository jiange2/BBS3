package com.gdut.bbs.util;

import org.junit.Test;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FileUtil {

    public static String saveImg(CommonsMultipartFile file,String contextPath){
        String fileName = file.getOriginalFilename();
        File destFile = new File(contextPath+"temp/"+fileName);
        String resultPath = "";
        InputStream fis = null;
        OutputStream fos = null;
        try {
            fis = file.getInputStream();
            fos = new FileOutputStream(destFile);
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] buffer = new byte[10240];
            int length = -1;
            while ((length = fis.read(buffer, 0, 10240)) != -1) {
                fos.write(buffer,0,length);
                md.update(buffer, 0, length);
            }
            BigInteger bigInt = new BigInteger(1, md.digest());
            String md5Code = bigInt.toString(16);
            String mvContextPath = "imgs/"+md5Code.substring(0,4)+"/"
                    +md5Code.substring(4,8)+"/"+
                    md5Code.substring(8,12)+"/"+md5Code.substring(12,16)+"/";
            resultPath = mvContextPath + md5Code.substring(28) +
                    fileName.substring(fileName.lastIndexOf('.'));
            File mvDestDir = new File(contextPath+ mvContextPath);
            mvDestDir.mkdirs();
            File mvDestFile = new File(contextPath + resultPath);
            fis.close();
            fos.flush();
            fos.close();
            destFile.renameTo(mvDestFile);
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(resultPath);
        return resultPath;
    }

    @Test
    public void test(){
        File file = new File("C:\\IDEA project\\BBS3\\target\\BBS-1.0-SNAPSHOT\\temp\\yzm.jpg");
        File file2 = new File("C:\\IDEA project\\BBS3\\target\\BBS-1.0-SNAPSHOT\\img\\1803\\b5e7\\b3da\\570f\\1803b5e7b3da570f01d28c78269d0804.jpg");
        file.renameTo(file2);
    }
}
