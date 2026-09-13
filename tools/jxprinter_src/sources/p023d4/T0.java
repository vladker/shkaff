package p023d4;

import E3.g;
import G3.d;

/* JADX INFO: loaded from: classes3.dex */
public final class T0 extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f3831a;
    public int b;
    public InterfaceC0615p c;
    public final /* synthetic */ P0 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public T0(P0 p1, g gVar) {
        super(gVar);
        this.d = p1;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.f3831a = obj;
        this.b |= Integer.MIN_VALUE;
        return this.d.emit(null, this);
    }
}
