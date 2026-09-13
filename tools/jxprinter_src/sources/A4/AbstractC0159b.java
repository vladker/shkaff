package A4;

/* JADX INFO: renamed from: A4.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractC0159b {
    private static final C0166i DEFAULT__new_UnsafeCursor = new C0166i();

    public static final void a(long j6, long j7, long j8) {
        if ((j7 | j8) < 0 || j7 > j6 || j6 - j7 < j8) {
            StringBuilder sbT = androidx.collection.a.t("size=", j6, " offset=");
            sbT.append(j7);
            sbT.append(" byteCount=");
            sbT.append(j8);
            throw new ArrayIndexOutOfBoundsException(sbT.toString());
        }
    }

    public static final boolean arrayRangeEquals(byte[] a6, int i5, byte[] b, int i6, int i7) {
        kotlin.jvm.internal.E.f(a6, "a");
        kotlin.jvm.internal.E.f(b, "b");
        for (int i8 = 0; i8 < i7; i8++) {
            if (a6[i8 + i5] != b[i8 + i6]) {
                return false;
            }
        }
        return true;
    }

    public static final int b(int i5) {
        return ((i5 & 255) << 24) | (((-16777216) & i5) >>> 24) | ((16711680 & i5) >>> 8) | ((65280 & i5) << 8);
    }

    public static final long c(long j6) {
        return ((j6 & 255) << 56) | (((-72057594037927936L) & j6) >>> 56) | ((71776119061217280L & j6) >>> 40) | ((280375465082880L & j6) >>> 24) | ((1095216660480L & j6) >>> 8) | ((4278190080L & j6) << 8) | ((16711680 & j6) << 24) | ((65280 & j6) << 40);
    }

    public static final C0166i getDEFAULT__new_UnsafeCursor() {
        return DEFAULT__new_UnsafeCursor;
    }

    public static final C0166i resolveDefaultParameter(C0166i unsafeCursor) {
        kotlin.jvm.internal.E.f(unsafeCursor, "unsafeCursor");
        return unsafeCursor == DEFAULT__new_UnsafeCursor ? new C0166i() : unsafeCursor;
    }

    public static final String toHexString(byte b) {
        return X3.W.concatToString(new char[]{B4.b.getHEX_DIGIT_CHARS()[(b >> 4) & 15], B4.b.getHEX_DIGIT_CHARS()[b & 15]});
    }

    public static final int resolveDefaultParameter(C0173p c0173p, int i5) {
        kotlin.jvm.internal.E.f(c0173p, "<this>");
        return i5 == -1234567890 ? c0173p.size() : i5;
    }

    public static final int resolveDefaultParameter(byte[] bArr, int i5) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        return i5 == -1234567890 ? bArr.length : i5;
    }

    public static final String toHexString(int i5) {
        if (i5 == 0) {
            return "0";
        }
        int i6 = 0;
        char[] cArr = {B4.b.getHEX_DIGIT_CHARS()[(i5 >> 28) & 15], B4.b.getHEX_DIGIT_CHARS()[(i5 >> 24) & 15], B4.b.getHEX_DIGIT_CHARS()[(i5 >> 20) & 15], B4.b.getHEX_DIGIT_CHARS()[(i5 >> 16) & 15], B4.b.getHEX_DIGIT_CHARS()[(i5 >> 12) & 15], B4.b.getHEX_DIGIT_CHARS()[(i5 >> 8) & 15], B4.b.getHEX_DIGIT_CHARS()[(i5 >> 4) & 15], B4.b.getHEX_DIGIT_CHARS()[i5 & 15]};
        while (i6 < 8 && cArr[i6] == '0') {
            i6++;
        }
        return X3.W.concatToString(cArr, i6, 8);
    }

    public static final String toHexString(long j6) {
        if (j6 == 0) {
            return "0";
        }
        int i5 = 0;
        char[] cArr = {B4.b.getHEX_DIGIT_CHARS()[(int) ((j6 >> 60) & 15)], B4.b.getHEX_DIGIT_CHARS()[(int) ((j6 >> 56) & 15)], B4.b.getHEX_DIGIT_CHARS()[(int) ((j6 >> 52) & 15)], B4.b.getHEX_DIGIT_CHARS()[(int) ((j6 >> 48) & 15)], B4.b.getHEX_DIGIT_CHARS()[(int) ((j6 >> 44) & 15)], B4.b.getHEX_DIGIT_CHARS()[(int) ((j6 >> 40) & 15)], B4.b.getHEX_DIGIT_CHARS()[(int) ((j6 >> 36) & 15)], B4.b.getHEX_DIGIT_CHARS()[(int) ((j6 >> 32) & 15)], B4.b.getHEX_DIGIT_CHARS()[(int) ((j6 >> 28) & 15)], B4.b.getHEX_DIGIT_CHARS()[(int) ((j6 >> 24) & 15)], B4.b.getHEX_DIGIT_CHARS()[(int) ((j6 >> 20) & 15)], B4.b.getHEX_DIGIT_CHARS()[(int) ((j6 >> 16) & 15)], B4.b.getHEX_DIGIT_CHARS()[(int) ((j6 >> 12) & 15)], B4.b.getHEX_DIGIT_CHARS()[(int) ((j6 >> 8) & 15)], B4.b.getHEX_DIGIT_CHARS()[(int) ((j6 >> 4) & 15)], B4.b.getHEX_DIGIT_CHARS()[(int) (j6 & 15)]};
        while (i5 < 16 && cArr[i5] == '0') {
            i5++;
        }
        return X3.W.concatToString(cArr, i5, 16);
    }
}
