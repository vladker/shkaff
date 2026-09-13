package com.google.common.net;

import com.google.android.gms.auth.api.accounttransfer.a;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.escape.UnicodeEscaper;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class PercentEscaper extends UnicodeEscaper {
    private static final char[] PLUS_SIGN = {'+'};
    private static final char[] UPPER_HEX_DIGITS = "0123456789ABCDEF".toCharArray();
    private final boolean plusForSpace;
    private final boolean[] safeOctets;

    public PercentEscaper(String str, boolean z6) {
        Preconditions.checkNotNull(str);
        if (str.matches(".*[0-9A-Za-z].*")) {
            throw new IllegalArgumentException("Alphanumeric characters are always 'safe' and should not be explicitly specified");
        }
        String strConcat = str.concat("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");
        if (z6 && strConcat.contains(" ")) {
            throw new IllegalArgumentException("plusForSpace cannot be specified when space is a 'safe' character");
        }
        this.plusForSpace = z6;
        this.safeOctets = createSafeOctets(strConcat);
    }

    private static boolean[] createSafeOctets(String str) {
        char[] charArray = str.toCharArray();
        int iMax = -1;
        for (char c : charArray) {
            iMax = Math.max((int) c, iMax);
        }
        boolean[] zArr = new boolean[iMax + 1];
        for (char c6 : charArray) {
            zArr[c6] = true;
        }
        return zArr;
    }

    @Override // com.google.common.escape.UnicodeEscaper, com.google.common.escape.Escaper
    public String escape(String str) {
        Preconditions.checkNotNull(str);
        int length = str.length();
        for (int i5 = 0; i5 < length; i5++) {
            char cCharAt = str.charAt(i5);
            boolean[] zArr = this.safeOctets;
            if (cCharAt >= zArr.length || !zArr[cCharAt]) {
                return escapeSlow(str, i5);
            }
        }
        return str;
    }

    @Override // com.google.common.escape.UnicodeEscaper
    public int nextEscapeIndex(CharSequence charSequence, int i5, int i6) {
        Preconditions.checkNotNull(charSequence);
        while (i5 < i6) {
            char cCharAt = charSequence.charAt(i5);
            boolean[] zArr = this.safeOctets;
            if (cCharAt >= zArr.length || !zArr[cCharAt]) {
                break;
            }
            i5++;
        }
        return i5;
    }

    @Override // com.google.common.escape.UnicodeEscaper
    public char[] escape(int i5) {
        boolean[] zArr = this.safeOctets;
        if (i5 < zArr.length && zArr[i5]) {
            return null;
        }
        if (i5 == 32 && this.plusForSpace) {
            return PLUS_SIGN;
        }
        if (i5 <= 127) {
            char[] cArr = UPPER_HEX_DIGITS;
            return new char[]{'%', cArr[i5 >>> 4], cArr[i5 & 15]};
        }
        if (i5 <= 2047) {
            char[] cArr2 = UPPER_HEX_DIGITS;
            return new char[]{'%', cArr2[(i5 >>> 10) | 12], cArr2[(i5 >>> 6) & 15], '%', cArr2[((i5 >>> 4) & 3) | 8], cArr2[i5 & 15]};
        }
        if (i5 <= 65535) {
            char[] cArr3 = UPPER_HEX_DIGITS;
            return new char[]{'%', 'E', cArr3[i5 >>> 12], '%', cArr3[((i5 >>> 10) & 3) | 8], cArr3[(i5 >>> 6) & 15], '%', cArr3[((i5 >>> 4) & 3) | 8], cArr3[i5 & 15]};
        }
        if (i5 <= 1114111) {
            char[] cArr4 = UPPER_HEX_DIGITS;
            return new char[]{'%', 'F', cArr4[(i5 >>> 18) & 7], '%', cArr4[((i5 >>> 16) & 3) | 8], cArr4[(i5 >>> 12) & 15], '%', cArr4[((i5 >>> 10) & 3) | 8], cArr4[(i5 >>> 6) & 15], '%', cArr4[((i5 >>> 4) & 3) | 8], cArr4[i5 & 15]};
        }
        throw new IllegalArgumentException(a.h(43, i5, "Invalid unicode character value "));
    }
}
