package p050j;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.poi.ss.util.IEEEDouble;
import p067m.b;
import p067m.c;
import p067m.j;
import p079o.G;
import p079o.Y;
import p079o.Z;
import p079o.b0;
import p079o.c0;
import p096r.e;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements u, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TimeZone f5372a = TimeZone.getDefault();
    public static final Locale b = Locale.getDefault();
    public static final String c = "@type";
    public static final Z[] d = new Z[0];
    public static final String e = "yyyy-MM-dd HH:mm:ss";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f5373f = ((((((c.AutoCloseSource.f6089a | c.InternFieldNames.f6089a) | c.UseBigDecimal.f6089a) | c.AllowUnQuotedFieldNames.f6089a) | c.AllowSingleQuotes.f6089a) | c.AllowArbitraryCommas.f6089a) | c.SortFeidFastMatch.f6089a) | c.IgnoreNotMatch.f6089a;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f5374g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ThreadLocal f5375h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ThreadLocal f5376i;

    static {
        int i5 = c0.QuoteFieldNames.f6406a | c0.SkipTransientField.f6406a | c0.WriteEnumUsingName.f6406a | c0.SortField.f6406a;
        String strC = e.c("fastjson.serializerFeatures.MapSortField");
        int i6 = c0.MapSortField.f6406a;
        if ("true".equals(strC)) {
            i5 |= i6;
        } else if ("false".equals(strC)) {
            i5 &= ~i6;
        }
        f5374g = i5;
        f5375h = new ThreadLocal();
        f5376i = new ThreadLocal();
    }

    public static Object f(String str) {
        if (str == null) {
            return null;
        }
        b bVar = new b(str, j.f6108l, f5373f);
        Object objH = bVar.h(null);
        bVar.g();
        bVar.close();
        return objH;
    }

    public static String g(Object obj) {
        Y y6 = Y.e;
        b0 b0Var = new b0(f5374g, new c0[0]);
        try {
            G g6 = new G(b0Var, y6);
            Z[] zArr = d;
            if (zArr != null) {
                for (Z z6 : zArr) {
                }
            }
            g6.h(obj);
            return b0Var.toString();
        } finally {
            b0Var.close();
        }
    }

    public static <T> T parseObject(InputStream inputStream, Type type, c... cVarArr) {
        return (T) parseObject(inputStream, e.b, type, cVarArr);
    }

    public static final int writeJSONString(OutputStream outputStream, Object obj, c0... c0VarArr) {
        return writeJSONString(outputStream, obj, f5374g, c0VarArr);
    }

    @Override // p050j.c
    public final String e() {
        b0 b0Var = new b0();
        try {
            new G(b0Var).h(this);
            return b0Var.toString();
        } finally {
            b0Var.close();
        }
    }

    public final String toString() {
        return e();
    }

    public static <T> T parseObject(InputStream inputStream, Charset charset, Type type, c... cVarArr) throws IOException {
        int i5;
        String str;
        int i6;
        if (charset == null) {
            charset = e.b;
        }
        ThreadLocal threadLocal = f5375h;
        byte[] bArr = (byte[]) threadLocal.get();
        if (bArr == null) {
            bArr = new byte[65536];
            threadLocal.set(bArr);
        } else if (bArr.length < 65536) {
            bArr = new byte[65536];
        }
        int i7 = 0;
        while (true) {
            int i8 = inputStream.read(bArr, i7, bArr.length - i7);
            i5 = -1;
            if (i8 == -1) {
                break;
            }
            i7 += i8;
            if (i7 == bArr.length) {
                byte[] bArr2 = new byte[(bArr.length * 3) / 2];
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                bArr = bArr2;
            }
        }
        if (charset == null) {
            charset = e.b;
        }
        if (charset == e.b) {
            int length = bArr.length;
            ThreadLocal threadLocal2 = f5376i;
            char[] cArr = (char[]) threadLocal2.get();
            if (cArr == null) {
                if (length <= 65536) {
                    cArr = new char[65536];
                    threadLocal2.set(cArr);
                } else {
                    cArr = new char[length];
                }
            } else if (cArr.length < length) {
                cArr = new char[length];
            }
            int iMin = Math.min(i7, cArr.length);
            int i9 = 0;
            int i10 = 0;
            while (i9 < iMin) {
                byte b6 = bArr[i10];
                if (b6 < 0) {
                    break;
                }
                i10++;
                cArr[i9] = (char) b6;
                i9++;
            }
            while (true) {
                if (i10 >= i7) {
                    i5 = i9;
                    break;
                }
                int i11 = i10 + 1;
                byte b7 = bArr[i10];
                if (b7 >= 0) {
                    cArr[i9] = (char) b7;
                    i9++;
                    i10 = i11;
                } else if ((b7 >> 5) == -2 && (b7 & 30) != 0) {
                    if (i11 >= i7) {
                        break;
                    }
                    i10 += 2;
                    byte b8 = bArr[i11];
                    if ((b8 & 192) != 128) {
                        break;
                    }
                    cArr[i9] = (char) ((b8 ^ (b7 << 6)) ^ 3968);
                    i9++;
                } else if ((b7 >> 4) == -2) {
                    int i12 = i10 + 2;
                    if (i12 >= i7) {
                        break;
                    }
                    byte b9 = bArr[i11];
                    i10 += 3;
                    byte b10 = bArr[i12];
                    if ((b7 == -32 && (b9 & 224) == 128) || (b9 & 192) != 128 || (b10 & 192) != 128) {
                        break;
                    }
                    char c6 = (char) (((b9 << 6) ^ (b7 << 12)) ^ ((-123008) ^ b10));
                    if (c6 >= 55296 && c6 < 57344) {
                        break;
                    }
                    cArr[i9] = c6;
                    i9++;
                } else {
                    if ((b7 >> 3) != -2 || (i6 = i10 + 3) >= i7) {
                        break;
                    }
                    byte b11 = bArr[i11];
                    byte b12 = bArr[i10 + 2];
                    i10 += 4;
                    byte b13 = bArr[i6];
                    int i13 = (((b7 << 18) ^ (b11 << 12)) ^ (b12 << 6)) ^ (3678080 ^ b13);
                    if ((b11 & 192) != 128 || (b12 & 192) != 128 || (b13 & 192) != 128 || !Character.isSupplementaryCodePoint(i13)) {
                        break;
                    }
                    int i14 = i9 + 1;
                    cArr[i9] = (char) ((i13 >>> 10) + 55232);
                    i9 += 2;
                    cArr[i14] = (char) ((i13 & IEEEDouble.EXPONENT_BIAS) + 56320);
                }
            }
            str = new String(cArr, 0, i5);
        } else {
            str = new String(bArr, 0, i7, charset);
        }
        j jVar = j.f6108l;
        int i15 = f5373f;
        if (cVarArr != null) {
            for (c cVar : cVarArr) {
                i15 |= cVar.f6089a;
            }
        }
        b bVar = new b(str, jVar, i15);
        T t6 = (T) bVar.l(null, type);
        bVar.g();
        bVar.close();
        return t6;
    }

    public static final int writeJSONString(OutputStream outputStream, Object obj, int i5, c0... c0VarArr) {
        return writeJSONString(outputStream, e.b, obj, Y.e, null, null, i5, c0VarArr);
    }

    public static final int writeJSONString(OutputStream outputStream, Charset charset, Object obj, c0... c0VarArr) {
        return writeJSONString(outputStream, charset, obj, Y.e, null, null, f5374g, c0VarArr);
    }

    public static final int writeJSONString(OutputStream outputStream, Charset charset, Object obj, Y y6, Z[] zArr, String str, int i5, c0... c0VarArr) {
        b0 b0Var = new b0(i5, c0VarArr);
        try {
            G g6 = new G(b0Var, y6);
            if (str != null && str.length() != 0) {
                g6.f6328m = str;
                if (g6.f6329n != null) {
                    g6.f6329n = null;
                }
                c0 c0Var = c0.WriteDateUseDateFormat;
                b0 b0Var2 = g6.f6325j;
                int i6 = b0Var2.c | c0Var.f6406a;
                b0Var2.c = i6;
                c0 c0Var2 = c0.WriteEnumUsingToString;
                if (c0Var == c0Var2) {
                    b0Var2.c = (~c0.WriteEnumUsingName.f6406a) & i6;
                } else if (c0Var == c0.WriteEnumUsingName) {
                    b0Var2.c = (~c0Var2.f6406a) & i6;
                }
                b0Var2.b();
            }
            if (zArr != null) {
                for (Z z6 : zArr) {
                }
            }
            g6.h(obj);
            return b0Var.writeToEx(outputStream, charset);
        } finally {
            b0Var.close();
        }
    }

    @Override // p050j.u
    public final void writeJSONString(Appendable appendable) {
        b0 b0Var = new b0();
        try {
            try {
                new G(b0Var).h(this);
                appendable.append(b0Var.toString());
                b0Var.close();
            } catch (IOException e6) {
                throw new d(e6.getMessage(), e6);
            }
        } catch (Throwable th) {
            b0Var.close();
            throw th;
        }
    }
}
