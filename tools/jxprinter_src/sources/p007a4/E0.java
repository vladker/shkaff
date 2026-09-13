package p007a4;

import O3.l;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class E0 extends O0 {
    private final l handler;

    public E0(l lVar) {
        this.handler = lVar;
    }

    @Override // p007a4.O0
    public final boolean d() {
        return false;
    }

    @Override // p007a4.O0
    public void invoke(Throwable th) {
        this.handler.invoke(th);
    }
}
