package org.apache.commons.collections4.trie;

import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class KeyAnalyzer<K> implements Comparator<K>, Serializable {
    public static final int EQUAL_BIT_KEY = -2;
    public static final int NULL_BIT_KEY = -1;
    public static final int OUT_OF_BOUNDS_BIT_KEY = -3;
    private static final long serialVersionUID = -20497563720380683L;

    public static boolean isEqualBitKey(int i5) {
        return i5 == -2;
    }

    public static boolean isNullBitKey(int i5) {
        return i5 == -1;
    }

    public static boolean isOutOfBoundsIndex(int i5) {
        return i5 == -3;
    }

    public static boolean isValidBitIndex(int i5) {
        return i5 >= 0;
    }

    public abstract int bitIndex(K k6, int i5, int i6, K k7, int i7, int i8);

    public abstract int bitsPerElement();

    @Override // java.util.Comparator
    public int compare(K k6, K k7) {
        if (k6 == null) {
            return k7 == null ? 0 : -1;
        }
        if (k7 == null) {
            return 1;
        }
        return ((Comparable) k6).compareTo(k7);
    }

    public abstract boolean isBitSet(K k6, int i5, int i6);

    public abstract boolean isPrefix(K k6, int i5, int i6, K k7);

    public abstract int lengthInBits(K k6);
}
