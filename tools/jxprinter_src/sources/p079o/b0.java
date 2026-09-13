package p079o;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.MalformedInputException;
import java.util.Properties;
import kotlinx.serialization.json.internal.AbstractC1127c;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.util.Chars;
import org.apache.xmlbeans.impl.common.NameUtil;
import p050j.a;
import p050j.d;
import p096r.e;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class b0 extends Writer {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Charset f6365o = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final ThreadLocal f6366p = new ThreadLocal();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final ThreadLocal f6367q = new ThreadLocal();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f6368r = ((((((((c0.UseSingleQuotes.f6406a | c0.BrowserSecure.f6406a) | c0.BrowserCompatible.f6406a) | c0.PrettyFormat.f6406a) | c0.WriteEnumUsingToString.f6406a) | c0.WriteNonStringValueAsString.f6406a) | c0.WriteSlashAsSpecial.f6406a) | c0.IgnoreErrorGetter.f6406a) | c0.WriteClassName.f6406a) | c0.NotWriteDefaultValue.f6406a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public char[] f6369a;
    public int b;
    public int c;
    public boolean d;
    public boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f6370f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f6371g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f6372h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f6373i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f6374j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f6375k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f6376l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public char f6377m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f6378n;

    public b0() {
        this(a.f5374g, c0.f6382D);
    }

    public static boolean e(char c, int i5) {
        if (c == ' ') {
            return false;
        }
        if (c == '/') {
            return (c0.WriteSlashAsSpecial.f6406a & i5) != 0;
        }
        if (c <= '#' || c == '\\') {
            return c <= 31 || c == '\\' || c == '\"';
        }
        return false;
    }

    private int encodeToUTF8(OutputStream outputStream) throws IOException {
        int i5;
        int i6;
        int codePoint;
        char c;
        int i7 = (int) (((double) this.b) * 3.0d);
        ThreadLocal threadLocal = f6367q;
        byte[] bArr = (byte[]) threadLocal.get();
        if (bArr == null) {
            bArr = new byte[8192];
            threadLocal.set(bArr);
        }
        if (bArr.length < i7) {
            bArr = new byte[i7];
        }
        char[] cArr = this.f6369a;
        int i8 = this.b;
        Properties properties = e.f7898a;
        int iMin = Math.min(i8, bArr.length);
        int i9 = 0;
        int i10 = 0;
        while (i9 < iMin && (c = cArr[i10]) < 128) {
            i10++;
            bArr[i9] = (byte) c;
            i9++;
        }
        while (i10 < i8) {
            int i11 = i10 + 1;
            char c6 = cArr[i10];
            if (c6 < 128) {
                i6 = i9 + 1;
                bArr[i9] = (byte) c6;
            } else {
                if (c6 < 2048) {
                    int i12 = i9 + 1;
                    bArr[i9] = (byte) ((c6 >> 6) | 192);
                    i9 += 2;
                    bArr[i12] = (byte) ((c6 & '?') | 128);
                } else if (c6 < 55296 || c6 >= 57344) {
                    bArr[i9] = (byte) ((c6 >> '\f') | 224);
                    int i13 = i9 + 2;
                    bArr[i9 + 1] = (byte) ((63 & (c6 >> 6)) | 128);
                    i9 += 3;
                    bArr[i13] = (byte) ((c6 & '?') | 128);
                } else {
                    if (Character.isHighSurrogate(c6)) {
                        if (i8 - i10 < 2) {
                            i5 = -1;
                        } else {
                            char c7 = cArr[i11];
                            if (!Character.isLowSurrogate(c7)) {
                                throw new d("encodeUTF8 error", new MalformedInputException(1));
                            }
                            codePoint = Character.toCodePoint(c6, c7);
                        }
                    } else if (Character.isLowSurrogate(c6)) {
                        i5 = c6;
                        throw new d("encodeUTF8 error", new MalformedInputException(1));
                    }
                    if (i5 < 0) {
                        i5 = codePoint;
                        i6 = i9 + 1;
                        bArr[i9] = 63;
                    } else {
                        i5 = codePoint;
                        bArr[i9] = (byte) ((i5 >> 18) | 240);
                        bArr[i9 + 1] = (byte) (((i5 >> 12) & 63) | 128);
                        bArr[i9 + 2] = (byte) ((63 & (i5 >> 6)) | 128);
                        bArr[i9 + 3] = (byte) ((i5 & 63) | 128);
                        i11 = i10 + 2;
                        i6 = i9 + 4;
                    }
                }
                i10 = i11;
            }
            i9 = i6;
            i10 = i11;
        }
        outputStream.write(bArr, 0, i9);
        return i9;
    }

    public final void a(CharSequence charSequence) {
        String string = charSequence == null ? AbstractC1127c.NULL : charSequence.toString();
        write(string, 0, string.length());
    }

    @Override // java.io.Writer, java.lang.Appendable
    public /* bridge */ /* synthetic */ Writer append(CharSequence charSequence) {
        a(charSequence);
        return this;
    }

    public final void b() {
        int i5 = this.c;
        boolean z6 = (c0.QuoteFieldNames.f6406a & i5) != 0;
        this.e = z6;
        boolean z7 = (c0.UseSingleQuotes.f6406a & i5) != 0;
        this.d = z7;
        this.f6370f = (c0.SortField.f6406a & i5) != 0;
        this.f6371g = (c0.DisableCircularReferenceDetect.f6406a & i5) != 0;
        this.f6372h = (c0.BeanToArray.f6406a & i5) != 0;
        this.f6373i = (c0.WriteNonStringValueAsString.f6406a & i5) != 0;
        this.f6374j = (c0.NotWriteDefaultValue.f6406a & i5) != 0;
        this.f6375k = (c0.WriteEnumUsingName.f6406a & i5) != 0;
        this.f6376l = (c0.WriteEnumUsingToString.f6406a & i5) != 0;
        if (z6) {
            int i6 = i5 & f6368r;
        }
        this.f6377m = z7 ? Chars.QUOTE : Chars.DQUOTE;
    }

    public final void c(int i5) {
        int i6 = this.f6378n;
        if (i6 != -1 && i5 >= i6) {
            throw new d(androidx.collection.a.h(i6, i5, "serialize exceeded MAX_OUTPUT_LENGTH=", ", minimumCapacity="));
        }
        char[] cArr = this.f6369a;
        int iC = androidx.collection.a.c(cArr.length, 3, 2, 1);
        if (iC >= i5) {
            i5 = iC;
        }
        char[] cArr2 = new char[i5];
        System.arraycopy(cArr, 0, cArr2, 0, this.b);
        this.f6369a = cArr2;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        char[] cArr = this.f6369a;
        if (cArr.length <= 65536) {
            f6366p.set(cArr);
        }
        this.f6369a = null;
    }

    public final boolean d(c0 c0Var) {
        return (c0Var.f6406a & this.c) != 0;
    }

    public final void f(double d, boolean z6) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            n();
            return;
        }
        String string = Double.toString(d);
        if (d(c0.WriteNullNumberAsZero) && string.endsWith(".0")) {
            string = androidx.collection.a.g(2, 0, string);
        }
        write(string);
        if (z6 && d(c0.WriteClassName)) {
            write(68);
        }
    }

    public final void g(String str) {
        boolean z6;
        int i5;
        if (str == null) {
            write("null:");
            return;
        }
        int i6 = 1;
        if (!this.d) {
            if (this.e) {
                r(str, NameUtil.COLON);
                return;
            }
            boolean z7 = str.length() == 0;
            int i7 = 0;
            while (true) {
                if (i7 >= str.length()) {
                    z6 = z7;
                    break;
                } else {
                    if (e(str.charAt(i7), 0)) {
                        z6 = true;
                        break;
                    }
                    i7++;
                }
            }
            if (z6) {
                r(str, NameUtil.COLON);
                return;
            } else {
                write(str);
                write(58);
                return;
            }
        }
        if (this.e) {
            s(str);
            write(58);
            return;
        }
        byte[] bArr = e.f7900g;
        int length = str.length();
        int i8 = this.b + length + 1;
        if (i8 > this.f6369a.length) {
            c(i8);
        }
        if (length == 0) {
            int i9 = this.b + 3;
            if (i9 > this.f6369a.length) {
                c(i9);
            }
            char[] cArr = this.f6369a;
            int i10 = this.b;
            int i11 = i10 + 1;
            this.b = i11;
            cArr[i10] = Chars.QUOTE;
            int i12 = i10 + 2;
            this.b = i12;
            cArr[i11] = Chars.QUOTE;
            this.b = i10 + 3;
            cArr[i12] = NameUtil.COLON;
            return;
        }
        int i13 = this.b;
        int i14 = i13 + length;
        str.getChars(0, length, this.f6369a, i13);
        this.b = i8;
        int i15 = 0;
        int i16 = i13;
        while (i16 < i14) {
            char[] cArr2 = this.f6369a;
            char c = cArr2[i16];
            if (c >= bArr.length || bArr[c] == 0) {
                i5 = i6;
            } else if (i15 == 0) {
                i8 += 3;
                if (i8 > cArr2.length) {
                    c(i8);
                }
                this.b = i8;
                char[] cArr3 = this.f6369a;
                int i17 = i16 + 1;
                System.arraycopy(cArr3, i17, cArr3, i16 + 3, (i14 - i16) - i6);
                char[] cArr4 = this.f6369a;
                System.arraycopy(cArr4, 0, cArr4, i6, i16);
                char[] cArr5 = this.f6369a;
                cArr5[i13] = Chars.QUOTE;
                cArr5[i17] = IOUtils.DIR_SEPARATOR_WINDOWS;
                i16 += 2;
                cArr5[i16] = e.f7903j[c];
                i14 += 2;
                cArr5[this.b - 2] = Chars.QUOTE;
                i15 = i6;
                i5 = i15;
            } else {
                i8++;
                if (i8 > cArr2.length) {
                    c(i8);
                }
                this.b = i8;
                char[] cArr6 = this.f6369a;
                int i18 = i16 + 1;
                i5 = i6;
                System.arraycopy(cArr6, i18, cArr6, i16 + 2, i14 - i16);
                char[] cArr7 = this.f6369a;
                cArr7[i16] = IOUtils.DIR_SEPARATOR_WINDOWS;
                cArr7[i18] = e.f7903j[c];
                i14++;
                i16 = i18;
            }
            i16++;
            i6 = i5;
        }
        this.f6369a[i8 - 1] = NameUtil.COLON;
    }

    public final void h(char c, String str, int i5) {
        if (i5 == Integer.MIN_VALUE || !this.e) {
            write(c);
            g(str);
            l(i5);
            return;
        }
        int iD = i5 < 0 ? e.d(-i5) + 1 : e.d(i5);
        int length = str.length();
        int i6 = this.b + length + 4 + iD;
        if (i6 > this.f6369a.length) {
            c(i6);
        }
        int i7 = this.b;
        this.b = i6;
        char[] cArr = this.f6369a;
        cArr[i7] = c;
        int i8 = i7 + length;
        cArr[i7 + 1] = this.f6377m;
        str.getChars(0, length, cArr, i7 + 2);
        char[] cArr2 = this.f6369a;
        cArr2[i8 + 2] = this.f6377m;
        cArr2[i8 + 3] = NameUtil.COLON;
        e.b(cArr2, i5, this.b);
    }

    public final void i(char c, String str, long j6) {
        if (j6 == Long.MIN_VALUE || !this.e) {
            write(c);
            g(str);
            m(j6);
            return;
        }
        int iE = j6 < 0 ? e.e(-j6) + 1 : e.e(j6);
        int length = str.length();
        int i5 = this.b + length + 4 + iE;
        if (i5 > this.f6369a.length) {
            c(i5);
        }
        int i6 = this.b;
        this.b = i5;
        char[] cArr = this.f6369a;
        cArr[i6] = c;
        int i7 = i6 + length;
        cArr[i6 + 1] = this.f6377m;
        str.getChars(0, length, cArr, i6 + 2);
        char[] cArr2 = this.f6369a;
        cArr2[i7 + 2] = this.f6377m;
        cArr2[i7 + 3] = NameUtil.COLON;
        e.a(j6, this.b, cArr2);
    }

    public final void j(String str, char c, String str2) {
        if (!this.e) {
            write(c);
            g(str);
            if (str2 == null) {
                n();
                return;
            } else {
                q(str2);
                return;
            }
        }
        if (this.d) {
            write(c);
            g(str);
            if (str2 == null) {
                n();
                return;
            } else {
                q(str2);
                return;
            }
        }
        if (d(c0.BrowserSecure)) {
            write(c);
            r(str, NameUtil.COLON);
            r(str2, (char) 0);
        } else {
            if (!d(c0.BrowserCompatible)) {
                k(str, c, str2);
                return;
            }
            write(c);
            r(str, NameUtil.COLON);
            r(str2, (char) 0);
        }
    }

    public final void k(String str, char c, String str2) {
        int i5;
        int i6;
        char c6;
        int length = str.length();
        int i7 = this.b;
        if (str2 == null) {
            i5 = length + 8 + i7;
            i6 = 4;
        } else {
            int length2 = str2.length();
            i5 = i7 + length + length2 + 6;
            i6 = length2;
        }
        if (i5 > this.f6369a.length) {
            c(i5);
        }
        char[] cArr = this.f6369a;
        int i8 = this.b;
        cArr[i8] = c;
        int i9 = i8 + 2;
        int i10 = i9 + length;
        char c7 = Chars.DQUOTE;
        cArr[i8 + 1] = Chars.DQUOTE;
        int i11 = 0;
        str.getChars(0, length, cArr, i9);
        this.b = i5;
        char[] cArr2 = this.f6369a;
        cArr2[i10] = Chars.DQUOTE;
        int i12 = i10 + 2;
        cArr2[i10 + 1] = NameUtil.COLON;
        char c8 = 'u';
        if (str2 == null) {
            cArr2[i12] = 'n';
            cArr2[i10 + 3] = 'u';
            cArr2[i10 + 4] = 'l';
            cArr2[i10 + 5] = 'l';
            return;
        }
        int i13 = i10 + 3;
        cArr2[i12] = Chars.DQUOTE;
        int i14 = i13 + i6;
        str2.getChars(0, i6, cArr2, i13);
        int i15 = -1;
        int i16 = -1;
        char c9 = 0;
        int i17 = i13;
        while (true) {
            c6 = c8;
            if (i17 >= i14) {
                break;
            }
            char c10 = c7;
            char c11 = this.f6369a[i17];
            if (c11 >= ']') {
                if (c11 >= 127 && (c11 == 8232 || c11 == 8233 || c11 < 160)) {
                    if (i15 == -1) {
                        i15 = i17;
                    }
                    i11++;
                    i5 += 4;
                    c9 = c11;
                    i16 = i17;
                }
            } else if (e(c11, this.c)) {
                i11++;
                byte[] bArr = e.f7899f;
                if (c11 < bArr.length && bArr[c11] == 4) {
                    i5 += 4;
                }
                c9 = c11;
                if (i15 == -1) {
                    i15 = i17;
                    i16 = i15;
                } else {
                    i16 = i17;
                }
            }
            i17++;
            c8 = c6;
            c7 = c10;
        }
        char c12 = c7;
        if (i11 > 0) {
            int i18 = i5 + i11;
            if (i18 > this.f6369a.length) {
                c(i18);
            }
            this.b = i18;
            if (i11 == 1) {
                if (c9 == 8232) {
                    int i19 = i16 + 1;
                    char[] cArr3 = this.f6369a;
                    System.arraycopy(cArr3, i19, cArr3, i16 + 6, (i14 - i16) - 1);
                    char[] cArr4 = this.f6369a;
                    cArr4[i16] = IOUtils.DIR_SEPARATOR_WINDOWS;
                    cArr4[i19] = c6;
                    cArr4[i16 + 2] = '2';
                    cArr4[i16 + 3] = '0';
                    cArr4[i16 + 4] = '2';
                    cArr4[i16 + 5] = '8';
                } else if (c9 == 8233) {
                    int i20 = i16 + 1;
                    char[] cArr5 = this.f6369a;
                    System.arraycopy(cArr5, i20, cArr5, i16 + 6, (i14 - i16) - 1);
                    char[] cArr6 = this.f6369a;
                    cArr6[i16] = IOUtils.DIR_SEPARATOR_WINDOWS;
                    cArr6[i20] = c6;
                    cArr6[i16 + 2] = '2';
                    cArr6[i16 + 3] = '0';
                    cArr6[i16 + 4] = '2';
                    cArr6[i16 + 5] = '9';
                } else {
                    byte[] bArr2 = e.f7899f;
                    if (c9 >= bArr2.length || bArr2[c9] != 4) {
                        int i21 = i16 + 1;
                        char[] cArr7 = this.f6369a;
                        System.arraycopy(cArr7, i21, cArr7, i16 + 2, (i14 - i16) - 1);
                        char[] cArr8 = this.f6369a;
                        cArr8[i16] = IOUtils.DIR_SEPARATOR_WINDOWS;
                        cArr8[i21] = e.f7903j[c9];
                    } else {
                        int i22 = i16 + 1;
                        char[] cArr9 = this.f6369a;
                        System.arraycopy(cArr9, i22, cArr9, i16 + 6, (i14 - i16) - 1);
                        char[] cArr10 = this.f6369a;
                        cArr10[i16] = IOUtils.DIR_SEPARATOR_WINDOWS;
                        cArr10[i22] = c6;
                        char[] cArr11 = e.c;
                        cArr10[i16 + 2] = cArr11[(c9 >>> '\f') & 15];
                        cArr10[i16 + 3] = cArr11[(c9 >>> '\b') & 15];
                        cArr10[i16 + 4] = cArr11[(c9 >>> 4) & 15];
                        cArr10[i16 + 5] = cArr11[c9 & 15];
                    }
                }
            } else if (i11 > 1) {
                for (int i23 = i15 - i13; i23 < str2.length(); i23++) {
                    char cCharAt = str2.charAt(i23);
                    byte[] bArr3 = e.f7899f;
                    if ((cCharAt < bArr3.length && bArr3[cCharAt] != 0) || (cCharAt == '/' && d(c0.WriteSlashAsSpecial))) {
                        char[] cArr12 = this.f6369a;
                        int i24 = i15 + 1;
                        cArr12[i15] = IOUtils.DIR_SEPARATOR_WINDOWS;
                        if (bArr3[cCharAt] == 4) {
                            cArr12[i24] = c6;
                            char[] cArr13 = e.c;
                            cArr12[i15 + 2] = cArr13[(cCharAt >>> '\f') & 15];
                            cArr12[i15 + 3] = cArr13[(cCharAt >>> '\b') & 15];
                            int i25 = i15 + 5;
                            cArr12[i15 + 4] = cArr13[(cCharAt >>> 4) & 15];
                            i15 += 6;
                            cArr12[i25] = cArr13[cCharAt & 15];
                        } else {
                            i15 += 2;
                            cArr12[i24] = e.f7903j[cCharAt];
                        }
                    } else if (cCharAt == 8232 || cCharAt == 8233) {
                        char[] cArr14 = this.f6369a;
                        cArr14[i15] = IOUtils.DIR_SEPARATOR_WINDOWS;
                        cArr14[i15 + 1] = c6;
                        char[] cArr15 = e.c;
                        cArr14[i15 + 2] = cArr15[(cCharAt >>> '\f') & 15];
                        cArr14[i15 + 3] = cArr15[(cCharAt >>> '\b') & 15];
                        int i26 = i15 + 5;
                        cArr14[i15 + 4] = cArr15[(cCharAt >>> 4) & 15];
                        i15 += 6;
                        cArr14[i26] = cArr15[cCharAt & 15];
                    } else {
                        this.f6369a[i15] = cCharAt;
                        i15++;
                    }
                }
            }
        }
        this.f6369a[this.b - 1] = c12;
    }

    public final void l(int i5) {
        if (i5 == Integer.MIN_VALUE) {
            write("-2147483648");
            return;
        }
        int iD = this.b + (i5 < 0 ? e.d(-i5) + 1 : e.d(i5));
        if (iD > this.f6369a.length) {
            c(iD);
        }
        e.b(this.f6369a, i5, iD);
        this.b = iD;
    }

    public final void m(long j6) {
        boolean z6 = d(c0.BrowserCompatible) && !d(c0.WriteClassName) && (j6 > 9007199254740991L || j6 < -9007199254740991L);
        if (j6 == Long.MIN_VALUE) {
            if (z6) {
                write("\"-9223372036854775808\"");
                return;
            } else {
                write("-9223372036854775808");
                return;
            }
        }
        int iE = this.b + (j6 < 0 ? e.e(-j6) + 1 : e.e(j6));
        if (z6) {
            iE += 2;
        }
        if (iE > this.f6369a.length) {
            c(iE);
        }
        if (z6) {
            char[] cArr = this.f6369a;
            cArr[this.b] = Chars.DQUOTE;
            int i5 = iE - 1;
            e.a(j6, i5, cArr);
            this.f6369a[i5] = Chars.DQUOTE;
        } else {
            e.a(j6, iE, this.f6369a);
        }
        this.b = iE;
    }

    public final void n() {
        write(AbstractC1127c.NULL);
    }

    public final void o(int i5, int i6) {
        if ((i5 & i6) == 0 && (this.c & i6) == 0) {
            n();
            return;
        }
        if (i6 == c0.WriteNullListAsEmpty.f6406a) {
            write("[]");
            return;
        }
        if (i6 == c0.WriteNullStringAsEmpty.f6406a) {
            q("");
            return;
        }
        if (i6 == c0.WriteNullBooleanAsFalse.f6406a) {
            write("false");
        } else if (i6 == c0.WriteNullNumberAsZero.f6406a) {
            write(48);
        } else {
            n();
        }
    }

    public final void p(c0 c0Var) {
        o(0, c0Var.f6406a);
    }

    public final void q(String str) {
        if (this.d) {
            s(str);
        } else {
            r(str, (char) 0);
        }
    }

    /* JADX WARN: Code duplicated, block: B:131:0x026c A[PHI: r4 r5 r11
  0x026c: PHI (r4v28 int) = (r4v24 int), (r4v29 int), (r4v30 int) binds: [B:143:0x028f, B:140:0x0286, B:130:0x0268] A[DONT_GENERATE, DONT_INLINE]
  0x026c: PHI (r5v23 int) = (r5v19 int), (r5v24 int), (r5v26 int) binds: [B:143:0x028f, B:140:0x0286, B:130:0x0268] A[DONT_GENERATE, DONT_INLINE]
  0x026c: PHI (r11v13 int) = (r11v2 int), (r11v2 int), (r11v14 int) binds: [B:143:0x028f, B:140:0x0286, B:130:0x0268] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:141:0x0288 A[PHI: r4 r5
  0x0288: PHI (r4v25 int) = (r4v24 int), (r4v29 int) binds: [B:143:0x028f, B:140:0x0286] A[DONT_GENERATE, DONT_INLINE]
  0x0288: PHI (r5v20 int) = (r5v19 int), (r5v24 int) binds: [B:143:0x028f, B:140:0x0286] A[DONT_GENERATE, DONT_INLINE]] */
    public final void r(String str, char c) {
        char c6;
        char c7;
        char c8;
        char c9;
        if (str == null) {
            n();
            if (c != 0) {
                write(c);
                return;
            }
            return;
        }
        int length = str.length();
        int i5 = this.b + length;
        int i6 = i5 + 2;
        if (c != 0) {
            i6 = i5 + 3;
        }
        if (i6 > this.f6369a.length) {
            c(i6);
        }
        int i7 = this.b;
        int i8 = i7 + 1;
        int i9 = i8 + length;
        char[] cArr = this.f6369a;
        char c10 = Chars.DQUOTE;
        cArr[i7] = Chars.DQUOTE;
        int i10 = 0;
        str.getChars(0, length, cArr, i8);
        this.b = i6;
        char c11 = '9';
        int i11 = -1;
        char c12 = '0';
        if (d(c0.BrowserSecure)) {
            int i12 = i8;
            while (true) {
                c8 = '.';
                c9 = c10;
                if (i12 >= i9) {
                    break;
                }
                char c13 = this.f6369a[i12];
                if ((c13 < '0' || c13 > '9') && ((c13 < 'a' || c13 > 'z') && ((c13 < 'A' || c13 > 'Z') && c13 != ',' && c13 != '.' && c13 != '_'))) {
                    i6 += 5;
                    i11 = i12;
                }
                i12++;
                c10 = c9;
            }
            if (i6 > this.f6369a.length) {
                c(i6);
            }
            this.b = i6;
            while (i11 >= i8) {
                char[] cArr2 = this.f6369a;
                char c14 = cArr2[i11];
                if ((c14 < '0' || c14 > c11) && ((c14 < 'a' || c14 > 'z') && ((c14 < 'A' || c14 > 'Z') && c14 != ',' && c14 != c8 && c14 != '_'))) {
                    int i13 = i11 + 1;
                    System.arraycopy(cArr2, i13, cArr2, i11 + 6, (i9 - i11) - 1);
                    char[] cArr3 = this.f6369a;
                    cArr3[i11] = IOUtils.DIR_SEPARATOR_WINDOWS;
                    cArr3[i13] = 'u';
                    char[] cArr4 = e.c;
                    cArr3[i11 + 2] = cArr4[(c14 >>> '\f') & 15];
                    cArr3[i11 + 3] = cArr4[(c14 >>> '\b') & 15];
                    cArr3[i11 + 4] = cArr4[(c14 >>> 4) & 15];
                    cArr3[i11 + 5] = cArr4[c14 & 15];
                    i9 += 5;
                }
                i11--;
                c11 = c11;
                c8 = '.';
            }
            if (c == 0) {
                this.f6369a[this.b - 1] = c9;
                return;
            }
            char[] cArr5 = this.f6369a;
            int i14 = this.b;
            cArr5[i14 - 2] = c9;
            cArr5[i14 - 1] = c;
            return;
        }
        char c15 = '\"';
        char c16 = IOUtils.DIR_SEPARATOR_WINDOWS;
        if (d(c0.BrowserCompatible)) {
            int i15 = i8;
            while (true) {
                c6 = Chars.SPACE;
                c7 = '\t';
                if (i15 >= i9) {
                    break;
                }
                char c17 = c12;
                char c18 = this.f6369a[i15];
                if (c18 == c15 || c18 == '/' || c18 == c16 || c18 == '\b' || c18 == '\f' || c18 == '\n' || c18 == '\r' || c18 == '\t') {
                    i6++;
                } else {
                    if (c18 < ' ' || c18 >= 127) {
                        i6 += 5;
                    }
                    i15++;
                    c12 = c17;
                    c16 = IOUtils.DIR_SEPARATOR_WINDOWS;
                    c15 = Chars.DQUOTE;
                }
                i11 = i15;
                i15++;
                c12 = c17;
                c16 = IOUtils.DIR_SEPARATOR_WINDOWS;
                c15 = Chars.DQUOTE;
            }
            char c19 = c12;
            if (i6 > this.f6369a.length) {
                c(i6);
            }
            this.b = i6;
            while (i11 >= i8) {
                char[] cArr6 = this.f6369a;
                char c20 = cArr6[i11];
                if (c20 == '\b' || c20 == '\f' || c20 == '\n' || c20 == '\r' || c20 == c7) {
                    int i16 = i11 + 1;
                    System.arraycopy(cArr6, i16, cArr6, i11 + 2, (i9 - i11) - 1);
                    char[] cArr7 = this.f6369a;
                    cArr7[i11] = IOUtils.DIR_SEPARATOR_WINDOWS;
                    cArr7[i16] = e.f7903j[c20];
                } else {
                    if (c20 == '\"' || c20 == '/' || c20 == '\\') {
                        int i17 = i11 + 1;
                        System.arraycopy(cArr6, i17, cArr6, i11 + 2, (i9 - i11) - 1);
                        char[] cArr8 = this.f6369a;
                        cArr8[i11] = IOUtils.DIR_SEPARATOR_WINDOWS;
                        cArr8[i17] = c20;
                    } else {
                        if (c20 < c6) {
                            int i18 = i11 + 1;
                            System.arraycopy(cArr6, i18, cArr6, i11 + 6, (i9 - i11) - 1);
                            char[] cArr9 = this.f6369a;
                            cArr9[i11] = IOUtils.DIR_SEPARATOR_WINDOWS;
                            cArr9[i18] = 'u';
                            cArr9[i11 + 2] = c19;
                            cArr9[i11 + 3] = c19;
                            char[] cArr10 = e.f7904k;
                            int i19 = c20 * 2;
                            cArr9[i11 + 4] = cArr10[i19];
                            cArr9[i11 + 5] = cArr10[i19 + 1];
                        } else if (c20 >= 127) {
                            int i20 = i11 + 1;
                            System.arraycopy(cArr6, i20, cArr6, i11 + 6, (i9 - i11) - 1);
                            char[] cArr11 = this.f6369a;
                            cArr11[i11] = IOUtils.DIR_SEPARATOR_WINDOWS;
                            cArr11[i20] = 'u';
                            char[] cArr12 = e.c;
                            cArr11[i11 + 2] = cArr12[(c20 >>> '\f') & 15];
                            cArr11[i11 + 3] = cArr12[(c20 >>> '\b') & 15];
                            cArr11[i11 + 4] = cArr12[(c20 >>> 4) & 15];
                            cArr11[i11 + 5] = cArr12[c20 & 15];
                        }
                        i9 += 5;
                    }
                    i11--;
                    c6 = Chars.SPACE;
                    c7 = '\t';
                }
                i9++;
                i11--;
                c6 = Chars.SPACE;
                c7 = '\t';
            }
            if (c == 0) {
                this.f6369a[this.b - 1] = Chars.DQUOTE;
                return;
            }
            char[] cArr13 = this.f6369a;
            int i21 = this.b;
            cArr13[i21 - 2] = Chars.DQUOTE;
            cArr13[i21 - 1] = c;
            return;
        }
        char c21 = 0;
        int i22 = -1;
        int i23 = -1;
        for (int i24 = i8; i24 < i9; i24++) {
            char c22 = this.f6369a[i24];
            if (c22 == 8232 || c22 == 8233) {
                i10++;
                i6 += 4;
                if (i22 == -1) {
                    i22 = i24;
                    i23 = i22;
                } else {
                    i23 = i24;
                }
                c21 = c22;
            } else if (c22 >= ']') {
                if (c22 >= 127 && c22 < 160) {
                    if (i22 == -1) {
                        i22 = i24;
                    }
                    i10++;
                    i6 += 4;
                    i23 = i24;
                    c21 = c22;
                }
            } else if (e(c22, this.c)) {
                i10++;
                byte[] bArr = e.f7899f;
                if (c22 < bArr.length && bArr[c22] == 4) {
                    i6 += 4;
                }
                if (i22 == -1) {
                    i22 = i24;
                    i23 = i22;
                } else {
                    i23 = i24;
                }
                c21 = c22;
            }
        }
        if (i10 > 0) {
            int i25 = i6 + i10;
            if (i25 > this.f6369a.length) {
                c(i25);
            }
            this.b = i25;
            if (i10 == 1) {
                if (c21 == 8232) {
                    int i26 = i23 + 1;
                    char[] cArr14 = this.f6369a;
                    System.arraycopy(cArr14, i26, cArr14, i23 + 6, (i9 - i23) - 1);
                    char[] cArr15 = this.f6369a;
                    cArr15[i23] = IOUtils.DIR_SEPARATOR_WINDOWS;
                    cArr15[i26] = 'u';
                    cArr15[i23 + 2] = '2';
                    cArr15[i23 + 3] = '0';
                    cArr15[i23 + 4] = '2';
                    cArr15[i23 + 5] = '8';
                } else if (c21 == 8233) {
                    int i27 = i23 + 1;
                    char[] cArr16 = this.f6369a;
                    System.arraycopy(cArr16, i27, cArr16, i23 + 6, (i9 - i23) - 1);
                    char[] cArr17 = this.f6369a;
                    cArr17[i23] = IOUtils.DIR_SEPARATOR_WINDOWS;
                    cArr17[i27] = 'u';
                    cArr17[i23 + 2] = '2';
                    cArr17[i23 + 3] = '0';
                    cArr17[i23 + 4] = '2';
                    cArr17[i23 + 5] = '9';
                } else {
                    byte[] bArr2 = e.f7899f;
                    if (c21 >= bArr2.length || bArr2[c21] != 4) {
                        int i28 = i23 + 1;
                        char[] cArr18 = this.f6369a;
                        System.arraycopy(cArr18, i28, cArr18, i23 + 2, (i9 - i23) - 1);
                        char[] cArr19 = this.f6369a;
                        cArr19[i23] = IOUtils.DIR_SEPARATOR_WINDOWS;
                        cArr19[i28] = e.f7903j[c21];
                    } else {
                        int i29 = i23 + 1;
                        char[] cArr20 = this.f6369a;
                        System.arraycopy(cArr20, i29, cArr20, i23 + 6, (i9 - i23) - 1);
                        char[] cArr21 = this.f6369a;
                        cArr21[i23] = IOUtils.DIR_SEPARATOR_WINDOWS;
                        cArr21[i29] = 'u';
                        char[] cArr22 = e.c;
                        cArr21[i23 + 2] = cArr22[(c21 >>> '\f') & 15];
                        cArr21[i23 + 3] = cArr22[(c21 >>> '\b') & 15];
                        cArr21[i23 + 4] = cArr22[(c21 >>> 4) & 15];
                        cArr21[i23 + 5] = cArr22[c21 & 15];
                    }
                }
            } else if (i10 > 1) {
                for (int i30 = i22 - i8; i30 < str.length(); i30++) {
                    char cCharAt = str.charAt(i30);
                    byte[] bArr3 = e.f7899f;
                    if ((cCharAt >= bArr3.length || bArr3[cCharAt] == 0) && !(cCharAt == '/' && d(c0.WriteSlashAsSpecial))) {
                        if (cCharAt == 8232 || cCharAt == 8233) {
                            char[] cArr23 = this.f6369a;
                            cArr23[i22] = IOUtils.DIR_SEPARATOR_WINDOWS;
                            cArr23[i22 + 1] = 'u';
                            char[] cArr24 = e.c;
                            cArr23[i22 + 2] = cArr24[(cCharAt >>> '\f') & 15];
                            cArr23[i22 + 3] = cArr24[(cCharAt >>> '\b') & 15];
                            int i31 = i22 + 5;
                            cArr23[i22 + 4] = cArr24[(cCharAt >>> 4) & 15];
                            i22 += 6;
                            cArr23[i31] = cArr24[cCharAt & 15];
                        } else {
                            this.f6369a[i22] = cCharAt;
                            i22++;
                        }
                    } else {
                        char[] cArr25 = this.f6369a;
                        int i32 = i22 + 1;
                        cArr25[i22] = IOUtils.DIR_SEPARATOR_WINDOWS;
                        if (bArr3[cCharAt] == 4) {
                            cArr25[i32] = 'u';
                            char[] cArr26 = e.c;
                            cArr25[i22 + 2] = cArr26[(cCharAt >>> '\f') & 15];
                            cArr25[i22 + 3] = cArr26[(cCharAt >>> '\b') & 15];
                            int i33 = i22 + 5;
                            cArr25[i22 + 4] = cArr26[(cCharAt >>> 4) & 15];
                            i22 += 6;
                            cArr25[i33] = cArr26[cCharAt & 15];
                        } else {
                            i22 += 2;
                            cArr25[i32] = e.f7903j[cCharAt];
                        }
                    }
                }
            }
        }
        if (c == 0) {
            this.f6369a[this.b - 1] = Chars.DQUOTE;
            return;
        }
        char[] cArr27 = this.f6369a;
        int i34 = this.b;
        cArr27[i34 - 2] = Chars.DQUOTE;
        cArr27[i34 - 1] = c;
    }

    public final void s(String str) {
        int i5 = 0;
        if (str == null) {
            int i6 = this.b + 4;
            if (i6 > this.f6369a.length) {
                c(i6);
            }
            AbstractC1127c.NULL.getChars(0, 4, this.f6369a, this.b);
            this.b = i6;
            return;
        }
        int length = str.length();
        int i7 = this.b + length + 2;
        if (i7 > this.f6369a.length) {
            c(i7);
        }
        int i8 = this.b;
        int i9 = i8 + 1;
        int i10 = i9 + length;
        char[] cArr = this.f6369a;
        cArr[i8] = Chars.QUOTE;
        str.getChars(0, length, cArr, i9);
        this.b = i7;
        int i11 = -1;
        char c = 0;
        for (int i12 = i9; i12 < i10; i12++) {
            char c6 = this.f6369a[i12];
            if (c6 <= '\r' || c6 == '\\' || c6 == '\'' || (c6 == '/' && d(c0.WriteSlashAsSpecial))) {
                i5++;
                i11 = i12;
                c = c6;
            }
        }
        int i13 = i7 + i5;
        if (i13 > this.f6369a.length) {
            c(i13);
        }
        this.b = i13;
        if (i5 == 1) {
            char[] cArr2 = this.f6369a;
            int i14 = i11 + 1;
            System.arraycopy(cArr2, i14, cArr2, i11 + 2, (i10 - i11) - 1);
            char[] cArr3 = this.f6369a;
            cArr3[i11] = IOUtils.DIR_SEPARATOR_WINDOWS;
            cArr3[i14] = e.f7903j[c];
        } else if (i5 > 1) {
            char[] cArr4 = this.f6369a;
            int i15 = i11 + 1;
            System.arraycopy(cArr4, i15, cArr4, i11 + 2, (i10 - i11) - 1);
            char[] cArr5 = this.f6369a;
            cArr5[i11] = IOUtils.DIR_SEPARATOR_WINDOWS;
            cArr5[i15] = e.f7903j[c];
            int i16 = i10 + 1;
            for (int i17 = i11 - 1; i17 >= i9; i17--) {
                char c7 = this.f6369a[i17];
                if (c7 <= '\r' || c7 == '\\' || c7 == '\'' || (c7 == '/' && d(c0.WriteSlashAsSpecial))) {
                    char[] cArr6 = this.f6369a;
                    int i18 = i17 + 1;
                    System.arraycopy(cArr6, i18, cArr6, i17 + 2, (i16 - i17) - 1);
                    char[] cArr7 = this.f6369a;
                    cArr7[i17] = IOUtils.DIR_SEPARATOR_WINDOWS;
                    cArr7[i18] = e.f7903j[c7];
                    i16++;
                }
            }
        }
        this.f6369a[this.b - 1] = Chars.QUOTE;
    }

    public final String toString() {
        return new String(this.f6369a, 0, this.b);
    }

    @Override // java.io.Writer
    public final void write(int i5) {
        int i6 = this.b + 1;
        if (i6 > this.f6369a.length) {
            c(i6);
        }
        this.f6369a[this.b] = (char) i5;
        this.b = i6;
    }

    public void writeTo(Writer writer) throws IOException {
        writer.write(this.f6369a, 0, this.b);
    }

    public int writeToEx(OutputStream outputStream, Charset charset) throws IOException {
        if (charset == f6365o) {
            return encodeToUTF8(outputStream);
        }
        byte[] bytes = new String(this.f6369a, 0, this.b).getBytes(charset);
        outputStream.write(bytes);
        return bytes.length;
    }

    public b0(int i5, c0... c0VarArr) {
        this.f6378n = -1;
        ThreadLocal threadLocal = f6366p;
        char[] cArr = (char[]) threadLocal.get();
        this.f6369a = cArr;
        if (cArr != null) {
            threadLocal.set(null);
        } else {
            this.f6369a = new char[2048];
        }
        for (c0 c0Var : c0VarArr) {
            i5 |= c0Var.f6406a;
        }
        this.c = i5;
        b();
    }

    @Override // java.io.Writer, java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(CharSequence charSequence) {
        a(charSequence);
        return this;
    }

    public void writeTo(OutputStream outputStream, String str) throws IOException {
        writeTo(outputStream, Charset.forName(str));
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence, int i5, int i6) {
        if (charSequence == null) {
            charSequence = AbstractC1127c.NULL;
        }
        String string = charSequence.subSequence(i5, i6).toString();
        write(string, 0, string.length());
        return this;
    }

    public void writeTo(OutputStream outputStream, Charset charset) throws IOException {
        writeToEx(outputStream, charset);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Appendable append(CharSequence charSequence, int i5, int i6) {
        if (charSequence == null) {
            charSequence = AbstractC1127c.NULL;
        }
        String string = charSequence.subSequence(i5, i6).toString();
        write(string, 0, string.length());
        return this;
    }

    @Override // java.io.Writer
    public final void write(char[] cArr, int i5, int i6) {
        int i7;
        if (i5 < 0 || i5 > cArr.length || i6 < 0 || (i7 = i5 + i6) > cArr.length || i7 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i6 == 0) {
            return;
        }
        int i8 = this.b + i6;
        if (i8 > this.f6369a.length) {
            c(i8);
        }
        System.arraycopy(cArr, i5, this.f6369a, this.b, i6);
        this.b = i8;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char c) {
        write(c);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Appendable append(char c) {
        write(c);
        return this;
    }

    @Override // java.io.Writer
    public final void write(String str, int i5, int i6) {
        int i7 = this.b + i6;
        if (i7 > this.f6369a.length) {
            c(i7);
        }
        str.getChars(i5, i6 + i5, this.f6369a, this.b);
        this.b = i7;
    }

    @Override // java.io.Writer
    public final void write(String str) {
        if (str == null) {
            n();
        } else {
            write(str, 0, str.length());
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
    }
}
