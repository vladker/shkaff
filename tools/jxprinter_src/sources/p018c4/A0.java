package p018c4;

import G3.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class A0 extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f1102a;
    public int b;

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.f1102a = obj;
        this.b |= Integer.MIN_VALUE;
        return z0.receiveOrNull(null, this);
    }
}
