package p134x2;

import E3.g;
import G3.d;

/* JADX INFO: renamed from: x2.b0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1848b0 extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public K0 f8892a;
    public /* synthetic */ Object b;
    public final /* synthetic */ K0 c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1848b0(K0 k6, g gVar) {
        super(gVar);
        this.c = k6;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return this.c.close(this);
    }
}
