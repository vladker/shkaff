package p023d4;

import E3.g;
import G3.d;

/* JADX INFO: loaded from: classes3.dex */
public final class C extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f3785a;
    public int b;
    public final /* synthetic */ C0641y c;
    public C0641y d;
    public InterfaceC0615p e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3786f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f3787g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C(C0641y c0641y, g gVar) {
        super(gVar);
        this.c = c0641y;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.f3785a = obj;
        this.b |= Integer.MIN_VALUE;
        return this.c.collect(null, this);
    }
}
