package com.google.common.escape;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class UnicodeEscaper extends Escaper {
    private static final int DEST_PAD = 32;

    public static int codePointAt(CharSequence charSequence, int i5, int i6) {
        Preconditions.checkNotNull(charSequence);
        if (i5 >= i6) {
            throw new IndexOutOfBoundsException("Index exceeds specified range");
        }
        int i7 = i5 + 1;
        char cCharAt = charSequence.charAt(i5);
        if (cCharAt < 55296 || cCharAt > 57343) {
            return cCharAt;
        }
        if (cCharAt > 56319) {
            String strValueOf = String.valueOf(charSequence);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 88);
            sb.append("Unexpected low surrogate character '");
            sb.append(cCharAt);
            sb.append("' with value ");
            sb.append((int) cCharAt);
            sb.append(" at index ");
            sb.append(i5);
            sb.append(" in '");
            sb.append(strValueOf);
            sb.append("'");
            throw new IllegalArgumentException(sb.toString());
        }
        if (i7 == i6) {
            return -cCharAt;
        }
        char cCharAt2 = charSequence.charAt(i7);
        if (Character.isLowSurrogate(cCharAt2)) {
            return Character.toCodePoint(cCharAt, cCharAt2);
        }
        String strValueOf2 = String.valueOf(charSequence);
        StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 89);
        sb2.append("Expected low surrogate but got char '");
        sb2.append(cCharAt2);
        sb2.append("' with value ");
        sb2.append((int) cCharAt2);
        sb2.append(" at index ");
        sb2.append(i7);
        sb2.append(" in '");
        sb2.append(strValueOf2);
        sb2.append("'");
        throw new IllegalArgumentException(sb2.toString());
    }

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
        int iNextEscapeIndex = nextEscapeIndex(str, 0, length);
        return iNextEscapeIndex == length ? str : escapeSlow(str, iNextEscapeIndex);
    }

    public abstract char[] escape(int i5);

    public final String escapeSlow(String str, int i5) {
        int length = str.length();
        char[] cArrCharBufferFromThreadLocal = Platform.charBufferFromThreadLocal();
        int i6 = 0;
        int length2 = 0;
        while (i5 < length) {
            int iCodePointAt = codePointAt(str, i5, length);
            if (iCodePointAt < 0) {
                throw new IllegalArgumentException("Trailing high surrogate at end of input");
            }
            char[] cArrEscape = escape(iCodePointAt);
            int i7 = (Character.isSupplementaryCodePoint(iCodePointAt) ? 2 : 1) + i5;
            if (cArrEscape != null) {
                int i8 = i5 - i6;
                int i9 = length2 + i8;
                int length3 = cArrEscape.length + i9;
                if (cArrCharBufferFromThreadLocal.length < length3) {
                    cArrCharBufferFromThreadLocal = growBuffer(cArrCharBufferFromThreadLocal, length2, (length - i5) + length3 + 32);
                }
                if (i8 > 0) {
                    str.getChars(i6, i5, cArrCharBufferFromThreadLocal, length2);
                    length2 = i9;
                }
                if (cArrEscape.length > 0) {
                    System.arraycopy(cArrEscape, 0, cArrCharBufferFromThreadLocal, length2, cArrEscape.length);
                    length2 += cArrEscape.length;
                }
                i6 = i7;
            }
            i5 = nextEscapeIndex(str, i7, length);
        }
        int i10 = length - i6;
        if (i10 > 0) {
            int i11 = i10 + length2;
            if (cArrCharBufferFromThreadLocal.length < i11) {
                cArrCharBufferFromThreadLocal = growBuffer(cArrCharBufferFromThreadLocal, length2, i11);
            }
            str.getChars(i6, length, cArrCharBufferFromThreadLocal, length2);
            length2 = i11;
        }
        return new String(cArrCharBufferFromThreadLocal, 0, length2);
    }

    public int nextEscapeIndex(CharSequence charSequence, int i5, int i6) {
        while (i5 < i6) {
            int iCodePointAt = codePointAt(charSequence, i5, i6);
            if (iCodePointAt < 0 || escape(iCodePointAt) != null) {
                break;
            }
            i5 += Character.isSupplementaryCodePoint(iCodePointAt) ? 2 : 1;
        }
        return i5;
    }
}
