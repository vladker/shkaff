package p084o4;

import kotlin.jvm.internal.C;
import kotlin.jvm.internal.E;
import p066l4.a;
import p078n4.f;
import p078n4.h;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Y extends L0 {
    public static final Y INSTANCE = new Y(a.serializer(C.INSTANCE));

    @Override // p084o4.AbstractC1297a
    /* JADX INFO: renamed from: collectionSize, reason: merged with bridge method [inline-methods] */
    public int d(int[] iArr) {
        E.f(iArr, "<this>");
        return iArr.length;
    }

    @Override // p084o4.L0
    /* JADX INFO: renamed from: empty, reason: merged with bridge method [inline-methods] */
    public int[] h() {
        return new int[0];
    }

    @Override // p084o4.AbstractC1297a
    /* JADX INFO: renamed from: toBuilder, reason: merged with bridge method [inline-methods] */
    public X e(int[] iArr) {
        E.f(iArr, "<this>");
        return new X(iArr);
    }

    @Override // p084o4.L0
    public void writeContent(h encoder, int[] content, int i5) {
        E.f(encoder, "encoder");
        E.f(content, "content");
        for (int i6 = 0; i6 < i5; i6++) {
            encoder.encodeIntElement(getDescriptor(), i6, content[i6]);
        }
    }

    @Override // p084o4.L0
    public void readElement(f decoder, int i5, X builder, boolean z6) {
        E.f(decoder, "decoder");
        E.f(builder, "builder");
        builder.e(decoder.decodeIntElement(getDescriptor(), i5));
    }
}
