package p077n3;

import io.reactivex.S;
import p033f3.d;
import p094q3.c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class U extends c implements S {
    private static final long serialVersionUID = 187782011903685568L;
    public p011b3.c c;

    @Override // p094q3.c, t5.d
    public final void cancel() {
        super.cancel();
        this.c.dispose();
    }

    @Override // io.reactivex.S
    public final void onError(Throwable th) {
        this.f7842a.onError(th);
    }

    @Override // io.reactivex.S
    public final void onSubscribe(p011b3.c cVar) {
        if (d.g(this.c, cVar)) {
            this.c = cVar;
            this.f7842a.onSubscribe(this);
        }
    }
}
