package p084o4;

import kotlin.jvm.internal.C1100n;
import kotlin.jvm.internal.E;
import p066l4.a;
import p078n4.f;
import p078n4.h;

/* JADX INFO: renamed from: o4.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1317k extends L0 {
    public static final C1317k INSTANCE = new C1317k(a.serializer(C1100n.INSTANCE));

    @Override // p084o4.AbstractC1297a
    /* JADX INFO: renamed from: collectionSize, reason: merged with bridge method [inline-methods] */
    public int d(byte[] bArr) {
        E.f(bArr, "<this>");
        return bArr.length;
    }

    @Override // p084o4.L0
    /* JADX INFO: renamed from: empty, reason: merged with bridge method [inline-methods] */
    public byte[] h() {
        return new byte[0];
    }

    @Override // p084o4.AbstractC1297a
    /* JADX INFO: renamed from: toBuilder, reason: merged with bridge method [inline-methods] */
    public C1315j e(byte[] bArr) {
        E.f(bArr, "<this>");
        return new C1315j(bArr);
    }

    @Override // p084o4.L0
    public void writeContent(h encoder, byte[] content, int i5) {
        E.f(encoder, "encoder");
        E.f(content, "content");
        for (int i6 = 0; i6 < i5; i6++) {
            encoder.encodeByteElement(getDescriptor(), i6, content[i6]);
        }
    }

    @Override // p084o4.L0
    public void readElement(f decoder, int i5, C1315j builder, boolean z6) {
        E.f(decoder, "decoder");
        E.f(builder, "builder");
        builder.e(decoder.decodeByteElement(getDescriptor(), i5));
    }
}
