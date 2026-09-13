package p023d4;

import E3.g;
import G3.d;

/* JADX INFO: loaded from: classes3.dex */
public final class O0 extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public P0 f3819a;
    public /* synthetic */ Object b;
    public int c;
    public final /* synthetic */ P0 d;
    public Object e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public O0(P0 p1, g gVar) {
        super(gVar);
        this.d = p1;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.c |= Integer.MIN_VALUE;
        return this.d.emit(null, this);
    }
}
