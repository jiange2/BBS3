package com.gdut.bbs.util;


import java.io.*;
import java.util.Date;

public class LogUtil {

    private static String defaultPath;
    private static Writer defaultWriter;


    static {
        defaultPath = LogUtil.class.getResource("/log/default.log").getPath().replaceAll("%20"," ");
    }

    public static void newLog(){
        try {
            defaultWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(defaultPath)));
            defaultWriter.write("----------------"+new Date()+"---------------------\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void log(String str){
        if (defaultWriter == null){
            newLog();
        }
        try {
            defaultWriter.write(str+"\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void endLog(){
        if(defaultWriter != null){
            try {
                defaultWriter.flush();
                defaultWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
