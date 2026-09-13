package p067m;

import java.io.Closeable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import kotlinx.serialization.json.internal.AbstractC1127c;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.util.Chars;
import p050j.a;
import p050j.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract class e implements d, Closeable {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final ThreadLocal f6090o = new ThreadLocal();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int[] f6091p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6092a;
    public int b;
    public int c;
    public char d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public char[] f6093f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f6094g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f6095h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f6096i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Calendar f6097j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TimeZone f6098k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Locale f6099l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f6100m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f6101n;

    static {
        ("\"" + a.c + "\":\"").toCharArray();
        f6091p = new int[103];
        for (int i5 = 48; i5 <= 57; i5++) {
            f6091p[i5] = i5 - 48;
        }
        for (int i6 = 97; i6 <= 102; i6++) {
            f6091p[i6] = i6 - 87;
        }
        for (int i7 = 65; i7 <= 70; i7++) {
            f6091p[i7] = i7 - 55;
        }
    }

    public static boolean j(char c) {
        if (c <= ' ') {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == '\f' || c == '\b';
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:48:0x00f2  */
    public static String r(char[] cArr, int i5) {
        int i6;
        int i7;
        char[] cArr2 = new char[i5];
        int i8 = 0;
        int i9 = 0;
        while (i8 < i5) {
            char c = cArr[i8];
            if (c != '\\') {
                cArr2[i9] = c;
                i9++;
            } else {
                int i10 = i8 + 1;
                char c6 = cArr[i10];
                if (c6 == '\"') {
                    i6 = i9 + 1;
                    cArr2[i9] = Chars.DQUOTE;
                } else if (c6 == '\'') {
                    i6 = i9 + 1;
                    cArr2[i9] = Chars.QUOTE;
                } else if (c6 == 'F') {
                    i6 = i9 + 1;
                    cArr2[i9] = '\f';
                } else if (c6 == '\\') {
                    i6 = i9 + 1;
                    cArr2[i9] = IOUtils.DIR_SEPARATOR_WINDOWS;
                } else if (c6 == 'b') {
                    i6 = i9 + 1;
                    cArr2[i9] = '\b';
                } else if (c6 == 'f') {
                    i6 = i9 + 1;
                    cArr2[i9] = '\f';
                } else if (c6 == 'n') {
                    i6 = i9 + 1;
                    cArr2[i9] = '\n';
                } else if (c6 != 'r') {
                    if (c6 != 'x') {
                        switch (c6) {
                            case '/':
                                i6 = i9 + 1;
                                cArr2[i9] = '/';
                                break;
                            case '0':
                                i6 = i9 + 1;
                                cArr2[i9] = 0;
                                break;
                            case '1':
                                i6 = i9 + 1;
                                cArr2[i9] = 1;
                                break;
                            case '2':
                                i6 = i9 + 1;
                                cArr2[i9] = 2;
                                break;
                            case '3':
                                i6 = i9 + 1;
                                cArr2[i9] = 3;
                                break;
                            case '4':
                                i6 = i9 + 1;
                                cArr2[i9] = 4;
                                break;
                            case '5':
                                i6 = i9 + 1;
                                cArr2[i9] = 5;
                                break;
                            case '6':
                                i6 = i9 + 1;
                                cArr2[i9] = 6;
                                break;
                            case '7':
                                i6 = i9 + 1;
                                cArr2[i9] = 7;
                                break;
                            default:
                                switch (c6) {
                                    case 't':
                                        i6 = i9 + 1;
                                        cArr2[i9] = '\t';
                                        break;
                                    case 'u':
                                        i7 = i9 + 1;
                                        char c7 = cArr[i8 + 2];
                                        char c8 = cArr[i8 + 3];
                                        char c9 = cArr[i8 + 4];
                                        i8 += 5;
                                        cArr2[i9] = (char) Integer.parseInt(new String(new char[]{c7, c8, c9, cArr[i8]}), 16);
                                        break;
                                    case 'v':
                                        i6 = i9 + 1;
                                        cArr2[i9] = 11;
                                        break;
                                    default:
                                        throw new d("unclosed.str.lit");
                                }
                                break;
                        }
                    } else {
                        i7 = i9 + 1;
                        char c10 = cArr[i8 + 2];
                        int[] iArr = f6091p;
                        i8 += 3;
                        cArr2[i9] = (char) ((iArr[c10] * 16) + iArr[cArr[i8]]);
                    }
                    i9 = i7;
                } else {
                    i6 = i9 + 1;
                    cArr2[i9] = Chars.CR;
                }
                i9 = i6;
                i8 = i10;
            }
            i8++;
        }
        return new String(cArr2, 0, i9);
    }

    public abstract String A(char[] cArr);

    public final void B() {
        this.f6095h = this.e - 1;
        this.f6096i = false;
        do {
            this.f6094g++;
            l();
        } while (Character.isLetterOrDigit(this.d));
        String strJ = J();
        if (AbstractC1127c.NULL.equalsIgnoreCase(strJ)) {
            this.f6092a = 8;
            return;
        }
        if ("new".equals(strJ)) {
            this.f6092a = 9;
            return;
        }
        if ("true".equals(strJ)) {
            this.f6092a = 6;
            return;
        }
        if ("false".equals(strJ)) {
            this.f6092a = 7;
            return;
        }
        if ("undefined".equals(strJ)) {
            this.f6092a = 23;
            return;
        }
        if ("Set".equals(strJ)) {
            this.f6092a = 21;
        } else if ("TreeSet".equals(strJ)) {
            this.f6092a = 22;
        } else {
            this.f6092a = 18;
        }
    }

    /* JADX WARN: Code duplicated, block: B:51:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:53:0x00cb  */
    public final void C() {
        char c;
        boolean z6;
        char c6;
        this.f6095h = this.e;
        boolean z7 = true;
        if (this.d == '-') {
            this.f6094g++;
            l();
        }
        while (true) {
            c = this.d;
            if (c < '0' || c > '9') {
                break;
            }
            this.f6094g++;
            l();
        }
        if (c == '.') {
            this.f6094g++;
            l();
            while (true) {
                char c7 = this.d;
                if (c7 < '0' || c7 > '9') {
                    break;
                }
                this.f6094g++;
                l();
            }
            z6 = true;
        } else {
            z6 = false;
        }
        char c8 = this.d;
        if (c8 != 'L' && c8 != 'S' && c8 != 'B') {
            if (c8 == 'F' || c8 == 'D') {
                this.f6094g++;
                l();
            } else if (c8 == 'e' || c8 == 'E') {
                this.f6094g++;
                l();
                char c9 = this.d;
                if (c9 == '+' || c9 == '-') {
                    this.f6094g++;
                    l();
                }
                while (true) {
                    c6 = this.d;
                    if (c6 < '0' || c6 > '9') {
                        break;
                    }
                    this.f6094g++;
                    l();
                }
                if (c6 == 'D' || c6 == 'F') {
                    this.f6094g++;
                    l();
                }
            }
            if (z7) {
                this.f6092a = 3;
            } else {
                this.f6092a = 2;
            }
        }
        this.f6094g++;
        l();
        z7 = z6;
        if (z7) {
            this.f6092a = 3;
        } else {
            this.f6092a = 2;
        }
    }

    public final void D() {
        this.f6095h = this.e;
        this.f6096i = false;
        while (true) {
            char cL = l();
            if (cL == '\"') {
                this.f6092a = 4;
                this.d = l();
                return;
            }
            if (cL == 26) {
                if (h()) {
                    throw new d(androidx.exifinterface.media.a.h("unclosed string : ", cL));
                }
                q((char) 26);
            } else if (cL == '\\') {
                if (!this.f6096i) {
                    this.f6096i = true;
                    int i5 = this.f6094g;
                    char[] cArr = this.f6093f;
                    if (i5 >= cArr.length) {
                        int length = cArr.length * 2;
                        if (i5 <= length) {
                            i5 = length;
                        }
                        char[] cArr2 = new char[i5];
                        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                        this.f6093f = cArr2;
                    }
                    int i6 = this.f6095h + 1;
                    ((g) this).f6102q.getChars(i6, this.f6094g + i6, this.f6093f, 0);
                }
                char cL2 = l();
                if (cL2 == '\"') {
                    q(Chars.DQUOTE);
                } else if (cL2 != '\'') {
                    if (cL2 != 'F') {
                        if (cL2 == '\\') {
                            q(IOUtils.DIR_SEPARATOR_WINDOWS);
                        } else if (cL2 == 'b') {
                            q('\b');
                        } else if (cL2 != 'f') {
                            if (cL2 == 'n') {
                                q('\n');
                            } else if (cL2 == 'r') {
                                q(Chars.CR);
                            } else if (cL2 != 'x') {
                                switch (cL2) {
                                    case '/':
                                        q('/');
                                        break;
                                    case '0':
                                        q((char) 0);
                                        break;
                                    case '1':
                                        q((char) 1);
                                        break;
                                    case '2':
                                        q((char) 2);
                                        break;
                                    case '3':
                                        q((char) 3);
                                        break;
                                    case '4':
                                        q((char) 4);
                                        break;
                                    case '5':
                                        q((char) 5);
                                        break;
                                    case '6':
                                        q((char) 6);
                                        break;
                                    case '7':
                                        q((char) 7);
                                        break;
                                    default:
                                        switch (cL2) {
                                            case 't':
                                                q('\t');
                                                break;
                                            case 'u':
                                                q((char) Integer.parseInt(new String(new char[]{l(), l(), l(), l()}), 16));
                                                break;
                                            case 'v':
                                                q((char) 11);
                                                break;
                                            default:
                                                this.d = cL2;
                                                throw new d(androidx.exifinterface.media.a.h("unclosed string : ", cL2));
                                        }
                                        break;
                                }
                            } else {
                                char cL3 = l();
                                char cL4 = l();
                                int[] iArr = f6091p;
                                q((char) ((iArr[cL3] * 16) + iArr[cL4]));
                            }
                        }
                    }
                    q('\f');
                } else {
                    q(Chars.QUOTE);
                }
            } else if (this.f6096i) {
                int i7 = this.f6094g;
                char[] cArr3 = this.f6093f;
                if (i7 == cArr3.length) {
                    q(cL);
                } else {
                    this.f6094g = i7 + 1;
                    cArr3[i7] = cL;
                }
            } else {
                this.f6094g++;
            }
        }
    }

    public final String E(k kVar) {
        I();
        char c = this.d;
        if (c == '\"') {
            return F(kVar, Chars.DQUOTE);
        }
        if (c == '\'') {
            if (i(c.AllowSingleQuotes.f6089a)) {
                return F(kVar, Chars.QUOTE);
            }
            throw new d("syntax error");
        }
        if (c == '}') {
            l();
            this.f6092a = 13;
            return null;
        }
        if (c == ',') {
            l();
            this.f6092a = 16;
            return null;
        }
        if (c == 26) {
            this.f6092a = 20;
            return null;
        }
        if (i(c.AllowUnQuotedFieldNames.f6089a)) {
            return G(kVar);
        }
        throw new d("syntax error");
    }

    public final String F(k kVar, char c) {
        String str;
        this.f6095h = this.e;
        this.f6094g = 0;
        boolean z6 = false;
        int i5 = 0;
        while (true) {
            char cL = l();
            if (cL == c) {
                this.f6092a = 4;
                if (z6) {
                    char[] cArr = this.f6093f;
                    int i6 = this.f6094g;
                    int i7 = kVar.f6115a & i5;
                    String[] strArr = (String[]) kVar.b;
                    String str2 = strArr[i7];
                    if (str2 == null) {
                        String strIntern = new String(cArr, 0, i6).intern();
                        strArr[i7] = strIntern;
                        str = strIntern;
                    } else if (i5 == str2.hashCode() && i6 == str2.length()) {
                        int i8 = 0;
                        while (true) {
                            if (i8 >= i6) {
                                str = str2;
                            } else if (cArr[i8] != str2.charAt(i8)) {
                                str = new String(cArr, 0, i6);
                            } else {
                                i8++;
                            }
                        }
                    } else {
                        str = new String(cArr, 0, i6);
                    }
                } else {
                    int i9 = this.f6095h;
                    str = kVar.a(((g) this).f6102q, i9 == -1 ? 0 : i9 + 1, this.f6094g, i5);
                }
                this.f6094g = 0;
                l();
                return str;
            }
            if (cL == 26) {
                throw new d("unclosed.str");
            }
            if (cL == '\\') {
                if (!z6) {
                    int i10 = this.f6094g;
                    char[] cArr2 = this.f6093f;
                    if (i10 >= cArr2.length) {
                        int length = cArr2.length * 2;
                        if (i10 <= length) {
                            i10 = length;
                        }
                        char[] cArr3 = new char[i10];
                        System.arraycopy(cArr2, 0, cArr3, 0, cArr2.length);
                        this.f6093f = cArr3;
                    }
                    int i11 = this.f6095h + 1;
                    ((g) this).f6102q.getChars(i11, this.f6094g + i11, this.f6093f, 0);
                    z6 = true;
                }
                char cL2 = l();
                if (cL2 == '\"') {
                    i5 = (i5 * 31) + 34;
                    q(Chars.DQUOTE);
                } else if (cL2 != '\'') {
                    if (cL2 != 'F') {
                        if (cL2 == '\\') {
                            i5 = (i5 * 31) + 92;
                            q(IOUtils.DIR_SEPARATOR_WINDOWS);
                        } else if (cL2 == 'b') {
                            i5 = (i5 * 31) + 8;
                            q('\b');
                        } else if (cL2 != 'f') {
                            if (cL2 == 'n') {
                                i5 = (i5 * 31) + 10;
                                q('\n');
                            } else if (cL2 == 'r') {
                                i5 = (i5 * 31) + 13;
                                q(Chars.CR);
                            } else if (cL2 != 'x') {
                                switch (cL2) {
                                    case '/':
                                        i5 = (i5 * 31) + 47;
                                        q('/');
                                        break;
                                    case '0':
                                        i5 = (i5 * 31) + cL2;
                                        q((char) 0);
                                        break;
                                    case '1':
                                        i5 = (i5 * 31) + cL2;
                                        q((char) 1);
                                        break;
                                    case '2':
                                        i5 = (i5 * 31) + cL2;
                                        q((char) 2);
                                        break;
                                    case '3':
                                        i5 = (i5 * 31) + cL2;
                                        q((char) 3);
                                        break;
                                    case '4':
                                        i5 = (i5 * 31) + cL2;
                                        q((char) 4);
                                        break;
                                    case '5':
                                        i5 = (i5 * 31) + cL2;
                                        q((char) 5);
                                        break;
                                    case '6':
                                        i5 = (i5 * 31) + cL2;
                                        q((char) 6);
                                        break;
                                    case '7':
                                        i5 = (i5 * 31) + cL2;
                                        q((char) 7);
                                        break;
                                    default:
                                        switch (cL2) {
                                            case 't':
                                                i5 = (i5 * 31) + 9;
                                                q('\t');
                                                break;
                                            case 'u':
                                                int i12 = Integer.parseInt(new String(new char[]{l(), l(), l(), l()}), 16);
                                                i5 = (i5 * 31) + i12;
                                                q((char) i12);
                                                break;
                                            case 'v':
                                                i5 = (i5 * 31) + 11;
                                                q((char) 11);
                                                break;
                                            default:
                                                this.d = cL2;
                                                throw new d("unclosed.str.lit");
                                        }
                                        break;
                                }
                            } else {
                                char cL3 = l();
                                this.d = cL3;
                                char cL4 = l();
                                this.d = cL4;
                                int[] iArr = f6091p;
                                char c6 = (char) ((iArr[cL3] * 16) + iArr[cL4]);
                                i5 = (i5 * 31) + c6;
                                q(c6);
                            }
                        }
                    }
                    i5 = (i5 * 31) + 12;
                    q('\f');
                } else {
                    i5 = (i5 * 31) + 39;
                    q(Chars.QUOTE);
                }
            } else {
                i5 = (i5 * 31) + cL;
                if (z6) {
                    int i13 = this.f6094g;
                    char[] cArr4 = this.f6093f;
                    if (i13 == cArr4.length) {
                        q(cL);
                    } else {
                        this.f6094g = i13 + 1;
                        cArr4[i13] = cL;
                    }
                } else {
                    this.f6094g++;
                }
            }
        }
    }

    public final String G(k kVar) {
        if (this.f6092a == 1 && this.b == 0 && this.e == 1) {
            this.e = 0;
        }
        boolean[] zArr = p096r.e.d;
        int i5 = this.d;
        if (i5 < zArr.length && !zArr[i5]) {
            throw new d("illegal identifier : " + this.d + f());
        }
        boolean[] zArr2 = p096r.e.e;
        this.f6095h = this.e;
        this.f6094g = 1;
        while (true) {
            char cL = l();
            if (cL < zArr2.length && !zArr2[cL]) {
                break;
            }
            i5 = (i5 * 31) + cL;
            this.f6094g++;
        }
        this.d = b(this.e);
        this.f6092a = 18;
        if (this.f6094g == 4 && i5 == 3392903 && b(this.f6095h) == 'n' && b(this.f6095h + 1) == 'u' && b(this.f6095h + 2) == 'l' && b(this.f6095h + 3) == 'l') {
            return null;
        }
        if (kVar == null) {
            return K(this.f6095h, this.f6094g);
        }
        return kVar.a(((g) this).f6102q, this.f6095h, this.f6094g, i5);
    }

    public final void H() {
        char c;
        l();
        char c6 = this.d;
        if (c6 == '/') {
            do {
                l();
                c = this.d;
                if (c == '\n') {
                    l();
                    return;
                }
            } while (c != 26);
            return;
        }
        if (c6 != '*') {
            throw new d("invalid comment");
        }
        l();
        while (true) {
            char c7 = this.d;
            if (c7 == 26) {
                return;
            }
            if (c7 == '*') {
                l();
                if (this.d == '/') {
                    l();
                    return;
                }
            } else {
                l();
            }
        }
    }

    public final void I() {
        while (true) {
            char c = this.d;
            if (c > '/') {
                return;
            }
            if (c == ' ' || c == '\r' || c == '\n' || c == '\t' || c == '\f' || c == '\b') {
                l();
            } else if (c != '/') {
                return;
            } else {
                H();
            }
        }
    }

    public abstract String J();

    public abstract String K(int i5, int i6);

    public abstract char[] L(int i5, int i6);

    public abstract boolean a(char[] cArr);

    public abstract char b(int i5);

    public final Number c(boolean z6) {
        char cB = b((this.f6095h + this.f6094g) - 1);
        try {
            if (cB == 'F') {
                return Float.valueOf(Float.parseFloat(p()));
            }
            if (cB == 'D') {
                return Double.valueOf(Double.parseDouble(p()));
            }
            return z6 ? d() : Double.valueOf(Double.parseDouble(p()));
        } catch (NumberFormatException e) {
            throw new d(e.getMessage() + ", " + f());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        char[] cArr = this.f6093f;
        if (cArr.length <= 8192) {
            f6090o.set(cArr);
        }
        this.f6093f = null;
    }

    public abstract BigDecimal d();

    public final float e() {
        char cCharAt;
        String strP = p();
        float f6 = Float.parseFloat(strP);
        if ((f6 == 0.0f || f6 == Float.POSITIVE_INFINITY) && (cCharAt = strP.charAt(0)) > '0' && cCharAt <= '9') {
            throw new d("float overflow : ".concat(strP));
        }
        return f6;
    }

    public abstract String f();

    public final int g() {
        int i5;
        boolean z6;
        int i6 = 0;
        if (this.f6095h == -1) {
            this.f6095h = 0;
        }
        int i7 = this.f6095h;
        int i8 = this.f6094g + i7;
        if (b(i7) == '-') {
            i7++;
            i5 = Integer.MIN_VALUE;
            z6 = true;
        } else {
            i5 = -2147483647;
            z6 = false;
        }
        if (i7 < i8) {
            i6 = -(b(i7) - '0');
            i7++;
        }
        while (i7 < i8) {
            int i9 = i7 + 1;
            char cB = b(i7);
            if (cB == 'L' || cB == 'S' || cB == 'B') {
                i7 = i9;
                break;
            }
            int i10 = cB - '0';
            if (i6 < -214748364) {
                throw new NumberFormatException(p());
            }
            int i11 = i6 * 10;
            if (i11 < i5 + i10) {
                throw new NumberFormatException(p());
            }
            i6 = i11 - i10;
            i7 = i9;
        }
        if (!z6) {
            return -i6;
        }
        if (i7 > this.f6095h + 1) {
            return i6;
        }
        throw new NumberFormatException(p());
    }

    public abstract boolean h();

    public final boolean i(int i5) {
        return (i5 & this.c) != 0;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0057  */
    /* JADX WARN: Code duplicated, block: B:24:0x0068  */
    /* JADX WARN: Code duplicated, block: B:26:0x0072  */
    /* JADX WARN: Code duplicated, block: B:28:0x007c  */
    /* JADX WARN: Code duplicated, block: B:30:0x0086  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0086 -> B:19:0x0051). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Number integerValue() {
        /*
            Method dump skipped, instruction units count: 230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p067m.e.integerValue():java.lang.Number");
    }

    public final boolean k(char[] cArr) {
        if (!a(cArr)) {
            return false;
        }
        int length = this.e + cArr.length;
        this.e = length;
        char cB = b(length);
        this.d = cB;
        if (cB == '{') {
            l();
            this.f6092a = 12;
            return true;
        }
        if (cB == '[') {
            l();
            this.f6092a = 14;
            return true;
        }
        if (cB != 'S' || b(this.e + 1) != 'e' || b(this.e + 2) != 't' || b(this.e + 3) != '[') {
            m();
            return true;
        }
        int i5 = this.e + 3;
        this.e = i5;
        this.d = b(i5);
        this.f6092a = 21;
        return true;
    }

    public abstract char l();

    /* JADX WARN: Code duplicated, block: B:14:0x0034  */
    /* JADX WARN: Code duplicated, block: B:32:0x0075  */
    /* JADX WARN: Code duplicated, block: B:34:0x007a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:35:0x007b  */
    /* JADX WARN: Code duplicated, block: B:37:0x0085  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x005c -> B:11:0x002e). Please report as a decompilation issue!!! */
    public final long longValue() {
        long j6;
        long j7;
        int i5;
        char cB;
        boolean z6 = false;
        if (this.f6095h == -1) {
            this.f6095h = 0;
        }
        int i6 = this.f6095h;
        int i7 = this.f6094g + i6;
        if (b(i6) == '-') {
            i6++;
            j6 = Long.MIN_VALUE;
            z6 = true;
        } else {
            j6 = -9223372036854775807L;
        }
        if (i6 >= i7) {
            j7 = 0;
            if (i6 < i7) {
                i5 = i6 + 1;
                cB = b(i6);
                if (cB != 'L' || cB == 'S' || cB == 'B') {
                    i6 = i5;
                } else {
                    int i8 = cB - '0';
                    if (j7 < -922337203685477580L) {
                        throw new NumberFormatException(p());
                    }
                    long j8 = j7 * 10;
                    long j9 = i8;
                    if (j8 < j6 + j9) {
                        throw new NumberFormatException(p());
                    }
                    j7 = j8 - j9;
                }
            }
            if (z6) {
                return -j7;
            }
            if (i6 > this.f6095h + 1) {
                return j7;
            }
            throw new NumberFormatException(p());
        }
        i5 = i6 + 1;
        j7 = -(b(i6) - '0');
        i6 = i5;
        if (i6 < i7) {
            i5 = i6 + 1;
            cB = b(i6);
            if (cB != 'L') {
            }
            i6 = i5;
        }
        if (z6) {
            return -j7;
        }
        if (i6 > this.f6095h + 1) {
            return j7;
        }
        throw new NumberFormatException(p());
    }

    public final void m() {
        int i5;
        int i6;
        this.f6094g = 0;
        while (true) {
            this.b = this.e;
            char c = this.d;
            if (c == '/') {
                H();
            } else {
                if (c == '\"') {
                    D();
                    return;
                }
                if (c == ',') {
                    l();
                    this.f6092a = 16;
                    return;
                }
                if (c >= '0' && c <= '9') {
                    C();
                    return;
                }
                if (c == '-') {
                    C();
                    return;
                }
                if (c != '\f' && c != '\r' && c != ' ') {
                    if (c == '+') {
                        l();
                        C();
                        return;
                    }
                    if (c == '.') {
                        l();
                        this.f6092a = 25;
                        return;
                    }
                    if (c != 'N') {
                        if (c == '[') {
                            l();
                            this.f6092a = 14;
                            return;
                        }
                        if (c == ']') {
                            l();
                            this.f6092a = 15;
                            return;
                        }
                        char c6 = 26;
                        if (c == 'f') {
                            if (c != 'f') {
                                throw new d("error parse false");
                            }
                            l();
                            if (this.d != 'a') {
                                throw new d("error parse false");
                            }
                            l();
                            if (this.d != 'l') {
                                throw new d("error parse false");
                            }
                            l();
                            if (this.d != 's') {
                                throw new d("error parse false");
                            }
                            l();
                            if (this.d != 'e') {
                                throw new d("error parse false");
                            }
                            l();
                            char c7 = this.d;
                            if (c7 != ' ' && c7 != ',' && c7 != '}' && c7 != ']' && c7 != '\n' && c7 != '\r' && c7 != '\t' && c7 != 26 && c7 != '\f' && c7 != '\b' && c7 != ':' && c7 != '/') {
                                throw new d("scan false error");
                            }
                            this.f6092a = 7;
                            return;
                        }
                        if (c == 'n') {
                            if (c != 'n') {
                                throw new d("error parse null or new");
                            }
                            l();
                            char c8 = this.d;
                            if (c8 == 'u') {
                                l();
                                if (this.d != 'l') {
                                    throw new d("error parse null");
                                }
                                l();
                                if (this.d != 'l') {
                                    throw new d("error parse null");
                                }
                                l();
                                char c9 = this.d;
                                if (c9 == ' ' || c9 == ',' || c9 == '}' || c9 == ']' || c9 == '\n' || c9 == '\r' || c9 == '\t' || c9 == 26 || c9 == '\f') {
                                    i6 = 8;
                                } else {
                                    i6 = 8;
                                    if (c9 != '\b') {
                                        throw new d("scan null error");
                                    }
                                }
                                this.f6092a = i6;
                                return;
                            }
                            if (c8 != 'e') {
                                throw new d("error parse new");
                            }
                            l();
                            if (this.d != 'w') {
                                throw new d("error parse new");
                            }
                            l();
                            char c10 = this.d;
                            if (c10 == ' ' || c10 == ',' || c10 == '}' || c10 == ']' || c10 == '\n' || c10 == '\r') {
                                i5 = 9;
                            } else {
                                i5 = 9;
                                if (c10 != '\t') {
                                    if (c10 != 26 && c10 != '\f' && c10 != '\b') {
                                        throw new d("scan new error");
                                    }
                                    i5 = 9;
                                }
                            }
                            this.f6092a = i5;
                            return;
                        }
                        if (c == '{') {
                            l();
                            this.f6092a = 12;
                            return;
                        }
                        if (c == '}') {
                            l();
                            this.f6092a = 13;
                            return;
                        }
                        if (c == ':') {
                            l();
                            this.f6092a = 17;
                            return;
                        }
                        if (c == ';') {
                            l();
                            this.f6092a = 24;
                            return;
                        }
                        if (c != 'S' && c != 'T') {
                            if (c == 't') {
                                if (c != 't') {
                                    throw new d("error parse true");
                                }
                                l();
                                if (this.d != 'r') {
                                    throw new d("error parse true");
                                }
                                l();
                                if (this.d != 'u') {
                                    throw new d("error parse true");
                                }
                                l();
                                if (this.d != 'e') {
                                    throw new d("error parse true");
                                }
                                l();
                                char c11 = this.d;
                                if (c11 != ' ' && c11 != ',' && c11 != '}' && c11 != ']' && c11 != '\n' && c11 != '\r' && c11 != '\t' && c11 != 26 && c11 != '\f' && c11 != '\b' && c11 != ':' && c11 != '/') {
                                    throw new d("scan true error");
                                }
                                this.f6092a = 6;
                                return;
                            }
                            if (c != 'u') {
                                switch (c) {
                                    case '\b':
                                    case '\t':
                                    case '\n':
                                        break;
                                    default:
                                        boolean z6 = true;
                                        switch (c) {
                                            case '\'':
                                                if (!i(c.AllowSingleQuotes.f6089a)) {
                                                    throw new d("Feature.AllowSingleQuotes is false");
                                                }
                                                this.f6095h = this.e;
                                                this.f6096i = false;
                                                while (true) {
                                                    char cL = l();
                                                    if (cL == '\'') {
                                                        this.f6092a = 4;
                                                        l();
                                                        return;
                                                    }
                                                    if (cL != c6) {
                                                        if (cL == '\\') {
                                                            if (!this.f6096i) {
                                                                this.f6096i = z6;
                                                                int i7 = this.f6094g;
                                                                char[] cArr = this.f6093f;
                                                                if (i7 > cArr.length) {
                                                                    char[] cArr2 = new char[i7 * 2];
                                                                    System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                                                                    this.f6093f = cArr2;
                                                                }
                                                                int i8 = this.f6095h + 1;
                                                                ((g) this).f6102q.getChars(i8, this.f6094g + i8, this.f6093f, 0);
                                                            }
                                                            char cL2 = l();
                                                            if (cL2 == '\"') {
                                                                q(Chars.DQUOTE);
                                                            } else if (cL2 != '\'') {
                                                                if (cL2 != 'F') {
                                                                    if (cL2 == '\\') {
                                                                        q(IOUtils.DIR_SEPARATOR_WINDOWS);
                                                                    } else if (cL2 == 'b') {
                                                                        q('\b');
                                                                    } else if (cL2 != 'f') {
                                                                        if (cL2 == 'n') {
                                                                            q('\n');
                                                                            z6 = true;
                                                                            c6 = 26;
                                                                        } else if (cL2 == 'r') {
                                                                            q(Chars.CR);
                                                                        } else if (cL2 != 'x') {
                                                                            switch (cL2) {
                                                                                case '/':
                                                                                    q('/');
                                                                                    z6 = true;
                                                                                    c6 = 26;
                                                                                    break;
                                                                                case '0':
                                                                                    q((char) 0);
                                                                                    break;
                                                                                case '1':
                                                                                    boolean z7 = z6;
                                                                                    q(z7 ? (char) 1 : (char) 0);
                                                                                    z6 = z7 ? 1 : 0;
                                                                                    c6 = 26;
                                                                                    break;
                                                                                case '2':
                                                                                    q((char) 2);
                                                                                    break;
                                                                                case '3':
                                                                                    q((char) 3);
                                                                                    break;
                                                                                case '4':
                                                                                    q((char) 4);
                                                                                    break;
                                                                                case '5':
                                                                                    q((char) 5);
                                                                                    break;
                                                                                case '6':
                                                                                    q((char) 6);
                                                                                    break;
                                                                                case '7':
                                                                                    q((char) 7);
                                                                                    break;
                                                                                default:
                                                                                    switch (cL2) {
                                                                                        case 't':
                                                                                            q('\t');
                                                                                            break;
                                                                                        case 'u':
                                                                                            char cL3 = l();
                                                                                            char cL4 = l();
                                                                                            char cL5 = l();
                                                                                            char cL6 = l();
                                                                                            char[] cArr3 = new char[4];
                                                                                            cArr3[0] = cL3;
                                                                                            cArr3[z6] = cL4;
                                                                                            cArr3[2] = cL5;
                                                                                            cArr3[3] = cL6;
                                                                                            q((char) Integer.parseInt(new String(cArr3), 16));
                                                                                            break;
                                                                                        case 'v':
                                                                                            q((char) 11);
                                                                                            break;
                                                                                        default:
                                                                                            this.d = cL2;
                                                                                            throw new d("unclosed single-quote string");
                                                                                    }
                                                                                    break;
                                                                            }
                                                                        } else {
                                                                            char cL7 = l();
                                                                            int[] iArr = f6091p;
                                                                            q((char) ((iArr[cL7] * 16) + iArr[l()]));
                                                                        }
                                                                    }
                                                                }
                                                                q('\f');
                                                            } else {
                                                                q(Chars.QUOTE);
                                                            }
                                                            z6 = true;
                                                            c6 = 26;
                                                        } else if (this.f6096i) {
                                                            z6 = true;
                                                            z6 = true;
                                                            int i9 = this.f6094g;
                                                            char[] cArr4 = this.f6093f;
                                                            if (i9 == cArr4.length) {
                                                                q(cL);
                                                            } else {
                                                                this.f6094g = i9 + 1;
                                                                cArr4[i9] = cL;
                                                            }
                                                        } else {
                                                            z6 = true;
                                                            this.f6094g++;
                                                        }
                                                        z6 = z6;
                                                        c6 = 26;
                                                    } else {
                                                        if (h()) {
                                                            throw new d("unclosed single-quote string");
                                                        }
                                                        q(c6);
                                                    }
                                                }
                                                break;
                                            case '(':
                                                l();
                                                this.f6092a = 10;
                                                return;
                                            case ')':
                                                l();
                                                this.f6092a = 11;
                                                return;
                                            default:
                                                if (h()) {
                                                    if (this.f6092a == 20) {
                                                        throw new d("EOF error");
                                                    }
                                                    this.f6092a = 20;
                                                    this.e = 0;
                                                    this.b = 0;
                                                    return;
                                                }
                                                char c12 = this.d;
                                                if (c12 > 31 && c12 != 127) {
                                                    String.valueOf((int) c12);
                                                    this.f6092a = 1;
                                                    l();
                                                    return;
                                                }
                                                l();
                                                continue;
                                                break;
                                        }
                                        break;
                                }
                            }
                        }
                    }
                    B();
                    return;
                }
                l();
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:113:0x0073 A[SYNTHETIC] */
    public final void n(int i5) {
        this.f6094g = 0;
        while (true) {
            if (i5 == 2) {
                char c = this.d;
                if (c >= '0' && c <= '9') {
                    this.b = this.e;
                    C();
                    return;
                }
                if (c == '\"') {
                    this.b = this.e;
                    D();
                    return;
                } else if (c == '[') {
                    this.f6092a = 14;
                    l();
                    return;
                } else if (c == '{') {
                    this.f6092a = 12;
                    l();
                    return;
                }
            } else if (i5 == 4) {
                char c6 = this.d;
                if (c6 == '\"') {
                    this.b = this.e;
                    D();
                    return;
                }
                if (c6 >= '0' && c6 <= '9') {
                    this.b = this.e;
                    C();
                    return;
                } else if (c6 == '[') {
                    this.f6092a = 14;
                    l();
                    return;
                } else if (c6 == '{') {
                    this.f6092a = 12;
                    l();
                    return;
                }
            } else if (i5 == 12) {
                char c7 = this.d;
                if (c7 == '{') {
                    this.f6092a = 12;
                    l();
                    return;
                } else if (c7 == '[') {
                    this.f6092a = 14;
                    l();
                    return;
                }
            } else {
                if (i5 == 18) {
                    while (j(this.d)) {
                        l();
                    }
                    char c8 = this.d;
                    if (c8 == '_' || Character.isLetter(c8)) {
                        B();
                        return;
                    } else {
                        m();
                        return;
                    }
                }
                if (i5 != 20) {
                    switch (i5) {
                        case 14:
                            char c9 = this.d;
                            if (c9 == '[') {
                                this.f6092a = 14;
                                l();
                            } else if (c9 == '{') {
                                this.f6092a = 12;
                                l();
                            }
                            break;
                        case 15:
                            if (this.d == ']') {
                                this.f6092a = 15;
                                l();
                            }
                            if (this.d == 26) {
                                this.f6092a = 20;
                            }
                            break;
                        case 16:
                            char c10 = this.d;
                            if (c10 == ',') {
                                this.f6092a = 16;
                                l();
                            } else if (c10 == '}') {
                                this.f6092a = 13;
                                l();
                            } else if (c10 == ']') {
                                this.f6092a = 15;
                                l();
                            } else if (c10 == 26) {
                                this.f6092a = 20;
                            }
                            break;
                    }
                    return;
                }
                if (this.d == 26) {
                    this.f6092a = 20;
                    return;
                }
            }
            char c11 = this.d;
            if (c11 != ' ' && c11 != '\n' && c11 != '\r' && c11 != '\t' && c11 != '\f' && c11 != '\b') {
                m();
                return;
            }
            l();
        }
    }

    public final void o() {
        this.f6094g = 0;
        while (true) {
            char c = this.d;
            if (c == ':') {
                l();
                m();
                return;
            }
            if (c != ' ' && c != '\n' && c != '\r' && c != '\t' && c != '\f' && c != '\b') {
                throw new d("not match : - " + this.d + ", info : " + f());
            }
            l();
        }
    }

    public abstract String p();

    public final void q(char c) {
        int i5 = this.f6094g;
        char[] cArr = this.f6093f;
        if (i5 == cArr.length) {
            char[] cArr2 = new char[cArr.length * 2];
            System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
            this.f6093f = cArr2;
        }
        char[] cArr3 = this.f6093f;
        int i6 = this.f6094g;
        this.f6094g = i6 + 1;
        cArr3[i6] = c;
    }

    public abstract boolean s(char[] cArr);

    /* JADX WARN: Code duplicated, block: B:37:0x007b A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x007d -> B:34:0x006e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final double t(char[] r11) {
        /*
            Method dump skipped, instruction units count: 269
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p067m.e.t(char[]):double");
    }

    public final float u(char[] cArr) {
        int i5;
        char cB;
        this.f6100m = 0;
        if (!a(cArr)) {
            this.f6100m = -2;
            return 0.0f;
        }
        int length = cArr.length;
        int i6 = length + 1;
        char cB2 = b(this.e + length);
        if (cB2 < '0' || cB2 > '9') {
            this.f6100m = -1;
            return 0.0f;
        }
        while (true) {
            i5 = i6 + 1;
            cB = b(this.e + i6);
            if (cB < '0' || cB > '9') {
                break;
            }
            i6 = i5;
        }
        if (cB == '.') {
            int i7 = i6 + 2;
            char cB3 = b(this.e + i5);
            if (cB3 < '0' || cB3 > '9') {
                this.f6100m = -1;
                return 0.0f;
            }
            while (true) {
                i5 = i7 + 1;
                cB = b(this.e + i7);
                if (cB < '0' || cB > '9') {
                    break;
                }
                i7 = i5;
            }
        }
        int i8 = this.e;
        int length2 = cArr.length + i8;
        float f6 = Float.parseFloat(K(length2, ((i8 + i5) - length2) - 1));
        if (cB == ',') {
            int i9 = this.e + i5;
            this.e = i9;
            this.d = b(i9);
            this.f6100m = 3;
            this.f6092a = 16;
            return f6;
        }
        if (cB != '}') {
            this.f6100m = -1;
            return 0.0f;
        }
        int i10 = i5 + 1;
        char cB4 = b(this.e + i5);
        if (cB4 == ',') {
            this.f6092a = 16;
            int i11 = this.e + i10;
            this.e = i11;
            this.d = b(i11);
        } else if (cB4 == ']') {
            this.f6092a = 15;
            int i12 = this.e + i10;
            this.e = i12;
            this.d = b(i12);
        } else if (cB4 == '}') {
            this.f6092a = 13;
            int i13 = this.e + i10;
            this.e = i13;
            this.d = b(i13);
        } else {
            if (cB4 != 26) {
                this.f6100m = -1;
                return 0.0f;
            }
            this.e += i5;
            this.f6092a = 20;
            this.d = (char) 26;
        }
        this.f6100m = 4;
        return f6;
    }

    public final float[] v(char[] cArr) {
        int i5;
        char cB;
        int i6;
        float f6;
        this.f6100m = 0;
        float[] fArr = null;
        if (!a(cArr)) {
            this.f6100m = -2;
            return null;
        }
        int length = cArr.length;
        int i7 = length + 1;
        if (b(this.e + length) != '[') {
            this.f6100m = -2;
            return null;
        }
        int i8 = length + 2;
        char cB2 = b(this.e + i7);
        float[] fArr2 = new float[16];
        int i9 = 0;
        while (true) {
            int i10 = this.e + i8;
            int i11 = i10 - 1;
            boolean z6 = cB2 == '-';
            if (z6) {
                i8++;
                cB2 = b(i10);
            }
            if (cB2 < '0' || cB2 > '9') {
                break;
            }
            int i12 = cB2 - '0';
            while (true) {
                i5 = i8 + 1;
                cB = b(this.e + i8);
                if (cB < '0' || cB > '9') {
                    break;
                }
                i12 = (i12 * 10) + (cB - '0');
                i8 = i5;
            }
            float[] fArr3 = fArr;
            if (cB == '.') {
                int i13 = i8 + 2;
                char cB3 = b(this.e + i5);
                if (cB3 < '0' || cB3 > '9') {
                    this.f6100m = -1;
                    return fArr3;
                }
                i12 = (cB3 - '0') + (i12 * 10);
                i6 = 10;
                while (true) {
                    i5 = i13 + 1;
                    cB = b(this.e + i13);
                    if (cB < '0' || cB > '9') {
                        break;
                    }
                    i12 = (i12 * 10) + (cB - '0');
                    i6 *= 10;
                    i13 = i5;
                }
            } else {
                i6 = 1;
            }
            boolean z7 = cB == 'e' || cB == 'E';
            if (z7) {
                int i14 = i5 + 1;
                cB = b(this.e + i5);
                if (cB == '+' || cB == '-') {
                    i5 += 2;
                    cB = b(this.e + i14);
                } else {
                    i5 = i14;
                }
                while (cB >= '0' && cB <= '9') {
                    cB = b(this.e + i5);
                    i5++;
                }
            }
            int i15 = ((this.e + i5) - i11) - 1;
            if (z7 || i15 >= 10) {
                f6 = Float.parseFloat(K(i11, i15));
            } else {
                f6 = i12 / i6;
                if (z6) {
                    f6 = -f6;
                }
            }
            if (i9 >= fArr2.length) {
                float[] fArr4 = new float[(fArr2.length * 3) / 2];
                System.arraycopy(fArr2, 0, fArr4, 0, i9);
                fArr2 = fArr4;
            }
            int i16 = i9 + 1;
            fArr2[i9] = f6;
            if (cB == ',') {
                cB = b(this.e + i5);
                i8 = i5 + 1;
            } else {
                if (cB == ']') {
                    int i17 = i5 + 1;
                    char cB4 = b(this.e + i5);
                    if (i16 != fArr2.length) {
                        float[] fArr5 = new float[i16];
                        System.arraycopy(fArr2, 0, fArr5, 0, i16);
                        fArr2 = fArr5;
                    }
                    if (cB4 == ',') {
                        this.e += i5;
                        l();
                        this.f6100m = 3;
                        this.f6092a = 16;
                        return fArr2;
                    }
                    if (cB4 != '}') {
                        this.f6100m = -1;
                        return fArr3;
                    }
                    char cB5 = b(this.e + i17);
                    if (cB5 == ',') {
                        this.f6092a = 16;
                        this.e = i17 + this.e;
                        l();
                    } else if (cB5 == ']') {
                        this.f6092a = 15;
                        this.e = i17 + this.e;
                        l();
                    } else if (cB5 == '}') {
                        this.f6092a = 13;
                        this.e = i17 + this.e;
                        l();
                    } else {
                        if (cB5 != 26) {
                            this.f6100m = -1;
                            return fArr3;
                        }
                        this.e = i17 + this.e;
                        this.f6092a = 20;
                        this.d = (char) 26;
                    }
                    this.f6100m = 4;
                    return fArr2;
                }
                i8 = i5;
            }
            i9 = i16;
            cB2 = cB;
            fArr = fArr3;
        }
        float[] fArr6 = fArr;
        this.f6100m = -1;
        return fArr6;
    }

    public final float[][] w(char[] cArr) {
        float[][] fArr;
        int i5;
        char cB;
        int i6;
        float f6;
        int i7;
        int i8;
        int i9 = 0;
        this.f6100m = 0;
        float[][] fArr2 = null;
        if (!a(cArr)) {
            this.f6100m = -2;
            return null;
        }
        int length = cArr.length;
        int i10 = length + 1;
        char c = '[';
        if (b(this.e + length) != '[') {
            this.f6100m = -2;
            return null;
        }
        int i11 = length + 2;
        char cB2 = b(this.e + i10);
        int i12 = 16;
        float[][] fArr3 = new float[16][];
        int i13 = 0;
        loop0: while (true) {
            if (cB2 == c) {
                int i14 = i11 + 1;
                char cB3 = b(this.e + i11);
                float[] fArr4 = new float[i12];
                int i15 = i9;
                while (true) {
                    int i16 = this.e + i14;
                    int i17 = i16 - 1;
                    int i18 = cB3 == '-' ? 1 : i9;
                    if (i18 != 0) {
                        i14++;
                        cB3 = b(i16);
                    }
                    fArr = fArr2;
                    if (cB3 < '0' || cB3 > '9') {
                        break loop0;
                    }
                    int i19 = cB3 - '0';
                    while (true) {
                        i5 = i14 + 1;
                        cB = b(this.e + i14);
                        if (cB < '0' || cB > '9') {
                            break;
                        }
                        i19 = (i19 * 10) + (cB - '0');
                        i14 = i5;
                    }
                    if (cB == '.') {
                        int i20 = i14 + 2;
                        char cB4 = b(this.e + i5);
                        if (cB4 < '0' || cB4 > '9') {
                            this.f6100m = -1;
                            return fArr;
                        }
                        i19 = (cB4 - '0') + (i19 * 10);
                        i6 = 10;
                        while (true) {
                            i5 = i20 + 1;
                            cB = b(this.e + i20);
                            if (cB < '0' || cB > '9') {
                                break;
                            }
                            i19 = (i19 * 10) + (cB - '0');
                            i6 *= 10;
                            i20 = i5;
                        }
                    } else {
                        i6 = 1;
                    }
                    boolean z6 = cB == 'e' || cB == 'E';
                    if (z6) {
                        int i21 = i5 + 1;
                        cB = b(this.e + i5);
                        if (cB == '+' || cB == '-') {
                            i5 += 2;
                            cB = b(this.e + i21);
                        } else {
                            i5 = i21;
                        }
                        while (cB >= '0' && cB <= '9') {
                            cB = b(this.e + i5);
                            i5++;
                        }
                    }
                    int i22 = ((this.e + i5) - i17) - 1;
                    if (z6 || i22 >= 10) {
                        f6 = Float.parseFloat(K(i17, i22));
                    } else {
                        f6 = i19 / i6;
                        if (i18 != 0) {
                            f6 = -f6;
                        }
                    }
                    if (i15 >= fArr4.length) {
                        float[] fArr5 = new float[(fArr4.length * 3) / 2];
                        System.arraycopy(fArr4, 0, fArr5, 0, i15);
                        fArr4 = fArr5;
                    }
                    int i23 = i15 + 1;
                    fArr4[i15] = f6;
                    if (cB == ',') {
                        cB = b(this.e + i5);
                        i14 = i5 + 1;
                    } else {
                        if (cB == ']') {
                            int i24 = i5 + 1;
                            char cB5 = b(this.e + i5);
                            if (i23 != fArr4.length) {
                                float[] fArr6 = new float[i23];
                                i7 = 0;
                                System.arraycopy(fArr4, 0, fArr6, 0, i23);
                                fArr4 = fArr6;
                            } else {
                                i7 = 0;
                            }
                            if (i13 >= fArr3.length) {
                                fArr3 = new float[(fArr3.length * 3) / 2][];
                                System.arraycopy(fArr4, i7, fArr3, i7, i23);
                            }
                            int i25 = i13 + 1;
                            fArr3[i13] = fArr4;
                            if (cB5 == ',') {
                                i8 = i5 + 2;
                                cB2 = b(this.e + i24);
                            } else {
                                if (cB5 == ']') {
                                    int i26 = i5 + 2;
                                    char cB6 = b(this.e + i24);
                                    if (i25 != fArr3.length) {
                                        float[][] fArr7 = new float[i25][];
                                        System.arraycopy(fArr3, 0, fArr7, 0, i25);
                                        fArr3 = fArr7;
                                    }
                                    if (cB6 == ',') {
                                        this.e = i24 + this.e;
                                        l();
                                        this.f6100m = 3;
                                        this.f6092a = 16;
                                        return fArr3;
                                    }
                                    if (cB6 != '}') {
                                        this.f6100m = -1;
                                        return fArr;
                                    }
                                    char cB7 = b(this.e + i26);
                                    if (cB7 == ',') {
                                        this.f6092a = 16;
                                        this.e = i26 + this.e;
                                        l();
                                    } else if (cB7 == ']') {
                                        this.f6092a = 15;
                                        this.e = i26 + this.e;
                                        l();
                                    } else if (cB7 == '}') {
                                        this.f6092a = 13;
                                        this.e = i26 + this.e;
                                        l();
                                    } else {
                                        if (cB7 != 26) {
                                            this.f6100m = -1;
                                            return fArr;
                                        }
                                        this.e = i26 + this.e;
                                        this.f6092a = 20;
                                        this.d = (char) 26;
                                    }
                                    this.f6100m = 4;
                                    return fArr3;
                                }
                                cB2 = cB5;
                                i8 = i24;
                            }
                            i13 = i25;
                            i12 = 16;
                            i9 = 0;
                            fArr2 = fArr;
                            i11 = i8;
                            c = '[';
                            break;
                        }
                        i14 = i5;
                    }
                    i15 = i23;
                    i9 = 0;
                    cB3 = cB;
                    fArr2 = fArr;
                }
            }
        }
        this.f6100m = -1;
        return fArr;
    }

    public abstract int x(char[] cArr);

    public final int[] y(char[] cArr) {
        boolean z6;
        int[] iArr;
        int i5;
        char cB;
        int i6;
        char cB2;
        int i7;
        this.f6100m = 0;
        int[] iArr2 = null;
        if (!a(cArr)) {
            this.f6100m = -2;
            return null;
        }
        int length = cArr.length;
        int i8 = length + 1;
        if (b(this.e + length) != '[') {
            this.f6100m = -2;
            return null;
        }
        int i9 = length + 2;
        char cB3 = b(this.e + i8);
        int[] iArr3 = new int[16];
        if (cB3 == ']') {
            i7 = length + 3;
            cB2 = b(this.e + i9);
            i6 = 0;
            iArr = null;
        } else {
            int i10 = 0;
            while (true) {
                if (cB3 == '-') {
                    cB3 = b(this.e + i9);
                    i9++;
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (cB3 < '0' || cB3 > '9') {
                    int[] iArr4 = iArr2;
                    this.f6100m = -1;
                    return iArr4;
                }
                int i11 = cB3 - '0';
                iArr = iArr2;
                while (true) {
                    i5 = i9 + 1;
                    cB = b(this.e + i9);
                    if (cB < '0' || cB > '9') {
                        break;
                    }
                    i11 = (i11 * 10) + (cB - '0');
                    i9 = i5;
                }
                if (i10 >= iArr3.length) {
                    int[] iArr5 = new int[(iArr3.length * 3) / 2];
                    System.arraycopy(iArr3, 0, iArr5, 0, i10);
                    iArr3 = iArr5;
                }
                i6 = i10 + 1;
                if (z6) {
                    i11 = -i11;
                }
                iArr3[i10] = i11;
                if (cB == ',') {
                    i9 += 2;
                    cB3 = b(this.e + i5);
                } else {
                    if (cB == ']') {
                        cB2 = b(this.e + i5);
                        i7 = i9 + 2;
                        break;
                    }
                    cB3 = cB;
                    i9 = i5;
                }
                i10 = i6;
                iArr2 = iArr;
            }
        }
        if (i6 != iArr3.length) {
            int[] iArr6 = new int[i6];
            System.arraycopy(iArr3, 0, iArr6, 0, i6);
            iArr3 = iArr6;
        }
        if (cB2 == ',') {
            this.e = (i7 - 1) + this.e;
            l();
            this.f6100m = 3;
            this.f6092a = 16;
            return iArr3;
        }
        if (cB2 != '}') {
            this.f6100m = -1;
            return iArr;
        }
        char cB4 = b(this.e + i7);
        if (cB4 == ',') {
            this.f6092a = 16;
            this.e += i7;
            l();
        } else if (cB4 == ']') {
            this.f6092a = 15;
            this.e += i7;
            l();
        } else if (cB4 == '}') {
            this.f6092a = 13;
            this.e += i7;
            l();
        } else {
            if (cB4 != 26) {
                this.f6100m = -1;
                return iArr;
            }
            this.e += i7;
            this.f6092a = 20;
            this.d = (char) 26;
        }
        this.f6100m = 4;
        return iArr3;
    }

    public abstract long z(char[] cArr);
}
