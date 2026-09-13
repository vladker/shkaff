package p023d4;

import E3.g;
import G3.d;

/* JADX INFO: loaded from: classes3.dex */
public final class B1 extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f3784a;
    public int b;
    public final /* synthetic */ C0588g c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B1(C0588g c0588g, g gVar) {
        super(gVar);
        this.c = c0588g;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.f3784a = obj;
        this.b |= Integer.MIN_VALUE;
        return this.c.emit(null, this);
    }
}
