package p084o4;

import kotlin.jvm.internal.E;
import kotlin.jvm.internal.G;
import p060k4.b;
import p066l4.a;
import p072m4.r;
import p078n4.j;
import p078n4.l;
import p147z3.J;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class i1 implements b {
    public static final i1 INSTANCE = new i1();
    private static final r descriptor = W.InlinePrimitiveDescriptor("kotlin.ULong", a.serializer(G.INSTANCE));

    @Override // p060k4.b, p060k4.a
    public final /* bridge */ /* synthetic */ Object deserialize(j jVar) {
        return J.a(m1063deserializeI7RO_PI(jVar));
    }

    /* JADX INFO: renamed from: deserialize-I7RO_PI, reason: not valid java name */
    public long m1063deserializeI7RO_PI(j decoder) {
        E.f(decoder, "decoder");
        return J.m1247constructorimpl(decoder.decodeInline(getDescriptor()).c());
    }

    @Override // p060k4.b, p060k4.m, p060k4.a
    public r getDescriptor() {
        return descriptor;
    }

    @Override // p060k4.b, p060k4.m
    public final /* synthetic */ void serialize(l lVar, Object obj) {
        m1064serialize2TYgG_w(lVar, ((J) obj).f9126a);
    }

    /* JADX INFO: renamed from: serialize-2TYgG_w, reason: not valid java name */
    public void m1064serialize2TYgG_w(l encoder, long j6) {
        E.f(encoder, "encoder");
        encoder.encodeInline(getDescriptor()).d(j6);
    }
}
