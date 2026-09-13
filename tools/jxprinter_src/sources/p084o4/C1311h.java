package p084o4;

import kotlin.jvm.internal.C1099m;
import kotlin.jvm.internal.E;
import p066l4.a;
import p078n4.f;
import p078n4.h;

/* JADX INFO: renamed from: o4.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1311h extends L0 {
    public static final C1311h INSTANCE = new C1311h(a.serializer(C1099m.INSTANCE));

    @Override // p084o4.AbstractC1297a
    /* JADX INFO: renamed from: collectionSize, reason: merged with bridge method [inline-methods] */
    public int d(boolean[] zArr) {
        E.f(zArr, "<this>");
        return zArr.length;
    }

    @Override // p084o4.L0
    /* JADX INFO: renamed from: empty, reason: merged with bridge method [inline-methods] */
    public boolean[] h() {
        return new boolean[0];
    }

    @Override // p084o4.AbstractC1297a
    /* JADX INFO: renamed from: toBuilder, reason: merged with bridge method [inline-methods] */
    public C1309g e(boolean[] zArr) {
        E.f(zArr, "<this>");
        return new C1309g(zArr);
    }

    @Override // p084o4.L0
    public void writeContent(h encoder, boolean[] content, int i5) {
        E.f(encoder, "encoder");
        E.f(content, "content");
        for (int i6 = 0; i6 < i5; i6++) {
            encoder.encodeBooleanElement(getDescriptor(), i6, content[i6]);
        }
    }

    @Override // p084o4.L0
    public void readElement(f decoder, int i5, C1309g builder, boolean z6) {
        E.f(decoder, "decoder");
        E.f(builder, "builder");
        builder.e(decoder.decodeBooleanElement(getDescriptor(), i5));
    }
}
