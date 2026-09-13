package p049i4;

import G3.d;
import O3.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class o extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f4074a;
    public a b;
    public /* synthetic */ Object c;
    public int d;

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        this.d |= Integer.MIN_VALUE;
        return p.withPermit(null, null, this);
    }
}
