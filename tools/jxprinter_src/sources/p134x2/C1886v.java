package p134x2;

import E3.g;
import G3.d;
import p049i4.b;

/* JADX INFO: renamed from: x2.v, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1886v extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f8943a;
    public M0 b;
    public /* synthetic */ Object c;
    public final /* synthetic */ E d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1886v(E e, g gVar) {
        super(gVar);
        this.d = e;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        this.e |= Integer.MIN_VALUE;
        return this.d.disconnectDevice(this);
    }
}
