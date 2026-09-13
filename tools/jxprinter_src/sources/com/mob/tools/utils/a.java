package com.mob.tools.utils;

/* JADX INFO: loaded from: classes3.dex */
public interface a {
    <T extends ExecutorDispatcher.SafeRunnable> void executeDelayed(T t6, long j6);

    <T extends ExecutorDispatcher.SafeRunnable> void executeDuctile(T t6);

    <T extends ExecutorDispatcher.SafeRunnable> void executeImmediately(T t6);

    <T extends ExecutorDispatcher.SafeRunnable> void executeSerial(T t6);
}
