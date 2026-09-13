package Y3;

import U3.B;
import U3.q;
import X3.W;
import X3.b0;
import X3.e0;
import androidx.core.location.LocationRequestCompat;
import java.util.Collection;
import kotlin.jvm.internal.E;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.common.NameUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d {
    public static final long a(String str, boolean z6) {
        char c;
        long jH;
        char cCharAt;
        char cCharAt2;
        char cCharAt3;
        int length = str.length();
        if (length == 0) {
            throw new IllegalArgumentException("The string is empty");
        }
        b.Companion.getClass();
        boolean z7 = false;
        char cCharAt4 = str.charAt(0);
        int i5 = (cCharAt4 == '+' || cCharAt4 == '-') ? 1 : 0;
        boolean z8 = i5 > 0;
        boolean z9 = z8 && b0.startsWith((CharSequence) str, '-', false);
        if (length <= i5) {
            throw new IllegalArgumentException("No components");
        }
        char cCharAt5 = str.charAt(i5);
        char c6 = '.';
        String str2 = "Unexpected order of duration components";
        char c7 = NameUtil.COLON;
        char c8 = '0';
        e eVar = null;
        long jH2 = 0;
        if (cCharAt5 == 'P') {
            int i6 = i5 + 1;
            if (i6 == length) {
                throw new IllegalArgumentException();
            }
            boolean z10 = false;
            c = 1;
            e eVar2 = null;
            jH = 0;
            while (i6 < length) {
                if (str.charAt(i6) != 'T') {
                    int i7 = i6;
                    while (i7 < str.length() && ((c8 <= (cCharAt3 = str.charAt(i7)) && cCharAt3 < ':') || b0.contains((CharSequence) "+-.", cCharAt3, false))) {
                        i7++;
                        c8 = '0';
                    }
                    String strSubstring = str.substring(i6, i7);
                    E.e(strSubstring, "substring(...)");
                    if (strSubstring.length() == 0) {
                        throw new IllegalArgumentException();
                    }
                    int length2 = strSubstring.length() + i6;
                    if (length2 < 0 || length2 >= str.length()) {
                        throw new IllegalArgumentException("Missing unit for value ".concat(strSubstring));
                    }
                    char cCharAt6 = str.charAt(length2);
                    int i8 = length2 + 1;
                    e eVarDurationUnitByIsoChar = h.durationUnitByIsoChar(cCharAt6, z10);
                    if (eVar2 != null && eVar2.compareTo(eVarDurationUnitByIsoChar) <= 0) {
                        throw new IllegalArgumentException(str2);
                    }
                    int iD = b0.d(strSubstring, c6, 0, false, 6);
                    if (eVarDurationUnitByIsoChar != e.SECONDS || iD <= 0) {
                        jH = b.h(jH, toDuration(e(strSubstring), eVarDurationUnitByIsoChar));
                    } else {
                        String strSubstring2 = strSubstring.substring(0, iD);
                        E.e(strSubstring2, "substring(...)");
                        long jH3 = b.h(jH, toDuration(e(strSubstring2), eVarDurationUnitByIsoChar));
                        String strSubstring3 = strSubstring.substring(iD);
                        E.e(strSubstring3, "substring(...)");
                        jH = b.h(jH3, toDuration(Double.parseDouble(strSubstring3), eVarDurationUnitByIsoChar));
                    }
                    eVar2 = eVarDurationUnitByIsoChar;
                    i6 = i8;
                    str2 = str2;
                    c8 = '0';
                    c6 = '.';
                } else {
                    if (z10 || (i6 = i6 + 1) == length) {
                        throw new IllegalArgumentException();
                    }
                    z10 = true;
                }
            }
        } else {
            c = 1;
            String str3 = "Unexpected order of duration components";
            if (z6) {
                throw new IllegalArgumentException();
            }
            char c9 = '0';
            if (W.regionMatches(str, i5, "Infinity", 0, Math.max(length - i5, 8), true)) {
                jH = b.b;
            } else {
                boolean z11 = !z8;
                if (z8 && str.charAt(i5) == '(' && e0.last(str) == ')') {
                    i5++;
                    length--;
                    if (i5 == length) {
                        throw new IllegalArgumentException("No components");
                    }
                    z11 = true;
                }
                while (i5 < length) {
                    if (z7 && z11) {
                        while (i5 < str.length() && str.charAt(i5) == ' ') {
                            i5++;
                        }
                    }
                    int i9 = i5;
                    while (i9 < str.length() && ((c9 <= (cCharAt2 = str.charAt(i9)) && cCharAt2 < c7) || cCharAt2 == '.')) {
                        i9++;
                    }
                    String strSubstring4 = str.substring(i5, i9);
                    E.e(strSubstring4, "substring(...)");
                    if (strSubstring4.length() == 0) {
                        throw new IllegalArgumentException();
                    }
                    int length3 = strSubstring4.length() + i5;
                    int i10 = length3;
                    while (i10 < str.length() && 'a' <= (cCharAt = str.charAt(i10)) && cCharAt < '{') {
                        i10++;
                    }
                    String strSubstring5 = str.substring(length3, i10);
                    E.e(strSubstring5, "substring(...)");
                    int length4 = length3 + strSubstring5.length();
                    e eVarDurationUnitByShortName = h.durationUnitByShortName(strSubstring5);
                    if (eVar != null && eVar.compareTo(eVarDurationUnitByShortName) <= 0) {
                        throw new IllegalArgumentException(str3);
                    }
                    String str4 = str3;
                    int iD2 = b0.d(strSubstring4, '.', 0, false, 6);
                    if (iD2 > 0) {
                        String strSubstring6 = strSubstring4.substring(0, iD2);
                        E.e(strSubstring6, "substring(...)");
                        long jH4 = b.h(jH2, toDuration(Long.parseLong(strSubstring6), eVarDurationUnitByShortName));
                        String strSubstring7 = strSubstring4.substring(iD2);
                        E.e(strSubstring7, "substring(...)");
                        jH2 = b.h(jH4, toDuration(Double.parseDouble(strSubstring7), eVarDurationUnitByShortName));
                        if (length4 < length) {
                            throw new IllegalArgumentException("Fractional component must be last");
                        }
                    } else {
                        jH2 = b.h(jH2, toDuration(Long.parseLong(strSubstring4), eVarDurationUnitByShortName));
                    }
                    str3 = str4;
                    z7 = true;
                    c9 = '0';
                    c7 = NameUtil.COLON;
                    eVar = eVarDurationUnitByShortName;
                    i5 = length4;
                }
                jH = jH2;
            }
        }
        if (!z9) {
            return jH;
        }
        long j6 = ((-(jH >> c)) << c) + ((long) (((int) jH) & 1));
        int i11 = c.f874a;
        return j6;
    }

    public static final long b(long j6) {
        long j7 = (j6 << 1) + 1;
        a aVar = b.Companion;
        int i5 = c.f874a;
        return j7;
    }

    public static final long c(long j6) {
        return (-4611686018426L > j6 || j6 >= 4611686018427L) ? b(B.a(j6, -4611686018427387903L, 4611686018427387903L)) : d(j6 * ((long) SchemaType.SIZE_BIG_INTEGER));
    }

    public static final long d(long j6) {
        long j7 = j6 << 1;
        a aVar = b.Companion;
        int i5 = c.f874a;
        return j7;
    }

    public static final long e(String str) {
        int length = str.length();
        int i5 = (length <= 0 || !b0.contains((CharSequence) "+-", str.charAt(0), false)) ? 0 : 1;
        if (length - i5 > 16) {
            Iterable qVar = new q(i5, b0.getLastIndex(str), 1);
            if (!(qVar instanceof Collection) || !((Collection) qVar).isEmpty()) {
                A3.e0 it = qVar.iterator();
                while (true) {
                    if (it.hasNext()) {
                        char cCharAt = str.charAt(it.nextInt());
                        if ('0' > cCharAt || cCharAt >= ':') {
                        }
                    }
                }
            }
            if (str.charAt(0) == '-') {
                return Long.MIN_VALUE;
            }
            return LocationRequestCompat.PASSIVE_INTERVAL;
        }
        return W.startsWith(str, "+", false) ? Long.parseLong(e0.drop(str, 1)) : Long.parseLong(str);
    }

    /* JADX INFO: renamed from: times-kIfJnKk, reason: not valid java name */
    private static final long m924timeskIfJnKk(double d, long j6) {
        a aVar = b.Companion;
        int iRoundToInt = Q3.c.roundToInt(d);
        if (iRoundToInt == d) {
            return b.i(iRoundToInt, j6);
        }
        e eVar = (((int) j6) & 1) == 0 ? e.NANOSECONDS : e.MILLISECONDS;
        return toDuration(b.m917toDoubleimpl(j6, eVar) * d, eVar);
    }

    /* JADX INFO: renamed from: times-mvk6XK0, reason: not valid java name */
    private static final long m925timesmvk6XK0(int i5, long j6) {
        return b.i(i5, j6);
    }

    public static final long toDuration(int i5, e unit) {
        E.f(unit, "unit");
        return unit.compareTo(e.SECONDS) <= 0 ? d(g.convertDurationUnitOverflow(i5, unit, e.NANOSECONDS)) : toDuration(i5, unit);
    }

    public static final long toDuration(long j6, e unit) {
        E.f(unit, "unit");
        e eVar = e.NANOSECONDS;
        long jConvertDurationUnitOverflow = g.convertDurationUnitOverflow(4611686018426999999L, eVar, unit);
        if ((-jConvertDurationUnitOverflow) <= j6 && j6 <= jConvertDurationUnitOverflow) {
            return d(g.convertDurationUnitOverflow(j6, unit, eVar));
        }
        return b(B.a(g.convertDurationUnit(j6, unit, e.MILLISECONDS), -4611686018427387903L, 4611686018427387903L));
    }

    public static final long toDuration(double d, e unit) {
        E.f(unit, "unit");
        double dConvertDurationUnit = g.convertDurationUnit(d, unit, e.NANOSECONDS);
        if (!Double.isNaN(dConvertDurationUnit)) {
            long jRoundToLong = Q3.c.roundToLong(dConvertDurationUnit);
            if (-4611686018426999999L <= jRoundToLong && jRoundToLong < 4611686018427000000L) {
                return d(jRoundToLong);
            }
            return c(Q3.c.roundToLong(g.convertDurationUnit(d, unit, e.MILLISECONDS)));
        }
        throw new IllegalArgumentException("Duration value cannot be NaN.");
    }
}
