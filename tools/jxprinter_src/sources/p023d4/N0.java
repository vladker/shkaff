package p023d4;

import E3.g;
import G3.d;

/* JADX INFO: loaded from: classes3.dex */
public final class N0 extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f3816a;
    public int b;
    public final /* synthetic */ C0616p0 c;
    public P0 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public N0(C0616p0 c0616p0, g gVar) {
        super(gVar);
        this.c = c0616p0;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.f3816a = obj;
        this.b |= Integer.MIN_VALUE;
        return this.c.collect(null, this);
    }
}
