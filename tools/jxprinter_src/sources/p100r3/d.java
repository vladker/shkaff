package p100r3;

import java.util.concurrent.CountDownLatch;
import p027e3.a;
import p027e3.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends CountDownLatch implements g, a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Throwable f7959a;

    @Override // p027e3.g
    public void accept(Object obj) {
        this.f7959a = (Throwable) obj;
        countDown();
    }

    @Override // p027e3.a
    public final void run() {
        countDown();
    }
}
