package p007a4;

import G3.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Z extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f950a;
    public int b;

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.f950a = obj;
        this.b |= Integer.MIN_VALUE;
        return AbstractC0261a0.awaitCancellation(this);
    }
}
