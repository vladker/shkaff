package p039g3;

import io.reactivex.A;
import p027e3.a;
import p027e3.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class q implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f4002a;

    public q(g gVar) {
        this.f4002a = gVar;
    }

    @Override // p027e3.a
    public void run() {
        this.f4002a.accept(A.createOnComplete());
    }
}
