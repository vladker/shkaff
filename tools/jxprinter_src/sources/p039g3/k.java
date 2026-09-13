package p039g3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import p027e3.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class k implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Future f3997a;

    public k(Future future) {
        this.f3997a = future;
    }

    @Override // p027e3.a
    public void run() throws ExecutionException, InterruptedException {
        this.f3997a.get();
    }
}
