package p023d4;

import E3.g;
import G3.d;

/* JADX INFO: loaded from: classes3.dex */
public final class A0 extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f3778a;
    public int b;
    public final /* synthetic */ B0 c;
    public B0 d;
    public InterfaceC0615p e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Throwable f3779f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f3780g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public A0(B0 b1, g gVar) {
        super(gVar);
        this.c = b1;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.f3778a = obj;
        this.b |= Integer.MIN_VALUE;
        return this.c.collect(null, this);
    }
}
