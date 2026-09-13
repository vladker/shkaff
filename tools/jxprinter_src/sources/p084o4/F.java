package p084o4;

import kotlin.jvm.internal.E;
import p060k4.b;
import p072m4.o;
import p072m4.r;
import p078n4.j;
import p078n4.l;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class F implements b {
    public static final F INSTANCE = new F();
    private static final r descriptor = new M0("kotlin.time.Duration", o.INSTANCE);

    @Override // p060k4.b, p060k4.a
    public final /* synthetic */ Object deserialize(j jVar) {
        return new Y3.b(m1042deserialize5sfh64U(jVar));
    }

    /* JADX INFO: renamed from: deserialize-5sfh64U, reason: not valid java name */
    public long m1042deserialize5sfh64U(j decoder) {
        E.f(decoder, "decoder");
        return Y3.b.Companion.m910parseIsoStringUwyO8pc(decoder.decodeString());
    }

    @Override // p060k4.b, p060k4.m, p060k4.a
    public r getDescriptor() {
        return descriptor;
    }

    @Override // p060k4.b, p060k4.m
    public final /* synthetic */ void serialize(l lVar, Object obj) {
        m1043serializeHG0u8IE(lVar, ((Y3.b) obj).f873a);
    }

    /* JADX INFO: renamed from: serialize-HG0u8IE, reason: not valid java name */
    public void m1043serializeHG0u8IE(l encoder, long j6) {
        E.f(encoder, "encoder");
        encoder.encodeString(Y3.b.m919toIsoStringimpl(j6));
    }
}
