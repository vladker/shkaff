package p084o4;

import kotlin.jvm.internal.E;
import kotlin.jvm.internal.W;
import p066l4.a;
import p078n4.f;
import p078n4.h;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class T0 extends L0 {
    public static final T0 INSTANCE = new T0(a.serializer(W.INSTANCE));

    @Override // p084o4.AbstractC1297a
    /* JADX INFO: renamed from: collectionSize, reason: merged with bridge method [inline-methods] */
    public int d(short[] sArr) {
        E.f(sArr, "<this>");
        return sArr.length;
    }

    @Override // p084o4.L0
    /* JADX INFO: renamed from: empty, reason: merged with bridge method [inline-methods] */
    public short[] h() {
        return new short[0];
    }

    @Override // p084o4.AbstractC1297a
    /* JADX INFO: renamed from: toBuilder, reason: merged with bridge method [inline-methods] */
    public S0 e(short[] sArr) {
        E.f(sArr, "<this>");
        return new S0(sArr);
    }

    @Override // p084o4.L0
    public void writeContent(h encoder, short[] content, int i5) {
        E.f(encoder, "encoder");
        E.f(content, "content");
        for (int i6 = 0; i6 < i5; i6++) {
            encoder.encodeShortElement(getDescriptor(), i6, content[i6]);
        }
    }

    @Override // p084o4.L0
    public void readElement(f decoder, int i5, S0 builder, boolean z6) {
        E.f(decoder, "decoder");
        E.f(builder, "builder");
        builder.e(decoder.decodeShortElement(getDescriptor(), i5));
    }
}
