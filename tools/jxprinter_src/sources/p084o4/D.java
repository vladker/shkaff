package p084o4;

import kotlin.jvm.internal.C1108w;
import kotlin.jvm.internal.E;
import p066l4.a;
import p078n4.f;
import p078n4.h;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class D extends L0 {
    public static final D INSTANCE = new D(a.serializer(C1108w.INSTANCE));

    @Override // p084o4.AbstractC1297a
    /* JADX INFO: renamed from: collectionSize, reason: merged with bridge method [inline-methods] */
    public int d(double[] dArr) {
        E.f(dArr, "<this>");
        return dArr.length;
    }

    @Override // p084o4.L0
    /* JADX INFO: renamed from: empty, reason: merged with bridge method [inline-methods] */
    public double[] h() {
        return new double[0];
    }

    @Override // p084o4.AbstractC1297a
    /* JADX INFO: renamed from: toBuilder, reason: merged with bridge method [inline-methods] */
    public C e(double[] dArr) {
        E.f(dArr, "<this>");
        return new C(dArr);
    }

    @Override // p084o4.L0
    public void writeContent(h encoder, double[] content, int i5) {
        E.f(encoder, "encoder");
        E.f(content, "content");
        for (int i6 = 0; i6 < i5; i6++) {
            encoder.encodeDoubleElement(getDescriptor(), i6, content[i6]);
        }
    }

    @Override // p084o4.L0
    public void readElement(f decoder, int i5, C builder, boolean z6) {
        E.f(decoder, "decoder");
        E.f(builder, "builder");
        builder.e(decoder.decodeDoubleElement(getDescriptor(), i5));
    }
}
