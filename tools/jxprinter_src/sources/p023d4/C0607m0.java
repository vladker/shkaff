package p023d4;

import E3.g;
import G3.d;

/* JADX INFO: renamed from: d4.m0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0607m0 extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f3889a;
    public final /* synthetic */ C0610n0 b;
    public int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0607m0(C0610n0 c0610n0, g gVar) {
        super(gVar);
        this.b = c0610n0;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.f3889a = obj;
        this.c |= Integer.MIN_VALUE;
        return this.b.emit(null, this);
    }
}
