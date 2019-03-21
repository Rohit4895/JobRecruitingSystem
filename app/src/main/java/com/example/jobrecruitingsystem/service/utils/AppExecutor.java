package com.example.jobrecruitingsystem.service.utils;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppExecutor {
    private final Executor diskIo;
    private final Executor mainThread;

    private AppExecutor(Executor diskIo, Executor mainThread) {
        this.diskIo = diskIo;
        this.mainThread = mainThread;
    }

    private static AppExecutor appExecutorInstance = null;

    public static AppExecutor getInstance(){
        if (appExecutorInstance == null){
            appExecutorInstance = new AppExecutor(Executors.newFixedThreadPool(2),
                    new MainThreadExecutor());
        }
        return appExecutorInstance;
    }

    private static class MainThreadExecutor implements Executor{

        private Handler handler = new Handler(Looper.getMainLooper());

        @Override
        public void execute(Runnable command) {
            handler.post(command);
        }
    }

    public Executor getDiskIo(){
        return diskIo;
    }


    public Executor getMainThread(){
        return mainThread;
    }

}
