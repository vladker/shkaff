package p084o4;

import kotlin.jvm.internal.E;
import p066l4.a;
import p078n4.f;
import p078n4.h;
import p147z3.G;
import p147z3.H;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class e1 extends L0 {
    public static final e1 INSTANCE = new e1(a.serializer(G.Companion));

    /* JADX INFO: renamed from: collectionSize--ajY-9A, reason: not valid java name */
    public int m1052collectionSizeajY9A(int[] collectionSize) {
        E.f(collectionSize, "$this$collectionSize");
        return collectionSize.length;
    }

    @Override // p084o4.AbstractC1297a
    public final /* bridge */ /* synthetic */ int d(Object obj) {
        return m1052collectionSizeajY9A(((H) obj).c());
    }

    @Override // p084o4.AbstractC1297a
    public final /* bridge */ /* synthetic */ Object e(Object obj) {
        return m1054toBuilderajY9A(((H) obj).c());
    }

    /* JADX INFO: renamed from: empty--hP7Qyg, reason: not valid java name */
    public int[] m1053emptyhP7Qyg() {
        return H.m1237constructorimpl(0);
    }

    @Override // p084o4.L0
    public final /* bridge */ /* synthetic */ Object h() {
        return H.b(m1053emptyhP7Qyg());
    }

    /* JADX INFO: renamed from: toBuilder--ajY-9A, reason: not valid java name */
    public d1 m1054toBuilderajY9A(int[] toBuilder) {
        E.f(toBuilder, "$this$toBuilder");
        return new d1(toBuilder);
    }

    @Override // p084o4.L0
    public final /* bridge */ /* synthetic */ void writeContent(h hVar, Object obj, int i5) {
        m1055writeContentCPlH8fI(hVar, ((H) obj).c(), i5);
    }

    /* JADX INFO: renamed from: writeContent-CPlH8fI, reason: not valid java name */
    public void m1055writeContentCPlH8fI(h encoder, int[] content, int i5) {
        E.f(encoder, "encoder");
        E.f(content, "content");
        for (int i6 = 0; i6 < i5; i6++) {
            encoder.encodeInlineElement(getDescriptor(), i6).c(G.m1188constructorimpl(content[i6]));
        }
    }

    @Override // p084o4.L0
    public void readElement(f decoder, int i5, d1 builder, boolean z6) {
        E.f(decoder, "decoder");
        E.f(builder, "builder");
        builder.e(G.m1188constructorimpl(decoder.decodeInlineElement(getDescriptor(), i5).f()));
    }
}
