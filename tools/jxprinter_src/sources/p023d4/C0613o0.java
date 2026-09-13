package p023d4;

import E3.g;
import G3.d;
import kotlinx.coroutines.flow.internal.F;

/* JADX INFO: renamed from: d4.o0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0613o0 extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f3894a;
    public int b;
    public final /* synthetic */ C0616p0 c;
    public C0616p0 d;
    public InterfaceC0615p e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public F f3895f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0613o0(C0616p0 c0616p0, g gVar) {
        super(gVar);
        this.c = c0616p0;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.f3894a = obj;
        this.b |= Integer.MIN_VALUE;
        return this.c.collect(null, this);
    }
}
