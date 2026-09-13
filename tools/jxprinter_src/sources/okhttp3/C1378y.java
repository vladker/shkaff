package okhttp3;

import A4.C0169l;
import androidx.webkit.ProxyConfig;
import com.google.common.primitives.UnsignedBytes;
import java.io.EOFException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import org.apache.logging.log4j.util.Chars;

/* JADX INFO: renamed from: okhttp3.y, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class C1378y {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final char[] f6679h = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6680a;
    public final String b;
    public final String c;
    public final String d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List f6681f;
    private final String fragment;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f6682g;
    private final List<String> queryNamesAndValues;

    public C1378y(C1377x c1377x) {
        this.f6680a = c1377x.scheme;
        String str = c1377x.f6678a;
        this.b = f(str, 0, str.length(), false);
        String str2 = c1377x.b;
        this.c = f(str2, 0, str2.length(), false);
        this.d = c1377x.host;
        int i5 = c1377x.c;
        this.e = i5 == -1 ? a(c1377x.scheme) : i5;
        this.f6681f = g(c1377x.d, false);
        List<String> list = c1377x.encodedQueryNamesAndValues;
        this.queryNamesAndValues = list != null ? g(list, true) : null;
        String str3 = c1377x.encodedFragment;
        this.fragment = str3 != null ? f(str3, 0, str3.length(), false) : null;
        this.f6682g = c1377x.toString();
    }

    public static int a(String str) {
        if (str.equals(ProxyConfig.MATCH_HTTP)) {
            return 80;
        }
        return str.equals(ProxyConfig.MATCH_HTTPS) ? 443 : -1;
    }

    public static String canonicalize(String str, int i5, int i6, String str2, boolean z6, boolean z7, boolean z8, boolean z9, Charset charset) {
        int iCharCount = i5;
        while (iCharCount < i6) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && z9) || str2.indexOf(iCodePointAt) != -1 || ((iCodePointAt == 37 && (!z6 || (z7 && !h(iCharCount, i6, str)))) || (iCodePointAt == 43 && z8)))) {
                C0169l c0169l = new C0169l();
                c0169l.writeUtf8(str, i5, iCharCount);
                canonicalize(c0169l, str, iCharCount, i6, str2, z6, z7, z8, z9, charset);
                return c0169l.readUtf8();
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str.substring(i5, i6);
    }

    public static void e(List list, StringBuilder sb) {
        int size = list.size();
        for (int i5 = 0; i5 < size; i5 += 2) {
            String str = (String) list.get(i5);
            String str2 = (String) list.get(i5 + 1);
            if (i5 > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append(Chars.EQ);
                sb.append(str2);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0052  */
    public static String f(String str, int i5, int i6, boolean z6) {
        int i7;
        int iCharCount = i5;
        while (iCharCount < i6) {
            char cCharAt = str.charAt(iCharCount);
            if (cCharAt == '%' || (cCharAt == '+' && z6)) {
                C0169l c0169l = new C0169l();
                c0169l.writeUtf8(str, i5, iCharCount);
                while (iCharCount < i6) {
                    int iCodePointAt = str.codePointAt(iCharCount);
                    if (iCodePointAt == 37 && (i7 = iCharCount + 2) < i6) {
                        int iE = p107s4.d.e(str.charAt(iCharCount + 1));
                        int iE2 = p107s4.d.e(str.charAt(i7));
                        if (iE == -1 || iE2 == -1) {
                            c0169l.writeUtf8CodePoint(iCodePointAt);
                        } else {
                            c0169l.writeByte((iE << 4) + iE2);
                            iCharCount = i7;
                        }
                    } else if (iCodePointAt == 43 && z6) {
                        c0169l.writeByte(32);
                    } else {
                        c0169l.writeUtf8CodePoint(iCodePointAt);
                    }
                    iCharCount += Character.charCount(iCodePointAt);
                }
                return c0169l.readUtf8();
            }
            iCharCount++;
        }
        return str.substring(i5, i6);
    }

    public static List g(List list, boolean z6) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i5 = 0; i5 < size; i5++) {
            String str = (String) list.get(i5);
            arrayList.add(str != null ? f(str, 0, str.length(), z6) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static C1378y get(URL url) {
        return parse(url.toString());
    }

    public static boolean h(int i5, int i6, String str) {
        int i7 = i5 + 2;
        return i7 < i6 && str.charAt(i5) == '%' && p107s4.d.e(str.charAt(i5 + 1)) != -1 && p107s4.d.e(str.charAt(i7)) != -1;
    }

    public static ArrayList i(String str) {
        ArrayList arrayList = new ArrayList();
        int i5 = 0;
        while (i5 <= str.length()) {
            int iIndexOf = str.indexOf(38, i5);
            if (iIndexOf == -1) {
                iIndexOf = str.length();
            }
            int iIndexOf2 = str.indexOf(61, i5);
            if (iIndexOf2 == -1 || iIndexOf2 > iIndexOf) {
                arrayList.add(str.substring(i5, iIndexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i5, iIndexOf2));
                arrayList.add(str.substring(iIndexOf2 + 1, iIndexOf));
            }
            i5 = iIndexOf + 1;
        }
        return arrayList;
    }

    public static C1378y parse(String str) {
        try {
            return new C1377x().parse(null, str).a();
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public final String b() {
        if (this.c.isEmpty()) {
            return "";
        }
        int length = this.f6680a.length() + 3;
        String str = this.f6682g;
        return str.substring(str.indexOf(58, length) + 1, str.indexOf(64));
    }

    public final ArrayList c() {
        int length = this.f6680a.length() + 3;
        String str = this.f6682g;
        int iIndexOf = str.indexOf(47, length);
        int iF = p107s4.d.f(iIndexOf, str.length(), str, "?#");
        ArrayList arrayList = new ArrayList();
        while (iIndexOf < iF) {
            int i5 = iIndexOf + 1;
            int iG = p107s4.d.g(str, i5, iF, '/');
            arrayList.add(str.substring(i5, iG));
            iIndexOf = iG;
        }
        return arrayList;
    }

    public final String d() {
        if (this.b.isEmpty()) {
            return "";
        }
        int length = this.f6680a.length() + 3;
        String str = this.f6682g;
        return str.substring(length, p107s4.d.f(length, str.length(), str, ":@"));
    }

    public String encodedFragment() {
        if (this.fragment == null) {
            return null;
        }
        String str = this.f6682g;
        return str.substring(str.indexOf(35) + 1);
    }

    public String encodedQuery() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        String str = this.f6682g;
        int iIndexOf = str.indexOf(63) + 1;
        return str.substring(iIndexOf, p107s4.d.g(str, iIndexOf, str.length(), '#'));
    }

    public boolean equals(Object obj) {
        return (obj instanceof C1378y) && ((C1378y) obj).f6682g.equals(this.f6682g);
    }

    public String fragment() {
        return this.fragment;
    }

    public final int hashCode() {
        return this.f6682g.hashCode();
    }

    public final String j() {
        C1377x c1377xNewBuilder = newBuilder("/...");
        c1377xNewBuilder.getClass();
        c1377xNewBuilder.f6678a = canonicalize("", 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true, null);
        c1377xNewBuilder.b = canonicalize("", 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true, null);
        return c1377xNewBuilder.a().f6682g;
    }

    public final URI k() {
        C1377x c1377x = new C1377x();
        String str = this.f6680a;
        c1377x.scheme = str;
        c1377x.f6678a = d();
        c1377x.b = b();
        c1377x.host = this.d;
        int iA = a(str);
        int i5 = this.e;
        if (i5 == iA) {
            i5 = -1;
        }
        c1377x.c = i5;
        ArrayList arrayList = c1377x.d;
        arrayList.clear();
        arrayList.addAll(c());
        c1377x.encodedQuery(encodedQuery());
        c1377x.encodedFragment = encodedFragment();
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            String str2 = (String) arrayList.get(i6);
            arrayList.set(i6, canonicalize(str2, 0, str2.length(), "[]", true, true, false, true, null));
        }
        List<String> list = c1377x.encodedQueryNamesAndValues;
        if (list != null) {
            int size2 = list.size();
            for (int i7 = 0; i7 < size2; i7++) {
                String str3 = c1377x.encodedQueryNamesAndValues.get(i7);
                if (str3 != null) {
                    c1377x.encodedQueryNamesAndValues.set(i7, canonicalize(str3, 0, str3.length(), "\\^`{|}", true, true, true, true, null));
                }
            }
        }
        String str4 = c1377x.encodedFragment;
        if (str4 != null) {
            c1377x.encodedFragment = canonicalize(str4, 0, str4.length(), " \"#<>\\^`{|}", true, true, false, false, null);
        }
        String string = c1377x.toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e) {
            try {
                return URI.create(string.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }

    public C1377x newBuilder(String str) {
        try {
            return new C1377x().parse(this, str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public String query() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        e(this.queryNamesAndValues, sb);
        return sb.toString();
    }

    public String queryParameter(String str) {
        List<String> list = this.queryNamesAndValues;
        if (list == null) {
            return null;
        }
        int size = list.size();
        for (int i5 = 0; i5 < size; i5 += 2) {
            if (str.equals(this.queryNamesAndValues.get(i5))) {
                return this.queryNamesAndValues.get(i5 + 1);
            }
        }
        return null;
    }

    public C1378y resolve(String str) {
        C1377x c1377xNewBuilder = newBuilder(str);
        if (c1377xNewBuilder != null) {
            return c1377xNewBuilder.a();
        }
        return null;
    }

    public final String toString() {
        return this.f6682g;
    }

    public String topPrivateDomain() {
        Pattern pattern = p107s4.d.f8241k;
        String str = this.d;
        if (pattern.matcher(str).matches()) {
            return null;
        }
        return PublicSuffixDatabase.f6656h.b(str);
    }

    public static C1378y get(URI uri) {
        return parse(uri.toString());
    }

    public static void canonicalize(C0169l c0169l, String str, int i5, int i6, String str2, boolean z6, boolean z7, boolean z8, boolean z9, Charset charset) throws EOFException {
        C0169l c0169l2 = null;
        while (i5 < i6) {
            int iCodePointAt = str.codePointAt(i5);
            if (!z6 || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt == 43 && z8) {
                    c0169l.writeUtf8(z6 ? "+" : "%2B");
                } else if (iCodePointAt >= 32 && iCodePointAt != 127 && ((iCodePointAt < 128 || !z9) && str2.indexOf(iCodePointAt) == -1 && (iCodePointAt != 37 || (z6 && (!z7 || h(i5, i6, str)))))) {
                    c0169l.writeUtf8CodePoint(iCodePointAt);
                } else {
                    if (c0169l2 == null) {
                        c0169l2 = new C0169l();
                    }
                    if (charset != null && !charset.equals(StandardCharsets.UTF_8)) {
                        c0169l2.writeString(str, i5, Character.charCount(iCodePointAt) + i5, charset);
                    } else {
                        c0169l2.writeUtf8CodePoint(iCodePointAt);
                    }
                    while (!c0169l2.exhausted()) {
                        byte b = c0169l2.readByte();
                        int i7 = b & UnsignedBytes.MAX_VALUE;
                        c0169l.writeByte(37);
                        char[] cArr = f6679h;
                        c0169l.writeByte((int) cArr[(i7 >> 4) & 15]);
                        c0169l.writeByte((int) cArr[b & 15]);
                    }
                }
            }
            i5 += Character.charCount(iCodePointAt);
        }
    }

    public static String canonicalize(String str, String str2, boolean z6, boolean z7, boolean z8, boolean z9, Charset charset) {
        return canonicalize(str, 0, str.length(), str2, z6, z7, z8, z9, charset);
    }
}
