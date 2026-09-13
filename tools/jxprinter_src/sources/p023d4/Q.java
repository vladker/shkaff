package p023d4;

import E3.g;
import G3.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Q extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public S f3824a;
    public /* synthetic */ Object b;
    public final /* synthetic */ S c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Q(S s6, g gVar) {
        super(gVar);
        this.c = s6;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return this.c.emit(null, this);
    }
}
