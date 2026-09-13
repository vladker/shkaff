package p023d4;

import E3.g;
import G3.d;

/* JADX INFO: renamed from: d4.i0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0595i0 extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f3876a;
    public int b;
    public final /* synthetic */ C0598j0 c;
    public Object d;
    public InterfaceC0615p e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0595i0(C0598j0 c0598j0, g gVar) {
        super(gVar);
        this.c = c0598j0;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.f3876a = obj;
        this.b |= Integer.MIN_VALUE;
        return this.c.collect(null, this);
    }
}
