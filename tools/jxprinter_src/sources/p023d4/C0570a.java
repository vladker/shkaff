package p023d4;

import E3.g;
import G3.d;
import kotlinx.coroutines.flow.internal.F;

/* JADX INFO: renamed from: d4.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0570a extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public F f3847a;
    public /* synthetic */ Object b;
    public final /* synthetic */ AbstractC0573b c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0570a(AbstractC0573b abstractC0573b, g gVar) {
        super(gVar);
        this.c = abstractC0573b;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return this.c.collect(null, this);
    }
}
