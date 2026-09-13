package p084o4;

import kotlin.jvm.internal.E;
import kotlin.jvm.internal.G;
import p066l4.a;
import p078n4.f;
import p078n4.h;

/* JADX INFO: renamed from: o4.j0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1316j0 extends L0 {
    public static final C1316j0 INSTANCE = new C1316j0(a.serializer(G.INSTANCE));

    @Override // p084o4.AbstractC1297a
    /* JADX INFO: renamed from: collectionSize, reason: merged with bridge method [inline-methods] */
    public int d(long[] jArr) {
        E.f(jArr, "<this>");
        return jArr.length;
    }

    @Override // p084o4.L0
    /* JADX INFO: renamed from: empty, reason: merged with bridge method [inline-methods] */
    public long[] h() {
        return new long[0];
    }

    @Override // p084o4.AbstractC1297a
    /* JADX INFO: renamed from: toBuilder, reason: merged with bridge method [inline-methods] */
    public C1314i0 e(long[] jArr) {
        E.f(jArr, "<this>");
        return new C1314i0(jArr);
    }

    @Override // p084o4.L0
    public void writeContent(h encoder, long[] content, int i5) {
        E.f(encoder, "encoder");
        E.f(content, "content");
        for (int i6 = 0; i6 < i5; i6++) {
            encoder.encodeLongElement(getDescriptor(), i6, content[i6]);
        }
    }

    @Override // p084o4.L0
    public void readElement(f decoder, int i5, C1314i0 builder, boolean z6) {
        E.f(decoder, "decoder");
        E.f(builder, "builder");
        builder.e(decoder.decodeLongElement(getDescriptor(), i5));
    }
}
