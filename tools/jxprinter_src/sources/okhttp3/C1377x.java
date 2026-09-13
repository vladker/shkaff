package okhttp3;

import androidx.webkit.ProxyConfig;
import com.alibaba.android.arouter.utils.Consts;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.util.Chars;
import org.apache.xmlbeans.impl.common.NameUtil;

/* JADX INFO: renamed from: okhttp3.x, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class C1377x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f6678a = "";
    public String b = "";
    public int c = -1;
    public final ArrayList d;
    String encodedFragment;
    List<String> encodedQueryNamesAndValues;
    String host;
    String scheme;

    public C1377x() {
        ArrayList arrayList = new ArrayList();
        this.d = arrayList;
        arrayList.add("");
    }

    private static String canonicalizeHost(String str, int i5, int i6) {
        return p107s4.d.a(C1378y.f(str, i5, i6, false));
    }

    public final C1378y a() {
        if (this.scheme == null) {
            throw new IllegalStateException("scheme == null");
        }
        if (this.host != null) {
            return new C1378y(this);
        }
        throw new IllegalStateException("host == null");
    }

    public C1377x addEncodedQueryParameter(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("encodedName == null");
        }
        if (this.encodedQueryNamesAndValues == null) {
            this.encodedQueryNamesAndValues = new ArrayList();
        }
        this.encodedQueryNamesAndValues.add(C1378y.canonicalize(str, 0, str.length(), " \"'<>#&=", true, false, true, true, null));
        this.encodedQueryNamesAndValues.add(str2 != null ? C1378y.canonicalize(str2, 0, str2.length(), " \"'<>#&=", true, false, true, true, null) : null);
        return this;
    }

    public C1377x addQueryParameter(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.encodedQueryNamesAndValues == null) {
            this.encodedQueryNamesAndValues = new ArrayList();
        }
        this.encodedQueryNamesAndValues.add(C1378y.canonicalize(str, 0, str.length(), " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true, null));
        this.encodedQueryNamesAndValues.add(str2 != null ? C1378y.canonicalize(str2, 0, str2.length(), " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true, null) : null);
        return this;
    }

    public final void b(String str) {
        if (str == null) {
            throw new NullPointerException("host == null");
        }
        String strCanonicalizeHost = canonicalizeHost(str, 0, str.length());
        if (strCanonicalizeHost == null) {
            throw new IllegalArgumentException("unexpected host: ".concat(str));
        }
        this.host = strCanonicalizeHost;
    }

    public final void c(String str) {
        for (int size = this.encodedQueryNamesAndValues.size() - 2; size >= 0; size -= 2) {
            if (str.equals(this.encodedQueryNamesAndValues.get(size))) {
                this.encodedQueryNamesAndValues.remove(size + 1);
                this.encodedQueryNamesAndValues.remove(size);
                if (this.encodedQueryNamesAndValues.isEmpty()) {
                    this.encodedQueryNamesAndValues = null;
                    return;
                }
            }
        }
    }

    public C1377x encodedFragment(String str) {
        this.encodedFragment = str != null ? C1378y.canonicalize(str, 0, str.length(), "", true, false, false, false, null) : null;
        return this;
    }

    public C1377x encodedQuery(String str) {
        this.encodedQueryNamesAndValues = str != null ? C1378y.i(C1378y.canonicalize(str, 0, str.length(), " \"'<>#", true, false, true, true, null)) : null;
        return this;
    }

    public C1377x fragment(String str) {
        this.encodedFragment = str != null ? C1378y.canonicalize(str, 0, str.length(), "", false, false, false, false, null) : null;
        return this;
    }

    public C1377x parse(C1378y c1378y, String str) {
        char cCharAt;
        int i5;
        char c;
        int iF;
        String str2;
        ArrayList arrayList;
        int i6;
        int i7;
        int i8;
        int i9;
        String str3;
        boolean z6;
        boolean z7;
        char c6;
        ArrayList arrayList2;
        char cCharAt2;
        String str4 = str;
        int iN = p107s4.d.n(0, str4.length(), str4);
        int iO = p107s4.d.o(iN, str4.length(), str4);
        if (iO - iN < 2 || (((cCharAt = str4.charAt(iN)) < 'a' || cCharAt > 'z') && (cCharAt < 'A' || cCharAt > 'Z'))) {
            i5 = -1;
            break;
        }
        int i10 = iN + 1;
        while (true) {
            if (i10 < iO) {
                char cCharAt3 = str4.charAt(i10);
                if ((cCharAt3 >= 'a' && cCharAt3 <= 'z') || ((cCharAt3 >= 'A' && cCharAt3 <= 'Z') || ((cCharAt3 >= '0' && cCharAt3 <= '9') || cCharAt3 == '+' || cCharAt3 == '-' || cCharAt3 == '.'))) {
                    i10++;
                } else if (cCharAt3 == ':') {
                    i5 = i10;
                    break;
                }
            }
            i5 = -1;
            break;
        }
        if (i5 != -1) {
            if (str4.regionMatches(true, iN, "https:", 0, 6)) {
                this.scheme = ProxyConfig.MATCH_HTTPS;
                iN += 6;
                str4 = str;
            } else {
                str4 = str;
                if (!str4.regionMatches(true, iN, "http:", 0, 5)) {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str4.substring(0, i5) + "'");
                }
                this.scheme = ProxyConfig.MATCH_HTTP;
                iN += 5;
            }
        } else {
            if (c1378y == null) {
                throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
            }
            this.scheme = c1378y.f6680a;
        }
        int i11 = iN;
        int i12 = 0;
        while (true) {
            c = IOUtils.DIR_SEPARATOR_WINDOWS;
            if (i11 >= iO || !((cCharAt2 = str4.charAt(i11)) == '\\' || cCharAt2 == '/')) {
                break;
            }
            i12++;
            i11++;
        }
        char c7 = '?';
        ArrayList arrayList3 = this.d;
        char c8 = '#';
        if (i12 >= 2 || c1378y == null || !c1378y.f6680a.equals(this.scheme)) {
            int i13 = iN + i12;
            boolean z8 = false;
            boolean z9 = false;
            while (true) {
                iF = p107s4.d.f(i13, iO, str4, "@/\\?#");
                byte bCharAt = iF != iO ? str4.charAt(iF) : (byte) -1;
                if (bCharAt == -1 || bCharAt == c8 || bCharAt == 47 || bCharAt == c || bCharAt == c7) {
                    break;
                }
                if (bCharAt != 64) {
                    str3 = str4;
                    arrayList3 = arrayList3;
                } else {
                    if (z8) {
                        i9 = iF;
                        StringBuilder sb = new StringBuilder();
                        sb.append(this.b);
                        sb.append("%40");
                        str3 = str;
                        sb.append(C1378y.canonicalize(str3, i13, i9, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null));
                        this.b = sb.toString();
                        z6 = z9;
                    } else {
                        int iG = p107s4.d.g(str4, i13, iF, NameUtil.COLON);
                        String strCanonicalize = C1378y.canonicalize(str, i13, iG, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                        if (z9) {
                            strCanonicalize = androidx.exifinterface.media.a.r(new StringBuilder(), this.f6678a, "%40", strCanonicalize);
                        }
                        this.f6678a = strCanonicalize;
                        if (iG != iF) {
                            int i14 = iG + 1;
                            i9 = iF;
                            this.b = C1378y.canonicalize(str, i14, i9, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            z7 = true;
                        } else {
                            i9 = iF;
                            z7 = z8;
                        }
                        str3 = str;
                        z8 = z7;
                        z6 = true;
                    }
                    i13 = i9 + 1;
                    z9 = z6;
                }
                str4 = str3;
                arrayList3 = arrayList3;
                c7 = '?';
                c8 = '#';
                c = IOUtils.DIR_SEPARATOR_WINDOWS;
            }
            str2 = str4;
            int i15 = i13;
            arrayList = arrayList3;
            i6 = 1;
            int i16 = i15;
            while (true) {
                if (i16 < iF) {
                    char cCharAt4 = str2.charAt(i16);
                    if (cCharAt4 == ':') {
                        i7 = i16;
                        break;
                    }
                    if (cCharAt4 == '[') {
                        do {
                            i16++;
                            if (i16 >= iF) {
                                break;
                            }
                        } while (str2.charAt(i16) != ']');
                    }
                    i16++;
                } else {
                    i7 = iF;
                    break;
                }
            }
            int i17 = i7 + 1;
            if (i17 < iF) {
                this.host = canonicalizeHost(str2, i15, i7);
                try {
                    i8 = Integer.parseInt(C1378y.canonicalize(str2, i17, iF, "", false, false, false, true, null));
                    if (i8 <= 0 || i8 > 65535) {
                        i8 = -1;
                    }
                } catch (NumberFormatException unused) {
                }
                this.c = i8;
                if (i8 == -1) {
                    throw new IllegalArgumentException("Invalid URL port: \"" + str2.substring(i17, iF) + Chars.DQUOTE);
                }
            } else {
                this.host = canonicalizeHost(str2, i15, i7);
                this.c = C1378y.a(this.scheme);
            }
            if (this.host == null) {
                throw new IllegalArgumentException("Invalid URL host: \"" + str2.substring(i15, i7) + Chars.DQUOTE);
            }
            iN = iF;
        } else {
            this.f6678a = c1378y.d();
            this.b = c1378y.b();
            this.host = c1378y.d;
            this.c = c1378y.e;
            arrayList3.clear();
            arrayList3.addAll(c1378y.c());
            if (iN == iO || str4.charAt(iN) == '#') {
                encodedQuery(c1378y.encodedQuery());
            }
            str2 = str4;
            arrayList = arrayList3;
            i6 = 1;
        }
        int iF2 = p107s4.d.f(iN, iO, str2, "?#");
        if (iN != iF2) {
            char cCharAt5 = str2.charAt(iN);
            if (cCharAt5 == '/' || cCharAt5 == '\\') {
                arrayList2 = arrayList;
                arrayList2.clear();
                arrayList2.add("");
                iN++;
            } else {
                arrayList2 = arrayList;
                arrayList2.set(arrayList.size() - 1, "");
            }
            int i18 = iN;
            while (i18 < iF2) {
                int iF3 = p107s4.d.f(i18, iF2, str2, "/\\");
                int i19 = iF3 < iF2 ? i6 : 0;
                String strCanonicalize2 = C1378y.canonicalize(str2, i18, iF3, " \"<>^`{}|/\\?#", true, false, false, true, null);
                if (!strCanonicalize2.equals(Consts.DOT) && !strCanonicalize2.equalsIgnoreCase("%2e")) {
                    if (!strCanonicalize2.equals("..") && !strCanonicalize2.equalsIgnoreCase("%2e.") && !strCanonicalize2.equalsIgnoreCase(".%2e") && !strCanonicalize2.equalsIgnoreCase("%2e%2e")) {
                        int i20 = i6;
                        if (((String) androidx.collection.a.e(arrayList2, i20)).isEmpty()) {
                            arrayList2.set(arrayList2.size() - i20, strCanonicalize2);
                        } else {
                            arrayList2.add(strCanonicalize2);
                        }
                        if (i19 != 0) {
                            arrayList2.add("");
                        }
                    } else if (!((String) arrayList2.remove(arrayList2.size() - 1)).isEmpty() || arrayList2.isEmpty()) {
                        arrayList2.add("");
                    } else {
                        arrayList2.set(arrayList2.size() - 1, "");
                    }
                }
                if (i19 != 0) {
                    iF3++;
                }
                i18 = iF3;
                i6 = 1;
            }
        }
        if (iF2 >= iO || str2.charAt(iF2) != '?') {
            c6 = '#';
        } else {
            c6 = '#';
            int iG2 = p107s4.d.g(str2, iF2, iO, '#');
            this.encodedQueryNamesAndValues = C1378y.i(C1378y.canonicalize(str2, iF2 + 1, iG2, " \"'<>#", true, false, true, true, null));
            iF2 = iG2;
        }
        if (iF2 < iO && str2.charAt(iF2) == c6) {
            this.encodedFragment = C1378y.canonicalize(str2, iF2 + 1, iO, "", true, false, false, false, null);
        }
        return this;
    }

    public C1377x query(String str) {
        this.encodedQueryNamesAndValues = str != null ? C1378y.i(C1378y.canonicalize(str, 0, str.length(), " \"'<>#", false, false, true, true, null)) : null;
        return this;
    }

    public C1377x setEncodedQueryParameter(String str, String str2) {
        String str3;
        if (str == null) {
            throw new NullPointerException("encodedName == null");
        }
        if (this.encodedQueryNamesAndValues == null) {
            str3 = str;
        } else {
            str3 = str;
            c(C1378y.canonicalize(str3, 0, str.length(), " \"'<>#&=", true, false, true, true, null));
        }
        addEncodedQueryParameter(str3, str2);
        return this;
    }

    public C1377x setQueryParameter(String str, String str2) {
        String str3;
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.encodedQueryNamesAndValues == null) {
            str3 = str;
        } else {
            str3 = str;
            c(C1378y.canonicalize(str3, 0, str.length(), " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true, null));
        }
        addQueryParameter(str3, str2);
        return this;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        String str = this.scheme;
        if (str != null) {
            sb.append(str);
            sb.append("://");
        } else {
            sb.append("//");
        }
        if (!this.f6678a.isEmpty() || !this.b.isEmpty()) {
            sb.append(this.f6678a);
            if (!this.b.isEmpty()) {
                sb.append(NameUtil.COLON);
                sb.append(this.b);
            }
            sb.append('@');
        }
        String str2 = this.host;
        if (str2 != null) {
            if (str2.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.host);
                sb.append(']');
            } else {
                sb.append(this.host);
            }
        }
        int iA = this.c;
        if (iA != -1 || this.scheme != null) {
            if (iA == -1) {
                iA = C1378y.a(this.scheme);
            }
            String str3 = this.scheme;
            if (str3 == null || iA != C1378y.a(str3)) {
                sb.append(NameUtil.COLON);
                sb.append(iA);
            }
        }
        ArrayList arrayList = this.d;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            sb.append('/');
            sb.append((String) arrayList.get(i5));
        }
        if (this.encodedQueryNamesAndValues != null) {
            sb.append('?');
            C1378y.e(this.encodedQueryNamesAndValues, sb);
        }
        if (this.encodedFragment != null) {
            sb.append('#');
            sb.append(this.encodedFragment);
        }
        return sb.toString();
    }
}
