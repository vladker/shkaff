package cn.fly.tools;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import cn.fly.tools.proguard.EverythingKeeper;

/* JADX INFO: loaded from: classes.dex */
public class FlyHandlerThread extends Thread implements EverythingKeeper {
    private Looper looper;
    private int priority;
    private int tid;

    public FlyHandlerThread() {
        this.tid = -1;
        this.priority = 0;
    }

    public static Handler newHandler(Handler.Callback callback) {
        return newHandler(null, null, callback);
    }

    public Looper getLooper() {
        if (!isAlive()) {
            return null;
        }
        synchronized (this) {
            while (isAlive() && this.looper == null) {
                wait();
            }
        }
        return this.looper;
    }

    public int getThreadId() {
        return this.tid;
    }

    public void onLooperPrepared() {
    }

    public boolean quit() {
        Looper looper = getLooper();
        if (looper == null) {
            return false;
        }
        looper.quit();
        return true;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            try {
                realRun();
                this.tid = Process.myTid();
                Looper.prepare();
                synchronized (this) {
                    this.looper = Looper.myLooper();
                    notifyAll();
                }
                Process.setThreadPriority(this.priority);
            } catch (Throwable th) {
                FlyLog.getInstance().d(th);
            }
            onLooperPrepared(this.looper);
            onLooperPrepared();
            Looper.loop();
            this.tid = -1;
        } catch (Throwable th2) {
            FlyLog.getInstance().d(th2);
        }
    }

    public static Handler newHandler(String str, Handler.Callback callback) {
        return newHandler(str, null, callback);
    }

    public void onLooperPrepared(Looper looper) {
    }

    public static Handler newHandler(Runnable runnable, Handler.Callback callback) {
        return newHandler(null, runnable, callback);
    }

    public FlyHandlerThread(int i5) {
        this.tid = -1;
        this.priority = i5;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0019 A[Catch: all -> 0x0010, LOOP:0: B:10:0x0015->B:12:0x0019, LOOP_END, TRY_LEAVE, TryCatch #0 {all -> 0x0010, blocks: (B:6:0x000c, B:9:0x0012, B:10:0x0015, B:12:0x0019), top: B:21:0x000c, outer: #1 }] */
    public static Handler newHandler(String str, final Runnable runnable, final Handler.Callback callback) {
        final Handler[] handlerArr = new Handler[1];
        FlyHandlerThread flyHandlerThread = new FlyHandlerThread() { // from class: cn.fly.tools.FlyHandlerThread.1
            @Override // cn.fly.tools.FlyHandlerThread
            public void onLooperPrepared(Looper looper) {
                synchronized (handlerArr) {
                    handlerArr[0] = new Handler(looper, callback);
                    handlerArr.notifyAll();
                }
            }

            @Override // cn.fly.tools.FlyHandlerThread, java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    Runnable runnable2 = runnable;
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                } catch (Throwable th) {
                    FlyLog.getInstance().d(th);
                }
                super.run();
            }
        };
        synchronized (handlerArr) {
            if (str != null) {
                try {
                    flyHandlerThread.setName(str);
                    flyHandlerThread.start();
                    while (handlerArr[0] == null) {
                        handlerArr.wait();
                    }
                } catch (Throwable th) {
                    FlyLog.getInstance().w(th);
                }
            } else {
                flyHandlerThread.start();
                while (handlerArr[0] == null) {
                    handlerArr.wait();
                }
            }
            throw th;
        }
        return handlerArr[0];
    }

    @Deprecated
    public void realRun() {
    }
}
