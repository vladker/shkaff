package androidx.emoji2.text.flatbuffer;

import io.flutter.embedding.android.KeyboardMap;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class IntVector extends BaseVector {
    public IntVector __assign(int i5, ByteBuffer byteBuffer) {
        __reset(i5, 4, byteBuffer);
        return this;
    }

    public int get(int i5) {
        return this.bb.getInt(__element(i5));
    }

    public long getAsUnsigned(int i5) {
        return ((long) get(i5)) & KeyboardMap.kValueMask;
    }
}
