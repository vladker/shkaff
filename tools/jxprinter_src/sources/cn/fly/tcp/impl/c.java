package cn.fly.tcp.impl;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public class c implements Future<e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final CountDownLatch f1551a = new CountDownLatch(1);
    final AtomicReference<e> b = new AtomicReference<>();

    @Override // java.util.concurrent.Future
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public e get() throws InterruptedException {
        this.f1551a.await();
        return this.b.get();
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z6) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.f1551a.getCount() == 0;
    }

    @Override // java.util.concurrent.Future
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public e get(long j6, TimeUnit timeUnit) throws TimeoutException {
        if (this.f1551a.await(j6, timeUnit)) {
            return this.b.get();
        }
        throw new TimeoutException("tcp get msg timeout");
    }

    public void a(e eVar) {
        synchronized (this.f1551a) {
            this.b.set(eVar);
            this.f1551a.countDown();
        }
    }
}
