package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class FloatVector extends BaseVector {
    public FloatVector __assign(int i5, ByteBuffer byteBuffer) {
        __reset(i5, 4, byteBuffer);
        return this;
    }

    public float get(int i5) {
        return this.bb.getFloat(__element(i5));
    }
}
