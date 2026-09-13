package cn.fly.tools.utils;

import cn.fly.tools.proguard.EverythingKeeper;

/* JADX INFO: loaded from: classes.dex */
public interface IExecutor extends EverythingKeeper {
    <T extends ExecutorDispatcher.SafeRunnable> void executeDelayed(T t6, long j6);

    <T extends ExecutorDispatcher.SafeRunnable> void executeDuctile(T t6);

    <T extends ExecutorDispatcher.SafeRunnable> void executeImmediately(T t6);

    <T extends ExecutorDispatcher.SafeRunnable> void executeSerial(T t6);
}
