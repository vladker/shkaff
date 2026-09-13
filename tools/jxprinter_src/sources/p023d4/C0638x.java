package p023d4;

import E3.g;
import G3.d;

/* JADX INFO: renamed from: d4.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0638x extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f3922a;
    public int b;
    public final /* synthetic */ C0641y c;
    public InterfaceC0615p d;
    public Object[] e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3923f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f3924g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0638x(C0641y c0641y, g gVar) {
        super(gVar);
        this.c = c0641y;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.f3922a = obj;
        this.b |= Integer.MIN_VALUE;
        return this.c.collect(null, this);
    }
}
