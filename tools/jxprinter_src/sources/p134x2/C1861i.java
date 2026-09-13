package p134x2;

import G3.d;

/* JADX INFO: renamed from: x2.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1861i extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public E f8904a;
    public boolean b;
    public /* synthetic */ Object c;
    public final /* synthetic */ E d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1861i(E e, d dVar) {
        super(dVar);
        this.d = e;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        this.e |= Integer.MIN_VALUE;
        return this.d.j(false, this);
    }
}
