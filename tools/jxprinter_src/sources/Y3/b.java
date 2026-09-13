package Y3;

import A3.AbstractC0157z;
import O3.p;
import O3.q;
import O3.r;
import O3.s;
import U3.B;
import X3.b0;
import androidx.core.location.LocationRequestCompat;
import androidx.exifinterface.media.ExifInterface;
import kotlin.jvm.internal.E;
import org.apache.logging.log4j.util.Chars;
import org.apache.xmlbeans.SchemaType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements Comparable {
    public static final a Companion = new a();
    public static final long b;
    public static final long c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f873a;

    static {
        int i5 = c.f874a;
        b = d.b(4611686018427387903L);
        c = d.b(-4611686018427387903L);
    }

    public /* synthetic */ b(long j6) {
        this.f873a = j6;
    }

    public static final long a(long j6, long j7) {
        long j8 = SchemaType.SIZE_BIG_INTEGER;
        long j9 = j7 / j8;
        long j10 = j6 + j9;
        if (-4611686018426L > j10 || j10 >= 4611686018427L) {
            return d.b(B.a(j10, -4611686018427387903L, 4611686018427387903L));
        }
        return d.d((j10 * j8) + (j7 - (j9 * j8)));
    }

    public static final void b(StringBuilder sb, int i5, int i6, int i7, String str, boolean z6) {
        sb.append(i5);
        if (i6 != 0) {
            sb.append('.');
            String strPadStart = b0.padStart(String.valueOf(i6), i7, '0');
            int i8 = -1;
            int length = strPadStart.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i9 = length - 1;
                    if (strPadStart.charAt(length) != '0') {
                        i8 = length;
                        break;
                    } else if (i9 < 0) {
                        break;
                    } else {
                        length = i9;
                    }
                }
            }
            int i10 = i8 + 1;
            if (z6 || i10 >= 3) {
                sb.append((CharSequence) strPadStart, 0, ((i8 + 3) / 3) * 3);
            } else {
                sb.append((CharSequence) strPadStart, 0, i10);
            }
        }
        sb.append(str);
    }

    public static int c(long j6, long j7) {
        long j8 = j6 ^ j7;
        if (j8 >= 0 && (((int) j8) & 1) != 0) {
            int i5 = (((int) j6) & 1) - (((int) j7) & 1);
            return j6 < 0 ? -i5 : i5;
        }
        if (j6 < j7) {
            return -1;
        }
        return j6 == j7 ? 0 : 1;
    }

    public static final int d(long j6) {
        if (g(j6)) {
            return 0;
        }
        return (int) (m920toLongimpl(j6, e.MINUTES) % ((long) 60));
    }

    public static final int e(long j6) {
        if (g(j6)) {
            return 0;
        }
        return (int) ((((int) j6) & 1) == 1 ? ((j6 >> 1) % ((long) 1000)) * ((long) SchemaType.SIZE_BIG_INTEGER) : (j6 >> 1) % ((long) 1000000000));
    }

    public static final int f(long j6) {
        if (g(j6)) {
            return 0;
        }
        return (int) (m920toLongimpl(j6, e.SECONDS) % ((long) 60));
    }

    public static final boolean g(long j6) {
        return j6 == b || j6 == c;
    }

    public static final long h(long j6, long j7) {
        if (g(j6)) {
            if (!g(j7) || (j7 ^ j6) >= 0) {
                return j6;
            }
            throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
        }
        if (g(j7)) {
            return j7;
        }
        int i5 = ((int) j6) & 1;
        if (i5 != (((int) j7) & 1)) {
            return i5 == 1 ? a(j6 >> 1, j7 >> 1) : a(j7 >> 1, j6 >> 1);
        }
        long j8 = (j6 >> 1) + (j7 >> 1);
        if (i5 == 0) {
            return (-4611686018426999999L > j8 || j8 >= 4611686018427000000L) ? d.b(j8 / ((long) SchemaType.SIZE_BIG_INTEGER)) : d.d(j8);
        }
        return d.c(j8);
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00aa, code lost:
    
        if ((java.lang.Integer.signum(r21) * java.lang.Long.signum(r7)) > 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ca, code lost:
    
        if ((java.lang.Integer.signum(r21) * java.lang.Long.signum(r7)) > 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00ce, code lost:
    
        return Y3.b.b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00d1, code lost:
    
        return Y3.b.c;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long i(int r21, long r22) {
        /*
            Method dump skipped, instruction units count: 210
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: Y3.b.i(int, long):long");
    }

    /* JADX INFO: renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m916toComponentsimpl(long j6, s action) {
        E.f(action, "action");
        m920toLongimpl(j6, e.DAYS);
        if (!g(j6)) {
            long jM920toLongimpl = m920toLongimpl(j6, e.HOURS) % ((long) 24);
        }
        d(j6);
        f(j6);
        e(j6);
        return (T) action.a();
    }

    /* JADX INFO: renamed from: toDouble-impl, reason: not valid java name */
    public static final double m917toDoubleimpl(long j6, e unit) {
        E.f(unit, "unit");
        if (j6 == b) {
            return Double.POSITIVE_INFINITY;
        }
        if (j6 == c) {
            return Double.NEGATIVE_INFINITY;
        }
        return g.convertDurationUnit(j6 >> 1, (((int) j6) & 1) == 0 ? e.NANOSECONDS : e.MILLISECONDS, unit);
    }

    /* JADX INFO: renamed from: toInt-impl, reason: not valid java name */
    public static final int m918toIntimpl(long j6, e unit) {
        E.f(unit, "unit");
        return (int) B.a(m920toLongimpl(j6, unit), -2147483648L, 2147483647L);
    }

    /* JADX INFO: renamed from: toIsoString-impl, reason: not valid java name */
    public static final String m919toIsoStringimpl(long j6) {
        long j7;
        StringBuilder sb = new StringBuilder();
        if (j6 < 0) {
            sb.append('-');
        }
        sb.append("PT");
        boolean z6 = true;
        if (j6 < 0) {
            j7 = ((-(j6 >> 1)) << 1) + ((long) (((int) j6) & 1));
            int i5 = c.f874a;
        } else {
            j7 = j6;
        }
        long jM920toLongimpl = m920toLongimpl(j7, e.HOURS);
        int iD = d(j7);
        int iF = f(j7);
        int iE = e(j7);
        if (g(j6)) {
            jM920toLongimpl = 9999999999999L;
        }
        boolean z7 = jM920toLongimpl != 0;
        boolean z8 = (iF == 0 && iE == 0) ? false : true;
        if (iD == 0 && (!z8 || !z7)) {
            z6 = false;
        }
        if (z7) {
            sb.append(jM920toLongimpl);
            sb.append('H');
        }
        if (z6) {
            sb.append(iD);
            sb.append('M');
        }
        if (z8 || (!z7 && !z6)) {
            b(sb, iF, iE, 9, ExifInterface.LATITUDE_SOUTH, true);
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: toLong-impl, reason: not valid java name */
    public static final long m920toLongimpl(long j6, e unit) {
        E.f(unit, "unit");
        if (j6 == b) {
            return LocationRequestCompat.PASSIVE_INTERVAL;
        }
        if (j6 == c) {
            return Long.MIN_VALUE;
        }
        return g.convertDurationUnit(j6 >> 1, (((int) j6) & 1) == 0 ? e.NANOSECONDS : e.MILLISECONDS, unit);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m921toStringimpl(long j6) {
        if (j6 == 0) {
            return "0s";
        }
        if (j6 == b) {
            return "Infinity";
        }
        if (j6 == c) {
            return "-Infinity";
        }
        int i5 = 0;
        boolean z6 = j6 < 0;
        StringBuilder sb = new StringBuilder();
        if (z6) {
            sb.append('-');
        }
        if (j6 < 0) {
            j6 = ((long) (((int) j6) & 1)) + ((-(j6 >> 1)) << 1);
            int i6 = c.f874a;
        }
        long jM920toLongimpl = m920toLongimpl(j6, e.DAYS);
        int iM920toLongimpl = g(j6) ? 0 : (int) (m920toLongimpl(j6, e.HOURS) % ((long) 24));
        int iD = d(j6);
        int iF = f(j6);
        int iE = e(j6);
        boolean z7 = jM920toLongimpl != 0;
        boolean z8 = iM920toLongimpl != 0;
        boolean z9 = iD != 0;
        boolean z10 = (iF == 0 && iE == 0) ? false : true;
        if (z7) {
            sb.append(jM920toLongimpl);
            sb.append('d');
            i5 = 1;
        }
        if (z8 || (z7 && (z9 || z10))) {
            int i7 = i5 + 1;
            if (i5 > 0) {
                sb.append(Chars.SPACE);
            }
            sb.append(iM920toLongimpl);
            sb.append('h');
            i5 = i7;
        }
        if (z9 || (z10 && (z8 || z7))) {
            int i8 = i5 + 1;
            if (i5 > 0) {
                sb.append(Chars.SPACE);
            }
            sb.append(iD);
            sb.append('m');
            i5 = i8;
        }
        if (z10) {
            int i9 = i5 + 1;
            if (i5 > 0) {
                sb.append(Chars.SPACE);
            }
            if (iF != 0 || z7 || z8 || z9) {
                b(sb, iF, iE, 9, "s", false);
            } else if (iE >= 1000000) {
                b(sb, iE / SchemaType.SIZE_BIG_INTEGER, iE % SchemaType.SIZE_BIG_INTEGER, 6, "ms", false);
            } else if (iE >= 1000) {
                b(sb, iE / 1000, iE % 1000, 3, "us", false);
            } else {
                sb.append(iE);
                sb.append("ns");
            }
            i5 = i9;
        }
        if (z6 && i5 > 1) {
            sb.insert(1, '(').append(')');
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: truncateTo-UwyO8pc$kotlin_stdlib, reason: not valid java name */
    public static final long m923truncateToUwyO8pc$kotlin_stdlib(long j6, e unit) {
        E.f(unit, "unit");
        e eVar = (((int) j6) & 1) == 0 ? e.NANOSECONDS : e.MILLISECONDS;
        if (unit.compareTo(eVar) <= 0 || g(j6)) {
            return j6;
        }
        long j7 = j6 >> 1;
        return d.toDuration(j7 - (j7 % g.convertDurationUnit(1L, unit, eVar)), eVar);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return c(this.f873a, ((b) obj).f873a);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof b) {
            return this.f873a == ((b) obj).f873a;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.f873a);
    }

    public String toString() {
        return m921toStringimpl(this.f873a);
    }

    /* JADX INFO: renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m915toComponentsimpl(long j6, r action) {
        E.f(action, "action");
        return (T) action.invoke(Long.valueOf(m920toLongimpl(j6, e.HOURS)), Integer.valueOf(d(j6)), Integer.valueOf(f(j6)), Integer.valueOf(e(j6)));
    }

    /* JADX INFO: renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m914toComponentsimpl(long j6, q action) {
        E.f(action, "action");
        return (T) action.invoke(Long.valueOf(m920toLongimpl(j6, e.MINUTES)), Integer.valueOf(f(j6)), Integer.valueOf(e(j6)));
    }

    /* JADX INFO: renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m913toComponentsimpl(long j6, p action) {
        E.f(action, "action");
        return (T) action.invoke(Long.valueOf(m920toLongimpl(j6, e.SECONDS)), Integer.valueOf(e(j6)));
    }

    public static /* synthetic */ void getHoursComponent$annotations() {
    }

    public static /* synthetic */ void getMinutesComponent$annotations() {
    }

    public static /* synthetic */ void getNanosecondsComponent$annotations() {
    }

    public static /* synthetic */ void getSecondsComponent$annotations() {
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static final String m922toStringimpl(long j6, e unit, int i5) {
        E.f(unit, "unit");
        if (i5 >= 0) {
            double dM917toDoubleimpl = m917toDoubleimpl(j6, unit);
            if (Double.isInfinite(dM917toDoubleimpl)) {
                return String.valueOf(dM917toDoubleimpl);
            }
            StringBuilder sb = new StringBuilder();
            if (i5 > 12) {
                i5 = 12;
            }
            sb.append(c.formatToExactDecimals(dM917toDoubleimpl, i5));
            sb.append(h.shortName(unit));
            return sb.toString();
        }
        throw new IllegalArgumentException(AbstractC0157z.k(i5, "decimals must be not negative, but was ").toString());
    }
}
