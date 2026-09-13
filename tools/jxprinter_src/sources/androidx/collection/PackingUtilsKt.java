package androidx.collection;

import io.flutter.embedding.android.KeyboardMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class PackingUtilsKt {
    public static final long packFloats(float f6, float f7) {
        return (((long) Float.floatToRawIntBits(f7)) & KeyboardMap.kValueMask) | (Float.floatToRawIntBits(f6) << 32);
    }

    public static final long packInts(int i5, int i6) {
        return (((long) i6) & KeyboardMap.kValueMask) | (((long) i5) << 32);
    }
}
