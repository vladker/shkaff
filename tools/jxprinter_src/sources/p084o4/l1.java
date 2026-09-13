package p084o4;

import kotlin.jvm.internal.E;
import kotlin.jvm.internal.W;
import p060k4.b;
import p066l4.a;
import p072m4.r;
import p078n4.j;
import p078n4.l;
import p147z3.N;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class l1 implements b {
    public static final l1 INSTANCE = new l1();
    private static final r descriptor = W.InlinePrimitiveDescriptor("kotlin.UShort", a.serializer(W.INSTANCE));

    @Override // p060k4.b, p060k4.a
    public final /* bridge */ /* synthetic */ Object deserialize(j jVar) {
        return N.a(m1070deserializeBwKQO78(jVar));
    }

    /* JADX INFO: renamed from: deserialize-BwKQO78, reason: not valid java name */
    public short m1070deserializeBwKQO78(j decoder) {
        E.f(decoder, "decoder");
        return N.m1306constructorimpl(decoder.decodeInline(getDescriptor()).d());
    }

    @Override // p060k4.b, p060k4.m, p060k4.a
    public r getDescriptor() {
        return descriptor;
    }

    @Override // p060k4.b, p060k4.m
    public final /* synthetic */ void serialize(l lVar, Object obj) {
        m1071serializei8woANY(lVar, ((N) obj).f9128a);
    }

    /* JADX INFO: renamed from: serialize-i8woANY, reason: not valid java name */
    public void m1071serializei8woANY(l encoder, short s6) {
        E.f(encoder, "encoder");
        encoder.encodeInline(getDescriptor()).a(s6);
    }
}
