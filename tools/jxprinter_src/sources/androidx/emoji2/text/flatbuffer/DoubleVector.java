package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class DoubleVector extends BaseVector {
    public DoubleVector __assign(int i5, ByteBuffer byteBuffer) {
        __reset(i5, 8, byteBuffer);
        return this;
    }

    public double get(int i5) {
        return this.bb.getDouble(__element(i5));
    }
}
