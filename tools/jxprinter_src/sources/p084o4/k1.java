package p084o4;

import kotlin.jvm.internal.E;
import p066l4.a;
import p078n4.f;
import p078n4.h;
import p147z3.N;
import p147z3.O;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class k1 extends L0 {
    public static final k1 INSTANCE = new k1(a.serializer(N.Companion));

    /* JADX INFO: renamed from: collectionSize-rL5Bavg, reason: not valid java name */
    public int m1066collectionSizerL5Bavg(short[] collectionSize) {
        E.f(collectionSize, "$this$collectionSize");
        return collectionSize.length;
    }

    @Override // p084o4.AbstractC1297a
    public final /* bridge */ /* synthetic */ int d(Object obj) {
        return m1066collectionSizerL5Bavg(((O) obj).c());
    }

    @Override // p084o4.AbstractC1297a
    public final /* bridge */ /* synthetic */ Object e(Object obj) {
        return m1068toBuilderrL5Bavg(((O) obj).c());
    }

    /* JADX INFO: renamed from: empty-amswpOA, reason: not valid java name */
    public short[] m1067emptyamswpOA() {
        return O.m1353constructorimpl(0);
    }

    @Override // p084o4.L0
    public final /* bridge */ /* synthetic */ Object h() {
        return O.b(m1067emptyamswpOA());
    }

    /* JADX INFO: renamed from: toBuilder-rL5Bavg, reason: not valid java name */
    public j1 m1068toBuilderrL5Bavg(short[] toBuilder) {
        E.f(toBuilder, "$this$toBuilder");
        return new j1(toBuilder);
    }

    @Override // p084o4.L0
    public final /* bridge */ /* synthetic */ void writeContent(h hVar, Object obj, int i5) {
        m1069writeContenteny0XGE(hVar, ((O) obj).c(), i5);
    }

    /* JADX INFO: renamed from: writeContent-eny0XGE, reason: not valid java name */
    public void m1069writeContenteny0XGE(h encoder, short[] content, int i5) {
        E.f(encoder, "encoder");
        E.f(content, "content");
        for (int i6 = 0; i6 < i5; i6++) {
            encoder.encodeInlineElement(getDescriptor(), i6).a(N.m1306constructorimpl(content[i6]));
        }
    }

    @Override // p084o4.L0
    public void readElement(f decoder, int i5, j1 builder, boolean z6) {
        E.f(decoder, "decoder");
        E.f(builder, "builder");
        builder.e(N.m1306constructorimpl(decoder.decodeInlineElement(getDescriptor(), i5).d()));
    }
}
