package p023d4;

import E3.g;
import G3.d;

/* JADX INFO: loaded from: classes3.dex */
public final class A extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f3775a;
    public int b;
    public final /* synthetic */ C0623s c;
    public InterfaceC0615p d;
    public long[] e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3776f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f3777g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public A(C0623s c0623s, g gVar) {
        super(gVar);
        this.c = c0623s;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.f3775a = obj;
        this.b |= Integer.MIN_VALUE;
        return this.c.collect(null, this);
    }
}
