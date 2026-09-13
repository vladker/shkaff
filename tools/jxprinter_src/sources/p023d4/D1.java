package p023d4;

import E3.g;
import G3.d;

/* JADX INFO: loaded from: classes3.dex */
public final class D1 extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f3790a;
    public int b;
    public final /* synthetic */ P0 c;
    public InterfaceC0615p d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public D1(P0 p1, g gVar) {
        super(gVar);
        this.c = p1;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.f3790a = obj;
        this.b |= Integer.MIN_VALUE;
        return this.c.emit(null, this);
    }
}
