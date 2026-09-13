package X3;

import com.google.common.primitives.UnsignedBytes;
import io.flutter.embedding.android.KeyboardMap;
import p147z3.C1929i;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class g0 {
    /* JADX INFO: renamed from: toString-JSWoG40, reason: not valid java name */
    public static final String m884toStringJSWoG40(long j6, int i5) {
        return p147z3.T.ulongToString(j6, AbstractC0239e.checkRadix(i5));
    }

    /* JADX INFO: renamed from: toString-LxnNnR4, reason: not valid java name */
    public static final String m885toStringLxnNnR4(byte b, int i5) {
        String string = Integer.toString(b & UnsignedBytes.MAX_VALUE, AbstractC0239e.checkRadix(i5));
        kotlin.jvm.internal.E.e(string, "toString(...)");
        return string;
    }

    /* JADX INFO: renamed from: toString-V7xB4Y4, reason: not valid java name */
    public static final String m886toStringV7xB4Y4(int i5, int i6) {
        return p147z3.T.ulongToString(((long) i5) & KeyboardMap.kValueMask, AbstractC0239e.checkRadix(i6));
    }

    /* JADX INFO: renamed from: toString-olVBNx4, reason: not valid java name */
    public static final String m887toStringolVBNx4(short s6, int i5) {
        String string = Integer.toString(s6 & 65535, AbstractC0239e.checkRadix(i5));
        kotlin.jvm.internal.E.e(string, "toString(...)");
        return string;
    }

    public static final byte toUByte(String str) {
        kotlin.jvm.internal.E.f(str, "<this>");
        p147z3.D uByteOrNull = toUByteOrNull(str);
        if (uByteOrNull != null) {
            return uByteOrNull.f9122a;
        }
        V.numberFormatError(str);
        throw new C1929i();
    }

    public static final p147z3.D toUByteOrNull(String str) {
        kotlin.jvm.internal.E.f(str, "<this>");
        return toUByteOrNull(str, 10);
    }

    public static final int toUInt(String str) {
        kotlin.jvm.internal.E.f(str, "<this>");
        p147z3.G uIntOrNull = toUIntOrNull(str);
        if (uIntOrNull != null) {
            return uIntOrNull.f9124a;
        }
        V.numberFormatError(str);
        throw new C1929i();
    }

    public static final p147z3.G toUIntOrNull(String str) {
        kotlin.jvm.internal.E.f(str, "<this>");
        return toUIntOrNull(str, 10);
    }

    public static final long toULong(String str) {
        kotlin.jvm.internal.E.f(str, "<this>");
        p147z3.J uLongOrNull = toULongOrNull(str);
        if (uLongOrNull != null) {
            return uLongOrNull.f9126a;
        }
        V.numberFormatError(str);
        throw new C1929i();
    }

    public static final p147z3.J toULongOrNull(String str) {
        kotlin.jvm.internal.E.f(str, "<this>");
        return toULongOrNull(str, 10);
    }

    public static final short toUShort(String str) {
        kotlin.jvm.internal.E.f(str, "<this>");
        p147z3.N uShortOrNull = toUShortOrNull(str);
        if (uShortOrNull != null) {
            return uShortOrNull.f9128a;
        }
        V.numberFormatError(str);
        throw new C1929i();
    }

    public static final p147z3.N toUShortOrNull(String str) {
        kotlin.jvm.internal.E.f(str, "<this>");
        return toUShortOrNull(str, 10);
    }

    public static final p147z3.D toUByteOrNull(String str, int i5) {
        kotlin.jvm.internal.E.f(str, "<this>");
        p147z3.G uIntOrNull = toUIntOrNull(str, i5);
        if (uIntOrNull == null) {
            return null;
        }
        int i6 = uIntOrNull.f9124a;
        if (Integer.compareUnsigned(i6, p147z3.G.m1188constructorimpl(255)) > 0) {
            return null;
        }
        return p147z3.D.a(p147z3.D.m1131constructorimpl((byte) i6));
    }

    public static final p147z3.G toUIntOrNull(String str, int i5) {
        int i6;
        kotlin.jvm.internal.E.f(str, "<this>");
        AbstractC0239e.checkRadix(i5);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i7 = 0;
        char cCharAt = str.charAt(0);
        if (kotlin.jvm.internal.E.h(cCharAt, 48) < 0) {
            i6 = 1;
            if (length == 1 || cCharAt != '+') {
                return null;
            }
        } else {
            i6 = 0;
        }
        int iM1188constructorimpl = p147z3.G.m1188constructorimpl(i5);
        int iDivideUnsigned = 119304647;
        while (i6 < length) {
            int iDigit = Character.digit((int) str.charAt(i6), i5);
            if (iDigit < 0) {
                return null;
            }
            if (Integer.compareUnsigned(i7, iDivideUnsigned) > 0) {
                if (iDivideUnsigned == 119304647) {
                    iDivideUnsigned = Integer.divideUnsigned(-1, iM1188constructorimpl);
                    if (Integer.compareUnsigned(i7, iDivideUnsigned) > 0) {
                    }
                }
                return null;
            }
            int iM1188constructorimpl2 = p147z3.G.m1188constructorimpl(i7 * iM1188constructorimpl);
            int iM1188constructorimpl3 = p147z3.G.m1188constructorimpl(p147z3.G.m1188constructorimpl(iDigit) + iM1188constructorimpl2);
            if (Integer.compareUnsigned(iM1188constructorimpl3, iM1188constructorimpl2) < 0) {
                return null;
            }
            i6++;
            i7 = iM1188constructorimpl3;
        }
        return p147z3.G.a(i7);
    }

    public static final p147z3.J toULongOrNull(String str, int i5) {
        kotlin.jvm.internal.E.f(str, "<this>");
        AbstractC0239e.checkRadix(i5);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i6 = 0;
        char cCharAt = str.charAt(0);
        if (kotlin.jvm.internal.E.h(cCharAt, 48) < 0) {
            i6 = 1;
            if (length == 1 || cCharAt != '+') {
                return null;
            }
        }
        long jM1247constructorimpl = p147z3.J.m1247constructorimpl(i5);
        long j6 = 0;
        long jDivideUnsigned = 512409557603043100L;
        while (i6 < length) {
            int iDigit = Character.digit((int) str.charAt(i6), i5);
            if (iDigit < 0) {
                return null;
            }
            if (Long.compareUnsigned(j6, jDivideUnsigned) > 0) {
                if (jDivideUnsigned == 512409557603043100L) {
                    jDivideUnsigned = Long.divideUnsigned(-1L, jM1247constructorimpl);
                    if (Long.compareUnsigned(j6, jDivideUnsigned) > 0) {
                    }
                }
                return null;
            }
            long jM1247constructorimpl2 = p147z3.J.m1247constructorimpl(j6 * jM1247constructorimpl);
            long jM1247constructorimpl3 = p147z3.J.m1247constructorimpl(p147z3.J.m1247constructorimpl(((long) p147z3.G.m1188constructorimpl(iDigit)) & KeyboardMap.kValueMask) + jM1247constructorimpl2);
            if (Long.compareUnsigned(jM1247constructorimpl3, jM1247constructorimpl2) < 0) {
                return null;
            }
            i6++;
            j6 = jM1247constructorimpl3;
        }
        return p147z3.J.a(j6);
    }

    public static final p147z3.N toUShortOrNull(String str, int i5) {
        kotlin.jvm.internal.E.f(str, "<this>");
        p147z3.G uIntOrNull = toUIntOrNull(str, i5);
        if (uIntOrNull == null) {
            return null;
        }
        int i6 = uIntOrNull.f9124a;
        if (Integer.compareUnsigned(i6, p147z3.G.m1188constructorimpl(65535)) > 0) {
            return null;
        }
        return p147z3.N.a(p147z3.N.m1306constructorimpl((short) i6));
    }

    public static final byte toUByte(String str, int i5) {
        kotlin.jvm.internal.E.f(str, "<this>");
        p147z3.D uByteOrNull = toUByteOrNull(str, i5);
        if (uByteOrNull != null) {
            return uByteOrNull.f9122a;
        }
        V.numberFormatError(str);
        throw new C1929i();
    }

    public static final int toUInt(String str, int i5) {
        kotlin.jvm.internal.E.f(str, "<this>");
        p147z3.G uIntOrNull = toUIntOrNull(str, i5);
        if (uIntOrNull != null) {
            return uIntOrNull.f9124a;
        }
        V.numberFormatError(str);
        throw new C1929i();
    }

    public static final long toULong(String str, int i5) {
        kotlin.jvm.internal.E.f(str, "<this>");
        p147z3.J uLongOrNull = toULongOrNull(str, i5);
        if (uLongOrNull != null) {
            return uLongOrNull.f9126a;
        }
        V.numberFormatError(str);
        throw new C1929i();
    }

    public static final short toUShort(String str, int i5) {
        kotlin.jvm.internal.E.f(str, "<this>");
        p147z3.N uShortOrNull = toUShortOrNull(str, i5);
        if (uShortOrNull != null) {
            return uShortOrNull.f9128a;
        }
        V.numberFormatError(str);
        throw new C1929i();
    }
}
