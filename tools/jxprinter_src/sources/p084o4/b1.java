package p084o4;

import kotlin.jvm.internal.E;
import p066l4.a;
import p078n4.f;
import p078n4.h;
import p147z3.D;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class b1 extends L0 {
    public static final b1 INSTANCE = new b1(a.serializer(D.Companion));

    /* JADX INFO: renamed from: collectionSize-GBYM_sE, reason: not valid java name */
    public int m1045collectionSizeGBYM_sE(byte[] collectionSize) {
        E.f(collectionSize, "$this$collectionSize");
        return collectionSize.length;
    }

    @Override // p084o4.AbstractC1297a
    public final /* bridge */ /* synthetic */ int d(Object obj) {
        return m1045collectionSizeGBYM_sE(((p147z3.E) obj).c());
    }

    @Override // p084o4.AbstractC1297a
    public final /* bridge */ /* synthetic */ Object e(Object obj) {
        return m1047toBuilderGBYM_sE(((p147z3.E) obj).c());
    }

    /* JADX INFO: renamed from: empty-TcUX1vc, reason: not valid java name */
    public byte[] m1046emptyTcUX1vc() {
        return p147z3.E.m1178constructorimpl(0);
    }

    @Override // p084o4.L0
    public final /* bridge */ /* synthetic */ Object h() {
        return p147z3.E.b(m1046emptyTcUX1vc());
    }

    /* JADX INFO: renamed from: toBuilder-GBYM_sE, reason: not valid java name */
    public a1 m1047toBuilderGBYM_sE(byte[] toBuilder) {
        E.f(toBuilder, "$this$toBuilder");
        return new a1(toBuilder);
    }

    @Override // p084o4.L0
    public final /* bridge */ /* synthetic */ void writeContent(h hVar, Object obj, int i5) {
        m1048writeContentCoi6ktg(hVar, ((p147z3.E) obj).c(), i5);
    }

    /* JADX INFO: renamed from: writeContent-Coi6ktg, reason: not valid java name */
    public void m1048writeContentCoi6ktg(h encoder, byte[] content, int i5) {
        E.f(encoder, "encoder");
        E.f(content, "content");
        for (int i6 = 0; i6 < i5; i6++) {
            encoder.encodeInlineElement(getDescriptor(), i6).f(D.m1131constructorimpl(content[i6]));
        }
    }

    @Override // p084o4.L0
    public void readElement(f decoder, int i5, a1 builder, boolean z6) {
        E.f(decoder, "decoder");
        E.f(builder, "builder");
        builder.e(D.m1131constructorimpl(decoder.decodeInlineElement(getDescriptor(), i5).b()));
    }
}
