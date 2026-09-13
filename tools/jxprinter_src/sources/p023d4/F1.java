package p023d4;

import E3.g;
import G3.d;
import kotlin.jvm.internal.T;

/* JADX INFO: loaded from: classes3.dex */
public final class F1 extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f3796a;
    public int b;
    public final /* synthetic */ O1 c;
    public O1 d;
    public InterfaceC0615p e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public T f3797f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public F1(O1 o6, g gVar) {
        super(gVar);
        this.c = o6;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.f3796a = obj;
        this.b |= Integer.MIN_VALUE;
        return this.c.collect(null, this);
    }
}
