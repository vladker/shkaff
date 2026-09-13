package p023d4;

import E3.g;
import G3.d;
import kotlin.jvm.internal.T;

/* JADX INFO: renamed from: d4.w1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0637w1 extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f3921a;
    public int b;
    public final /* synthetic */ F0 c;
    public InterfaceC0615p d;
    public T e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0637w1(F0 f1, g gVar) {
        super(gVar);
        this.c = f1;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.f3921a = obj;
        this.b |= Integer.MIN_VALUE;
        return this.c.collect(null, this);
    }
}
