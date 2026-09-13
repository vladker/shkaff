package p023d4;

import E3.g;
import G3.d;

/* JADX INFO: renamed from: d4.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0600k extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f3881a;
    public final /* synthetic */ C0603l b;
    public int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0600k(C0603l c0603l, g gVar) {
        super(gVar);
        this.b = c0603l;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.f3881a = obj;
        this.c |= Integer.MIN_VALUE;
        return this.b.emit(null, this);
    }
}
