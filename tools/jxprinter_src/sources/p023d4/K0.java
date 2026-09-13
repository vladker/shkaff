package p023d4;

import E3.g;
import G3.d;

/* JADX INFO: loaded from: classes3.dex */
public final class K0 extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f3810a;
    public int b;
    public final /* synthetic */ F0 c;
    public Object d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public K0(F0 f1, g gVar) {
        super(gVar);
        this.c = f1;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.f3810a = obj;
        this.b |= Integer.MIN_VALUE;
        return this.c.collect(null, this);
    }
}
