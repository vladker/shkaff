package org.apache.xmlbeans.impl.common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class Mutex {
    private Thread owner = null;
    private int lock_count = 0;

    public synchronized void acquire() {
        while (!tryToAcquire()) {
            wait();
        }
    }

    public synchronized void release() {
        if (this.owner != Thread.currentThread()) {
            throw new IllegalStateException("Thread calling release() doesn't own mutex");
        }
        int i5 = this.lock_count - 1;
        this.lock_count = i5;
        if (i5 <= 0) {
            this.owner = null;
            notify();
        }
    }

    public synchronized boolean tryToAcquire() {
        Thread thread = this.owner;
        if (thread == null) {
            this.owner = Thread.currentThread();
            this.lock_count = 1;
            return true;
        }
        if (thread != Thread.currentThread()) {
            return false;
        }
        this.lock_count++;
        return true;
    }
}
