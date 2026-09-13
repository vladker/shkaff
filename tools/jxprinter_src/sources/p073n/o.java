package p073n;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;
import p050j.a;
import p067m.b;
import p067m.g;
import p079o.C1281j;
import p079o.G;
import p079o.InterfaceC1290t;
import p079o.Q;
import p079o.b0;
import p079o.c0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class o extends f implements Q, InterfaceC1290t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f6191a = new o();
    public static final DateTimeFormatter b = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static final DateTimeFormatter c = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    public static final DateTimeFormatter d = DateTimeFormatter.ofPattern("yyyy年M月d日 HH:mm:ss");
    public static final DateTimeFormatter e = DateTimeFormatter.ofPattern("yyyy年M月d日 H时m分s秒");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final DateTimeFormatter f6192f = DateTimeFormatter.ofPattern("yyyy년M월d일 HH:mm:ss");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final DateTimeFormatter f6193g = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final DateTimeFormatter f6194h = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final DateTimeFormatter f6195i = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final DateTimeFormatter f6196j = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final DateTimeFormatter f6197k = DateTimeFormatter.ofPattern("yyyyMMdd");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final DateTimeFormatter f6198l = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final DateTimeFormatter f6199m = DateTimeFormatter.ofPattern("yyyy年M月d日");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final DateTimeFormatter f6200n = DateTimeFormatter.ofPattern("yyyy년M월d일");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final DateTimeFormatter f6201o = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final DateTimeFormatter f6202p = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final DateTimeFormatter f6203q = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final DateTimeFormatter f6204r = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final DateTimeFormatter f6205s = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.systemDefault());

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final DateTimeFormatter f6206t = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    /* JADX WARN: Code duplicated, block: B:17:0x0055  */
    /* JADX WARN: Code duplicated, block: B:20:0x005b  */
    public static LocalDate d(String str, DateTimeFormatter dateTimeFormatter) {
        if (dateTimeFormatter == null) {
            if (str.length() == 8) {
                dateTimeFormatter = f6197k;
            }
            if (str.length() == 10) {
                char cCharAt = str.charAt(4);
                char cCharAt2 = str.charAt(7);
                if (cCharAt == '/' && cCharAt2 == '/') {
                    dateTimeFormatter = f6198l;
                }
                char cCharAt3 = str.charAt(0);
                char cCharAt4 = str.charAt(1);
                char cCharAt5 = str.charAt(2);
                char cCharAt6 = str.charAt(3);
                char cCharAt7 = str.charAt(5);
                if (cCharAt5 == '/' && cCharAt7 == '/') {
                    int i5 = (cCharAt4 - '0') + ((cCharAt3 - '0') * 10);
                    int i6 = (cCharAt - '0') + ((cCharAt6 - '0') * 10);
                    DateTimeFormatter dateTimeFormatter2 = f6202p;
                    if (i5 > 12) {
                        dateTimeFormatter = dateTimeFormatter2;
                    } else {
                        DateTimeFormatter dateTimeFormatter3 = f6201o;
                        if (i6 > 12) {
                            dateTimeFormatter = dateTimeFormatter3;
                        } else {
                            String country = Locale.getDefault().getCountry();
                            if (country.equals("US")) {
                                dateTimeFormatter = dateTimeFormatter3;
                            } else if (country.equals("BR") || country.equals("AU")) {
                                dateTimeFormatter = dateTimeFormatter2;
                            }
                        }
                    }
                } else if (cCharAt5 == '.' && cCharAt7 == '.') {
                    dateTimeFormatter = f6203q;
                } else if (cCharAt5 == '-' && cCharAt7 == '-') {
                    dateTimeFormatter = f6204r;
                }
            }
            if (str.length() >= 9) {
                char cCharAt8 = str.charAt(4);
                if (cCharAt8 == 24180) {
                    dateTimeFormatter = f6199m;
                } else if (cCharAt8 == 45380) {
                    dateTimeFormatter = f6200n;
                }
            }
        }
        return dateTimeFormatter == null ? LocalDate.parse(str) : LocalDate.parse(str, dateTimeFormatter);
    }

    @Override // p073n.p
    public final int a() {
        return 4;
    }

    /* JADX WARN: Code duplicated, block: B:138:0x0239  */
    /* JADX WARN: Code duplicated, block: B:157:0x026e  */
    /* JADX WARN: Code duplicated, block: B:169:0x029a  */
    /* JADX WARN: Code duplicated, block: B:52:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:71:0x011d  */
    /* JADX WARN: Code duplicated, block: B:83:0x014a  */
    @Override // p073n.f
    public final Object c(b bVar, Type type, Object obj, String str) {
        DateTimeFormatter dateTimeFormatterOfPattern;
        g gVar = bVar.e;
        int i5 = gVar.f6092a;
        if (i5 == 8) {
            gVar.m();
            return null;
        }
        if (i5 != 4) {
            throw new UnsupportedOperationException();
        }
        String strJ = gVar.J();
        gVar.m();
        DateTimeFormatter dateTimeFormatter = b;
        if (str != null) {
            dateTimeFormatterOfPattern = "yyyy-MM-dd HH:mm:ss".equals(str) ? dateTimeFormatter : DateTimeFormatter.ofPattern(str);
        } else {
            dateTimeFormatterOfPattern = null;
        }
        if ("".equals(strJ)) {
            return null;
        }
        DateTimeFormatter dateTimeFormatter2 = f6192f;
        DateTimeFormatter dateTimeFormatter3 = d;
        DateTimeFormatter dateTimeFormatter4 = e;
        DateTimeFormatter dateTimeFormatter5 = f6196j;
        DateTimeFormatter dateTimeFormatter6 = f6195i;
        DateTimeFormatter dateTimeFormatter7 = c;
        DateTimeFormatter dateTimeFormatter8 = f6194h;
        DateTimeFormatter dateTimeFormatter9 = f6193g;
        if (type == LocalDateTime.class) {
            if (strJ.length() == 10 || strJ.length() == 8) {
                return LocalDateTime.of(d(strJ, dateTimeFormatterOfPattern), LocalTime.MIN);
            }
            if (dateTimeFormatterOfPattern == null) {
                if (strJ.length() == 19) {
                    char cCharAt = strJ.charAt(4);
                    char cCharAt2 = strJ.charAt(7);
                    char cCharAt3 = strJ.charAt(10);
                    char cCharAt4 = strJ.charAt(13);
                    char cCharAt5 = strJ.charAt(16);
                    if (cCharAt4 != ':' || cCharAt5 != ':') {
                        dateTimeFormatter = dateTimeFormatterOfPattern;
                    } else if (cCharAt == '-' && cCharAt2 == '-') {
                        if (cCharAt3 == 'T') {
                            dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
                        } else if (cCharAt3 != ' ') {
                            dateTimeFormatter = dateTimeFormatterOfPattern;
                        }
                    } else if (cCharAt != '-' || cCharAt2 != '-') {
                        if (cCharAt == '/' && cCharAt2 == '/') {
                            dateTimeFormatter = dateTimeFormatter7;
                        } else {
                            char cCharAt6 = strJ.charAt(0);
                            char cCharAt7 = strJ.charAt(1);
                            char cCharAt8 = strJ.charAt(2);
                            char cCharAt9 = strJ.charAt(3);
                            char cCharAt10 = strJ.charAt(5);
                            if (cCharAt8 == '/' && cCharAt10 == '/') {
                                int i6 = (cCharAt - '0') + ((cCharAt9 - '0') * 10);
                                if ((cCharAt7 - '0') + ((cCharAt6 - '0') * 10) <= 12) {
                                    if (i6 <= 12) {
                                        String country = Locale.getDefault().getCountry();
                                        if (!country.equals("US")) {
                                            if (country.equals("BR") || country.equals("AU")) {
                                                dateTimeFormatter = dateTimeFormatter8;
                                            } else {
                                                dateTimeFormatter = dateTimeFormatterOfPattern;
                                            }
                                        }
                                    }
                                    dateTimeFormatter = dateTimeFormatter9;
                                } else {
                                    dateTimeFormatter = dateTimeFormatter8;
                                }
                            } else if (cCharAt8 == '.' && cCharAt10 == '.') {
                                dateTimeFormatter = dateTimeFormatter6;
                            } else if (cCharAt8 == '-' && cCharAt10 == '-') {
                                dateTimeFormatter = dateTimeFormatter5;
                            } else {
                                dateTimeFormatter = dateTimeFormatterOfPattern;
                            }
                        }
                    }
                } else {
                    dateTimeFormatter = dateTimeFormatterOfPattern;
                }
                if (strJ.length() < 17) {
                    dateTimeFormatterOfPattern = dateTimeFormatter;
                } else {
                    char cCharAt11 = strJ.charAt(4);
                    if (cCharAt11 == 24180) {
                        dateTimeFormatterOfPattern = strJ.charAt(strJ.length() + (-1)) == 31186 ? dateTimeFormatter4 : dateTimeFormatter3;
                    } else if (cCharAt11 == 45380) {
                        dateTimeFormatterOfPattern = dateTimeFormatter2;
                    } else {
                        dateTimeFormatterOfPattern = dateTimeFormatter;
                    }
                }
            }
            return dateTimeFormatterOfPattern == null ? LocalDateTime.parse(strJ) : LocalDateTime.parse(strJ, dateTimeFormatterOfPattern);
        }
        if (type == LocalDate.class) {
            if (strJ.length() != 23) {
                return d(strJ, dateTimeFormatterOfPattern);
            }
            LocalDateTime localDateTime = LocalDateTime.parse(strJ);
            return LocalDate.of(localDateTime.getYear(), localDateTime.getMonthValue(), localDateTime.getDayOfMonth());
        }
        if (type == LocalTime.class) {
            if (strJ.length() != 23) {
                return LocalTime.parse(strJ);
            }
            LocalDateTime localDateTime2 = LocalDateTime.parse(strJ);
            return LocalTime.of(localDateTime2.getHour(), localDateTime2.getMinute(), localDateTime2.getSecond(), localDateTime2.getNano());
        }
        if (type != ZonedDateTime.class) {
            if (type == OffsetDateTime.class) {
                return OffsetDateTime.parse(strJ);
            }
            if (type == OffsetTime.class) {
                return OffsetTime.parse(strJ);
            }
            if (type == ZoneId.class) {
                return ZoneId.of(strJ);
            }
            if (type == Period.class) {
                return Period.parse(strJ);
            }
            if (type == Duration.class) {
                return Duration.parse(strJ);
            }
            if (type == Instant.class) {
                return Instant.parse(strJ);
            }
            return null;
        }
        if (dateTimeFormatterOfPattern == dateTimeFormatter) {
            dateTimeFormatterOfPattern = f6205s;
        }
        if (dateTimeFormatterOfPattern == null) {
            if (strJ.length() == 19) {
                char cCharAt12 = strJ.charAt(4);
                char cCharAt13 = strJ.charAt(7);
                char cCharAt14 = strJ.charAt(10);
                char cCharAt15 = strJ.charAt(13);
                char cCharAt16 = strJ.charAt(16);
                if (cCharAt15 != ':' || cCharAt16 != ':') {
                    dateTimeFormatter = dateTimeFormatterOfPattern;
                } else if (cCharAt12 == '-' && cCharAt13 == '-') {
                    if (cCharAt14 == 'T') {
                        dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
                    } else if (cCharAt14 != ' ') {
                        dateTimeFormatter = dateTimeFormatterOfPattern;
                    }
                } else if (cCharAt12 != '-' || cCharAt13 != '-') {
                    if (cCharAt12 == '/' && cCharAt13 == '/') {
                        dateTimeFormatter = dateTimeFormatter7;
                    } else {
                        char cCharAt17 = strJ.charAt(0);
                        char cCharAt18 = strJ.charAt(1);
                        char cCharAt19 = strJ.charAt(2);
                        char cCharAt20 = strJ.charAt(3);
                        char cCharAt21 = strJ.charAt(5);
                        if (cCharAt19 == '/' && cCharAt21 == '/') {
                            int i7 = (cCharAt12 - '0') + ((cCharAt20 - '0') * 10);
                            if ((cCharAt18 - '0') + ((cCharAt17 - '0') * 10) <= 12) {
                                if (i7 <= 12) {
                                    String country2 = Locale.getDefault().getCountry();
                                    if (!country2.equals("US")) {
                                        if (country2.equals("BR") || country2.equals("AU")) {
                                            dateTimeFormatter = dateTimeFormatter8;
                                        } else {
                                            dateTimeFormatter = dateTimeFormatterOfPattern;
                                        }
                                    }
                                }
                                dateTimeFormatter = dateTimeFormatter9;
                            } else {
                                dateTimeFormatter = dateTimeFormatter8;
                            }
                        } else if (cCharAt19 == '.' && cCharAt21 == '.') {
                            dateTimeFormatter = dateTimeFormatter6;
                        } else if (cCharAt19 == '-' && cCharAt21 == '-') {
                            dateTimeFormatter = dateTimeFormatter5;
                        } else {
                            dateTimeFormatter = dateTimeFormatterOfPattern;
                        }
                    }
                }
            } else {
                dateTimeFormatter = dateTimeFormatterOfPattern;
            }
            if (strJ.length() < 17) {
                dateTimeFormatter2 = dateTimeFormatter;
            } else {
                char cCharAt22 = strJ.charAt(4);
                if (cCharAt22 == 24180) {
                    dateTimeFormatter2 = strJ.charAt(strJ.length() + (-1)) == 31186 ? dateTimeFormatter4 : dateTimeFormatter3;
                } else if (cCharAt22 != 45380) {
                    dateTimeFormatter2 = dateTimeFormatter;
                }
            }
        } else {
            dateTimeFormatter2 = dateTimeFormatterOfPattern;
        }
        return dateTimeFormatter2 == null ? ZonedDateTime.parse(strJ) : ZonedDateTime.parse(strJ, dateTimeFormatter2);
    }

    @Override // p079o.Q, p079o.InterfaceC1290t
    public void write(G g6, Object obj, Object obj2, Type type, int i5) {
        b0 b0Var = g6.f6325j;
        if (obj == null) {
            b0Var.n();
            return;
        }
        if (type == null) {
            type = obj.getClass();
        }
        if (type != LocalDateTime.class) {
            b0Var.q(obj.toString());
            return;
        }
        c0 c0Var = c0.UseISO8601DateFormat;
        int i6 = c0Var.f6406a;
        LocalDateTime localDateTime = (LocalDateTime) obj;
        SimpleDateFormat simpleDateFormat = g6.f6329n;
        String pattern = simpleDateFormat != null ? simpleDateFormat.toPattern() : g6.f6328m;
        if ((pattern == null && (i5 & i6) != 0) || g6.f6325j.d(c0Var)) {
            pattern = "yyyy-MM-dd'T'HH:mm:ss";
        }
        if (localDateTime.getNano() != 0 && pattern == null) {
            b0Var.q(obj.toString());
            return;
        }
        if (pattern == null) {
            pattern = a.e;
        }
        b0Var.q((pattern == "yyyy-MM-dd'T'HH:mm:ss" ? f6206t : DateTimeFormatter.ofPattern(pattern)).format(localDateTime));
    }

    @Override // p079o.InterfaceC1290t
    public void write(G g6, Object obj, C1281j c1281j) {
        DateTimeFormatter dateTimeFormatterOfPattern;
        b0 b0Var = g6.f6325j;
        String str = c1281j.b;
        TemporalAccessor temporalAccessor = (TemporalAccessor) obj;
        if (str == "yyyy-MM-dd'T'HH:mm:ss") {
            dateTimeFormatterOfPattern = f6206t;
        } else {
            dateTimeFormatterOfPattern = DateTimeFormatter.ofPattern(str);
        }
        b0Var.q(dateTimeFormatterOfPattern.format(temporalAccessor));
    }
}
