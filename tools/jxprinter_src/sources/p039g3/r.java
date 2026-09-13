package p039g3;

import io.reactivex.A;
import p027e3.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class r implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f4003a;

    public r(g gVar) {
        this.f4003a = gVar;
    }

    @Override // p027e3.g
    public void accept(Throwable th) {
        this.f4003a.accept(A.createOnError(th));
    }
}
