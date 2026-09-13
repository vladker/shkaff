package p023d4;

import E3.g;
import G3.d;
import kotlin.jvm.internal.P;

/* JADX INFO: renamed from: d4.k0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0601k0 extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f3882a;
    public int b;
    public final /* synthetic */ C0604l0 c;
    public Object d;
    public InterfaceC0615p e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public P f3883f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0601k0(C0604l0 c0604l0, g gVar) {
        super(gVar);
        this.c = c0604l0;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.f3882a = obj;
        this.b |= Integer.MIN_VALUE;
        return this.c.collect(null, this);
    }
}
