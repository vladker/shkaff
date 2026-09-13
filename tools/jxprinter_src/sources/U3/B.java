package U3;

import android.support.v4.media.session.PlaybackStateCompat;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class B extends A {
    public static long a(long j6, long j7, long j8) {
        if (j7 <= j8) {
            if (j6 < j7) {
                return j7;
            }
            return j6 > j8 ? j8 : j6;
        }
        StringBuilder sbT = androidx.collection.a.t("Cannot coerce value to an empty range: maximum ", j8, " is less than minimum ");
        sbT.append(j7);
        sbT.append('.');
        throw new IllegalArgumentException(sbT.toString());
    }

    public static final /* synthetic */ boolean byteRangeContains(InterfaceC0213j interfaceC0213j, double d) {
        kotlin.jvm.internal.E.f(interfaceC0213j, "<this>");
        Byte byteExactOrNull = toByteExactOrNull(d);
        if (byteExactOrNull != null) {
            return interfaceC0213j.contains(byteExactOrNull);
        }
        return false;
    }

    public static final <T extends Comparable<? super T>> T coerceAtLeast(T t6, T minimumValue) {
        kotlin.jvm.internal.E.f(t6, "<this>");
        kotlin.jvm.internal.E.f(minimumValue, "minimumValue");
        return t6.compareTo(minimumValue) < 0 ? minimumValue : t6;
    }

    public static final <T extends Comparable<? super T>> T coerceAtMost(T t6, T maximumValue) {
        kotlin.jvm.internal.E.f(t6, "<this>");
        kotlin.jvm.internal.E.f(maximumValue, "maximumValue");
        return t6.compareTo(maximumValue) > 0 ? maximumValue : t6;
    }

    public static final <T extends Comparable<? super T>> T coerceIn(T t6, T t7, T t8) {
        kotlin.jvm.internal.E.f(t6, "<this>");
        if (t7 == null || t8 == null) {
            if (t7 != null && t6.compareTo(t7) < 0) {
                return t7;
            }
            if (t8 != null && t6.compareTo(t8) > 0) {
                return t8;
            }
        } else {
            if (t7.compareTo(t8) > 0) {
                throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + t8 + " is less than minimum " + t7 + '.');
            }
            if (t6.compareTo(t7) < 0) {
                return t7;
            }
            if (t6.compareTo(t8) > 0) {
                return t8;
            }
        }
        return t6;
    }

    private static final boolean contains(q qVar, Integer num) {
        int iIntValue;
        kotlin.jvm.internal.E.f(qVar, "<this>");
        return num != null && qVar.f732a <= (iIntValue = num.intValue()) && iIntValue <= qVar.b;
    }

    public static final /* synthetic */ boolean doubleRangeContains(InterfaceC0213j interfaceC0213j, byte b) {
        kotlin.jvm.internal.E.f(interfaceC0213j, "<this>");
        return interfaceC0213j.contains(Double.valueOf(b));
    }

    public static final n downTo(int i5, byte b) {
        return n.Companion.fromClosedRange(i5, b, -1);
    }

    public static final int first(n nVar) {
        kotlin.jvm.internal.E.f(nVar, "<this>");
        if (!nVar.isEmpty()) {
            return nVar.f732a;
        }
        throw new NoSuchElementException("Progression " + nVar + " is empty.");
    }

    public static final Integer firstOrNull(n nVar) {
        kotlin.jvm.internal.E.f(nVar, "<this>");
        if (nVar.isEmpty()) {
            return null;
        }
        return Integer.valueOf(nVar.f732a);
    }

    public static final /* synthetic */ boolean floatRangeContains(InterfaceC0213j interfaceC0213j, byte b) {
        kotlin.jvm.internal.E.f(interfaceC0213j, "<this>");
        return interfaceC0213j.contains(Float.valueOf(b));
    }

    public static final boolean intRangeContains(InterfaceC0213j interfaceC0213j, byte b) {
        kotlin.jvm.internal.E.f(interfaceC0213j, "<this>");
        return interfaceC0213j.contains(Integer.valueOf(b));
    }

    public static final int last(n nVar) {
        kotlin.jvm.internal.E.f(nVar, "<this>");
        if (!nVar.isEmpty()) {
            return nVar.b;
        }
        throw new NoSuchElementException("Progression " + nVar + " is empty.");
    }

    public static final Integer lastOrNull(n nVar) {
        kotlin.jvm.internal.E.f(nVar, "<this>");
        if (nVar.isEmpty()) {
            return null;
        }
        return Integer.valueOf(nVar.b);
    }

    public static final boolean longRangeContains(InterfaceC0213j interfaceC0213j, byte b) {
        kotlin.jvm.internal.E.f(interfaceC0213j, "<this>");
        return interfaceC0213j.contains(Long.valueOf(b));
    }

    public static final char random(C0208e c0208e, S3.f random) {
        kotlin.jvm.internal.E.f(c0208e, "<this>");
        kotlin.jvm.internal.E.f(random, "random");
        try {
            return (char) random.e(c0208e.f728a, c0208e.b + 1);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    private static final Integer randomOrNull(q qVar) {
        kotlin.jvm.internal.E.f(qVar, "<this>");
        return randomOrNull(qVar, S3.f.Default);
    }

    public static final n reversed(n nVar) {
        kotlin.jvm.internal.E.f(nVar, "<this>");
        return n.Companion.fromClosedRange(nVar.b, nVar.f732a, -nVar.c);
    }

    public static final boolean shortRangeContains(InterfaceC0213j interfaceC0213j, byte b) {
        kotlin.jvm.internal.E.f(interfaceC0213j, "<this>");
        return interfaceC0213j.contains(Short.valueOf(b));
    }

    public static n step(n nVar, int i5) {
        kotlin.jvm.internal.E.f(nVar, "<this>");
        A.checkStepIsPositive(i5 > 0, Integer.valueOf(i5));
        C0216m c0216m = n.Companion;
        int i6 = nVar.f732a;
        int i7 = nVar.b;
        if (nVar.c <= 0) {
            i5 = -i5;
        }
        return c0216m.fromClosedRange(i6, i7, i5);
    }

    public static final Byte toByteExactOrNull(int i5) {
        if (-128 > i5 || i5 >= 128) {
            return null;
        }
        return Byte.valueOf((byte) i5);
    }

    public static final Integer toIntExactOrNull(long j6) {
        if (-2147483648L > j6 || j6 >= 2147483648L) {
            return null;
        }
        return Integer.valueOf((int) j6);
    }

    public static final Long toLongExactOrNull(double d) {
        if (-9.223372036854776E18d > d || d > 9.223372036854776E18d) {
            return null;
        }
        return Long.valueOf((long) d);
    }

    public static final Short toShortExactOrNull(int i5) {
        if (-32768 > i5 || i5 >= 32768) {
            return null;
        }
        return Short.valueOf((short) i5);
    }

    public static final q until(int i5, byte b) {
        return new q(i5, b - 1, 1);
    }

    public static final /* synthetic */ boolean byteRangeContains(InterfaceC0213j interfaceC0213j, float f6) {
        kotlin.jvm.internal.E.f(interfaceC0213j, "<this>");
        Byte byteExactOrNull = toByteExactOrNull(f6);
        if (byteExactOrNull != null) {
            return interfaceC0213j.contains(byteExactOrNull);
        }
        return false;
    }

    public static final boolean doubleRangeContains(InterfaceC0213j interfaceC0213j, float f6) {
        kotlin.jvm.internal.E.f(interfaceC0213j, "<this>");
        return interfaceC0213j.contains(Double.valueOf(f6));
    }

    public static final s downTo(long j6, byte b) {
        return s.Companion.fromClosedRange(j6, b, -1L);
    }

    public static final boolean floatRangeContains(InterfaceC0213j interfaceC0213j, double d) {
        kotlin.jvm.internal.E.f(interfaceC0213j, "<this>");
        return interfaceC0213j.contains(Float.valueOf((float) d));
    }

    public static final boolean intRangeContains(z zVar, byte b) {
        kotlin.jvm.internal.E.f(zVar, "<this>");
        return zVar.contains(Integer.valueOf(b));
    }

    public static final boolean longRangeContains(z zVar, byte b) {
        kotlin.jvm.internal.E.f(zVar, "<this>");
        return zVar.contains(Long.valueOf(b));
    }

    private static final Long randomOrNull(v vVar) {
        kotlin.jvm.internal.E.f(vVar, "<this>");
        return randomOrNull(vVar, S3.f.Default);
    }

    public static final boolean shortRangeContains(z zVar, byte b) {
        kotlin.jvm.internal.E.f(zVar, "<this>");
        return zVar.contains(Short.valueOf(b));
    }

    public static final Byte toByteExactOrNull(long j6) {
        if (-128 > j6 || j6 >= 128) {
            return null;
        }
        return Byte.valueOf((byte) j6);
    }

    public static final Integer toIntExactOrNull(double d) {
        if (-2.147483648E9d > d || d > 2.147483647E9d) {
            return null;
        }
        return Integer.valueOf((int) d);
    }

    public static final Long toLongExactOrNull(float f6) {
        if (-9.223372E18f > f6 || f6 > 9.223372E18f) {
            return null;
        }
        return Long.valueOf((long) f6);
    }

    public static final Short toShortExactOrNull(long j6) {
        if (-32768 > j6 || j6 >= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID) {
            return null;
        }
        return Short.valueOf((short) j6);
    }

    public static final boolean byteRangeContains(InterfaceC0213j interfaceC0213j, int i5) {
        kotlin.jvm.internal.E.f(interfaceC0213j, "<this>");
        Byte byteExactOrNull = toByteExactOrNull(i5);
        if (byteExactOrNull != null) {
            return interfaceC0213j.contains(byteExactOrNull);
        }
        return false;
    }

    public static final boolean doubleRangeContains(z zVar, float f6) {
        kotlin.jvm.internal.E.f(zVar, "<this>");
        return zVar.contains(Double.valueOf(f6));
    }

    public static final n downTo(byte b, byte b6) {
        return n.Companion.fromClosedRange(b, b6, -1);
    }

    public static final /* synthetic */ boolean floatRangeContains(InterfaceC0213j interfaceC0213j, int i5) {
        kotlin.jvm.internal.E.f(interfaceC0213j, "<this>");
        return interfaceC0213j.contains(Float.valueOf(i5));
    }

    public static final /* synthetic */ boolean intRangeContains(InterfaceC0213j interfaceC0213j, double d) {
        kotlin.jvm.internal.E.f(interfaceC0213j, "<this>");
        Integer intExactOrNull = toIntExactOrNull(d);
        if (intExactOrNull != null) {
            return interfaceC0213j.contains(intExactOrNull);
        }
        return false;
    }

    public static final /* synthetic */ boolean longRangeContains(InterfaceC0213j interfaceC0213j, double d) {
        kotlin.jvm.internal.E.f(interfaceC0213j, "<this>");
        Long longExactOrNull = toLongExactOrNull(d);
        if (longExactOrNull != null) {
            return interfaceC0213j.contains(longExactOrNull);
        }
        return false;
    }

    private static final Character randomOrNull(C0208e c0208e) {
        kotlin.jvm.internal.E.f(c0208e, "<this>");
        return randomOrNull(c0208e, S3.f.Default);
    }

    public static final /* synthetic */ boolean shortRangeContains(InterfaceC0213j interfaceC0213j, double d) {
        kotlin.jvm.internal.E.f(interfaceC0213j, "<this>");
        Short shortExactOrNull = toShortExactOrNull(d);
        if (shortExactOrNull != null) {
            return interfaceC0213j.contains(shortExactOrNull);
        }
        return false;
    }

    public static final Byte toByteExactOrNull(short s6) {
        if (-128 > s6 || s6 >= 128) {
            return null;
        }
        return Byte.valueOf((byte) s6);
    }

    public static final Integer toIntExactOrNull(float f6) {
        if (-2.1474836E9f > f6 || f6 > 2.1474836E9f) {
            return null;
        }
        return Integer.valueOf((int) f6);
    }

    public static final Short toShortExactOrNull(double d) {
        if (-32768.0d > d || d > 32767.0d) {
            return null;
        }
        return Short.valueOf((short) d);
    }

    public static final v until(long j6, byte b) {
        return new v(j6, ((long) b) - 1);
    }

    public static final boolean byteRangeContains(z zVar, int i5) {
        kotlin.jvm.internal.E.f(zVar, "<this>");
        Byte byteExactOrNull = toByteExactOrNull(i5);
        if (byteExactOrNull != null) {
            return zVar.contains(byteExactOrNull);
        }
        return false;
    }

    private static final boolean contains(v vVar, Long l6) {
        kotlin.jvm.internal.E.f(vVar, "<this>");
        if (l6 == null) {
            return false;
        }
        long jLongValue = l6.longValue();
        return vVar.f734a <= jLongValue && jLongValue <= vVar.b;
    }

    public static final /* synthetic */ boolean doubleRangeContains(InterfaceC0213j interfaceC0213j, int i5) {
        kotlin.jvm.internal.E.f(interfaceC0213j, "<this>");
        return interfaceC0213j.contains(Double.valueOf(i5));
    }

    public static final n downTo(short s6, byte b) {
        return n.Companion.fromClosedRange(s6, b, -1);
    }

    public static final long first(s sVar) {
        kotlin.jvm.internal.E.f(sVar, "<this>");
        if (!sVar.isEmpty()) {
            return sVar.f734a;
        }
        throw new NoSuchElementException("Progression " + sVar + " is empty.");
    }

    public static final Long firstOrNull(s sVar) {
        kotlin.jvm.internal.E.f(sVar, "<this>");
        if (sVar.isEmpty()) {
            return null;
        }
        return Long.valueOf(sVar.f734a);
    }

    public static final /* synthetic */ boolean floatRangeContains(InterfaceC0213j interfaceC0213j, long j6) {
        kotlin.jvm.internal.E.f(interfaceC0213j, "<this>");
        return interfaceC0213j.contains(Float.valueOf(j6));
    }

    public static final /* synthetic */ boolean intRangeContains(InterfaceC0213j interfaceC0213j, float f6) {
        kotlin.jvm.internal.E.f(interfaceC0213j, "<this>");
        Integer intExactOrNull = toIntExactOrNull(f6);
        if (intExactOrNull != null) {
            return interfaceC0213j.contains(intExactOrNull);
        }
        return false;
    }

    public static final long last(s sVar) {
        kotlin.jvm.internal.E.f(sVar, "<this>");
        if (!sVar.isEmpty()) {
            return sVar.b;
        }
        throw new NoSuchElementException("Progression " + sVar + " is empty.");
    }

    public static final Long lastOrNull(s sVar) {
        kotlin.jvm.internal.E.f(sVar, "<this>");
        if (sVar.isEmpty()) {
            return null;
        }
        return Long.valueOf(sVar.b);
    }

    public static final /* synthetic */ boolean longRangeContains(InterfaceC0213j interfaceC0213j, float f6) {
        kotlin.jvm.internal.E.f(interfaceC0213j, "<this>");
        Long longExactOrNull = toLongExactOrNull(f6);
        if (longExactOrNull != null) {
            return interfaceC0213j.contains(longExactOrNull);
        }
        return false;
    }

    public static final Integer randomOrNull(q qVar, S3.f random) {
        kotlin.jvm.internal.E.f(qVar, "<this>");
        kotlin.jvm.internal.E.f(random, "random");
        if (qVar.isEmpty()) {
            return null;
        }
        return Integer.valueOf(S3.g.nextInt(random, qVar));
    }

    public static final /* synthetic */ boolean shortRangeContains(InterfaceC0213j interfaceC0213j, float f6) {
        kotlin.jvm.internal.E.f(interfaceC0213j, "<this>");
        Short shortExactOrNull = toShortExactOrNull(f6);
        if (shortExactOrNull != null) {
            return interfaceC0213j.contains(shortExactOrNull);
        }
        return false;
    }

    public static final Byte toByteExactOrNull(double d) {
        if (-128.0d > d || d > 127.0d) {
            return null;
        }
        return Byte.valueOf((byte) d);
    }

    public static final Short toShortExactOrNull(float f6) {
        if (-32768.0f > f6 || f6 > 32767.0f) {
            return null;
        }
        return Short.valueOf((short) f6);
    }

    public static final q until(byte b, byte b6) {
        return new q(b, b6 - 1, 1);
    }

    public static final boolean byteRangeContains(InterfaceC0213j interfaceC0213j, long j6) {
        kotlin.jvm.internal.E.f(interfaceC0213j, "<this>");
        Byte byteExactOrNull = toByteExactOrNull(j6);
        if (byteExactOrNull != null) {
            return interfaceC0213j.contains(byteExactOrNull);
        }
        return false;
    }

    public static final /* synthetic */ boolean doubleRangeContains(InterfaceC0213j interfaceC0213j, long j6) {
        kotlin.jvm.internal.E.f(interfaceC0213j, "<this>");
        return interfaceC0213j.contains(Double.valueOf(j6));
    }

    public static final C0205b downTo(char c, char c6) {
        return C0205b.Companion.fromClosedRange(c, c6, -1);
    }

    public static final /* synthetic */ boolean floatRangeContains(InterfaceC0213j interfaceC0213j, short s6) {
        kotlin.jvm.internal.E.f(interfaceC0213j, "<this>");
        return interfaceC0213j.contains(Float.valueOf(s6));
    }

    public static final boolean intRangeContains(InterfaceC0213j interfaceC0213j, long j6) {
        kotlin.jvm.internal.E.f(interfaceC0213j, "<this>");
        Integer intExactOrNull = toIntExactOrNull(j6);
        if (intExactOrNull != null) {
            return interfaceC0213j.contains(intExactOrNull);
        }
        return false;
    }

    public static final boolean longRangeContains(InterfaceC0213j interfaceC0213j, int i5) {
        kotlin.jvm.internal.E.f(interfaceC0213j, "<this>");
        return interfaceC0213j.contains(Long.valueOf(i5));
    }

    private static final int random(q qVar) {
        kotlin.jvm.internal.E.f(qVar, "<this>");
        return random(qVar, S3.f.Default);
    }

    public static final boolean shortRangeContains(InterfaceC0213j interfaceC0213j, int i5) {
        kotlin.jvm.internal.E.f(interfaceC0213j, "<this>");
        Short shortExactOrNull = toShortExactOrNull(i5);
        if (shortExactOrNull != null) {
            return interfaceC0213j.contains(shortExactOrNull);
        }
        return false;
    }

    public static final Byte toByteExactOrNull(float f6) {
        if (-128.0f > f6 || f6 > 127.0f) {
            return null;
        }
        return Byte.valueOf((byte) f6);
    }

    public static final boolean byteRangeContains(z zVar, long j6) {
        kotlin.jvm.internal.E.f(zVar, "<this>");
        Byte byteExactOrNull = toByteExactOrNull(j6);
        if (byteExactOrNull != null) {
            return zVar.contains(byteExactOrNull);
        }
        return false;
    }

    public static final /* synthetic */ boolean doubleRangeContains(InterfaceC0213j interfaceC0213j, short s6) {
        kotlin.jvm.internal.E.f(interfaceC0213j, "<this>");
        return interfaceC0213j.contains(Double.valueOf(s6));
    }

    public static n downTo(int i5, int i6) {
        return n.Companion.fromClosedRange(i5, i6, -1);
    }

    public static final boolean intRangeContains(z zVar, long j6) {
        kotlin.jvm.internal.E.f(zVar, "<this>");
        Integer intExactOrNull = toIntExactOrNull(j6);
        if (intExactOrNull != null) {
            return zVar.contains(intExactOrNull);
        }
        return false;
    }

    public static final boolean longRangeContains(z zVar, int i5) {
        kotlin.jvm.internal.E.f(zVar, "<this>");
        return zVar.contains(Long.valueOf(i5));
    }

    private static final long random(v vVar) {
        kotlin.jvm.internal.E.f(vVar, "<this>");
        return random(vVar, S3.f.Default);
    }

    public static final Long randomOrNull(v vVar, S3.f random) {
        kotlin.jvm.internal.E.f(vVar, "<this>");
        kotlin.jvm.internal.E.f(random, "random");
        if (vVar.isEmpty()) {
            return null;
        }
        return Long.valueOf(S3.g.nextLong(random, vVar));
    }

    public static final s reversed(s sVar) {
        kotlin.jvm.internal.E.f(sVar, "<this>");
        return s.Companion.fromClosedRange(sVar.b, sVar.f734a, -sVar.c);
    }

    public static final boolean shortRangeContains(z zVar, int i5) {
        kotlin.jvm.internal.E.f(zVar, "<this>");
        Short shortExactOrNull = toShortExactOrNull(i5);
        if (shortExactOrNull != null) {
            return zVar.contains(shortExactOrNull);
        }
        return false;
    }

    public static final q until(short s6, byte b) {
        return new q(s6, b - 1, 1);
    }

    public static final boolean byteRangeContains(InterfaceC0213j interfaceC0213j, short s6) {
        kotlin.jvm.internal.E.f(interfaceC0213j, "<this>");
        Byte byteExactOrNull = toByteExactOrNull(s6);
        if (byteExactOrNull != null) {
            return interfaceC0213j.contains(byteExactOrNull);
        }
        return false;
    }

    public static final <T extends Comparable<? super T>> T coerceIn(T t6, InterfaceC0211h range) {
        kotlin.jvm.internal.E.f(t6, "<this>");
        kotlin.jvm.internal.E.f(range, "range");
        if (!range.isEmpty()) {
            if (!range.lessThanOrEquals(t6, range.getStart()) || range.lessThanOrEquals(range.getStart(), t6)) {
                return (!range.lessThanOrEquals(range.getEndInclusive(), t6) || range.lessThanOrEquals(t6, range.getEndInclusive())) ? t6 : (T) range.getEndInclusive();
            }
            return (T) range.getStart();
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    private static final boolean contains(C0208e c0208e, Character ch) {
        kotlin.jvm.internal.E.f(c0208e, "<this>");
        if (ch == null) {
            return false;
        }
        char cCharValue = ch.charValue();
        return kotlin.jvm.internal.E.h(c0208e.f728a, cCharValue) <= 0 && kotlin.jvm.internal.E.h(cCharValue, c0208e.b) <= 0;
    }

    public static final s downTo(long j6, int i5) {
        return s.Companion.fromClosedRange(j6, i5, -1L);
    }

    public static final char first(C0205b c0205b) {
        kotlin.jvm.internal.E.f(c0205b, "<this>");
        if (!c0205b.isEmpty()) {
            return c0205b.f728a;
        }
        throw new NoSuchElementException("Progression " + c0205b + " is empty.");
    }

    public static final Character firstOrNull(C0205b c0205b) {
        kotlin.jvm.internal.E.f(c0205b, "<this>");
        if (c0205b.isEmpty()) {
            return null;
        }
        return Character.valueOf(c0205b.f728a);
    }

    public static final boolean intRangeContains(InterfaceC0213j interfaceC0213j, short s6) {
        kotlin.jvm.internal.E.f(interfaceC0213j, "<this>");
        return interfaceC0213j.contains(Integer.valueOf(s6));
    }

    public static final char last(C0205b c0205b) {
        kotlin.jvm.internal.E.f(c0205b, "<this>");
        if (!c0205b.isEmpty()) {
            return c0205b.b;
        }
        throw new NoSuchElementException("Progression " + c0205b + " is empty.");
    }

    public static final Character lastOrNull(C0205b c0205b) {
        kotlin.jvm.internal.E.f(c0205b, "<this>");
        if (c0205b.isEmpty()) {
            return null;
        }
        return Character.valueOf(c0205b.b);
    }

    public static final boolean longRangeContains(InterfaceC0213j interfaceC0213j, short s6) {
        kotlin.jvm.internal.E.f(interfaceC0213j, "<this>");
        return interfaceC0213j.contains(Long.valueOf(s6));
    }

    private static final char random(C0208e c0208e) {
        kotlin.jvm.internal.E.f(c0208e, "<this>");
        return random(c0208e, S3.f.Default);
    }

    public static final boolean shortRangeContains(InterfaceC0213j interfaceC0213j, long j6) {
        kotlin.jvm.internal.E.f(interfaceC0213j, "<this>");
        Short shortExactOrNull = toShortExactOrNull(j6);
        if (shortExactOrNull != null) {
            return interfaceC0213j.contains(shortExactOrNull);
        }
        return false;
    }

    public static final s step(s sVar, long j6) {
        kotlin.jvm.internal.E.f(sVar, "<this>");
        A.checkStepIsPositive(j6 > 0, Long.valueOf(j6));
        r rVar = s.Companion;
        long j7 = sVar.f734a;
        long j8 = sVar.b;
        if (sVar.c <= 0) {
            j6 = -j6;
        }
        return rVar.fromClosedRange(j7, j8, j6);
    }

    public static final boolean byteRangeContains(z zVar, short s6) {
        kotlin.jvm.internal.E.f(zVar, "<this>");
        Byte byteExactOrNull = toByteExactOrNull(s6);
        if (byteExactOrNull != null) {
            return zVar.contains(byteExactOrNull);
        }
        return false;
    }

    public static final n downTo(byte b, int i5) {
        return n.Companion.fromClosedRange(b, i5, -1);
    }

    public static final boolean intRangeContains(z zVar, short s6) {
        kotlin.jvm.internal.E.f(zVar, "<this>");
        return zVar.contains(Integer.valueOf(s6));
    }

    public static final boolean longRangeContains(z zVar, short s6) {
        kotlin.jvm.internal.E.f(zVar, "<this>");
        return zVar.contains(Long.valueOf(s6));
    }

    public static final int random(q qVar, S3.f random) {
        kotlin.jvm.internal.E.f(qVar, "<this>");
        kotlin.jvm.internal.E.f(random, "random");
        try {
            return S3.g.nextInt(random, qVar);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public static final Character randomOrNull(C0208e c0208e, S3.f random) {
        kotlin.jvm.internal.E.f(c0208e, "<this>");
        kotlin.jvm.internal.E.f(random, "random");
        if (c0208e.isEmpty()) {
            return null;
        }
        return Character.valueOf((char) random.e(c0208e.f728a, c0208e.b + 1));
    }

    public static final boolean shortRangeContains(z zVar, long j6) {
        kotlin.jvm.internal.E.f(zVar, "<this>");
        Short shortExactOrNull = toShortExactOrNull(j6);
        if (shortExactOrNull != null) {
            return zVar.contains(shortExactOrNull);
        }
        return false;
    }

    public static final C0208e until(char c, char c6) {
        return kotlin.jvm.internal.E.h(c6, 0) <= 0 ? C0208e.Companion.getEMPTY() : new C0208e(c, (char) (c6 - 1), 1);
    }

    public static final n downTo(short s6, int i5) {
        return n.Companion.fromClosedRange(s6, i5, -1);
    }

    public static final s downTo(int i5, long j6) {
        return s.Companion.fromClosedRange(i5, j6, -1L);
    }

    public static final long random(v vVar, S3.f random) {
        kotlin.jvm.internal.E.f(vVar, "<this>");
        kotlin.jvm.internal.E.f(random, "random");
        try {
            return S3.g.nextLong(random, vVar);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public static final <T extends Comparable<? super T>> T coerceIn(T t6, InterfaceC0213j range) {
        kotlin.jvm.internal.E.f(t6, "<this>");
        kotlin.jvm.internal.E.f(range, "range");
        if (range instanceof InterfaceC0211h) {
            return (T) coerceIn((Comparable) t6, (InterfaceC0211h) range);
        }
        if (!range.isEmpty()) {
            if (t6.compareTo(range.getStart()) < 0) {
                return (T) range.getStart();
            }
            return t6.compareTo(range.getEndInclusive()) > 0 ? (T) range.getEndInclusive() : t6;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    public static final s downTo(long j6, long j7) {
        return s.Companion.fromClosedRange(j6, j7, -1L);
    }

    public static final C0205b reversed(C0205b c0205b) {
        kotlin.jvm.internal.E.f(c0205b, "<this>");
        return C0205b.Companion.fromClosedRange(c0205b.b, c0205b.f728a, -c0205b.c);
    }

    public static q until(int i5, int i6) {
        if (i6 <= Integer.MIN_VALUE) {
            return q.Companion.getEMPTY();
        }
        return new q(i5, i6 - 1, 1);
    }

    private static final boolean contains(q qVar, byte b) {
        kotlin.jvm.internal.E.f(qVar, "<this>");
        return intRangeContains((InterfaceC0213j) qVar, b);
    }

    public static final s downTo(byte b, long j6) {
        return s.Companion.fromClosedRange(b, j6, -1L);
    }

    private static final boolean contains(v vVar, byte b) {
        kotlin.jvm.internal.E.f(vVar, "<this>");
        return longRangeContains((InterfaceC0213j) vVar, b);
    }

    public static final s downTo(short s6, long j6) {
        return s.Companion.fromClosedRange(s6, j6, -1L);
    }

    public static final C0205b step(C0205b c0205b, int i5) {
        kotlin.jvm.internal.E.f(c0205b, "<this>");
        A.checkStepIsPositive(i5 > 0, Integer.valueOf(i5));
        C0204a c0204a = C0205b.Companion;
        char c = c0205b.f728a;
        char c6 = c0205b.b;
        if (c0205b.c <= 0) {
            i5 = -i5;
        }
        return c0204a.fromClosedRange(c, c6, i5);
    }

    private static final boolean contains(v vVar, int i5) {
        kotlin.jvm.internal.E.f(vVar, "<this>");
        return longRangeContains((InterfaceC0213j) vVar, i5);
    }

    public static final n downTo(int i5, short s6) {
        return n.Companion.fromClosedRange(i5, s6, -1);
    }

    public static final v until(long j6, int i5) {
        return new v(j6, ((long) i5) - 1);
    }

    private static final boolean contains(q qVar, long j6) {
        kotlin.jvm.internal.E.f(qVar, "<this>");
        return intRangeContains((InterfaceC0213j) qVar, j6);
    }

    public static final s downTo(long j6, short s6) {
        return s.Companion.fromClosedRange(j6, s6, -1L);
    }

    public static final q until(byte b, int i5) {
        if (i5 <= Integer.MIN_VALUE) {
            return q.Companion.getEMPTY();
        }
        return new q(b, i5 - 1, 1);
    }

    private static final boolean contains(q qVar, short s6) {
        kotlin.jvm.internal.E.f(qVar, "<this>");
        return intRangeContains((InterfaceC0213j) qVar, s6);
    }

    public static final n downTo(byte b, short s6) {
        return n.Companion.fromClosedRange(b, s6, -1);
    }

    public static final int coerceIn(int i5, InterfaceC0213j range) {
        kotlin.jvm.internal.E.f(range, "range");
        if (range instanceof InterfaceC0211h) {
            return ((Number) coerceIn(Integer.valueOf(i5), (InterfaceC0211h) range)).intValue();
        }
        if (!range.isEmpty()) {
            if (i5 < ((Number) range.getStart()).intValue()) {
                return ((Number) range.getStart()).intValue();
            }
            return i5 > ((Number) range.getEndInclusive()).intValue() ? ((Number) range.getEndInclusive()).intValue() : i5;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    private static final boolean contains(v vVar, short s6) {
        kotlin.jvm.internal.E.f(vVar, "<this>");
        return longRangeContains((InterfaceC0213j) vVar, s6);
    }

    public static final n downTo(short s6, short s7) {
        return n.Companion.fromClosedRange(s6, s7, -1);
    }

    public static final q until(short s6, int i5) {
        if (i5 <= Integer.MIN_VALUE) {
            return q.Companion.getEMPTY();
        }
        return new q(s6, i5 - 1, 1);
    }

    public static final v until(int i5, long j6) {
        if (j6 <= Long.MIN_VALUE) {
            return v.Companion.getEMPTY();
        }
        return new v(i5, j6 - 1);
    }

    public static long coerceIn(long j6, InterfaceC0213j range) {
        kotlin.jvm.internal.E.f(range, "range");
        if (range instanceof InterfaceC0211h) {
            return ((Number) coerceIn(Long.valueOf(j6), (InterfaceC0211h) range)).longValue();
        }
        if (!range.isEmpty()) {
            if (j6 < ((Number) range.getStart()).longValue()) {
                return ((Number) range.getStart()).longValue();
            }
            return j6 > ((Number) range.getEndInclusive()).longValue() ? ((Number) range.getEndInclusive()).longValue() : j6;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    public static final v until(long j6, long j7) {
        if (j7 <= Long.MIN_VALUE) {
            return v.Companion.getEMPTY();
        }
        return new v(j6, j7 - 1);
    }

    public static final v until(byte b, long j6) {
        if (j6 <= Long.MIN_VALUE) {
            return v.Companion.getEMPTY();
        }
        return new v(b, j6 - 1);
    }

    public static final v until(short s6, long j6) {
        if (j6 <= Long.MIN_VALUE) {
            return v.Companion.getEMPTY();
        }
        return new v(s6, j6 - 1);
    }

    public static final q until(int i5, short s6) {
        return new q(i5, s6 - 1, 1);
    }

    public static final v until(long j6, short s6) {
        return new v(j6, ((long) s6) - 1);
    }

    public static final q until(byte b, short s6) {
        return new q(b, s6 - 1, 1);
    }

    public static final q until(short s6, short s7) {
        return new q(s6, s7 - 1, 1);
    }
}
