package p084o4;

import kotlin.jvm.internal.C1100n;
import kotlin.jvm.internal.E;
import p060k4.b;
import p066l4.a;
import p072m4.r;
import p078n4.j;
import p078n4.l;
import p147z3.D;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class c1 implements b {
    public static final c1 INSTANCE = new c1();
    private static final r descriptor = W.InlinePrimitiveDescriptor("kotlin.UByte", a.serializer(C1100n.INSTANCE));

    @Override // p060k4.b, p060k4.a
    public final /* bridge */ /* synthetic */ Object deserialize(j jVar) {
        return D.a(m1049deserializeWa3L5BU(jVar));
    }

    /* JADX INFO: renamed from: deserialize-Wa3L5BU, reason: not valid java name */
    public byte m1049deserializeWa3L5BU(j decoder) {
        E.f(decoder, "decoder");
        return D.m1131constructorimpl(decoder.decodeInline(getDescriptor()).b());
    }

    @Override // p060k4.b, p060k4.m, p060k4.a
    public r getDescriptor() {
        return descriptor;
    }

    @Override // p060k4.b, p060k4.m
    public final /* synthetic */ void serialize(l lVar, Object obj) {
        m1050serializeEK6454(lVar, ((D) obj).f9122a);
    }

    /* JADX INFO: renamed from: serialize-EK-6454, reason: not valid java name */
    public void m1050serializeEK6454(l encoder, byte b) {
        E.f(encoder, "encoder");
        encoder.encodeInline(getDescriptor()).f(b);
    }
}
