package p084o4;

import kotlin.jvm.internal.C;
import kotlin.jvm.internal.E;
import p060k4.b;
import p066l4.a;
import p072m4.r;
import p078n4.j;
import p078n4.l;
import p147z3.G;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class f1 implements b {
    public static final f1 INSTANCE = new f1();
    private static final r descriptor = W.InlinePrimitiveDescriptor("kotlin.UInt", a.serializer(C.INSTANCE));

    @Override // p060k4.b, p060k4.a
    public final /* bridge */ /* synthetic */ Object deserialize(j jVar) {
        return G.a(m1056deserializeOGnWXxg(jVar));
    }

    /* JADX INFO: renamed from: deserialize-OGnWXxg, reason: not valid java name */
    public int m1056deserializeOGnWXxg(j decoder) {
        E.f(decoder, "decoder");
        return G.m1188constructorimpl(decoder.decodeInline(getDescriptor()).f());
    }

    @Override // p060k4.b, p060k4.m, p060k4.a
    public r getDescriptor() {
        return descriptor;
    }

    @Override // p060k4.b, p060k4.m
    public final /* synthetic */ void serialize(l lVar, Object obj) {
        m1057serializeQn1smSk(lVar, ((G) obj).f9124a);
    }

    /* JADX INFO: renamed from: serialize-Qn1smSk, reason: not valid java name */
    public void m1057serializeQn1smSk(l encoder, int i5) {
        E.f(encoder, "encoder");
        encoder.encodeInline(getDescriptor()).c(i5);
    }
}
