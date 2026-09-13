package cn.fly.tools.utils;

import android.os.SystemClock;
import android.text.TextUtils;
import cn.fly.commons.C0396r;
import cn.fly.commons.n;
import cn.fly.tools.FlyLog;
import cn.fly.tools.proguard.PublicMemberKeeper;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;

/* JADX INFO: loaded from: classes.dex */
public class FileLocker implements PublicMemberKeeper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RandomAccessFile f1882a;
    private FileLock b;
    private FileChannel c;
    private volatile boolean d = false;

    private boolean a(boolean z6) {
        if (z6) {
            this.b = this.c.lock();
        } else {
            this.b = this.c.tryLock();
        }
        return this.b != null;
    }

    public synchronized boolean lock(boolean z6) {
        return lock(z6, z6 ? 1000L : 500L, 16L);
    }

    public synchronized void release() {
        if (this.d && this.f1882a == null && this.c == null && this.b == null) {
            return;
        }
        try {
            unlock();
            a();
            this.d = true;
        } catch (Throwable th) {
            a();
            this.d = true;
            throw th;
        }
    }

    public synchronized void setLockFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        release();
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(str, n.a("002*bhde"));
            this.f1882a = randomAccessFile;
            this.c = randomAccessFile.getChannel();
            this.d = false;
        } catch (Throwable th) {
            a();
            FlyLog.getInstance().w(th);
        }
    }

    public synchronized void unlock() {
        FileLock fileLock = this.b;
        if (fileLock == null) {
            return;
        }
        try {
            fileLock.release();
        } catch (Throwable th) {
            try {
                FlyLog.getInstance().w(th);
            } catch (Throwable th2) {
                this.b = null;
                throw th2;
            }
        }
        this.b = null;
    }

    public synchronized boolean lock(boolean z6, long j6, long j7) {
        boolean zA;
        try {
            if (this.d) {
                return false;
            }
            if (this.f1882a == null) {
                return false;
            }
            try {
                return a(z6);
            } catch (Throwable th) {
                if (j6 <= 0 || !((th instanceof OverlappingFileLockException) || (th instanceof IOException))) {
                    FlyLog.getInstance().w(th);
                } else {
                    long jElapsedRealtime = SystemClock.elapsedRealtime() + j6;
                    while (true) {
                        if (j6 <= 0 || this.d) {
                            zA = false;
                            break;
                        }
                        try {
                            Thread.sleep(j7);
                        } catch (Throwable unused) {
                        }
                        try {
                            j6 = jElapsedRealtime - SystemClock.elapsedRealtime();
                            zA = a(z6);
                            break;
                        } catch (Throwable th2) {
                            if (!(th2 instanceof OverlappingFileLockException) && !(th2 instanceof IOException)) {
                                FlyLog.getInstance().w(th);
                                j6 = -1;
                            } else if (j6 <= 0) {
                                FlyLog.getInstance().w("OverlappingFileLockException or IOExcept timeout");
                            }
                        }
                    }
                    if (j6 > 0) {
                        return zA;
                    }
                }
                FileLock fileLock = this.b;
                if (fileLock != null) {
                    try {
                        fileLock.release();
                    } catch (Throwable unused2) {
                    }
                    this.b = null;
                }
                a();
                return false;
            }
        } catch (Throwable th3) {
            throw th3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a() {
        try {
            C0396r.a(this.f1882a);
        } catch (Throwable th) {
            try {
                FlyLog.getInstance().w(th);
            } finally {
                this.c = null;
                this.f1882a = null;
            }
        }
    }

    public synchronized void lock(Runnable runnable, boolean z6) {
        if (runnable != null) {
            if (lock(z6)) {
                runnable.run();
            }
        }
    }
}
