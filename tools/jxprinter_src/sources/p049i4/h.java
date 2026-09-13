package p049i4;

import G3.d;
import O3.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class h extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f4069a;
    public Object b;
    public a c;
    public /* synthetic */ Object d;
    public int e;

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.d = obj;
        this.e |= Integer.MIN_VALUE;
        return i.withLock(null, null, null, this);
    }
}
