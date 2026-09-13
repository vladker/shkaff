package p028e4;

import E3.q;
import p007a4.M;

/* JADX INFO: renamed from: e4.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0650d implements M {
    private final q coroutineContext;

    public C0650d(q qVar) {
        this.coroutineContext = qVar;
    }

    @Override // p007a4.M
    public q getCoroutineContext() {
        return this.coroutineContext;
    }

    public String toString() {
        return "CoroutineScope(coroutineContext=" + getCoroutineContext() + ')';
    }
}
