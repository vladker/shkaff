package p023d4;

import E3.g;
import G3.d;
import kotlinx.coroutines.flow.internal.F;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class s2 extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public t2 f3911a;
    public F b;
    public /* synthetic */ Object c;
    public final /* synthetic */ t2 d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s2(t2 t2Var, g gVar) {
        super(gVar);
        this.d = t2Var;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        this.e |= Integer.MIN_VALUE;
        return this.d.onSubscription(this);
    }
}
