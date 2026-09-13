package p023d4;

import E3.g;
import G3.d;

/* JADX INFO: renamed from: d4.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0585f extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f3868a;
    public final /* synthetic */ C0588g b;
    public int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0585f(C0588g c0588g, g gVar) {
        super(gVar);
        this.b = c0588g;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.f3868a = obj;
        this.c |= Integer.MIN_VALUE;
        return this.b.emit(null, this);
    }
}
