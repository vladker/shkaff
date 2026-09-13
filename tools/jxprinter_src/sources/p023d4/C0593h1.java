package p023d4;

import E3.g;
import G3.d;

/* JADX INFO: renamed from: d4.h1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0593h1 extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C0584e1 f3874a;
    public /* synthetic */ Object b;
    public int c;
    public final /* synthetic */ C0584e1 d;
    public Object e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0593h1(C0584e1 c0584e1, g gVar) {
        super(gVar);
        this.d = c0584e1;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.c |= Integer.MIN_VALUE;
        return this.d.emit(null, this);
    }
}
