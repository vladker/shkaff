package p084o4;

import kotlin.jvm.internal.E;
import p066l4.a;
import p078n4.f;
import p078n4.h;
import p147z3.J;
import p147z3.K;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class h1 extends L0 {
    public static final h1 INSTANCE = new h1(a.serializer(J.Companion));

    /* JADX INFO: renamed from: collectionSize-QwZRm1k, reason: not valid java name */
    public int m1059collectionSizeQwZRm1k(long[] collectionSize) {
        E.f(collectionSize, "$this$collectionSize");
        return collectionSize.length;
    }

    @Override // p084o4.AbstractC1297a
    public final /* bridge */ /* synthetic */ int d(Object obj) {
        return m1059collectionSizeQwZRm1k(((K) obj).c());
    }

    @Override // p084o4.AbstractC1297a
    public final /* bridge */ /* synthetic */ Object e(Object obj) {
        return m1061toBuilderQwZRm1k(((K) obj).c());
    }

    /* JADX INFO: renamed from: empty-Y2RjT0g, reason: not valid java name */
    public long[] m1060emptyY2RjT0g() {
        return K.m1296constructorimpl(0);
    }

    @Override // p084o4.L0
    public final /* bridge */ /* synthetic */ Object h() {
        return K.b(m1060emptyY2RjT0g());
    }

    /* JADX INFO: renamed from: toBuilder-QwZRm1k, reason: not valid java name */
    public g1 m1061toBuilderQwZRm1k(long[] toBuilder) {
        E.f(toBuilder, "$this$toBuilder");
        return new g1(toBuilder);
    }

    @Override // p084o4.L0
    public final /* bridge */ /* synthetic */ void writeContent(h hVar, Object obj, int i5) {
        m1062writeContent0q3Fkuo(hVar, ((K) obj).c(), i5);
    }

    /* JADX INFO: renamed from: writeContent-0q3Fkuo, reason: not valid java name */
    public void m1062writeContent0q3Fkuo(h encoder, long[] content, int i5) {
        E.f(encoder, "encoder");
        E.f(content, "content");
        for (int i6 = 0; i6 < i5; i6++) {
            encoder.encodeInlineElement(getDescriptor(), i6).d(J.m1247constructorimpl(content[i6]));
        }
    }

    @Override // p084o4.L0
    public void readElement(f decoder, int i5, g1 builder, boolean z6) {
        E.f(decoder, "decoder");
        E.f(builder, "builder");
        builder.e(J.m1247constructorimpl(decoder.decodeInlineElement(getDescriptor(), i5).c()));
    }
}
