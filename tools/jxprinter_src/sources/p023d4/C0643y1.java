package p023d4;

import E3.g;
import G3.d;

/* JADX INFO: renamed from: d4.y1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0643y1 extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f3929a;
    public int b;
    public final /* synthetic */ P0 c;
    public Object d;
    public InterfaceC0615p e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0643y1(P0 p1, g gVar) {
        super(gVar);
        this.c = p1;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.f3929a = obj;
        this.b |= Integer.MIN_VALUE;
        return this.c.emit(null, this);
    }
}
