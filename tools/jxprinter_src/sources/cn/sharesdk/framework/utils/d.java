package cn.sharesdk.framework.utils;

import A3.AbstractC0157z;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class d extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f2229a = {'+'};
    private static final char[] b = "0123456789ABCDEF".toCharArray();
    private final boolean c;
    private final boolean[] d;

    public d(String str, boolean z6) {
        if (str.matches(".*[0-9A-Za-z].*")) {
            throw new IllegalArgumentException("Alphanumeric characters are always 'safe' and should not be explicitly specified");
        }
        if (z6 && str.contains(" ")) {
            throw new IllegalArgumentException("plusForSpace cannot be specified when space is a 'safe' character");
        }
        if (str.contains("%")) {
            throw new IllegalArgumentException("The '%' character cannot be specified as 'safe'");
        }
        this.c = z6;
        this.d = a(str);
    }

    private static boolean[] a(String str) {
        char[] charArray = str.toCharArray();
        int iMax = 122;
        for (char c : charArray) {
            iMax = Math.max((int) c, iMax);
        }
        boolean[] zArr = new boolean[iMax + 1];
        for (int i5 = 48; i5 <= 57; i5++) {
            zArr[i5] = true;
        }
        for (int i6 = 65; i6 <= 90; i6++) {
            zArr[i6] = true;
        }
        for (int i7 = 97; i7 <= 122; i7++) {
            zArr[i7] = true;
        }
        for (char c6 : charArray) {
            zArr[c6] = true;
        }
        return zArr;
    }

    @Override // cn.sharesdk.framework.utils.l, cn.sharesdk.framework.utils.Escaper
    public String escape(String str) {
        int length = str.length();
        for (int i5 = 0; i5 < length; i5++) {
            char cCharAt = str.charAt(i5);
            boolean[] zArr = this.d;
            if (cCharAt >= zArr.length || !zArr[cCharAt]) {
                return a(str, i5);
            }
        }
        return str;
    }

    @Override // cn.sharesdk.framework.utils.l
    public int a(CharSequence charSequence, int i5, int i6) {
        while (i5 < i6) {
            char cCharAt = charSequence.charAt(i5);
            boolean[] zArr = this.d;
            if (cCharAt >= zArr.length || !zArr[cCharAt]) {
                break;
            }
            i5++;
        }
        return i5;
    }

    @Override // cn.sharesdk.framework.utils.l
    public char[] a(int i5) {
        boolean[] zArr = this.d;
        if (i5 < zArr.length && zArr[i5]) {
            return null;
        }
        if (i5 == 32 && this.c) {
            return f2229a;
        }
        if (i5 <= 127) {
            char[] cArr = b;
            return new char[]{'%', cArr[i5 >>> 4], cArr[i5 & 15]};
        }
        if (i5 <= 2047) {
            char[] cArr2 = b;
            return new char[]{'%', cArr2[(i5 >>> 10) | 12], cArr2[(i5 >>> 6) & 15], '%', cArr2[((i5 >>> 4) & 3) | 8], cArr2[i5 & 15]};
        }
        if (i5 <= 65535) {
            char[] cArr3 = b;
            return new char[]{'%', 'E', cArr3[i5 >>> 12], '%', cArr3[((i5 >>> 10) & 3) | 8], cArr3[(i5 >>> 6) & 15], '%', cArr3[((i5 >>> 4) & 3) | 8], cArr3[i5 & 15]};
        }
        if (i5 <= 1114111) {
            char[] cArr4 = b;
            return new char[]{'%', 'F', cArr4[(i5 >>> 18) & 7], '%', cArr4[((i5 >>> 16) & 3) | 8], cArr4[(i5 >>> 12) & 15], '%', cArr4[((i5 >>> 10) & 3) | 8], cArr4[(i5 >>> 6) & 15], '%', cArr4[((i5 >>> 4) & 3) | 8], cArr4[i5 & 15]};
        }
        throw new IllegalArgumentException(AbstractC0157z.k(i5, "Invalid unicode character value "));
    }
}
