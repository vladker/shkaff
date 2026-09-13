package com.google.common.escape;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class CharEscaper extends Escaper {
    private static final int DEST_PAD_MULTIPLIER = 2;

    private static char[] growBuffer(char[] cArr, int i5, int i6) {
        if (i6 < 0) {
            throw new AssertionError("Cannot increase internal buffer any further");
        }
        char[] cArr2 = new char[i6];
        if (i5 > 0) {
            System.arraycopy(cArr, 0, cArr2, 0, i5);
        }
        return cArr2;
    }

    @Override // com.google.common.escape.Escaper
    public String escape(String str) {
        Preconditions.checkNotNull(str);
        int length = str.length();
        for (int i5 = 0; i5 < length; i5++) {
            if (escape(str.charAt(i5)) != null) {
                return escapeSlow(str, i5);
            }
        }
        return str;
    }

    public abstract char[] escape(char c);

    public final String escapeSlow(String str, int i5) {
        int length = str.length();
        char[] cArrCharBufferFromThreadLocal = Platform.charBufferFromThreadLocal();
        int length2 = cArrCharBufferFromThreadLocal.length;
        int i6 = 0;
        int i7 = 0;
        while (i5 < length) {
            char[] cArrEscape = escape(str.charAt(i5));
            if (cArrEscape != null) {
                int length3 = cArrEscape.length;
                int i8 = i5 - i6;
                int i9 = i7 + i8;
                int i10 = i9 + length3;
                if (length2 < i10) {
                    length2 = ((length - i5) * 2) + i10;
                    cArrCharBufferFromThreadLocal = growBuffer(cArrCharBufferFromThreadLocal, i7, length2);
                }
                if (i8 > 0) {
                    str.getChars(i6, i5, cArrCharBufferFromThreadLocal, i7);
                    i7 = i9;
                }
                if (length3 > 0) {
                    System.arraycopy(cArrEscape, 0, cArrCharBufferFromThreadLocal, i7, length3);
                    i7 += length3;
                }
                i6 = i5 + 1;
            }
            i5++;
        }
        int i11 = length - i6;
        if (i11 > 0) {
            int i12 = i11 + i7;
            if (length2 < i12) {
                cArrCharBufferFromThreadLocal = growBuffer(cArrCharBufferFromThreadLocal, i7, i12);
            }
            str.getChars(i6, length, cArrCharBufferFromThreadLocal, i7);
            i7 = i12;
        }
        return new String(cArrCharBufferFromThreadLocal, 0, i7);
    }
}
