package okhttp3;

import androidx.core.location.LocationRequestCompat;
import com.alibaba.android.arouter.utils.Consts;
import java.text.DateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import org.apache.logging.log4j.util.Chars;
import org.apache.logging.log4j.util.ProcessIdUtil;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.opencv.videoio.Videoio;

/* JADX INFO: renamed from: okhttp3.m, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class C1367m {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Pattern f6660j = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Pattern f6661k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Pattern f6662l = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Pattern f6663m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6664a;
    public final String b;
    public final long c;
    public final String d;
    public final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f6665f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f6666g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f6667h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f6668i;

    public C1367m(String str, String str2, long j6, String str3, String str4, boolean z6, boolean z7, boolean z8, boolean z9) {
        this.f6664a = str;
        this.b = str2;
        this.c = j6;
        this.d = str3;
        this.e = str4;
        this.f6665f = z6;
        this.f6666g = z7;
        this.f6668i = z8;
        this.f6667h = z9;
    }

    public static int a(String str, int i5, int i6, boolean z6) {
        while (i5 < i6) {
            char cCharAt = str.charAt(i5);
            if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || (cCharAt >= '0' && cCharAt <= '9') || ((cCharAt >= 'a' && cCharAt <= 'z') || ((cCharAt >= 'A' && cCharAt <= 'Z') || cCharAt == ':'))) == (!z6)) {
                return i5;
            }
            i5++;
        }
        return i6;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x007f  */
    public static long b(int i5, String str) {
        int iA = a(str, 0, i5, false);
        Pattern pattern = f6663m;
        Matcher matcher = pattern.matcher(str);
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        int iIndexOf = -1;
        int i9 = -1;
        int i10 = -1;
        while (iA < i5) {
            int iA2 = a(str, iA + 1, i5, true);
            matcher.region(iA, iA2);
            if (i7 == -1 && matcher.usePattern(pattern).matches()) {
                i7 = Integer.parseInt(matcher.group(1));
                i9 = Integer.parseInt(matcher.group(2));
                i10 = Integer.parseInt(matcher.group(3));
            } else if (i8 == -1 && matcher.usePattern(f6662l).matches()) {
                i8 = Integer.parseInt(matcher.group(1));
            } else if (iIndexOf == -1) {
                Pattern pattern2 = f6661k;
                if (matcher.usePattern(pattern2).matches()) {
                    iIndexOf = pattern2.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
                } else if (i6 != -1 && matcher.usePattern(f6660j).matches()) {
                    i6 = Integer.parseInt(matcher.group(1));
                }
            } else if (i6 != -1) {
            }
            iA = a(str, iA2 + 1, i5, false);
        }
        if (i6 >= 70 && i6 <= 99) {
            i6 += Videoio.CAP_FFMPEG;
        }
        if (i6 >= 0 && i6 <= 69) {
            i6 += 2000;
        }
        if (i6 < 1601) {
            throw new IllegalArgumentException();
        }
        if (iIndexOf == -1) {
            throw new IllegalArgumentException();
        }
        if (i8 < 1 || i8 > 31) {
            throw new IllegalArgumentException();
        }
        if (i7 < 0 || i7 > 23) {
            throw new IllegalArgumentException();
        }
        if (i9 < 0 || i9 > 59) {
            throw new IllegalArgumentException();
        }
        if (i10 < 0 || i10 > 59) {
            throw new IllegalArgumentException();
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(p107s4.d.f8238h);
        gregorianCalendar.setLenient(false);
        gregorianCalendar.set(1, i6);
        gregorianCalendar.set(2, iIndexOf - 1);
        gregorianCalendar.set(5, i8);
        gregorianCalendar.set(11, i7);
        gregorianCalendar.set(12, i9);
        gregorianCalendar.set(13, i10);
        gregorianCalendar.set(14, 0);
        return gregorianCalendar.getTimeInMillis();
    }

    public static C1367m parse(C1378y c1378y, String str) {
        return parse(System.currentTimeMillis(), c1378y, str);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1367m)) {
            return false;
        }
        C1367m c1367m = (C1367m) obj;
        return c1367m.f6664a.equals(this.f6664a) && c1367m.b.equals(this.b) && c1367m.d.equals(this.d) && c1367m.e.equals(this.e) && c1367m.c == this.c && c1367m.f6665f == this.f6665f && c1367m.f6666g == this.f6666g && c1367m.f6667h == this.f6667h && c1367m.f6668i == this.f6668i;
    }

    public final int hashCode() {
        int iA = androidx.exifinterface.media.a.a(androidx.exifinterface.media.a.a(androidx.exifinterface.media.a.a(androidx.exifinterface.media.a.a(527, 31, this.f6664a), 31, this.b), 31, this.d), 31, this.e);
        long j6 = this.c;
        return ((((((((iA + ((int) (j6 ^ (j6 >>> 32)))) * 31) + (!this.f6665f ? 1 : 0)) * 31) + (!this.f6666g ? 1 : 0)) * 31) + (!this.f6667h ? 1 : 0)) * 31) + (!this.f6668i ? 1 : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f6664a);
        sb.append(Chars.EQ);
        sb.append(this.b);
        if (this.f6667h) {
            long j6 = this.c;
            if (j6 == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(((DateFormat) p118u4.d.f8736a.get()).format(new Date(j6)));
            }
        }
        if (!this.f6668i) {
            sb.append("; domain=");
            sb.append(this.d);
        }
        sb.append("; path=");
        sb.append(this.e);
        if (this.f6665f) {
            sb.append("; secure");
        }
        if (this.f6666g) {
            sb.append("; httponly");
        }
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [okhttp3.internal.publicsuffix.PublicSuffixDatabase] */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v13 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Type inference failed for: r16v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r17v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.util.regex.Pattern] */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static C1367m parse(long j6, C1378y c1378y, String str) {
        C1367m c1367m;
        ?? r8;
        ?? r15;
        String strSubstring;
        int length = str.length();
        char c = ';';
        int iG = p107s4.d.g(str, 0, length, ';');
        int iG2 = p107s4.d.g(str, 0, iG, Chars.EQ);
        if (iG2 != iG) {
            int iN = p107s4.d.n(0, iG2, str);
            String strSubstring2 = str.substring(iN, p107s4.d.o(iN, iG2, str));
            if (!strSubstring2.isEmpty()) {
                int length2 = strSubstring2.length();
                int i5 = 0;
                while (true) {
                    if (i5 >= length2) {
                        i5 = -1;
                        break;
                    }
                    char cCharAt = strSubstring2.charAt(i5);
                    if (cCharAt <= 31 || cCharAt >= 127) {
                        break;
                    }
                    i5++;
                }
                if (i5 == -1) {
                    int iN2 = p107s4.d.n(iG2 + 1, iG, str);
                    String strSubstring3 = str.substring(iN2, p107s4.d.o(iN2, iG, str));
                    int length3 = strSubstring3.length();
                    int i6 = 0;
                    while (true) {
                        if (i6 >= length3) {
                            c1367m = null;
                            i6 = -1;
                            break;
                        }
                        c1367m = null;
                        char cCharAt2 = strSubstring3.charAt(i6);
                        if (cCharAt2 <= 31 || cCharAt2 >= 127) {
                            break;
                        }
                        i6++;
                    }
                    if (i6 != -1) {
                        return c1367m;
                    }
                    int i7 = iG + 1;
                    long j7 = 253402300799999L;
                    boolean z6 = false;
                    boolean z7 = false;
                    boolean z8 = false;
                    boolean z9 = true;
                    long jB = 253402300799999L;
                    C1367m c1367m2 = c1367m;
                    ?? r16 = c1367m2;
                    long j8 = -1;
                    ?? r9 = c1367m2;
                    while (true) {
                        long j9 = LocationRequestCompat.PASSIVE_INTERVAL;
                        if (i7 >= length) {
                            if (j8 == Long.MIN_VALUE) {
                                j7 = Long.MIN_VALUE;
                            } else if (j8 != -1) {
                                if (j8 <= 9223372036854775L) {
                                    j9 = j8 * 1000;
                                }
                                long j10 = j6 + j9;
                                if (j10 >= j6 && j10 <= 253402300799999L) {
                                    j7 = j10;
                                }
                            } else {
                                j7 = jB;
                            }
                            ?? r6 = c1378y.d;
                            if (r9 == 0) {
                                r8 = r6;
                            } else if (!r6.equals(r9)) {
                                if (!r6.endsWith(r9) || r6.charAt((r6.length() - r9.length()) - 1) != '.') {
                                    r8 = r9;
                                    return c1367m;
                                }
                                if (p107s4.d.f8241k.matcher(r6).matches()) {
                                    r8 = r9;
                                    r8 = r9;
                                    return c1367m;
                                }
                            }
                            r8 = r9;
                            r8 = r9;
                            r8 = r9;
                            if (r6.length() != r8.length() && PublicSuffixDatabase.f6656h.b(r8) == null) {
                                return c1367m;
                            }
                            String strSubstring4 = PackagingURIHelper.FORWARD_SLASH_STRING;
                            if (r16 == 0 || !r16.startsWith(PackagingURIHelper.FORWARD_SLASH_STRING)) {
                                r15 = r16;
                                String str2 = c1378y.f6682g;
                                int iIndexOf = str2.indexOf(47, c1378y.f6680a.length() + 3);
                                String strSubstring5 = str2.substring(iIndexOf, p107s4.d.f(iIndexOf, str2.length(), str2, "?#"));
                                int iLastIndexOf = strSubstring5.lastIndexOf(47);
                                if (iLastIndexOf != 0) {
                                    strSubstring4 = strSubstring5.substring(0, iLastIndexOf);
                                }
                                r15 = strSubstring4;
                            }
                            r15 = r16;
                            return new C1367m(strSubstring2, strSubstring3, j7, r8, r15, z6, z7, z9, z8);
                        }
                        int iG3 = p107s4.d.g(str, i7, length, c);
                        int iG4 = p107s4.d.g(str, i7, iG3, Chars.EQ);
                        int iN3 = p107s4.d.n(i7, iG4, str);
                        String strSubstring6 = str.substring(iN3, p107s4.d.o(iN3, iG4, str));
                        if (iG4 < iG3) {
                            int iN4 = p107s4.d.n(iG4 + 1, iG3, str);
                            strSubstring = str.substring(iN4, p107s4.d.o(iN4, iG3, str));
                        } else {
                            strSubstring = "";
                        }
                        if (strSubstring6.equalsIgnoreCase("expires")) {
                            try {
                                jB = b(strSubstring.length(), strSubstring);
                                z8 = true;
                            } catch (NumberFormatException | IllegalArgumentException unused) {
                            }
                        } else if (strSubstring6.equalsIgnoreCase("max-age")) {
                            try {
                                j8 = Long.parseLong(strSubstring);
                                if (j8 <= 0) {
                                    j8 = Long.MIN_VALUE;
                                }
                            } catch (NumberFormatException e) {
                                if (!strSubstring.matches("-?\\d+")) {
                                    throw e;
                                }
                                if (strSubstring.startsWith(ProcessIdUtil.DEFAULT_PROCESSID)) {
                                    j9 = Long.MIN_VALUE;
                                }
                                j8 = j9;
                            }
                            z8 = true;
                        } else if (strSubstring6.equalsIgnoreCase("domain")) {
                            if (strSubstring.endsWith(Consts.DOT)) {
                                throw new IllegalArgumentException();
                            }
                            if (strSubstring.startsWith(Consts.DOT)) {
                                strSubstring = strSubstring.substring(1);
                            }
                            String strA = p107s4.d.a(strSubstring);
                            if (strA == null) {
                                throw new IllegalArgumentException();
                            }
                            r9 = strA;
                            z9 = false;
                        } else if (strSubstring6.equalsIgnoreCase("path")) {
                            r16 = strSubstring;
                        } else if (strSubstring6.equalsIgnoreCase("secure")) {
                            z6 = true;
                        } else if (strSubstring6.equalsIgnoreCase("httponly")) {
                            z7 = true;
                        }
                        i7 = iG3 + 1;
                        c = ';';
                        r9 = r9;
                        r16 = r16;
                    }
                }
            }
        }
        return null;
    }
}
