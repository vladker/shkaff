package retrofit2;

import A3.AbstractC0157z;
import A4.C0169l;
import com.google.common.net.HttpHeaders;
import com.google.common.primitives.UnsignedBytes;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;
import okhttp3.C1372s;
import okhttp3.C1373t;
import okhttp3.C1375v;
import okhttp3.C1376w;
import okhttp3.C1377x;
import okhttp3.C1378y;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class o0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final char[] f8133f = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Pattern f8134g = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8135a;
    public final C1378y b;
    private okhttp3.Q body;
    public final okhttp3.L c = new okhttp3.L();
    private okhttp3.B contentType;
    public final C1375v d;
    public final boolean e;
    private C1372s formBuilder;
    private okhttp3.C multipartBuilder;
    private String relativeUrl;
    private C1377x urlBuilder;

    public o0(String str, C1378y c1378y, String str2, C1376w c1376w, okhttp3.B b, boolean z6, boolean z7, boolean z8) {
        this.f8135a = str;
        this.b = c1378y;
        this.relativeUrl = str2;
        this.contentType = b;
        this.e = z6;
        if (c1376w != null) {
            this.d = c1376w.d();
        } else {
            this.d = new C1375v();
        }
        if (z7) {
            this.formBuilder = new C1372s(null);
            return;
        }
        if (z8) {
            okhttp3.C c = new okhttp3.C();
            this.multipartBuilder = c;
            okhttp3.B b6 = okhttp3.E.f6486f;
            if (b6 == null) {
                throw new NullPointerException("type == null");
            }
            if (b6.b.equals("multipart")) {
                c.b = b6;
            } else {
                throw new IllegalArgumentException("multipart != " + b6);
            }
        }
    }

    public final void a(String str, String str2, boolean z6) {
        if (z6) {
            this.formBuilder.b(str, str2);
        } else {
            this.formBuilder.a(str, str2);
        }
    }

    public void addQueryParam(String str, String str2, boolean z6) {
        String str3 = this.relativeUrl;
        if (str3 != null) {
            C1378y c1378y = this.b;
            C1377x c1377xNewBuilder = c1378y.newBuilder(str3);
            this.urlBuilder = c1377xNewBuilder;
            if (c1377xNewBuilder == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + c1378y + ", Relative: " + this.relativeUrl);
            }
            this.relativeUrl = null;
        }
        if (z6) {
            this.urlBuilder.addEncodedQueryParameter(str, str2);
        } else {
            this.urlBuilder.addQueryParameter(str, str2);
        }
    }

    public <T> void addTag(Class<T> cls, T t6) {
        this.c.tag(cls, t6);
    }

    public final void b(String str, String str2, boolean z6) {
        if (HttpHeaders.CONTENT_TYPE.equalsIgnoreCase(str)) {
            try {
                this.contentType = okhttp3.B.a(str2);
                return;
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(AbstractC0157z.n("Malformed content type: ", str2), e);
            }
        }
        C1375v c1375v = this.d;
        if (!z6) {
            c1375v.a(str, str2);
            return;
        }
        c1375v.getClass();
        C1376w.a(str);
        c1375v.b(str, str2);
    }

    public final void c(C1376w c1376w, okhttp3.Q q6) {
        this.multipartBuilder.addPart(c1376w, q6);
    }

    public final void d(okhttp3.D d) {
        this.multipartBuilder.a(d);
    }

    public final void e(String str, String str2, boolean z6) throws EOFException {
        String utf8;
        if (this.relativeUrl == null) {
            throw new AssertionError();
        }
        int length = str2.length();
        int iCharCount = 0;
        while (true) {
            if (iCharCount >= length) {
                utf8 = str2;
                break;
            }
            int iCodePointAt = str2.codePointAt(iCharCount);
            if (iCodePointAt < 32 || iCodePointAt >= 127 || " \"<>^`{}|\\?#".indexOf(iCodePointAt) != -1 || (!z6 && (iCodePointAt == 47 || iCodePointAt == 37))) {
                C0169l c0169l = new C0169l();
                c0169l.writeUtf8(str2, 0, iCharCount);
                C0169l c0169l2 = null;
                while (iCharCount < length) {
                    int iCodePointAt2 = str2.codePointAt(iCharCount);
                    if (!z6 || (iCodePointAt2 != 9 && iCodePointAt2 != 10 && iCodePointAt2 != 12 && iCodePointAt2 != 13)) {
                        if (iCodePointAt2 < 32 || iCodePointAt2 >= 127 || " \"<>^`{}|\\?#".indexOf(iCodePointAt2) != -1 || (!z6 && (iCodePointAt2 == 47 || iCodePointAt2 == 37))) {
                            if (c0169l2 == null) {
                                c0169l2 = new C0169l();
                            }
                            c0169l2.writeUtf8CodePoint(iCodePointAt2);
                            while (!c0169l2.exhausted()) {
                                byte b = c0169l2.readByte();
                                int i5 = b & UnsignedBytes.MAX_VALUE;
                                c0169l.writeByte(37);
                                char[] cArr = f8133f;
                                c0169l.writeByte((int) cArr[(i5 >> 4) & 15]);
                                c0169l.writeByte((int) cArr[b & 15]);
                            }
                        } else {
                            c0169l.writeUtf8CodePoint(iCodePointAt2);
                        }
                    }
                    iCharCount += Character.charCount(iCodePointAt2);
                }
                utf8 = c0169l.readUtf8();
                break;
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        String strReplace = this.relativeUrl.replace(VectorFormat.DEFAULT_PREFIX + str + VectorFormat.DEFAULT_SUFFIX, utf8);
        if (f8134g.matcher(strReplace).matches()) {
            throw new IllegalArgumentException("@Path parameters shouldn't perform path traversal ('.' or '..'): ".concat(str2));
        }
        this.relativeUrl = strReplace;
    }

    public final okhttp3.L f() {
        C1378y c1378yResolve;
        C1377x c1377x = this.urlBuilder;
        if (c1377x != null) {
            c1378yResolve = c1377x.a();
        } else {
            String str = this.relativeUrl;
            C1378y c1378y = this.b;
            c1378yResolve = c1378y.resolve(str);
            if (c1378yResolve == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + c1378y + ", Relative: " + this.relativeUrl);
            }
        }
        okhttp3.Q n0Var = this.body;
        if (n0Var == null) {
            C1372s c1372s = this.formBuilder;
            if (c1372s != null) {
                n0Var = new C1373t(c1372s.f6673a, c1372s.b);
            } else {
                okhttp3.C c = this.multipartBuilder;
                if (c != null) {
                    ArrayList arrayList = c.c;
                    if (arrayList.isEmpty()) {
                        throw new IllegalStateException("Multipart body must have at least one part.");
                    }
                    n0Var = new okhttp3.E(c.f6484a, c.b, arrayList);
                } else if (this.e) {
                    n0Var = okhttp3.Q.create((okhttp3.B) null, new byte[0]);
                }
            }
        }
        okhttp3.B b = this.contentType;
        C1375v c1375v = this.d;
        if (b != null) {
            if (n0Var != null) {
                n0Var = new n0(n0Var, b);
            } else {
                c1375v.a(HttpHeaders.CONTENT_TYPE, b.f6483a);
            }
        }
        okhttp3.L l6 = this.c;
        l6.d(c1378yResolve);
        c1375v.getClass();
        ArrayList arrayList2 = c1375v.f6676a;
        String[] strArr = (String[]) arrayList2.toArray(new String[arrayList2.size()]);
        C1375v c1375v2 = new C1375v();
        Collections.addAll(c1375v2.f6676a, strArr);
        l6.b = c1375v2;
        return l6.method(this.f8135a, n0Var);
    }

    public final void g(okhttp3.Q q6) {
        this.body = q6;
    }

    public final void h(Object obj) {
        this.relativeUrl = obj.toString();
    }
}
