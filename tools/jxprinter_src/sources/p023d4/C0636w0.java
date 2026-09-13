package p023d4;

import E3.g;
import G3.d;

/* JADX INFO: renamed from: d4.w0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0636w0 extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f3920a;
    public int b;
    public final /* synthetic */ C0627t0 c;
    public C0627t0 d;
    public InterfaceC0615p e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0636w0(C0627t0 c0627t0, g gVar) {
        super(gVar);
        this.c = c0627t0;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.f3920a = obj;
        this.b |= Integer.MIN_VALUE;
        return this.c.collect(null, this);
    }
}
