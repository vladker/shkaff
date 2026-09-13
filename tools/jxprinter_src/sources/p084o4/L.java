package p084o4;

import kotlin.jvm.internal.C1109x;
import kotlin.jvm.internal.E;
import p066l4.a;
import p078n4.f;
import p078n4.h;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class L extends L0 {
    public static final L INSTANCE = new L(a.serializer(C1109x.INSTANCE));

    @Override // p084o4.AbstractC1297a
    /* JADX INFO: renamed from: collectionSize, reason: merged with bridge method [inline-methods] */
    public int d(float[] fArr) {
        E.f(fArr, "<this>");
        return fArr.length;
    }

    @Override // p084o4.L0
    /* JADX INFO: renamed from: empty, reason: merged with bridge method [inline-methods] */
    public float[] h() {
        return new float[0];
    }

    @Override // p084o4.AbstractC1297a
    /* JADX INFO: renamed from: toBuilder, reason: merged with bridge method [inline-methods] */
    public K e(float[] fArr) {
        E.f(fArr, "<this>");
        return new K(fArr);
    }

    @Override // p084o4.L0
    public void writeContent(h encoder, float[] content, int i5) {
        E.f(encoder, "encoder");
        E.f(content, "content");
        for (int i6 = 0; i6 < i5; i6++) {
            encoder.encodeFloatElement(getDescriptor(), i6, content[i6]);
        }
    }

    @Override // p084o4.L0
    public void readElement(f decoder, int i5, K builder, boolean z6) {
        E.f(decoder, "decoder");
        E.f(builder, "builder");
        builder.e(decoder.decodeFloatElement(getDescriptor(), i5));
    }
}
