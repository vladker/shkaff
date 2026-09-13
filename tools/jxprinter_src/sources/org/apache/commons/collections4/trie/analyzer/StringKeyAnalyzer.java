package org.apache.commons.collections4.trie.analyzer;

import org.apache.commons.collections4.trie.KeyAnalyzer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class StringKeyAnalyzer extends KeyAnalyzer<String> {
    public static final StringKeyAnalyzer INSTANCE = new StringKeyAnalyzer();
    public static final int LENGTH = 16;
    private static final int MSB = 32768;
    private static final long serialVersionUID = -7032449491269434877L;

    private static int mask(int i5) {
        return 32768 >>> i5;
    }

    @Override // org.apache.commons.collections4.trie.KeyAnalyzer
    public int bitsPerElement() {
        return 16;
    }

    @Override // org.apache.commons.collections4.trie.KeyAnalyzer
    public int bitIndex(String str, int i5, int i6, String str2, int i7, int i8) {
        if (i5 % 16 != 0 || i7 % 16 != 0 || i6 % 16 != 0 || i8 % 16 != 0) {
            throw new IllegalArgumentException("The offsets and lengths must be at Character boundaries");
        }
        int i9 = i5 / 16;
        int i10 = i7 / 16;
        int i11 = (i6 / 16) + i9;
        int i12 = (i8 / 16) + i10;
        int iMax = Math.max(i11, i12);
        boolean z6 = true;
        for (int i13 = 0; i13 < iMax; i13++) {
            int i14 = i9 + i13;
            int i15 = i10 + i13;
            char cCharAt = i14 >= i11 ? (char) 0 : str.charAt(i14);
            char cCharAt2 = (str2 == null || i15 >= i12) ? (char) 0 : str2.charAt(i15);
            if (cCharAt != cCharAt2) {
                return (Integer.numberOfLeadingZeros(cCharAt ^ cCharAt2) + (i13 * 16)) - 16;
            }
            if (cCharAt != 0) {
                z6 = false;
            }
        }
        return z6 ? -1 : -2;
    }

    @Override // org.apache.commons.collections4.trie.KeyAnalyzer
    public boolean isBitSet(String str, int i5, int i6) {
        if (str != null && i5 < i6) {
            if ((str.charAt(i5 / 16) & mask(i5 % 16)) != 0) {
                return true;
            }
        }
        return false;
    }

    @Override // org.apache.commons.collections4.trie.KeyAnalyzer
    public boolean isPrefix(String str, int i5, int i6, String str2) {
        if (i5 % 16 == 0 && i6 % 16 == 0) {
            return str2.startsWith(str.substring(i5 / 16, i6 / 16));
        }
        throw new IllegalArgumentException("Cannot determine prefix outside of Character boundaries");
    }

    @Override // org.apache.commons.collections4.trie.KeyAnalyzer
    public int lengthInBits(String str) {
        if (str != null) {
            return str.length() * 16;
        }
        return 0;
    }
}
