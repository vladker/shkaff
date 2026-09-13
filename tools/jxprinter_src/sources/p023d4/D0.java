package p023d4;

import G3.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class D0 extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public G f3789a;
    public /* synthetic */ Object b;
    public int c;

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.c |= Integer.MIN_VALUE;
        return S0.collectWhile(null, null, this);
    }
}
