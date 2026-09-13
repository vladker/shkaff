package p023d4;

import E3.g;
import G3.d;

/* JADX INFO: loaded from: classes3.dex */
public final class Q0 extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public R0 f3825a;
    public /* synthetic */ Object b;
    public int c;
    public final /* synthetic */ R0 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Q0(R0 r6, g gVar) {
        super(gVar);
        this.d = r6;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.c |= Integer.MIN_VALUE;
        return this.d.emit(null, this);
    }
}
