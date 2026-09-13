package p023d4;

import E3.g;
import G3.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class u2 extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f3917a;
    public final /* synthetic */ v2 b;
    public int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u2(v2 v2Var, g gVar) {
        super(gVar);
        this.b = v2Var;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.f3917a = obj;
        this.c |= Integer.MIN_VALUE;
        return this.b.collect(null, this);
    }
}
