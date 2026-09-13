package p134x2;

import F3.i;
import G3.d;
import p147z3.u;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class B extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public E f8845a;
    public boolean b;
    public /* synthetic */ Object c;
    public final /* synthetic */ E d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B(E e, d dVar) {
        super(dVar);
        this.d = e;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.c = obj;
        this.e |= Integer.MIN_VALUE;
        Object objM = this.d.m(false, this);
        return objM == i.getCOROUTINE_SUSPENDED() ? objM : u.a(objM);
    }
}
