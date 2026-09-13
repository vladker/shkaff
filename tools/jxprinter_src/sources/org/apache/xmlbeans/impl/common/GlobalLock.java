package org.apache.xmlbeans.impl.common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class GlobalLock {
    private static final Mutex GLOBAL_MUTEX = new Mutex();

    public static void acquire() {
        GLOBAL_MUTEX.acquire();
    }

    public static void release() {
        GLOBAL_MUTEX.release();
    }

    public static void tryToAcquire() {
        GLOBAL_MUTEX.tryToAcquire();
    }
}
