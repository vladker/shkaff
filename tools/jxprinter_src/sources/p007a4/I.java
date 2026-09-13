package p007a4;

import E3.a;
import E3.q;
import O3.p;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class I extends a implements H {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f941a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public I(p pVar, G g6) {
        super(g6);
        this.f941a = pVar;
    }

    @Override // p007a4.H
    public final void handleException(q qVar, Throwable th) {
        this.f941a.invoke(qVar, th);
    }
}
