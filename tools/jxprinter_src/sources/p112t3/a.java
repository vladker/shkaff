package p112t3;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import p011b3.c;
import p100r3.p;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements c {
    public boolean d;
    public final p b = new p();
    public final p c = new p();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CountDownLatch f8658a = new CountDownLatch(1);

    public final a await() throws InterruptedException {
        CountDownLatch countDownLatch = this.f8658a;
        if (countDownLatch.getCount() == 0) {
            return this;
        }
        countDownLatch.await();
        return this;
    }

    public final boolean await(long j6, TimeUnit timeUnit) {
        CountDownLatch countDownLatch = this.f8658a;
        return countDownLatch.getCount() == 0 || countDownLatch.await(j6, timeUnit);
    }
}
