package p007a4;

import E3.q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class y1 extends F {
    public static final y1 INSTANCE = new y1();

    @Override // p007a4.F
    /* JADX INFO: renamed from: dispatch */
    public void mo1035dispatch(q qVar, Runnable runnable) {
        D1 d1 = (D1) qVar.get(D1.Key);
        if (d1 == null) {
            throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
        }
        d1.dispatcherWasUnconfined = true;
    }

    @Override // p007a4.F
    public boolean isDispatchNeeded(q qVar) {
        return false;
    }

    @Override // p007a4.F
    public F limitedParallelism(int i5, String str) {
        throw new UnsupportedOperationException("limitedParallelism is not supported for Dispatchers.Unconfined");
    }

    @Override // p007a4.F
    public String toString() {
        return "Dispatchers.Unconfined";
    }
}
