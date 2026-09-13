package p023d4;

import E3.g;
import G3.d;
import p018c4.x0;

/* JADX INFO: renamed from: d4.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0576c extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public x0 f3859a;
    public /* synthetic */ Object b;
    public final /* synthetic */ C0579d c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0576c(C0579d c0579d, g gVar) {
        super(gVar);
        this.c = c0579d;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return this.c.collectTo(null, this);
    }
}
