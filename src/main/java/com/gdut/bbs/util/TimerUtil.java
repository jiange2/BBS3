package com.gdut.bbs.util;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimerUtil {

    private static ScheduledExecutorService service = Executors
            .newSingleThreadScheduledExecutor();

    public static void addTask(Runnable runnable,int delay){
        service.schedule(runnable,delay, TimeUnit.MILLISECONDS);
    }
}
