package org.jsoup.parser;

import A3.AbstractC0157z;
import org.apache.xmlbeans.impl.common.NameUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class P {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f7561a;
    public int b = 0;

    public P(String str) {
        V4.h.notNull(str);
        this.f7561a = str;
    }

    public static String n(String str) {
        StringBuilder sbB = W4.b.b();
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        int i5 = 0;
        char c = 0;
        while (i5 < length) {
            char c6 = charArray[i5];
            if (c6 != '\\') {
                sbB.append(c6);
            } else if (c == '\\') {
                sbB.append(c6);
            }
            i5++;
            c = c6;
        }
        return W4.b.g(sbB);
    }

    /* JADX WARN: Code duplicated, block: B:45:0x0071 A[LOOP:0: B:3:0x0009->B:45:0x0071, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:47:0x0055 A[EDGE_INSN: B:47:0x0055->B:38:0x0055 BREAK  A[LOOP:0: B:3:0x0009->B:45:0x0071], SYNTHETIC] */
    public final String a(char c, char c6) {
        int i5 = -1;
        int i6 = -1;
        char c7 = 0;
        boolean z6 = false;
        boolean z7 = false;
        int i7 = 0;
        boolean z8 = false;
        while (!g()) {
            char cB = b();
            if (c7 != '\\') {
                if (cB == '\'' && cB != c && !z6) {
                    z7 = !z7;
                } else if (cB == '\"' && cB != c && !z7) {
                    z6 = !z6;
                }
                if (!z7 && !z6 && !z8) {
                    if (cB == c) {
                        i7++;
                        if (i5 == -1) {
                            i5 = this.b;
                        }
                    } else if (cB == c6) {
                        i7--;
                    }
                }
                if (i7 <= 0) {
                    break;
                }
                c7 = cB;
            } else if (cB == 'Q') {
                z8 = true;
            } else if (cB == 'E') {
                z8 = false;
            }
            if (i7 > 0 && c7 != 0) {
                i6 = this.b;
            }
            if (i7 <= 0) {
                break;
                break;
            }
            c7 = cB;
        }
        String strSubstring = i6 >= 0 ? this.f7561a.substring(i5, i6) : "";
        if (i7 <= 0) {
            return strSubstring;
        }
        throw new IllegalArgumentException(AbstractC0157z.o("Did not find balanced marker at '", strSubstring, "'"));
    }

    @Deprecated
    public void addFirst(Character ch) {
        this.f7561a = androidx.exifinterface.media.a.j(this.f7561a, this.b, androidx.collection.a.r(ch.toString()));
        this.b = 0;
    }

    public final char b() {
        String str = this.f7561a;
        int i5 = this.b;
        this.b = i5 + 1;
        return str.charAt(i5);
    }

    public final void c(String str) {
        if (!i(str)) {
            throw new IllegalStateException("Queue did not match expected sequence");
        }
        int length = str.length();
        int length2 = this.f7561a.length();
        int i5 = this.b;
        if (length > length2 - i5) {
            throw new IllegalStateException("Queue not long enough to consume sequence");
        }
        this.b = i5 + length;
    }

    @Deprecated
    public String consumeAttributeKey() {
        int i5 = this.b;
        while (!g() && (l() || j('-', NameUtil.USCORE, NameUtil.COLON))) {
            this.b++;
        }
        return this.f7561a.substring(i5, this.b);
    }

    @Deprecated
    public String consumeTagName() {
        int i5 = this.b;
        while (!g() && (l() || j(NameUtil.COLON, NameUtil.USCORE, '-'))) {
            this.b++;
        }
        return this.f7561a.substring(i5, this.b);
    }

    public final String d() {
        int i5 = this.b;
        while (!g() && (l() || j('-', NameUtil.USCORE))) {
            this.b++;
        }
        return this.f7561a.substring(i5, this.b);
    }

    public final String e(String str) {
        int iIndexOf = this.f7561a.indexOf(str, this.b);
        if (iIndexOf == -1) {
            return m();
        }
        String strSubstring = this.f7561a.substring(this.b, iIndexOf);
        this.b = strSubstring.length() + this.b;
        return strSubstring;
    }

    public final boolean f() {
        boolean z6 = false;
        while (!g() && W4.b.e(this.f7561a.charAt(this.b))) {
            this.b++;
            z6 = true;
        }
        return z6;
    }

    public final boolean g() {
        return this.f7561a.length() - this.b == 0;
    }

    public final boolean h(String str) {
        if (!i(str)) {
            return false;
        }
        this.b = str.length() + this.b;
        return true;
    }

    public final boolean i(String str) {
        return this.f7561a.regionMatches(true, this.b, str, 0, str.length());
    }

    public final boolean j(char... cArr) {
        if (!g()) {
            for (char c : cArr) {
                if (this.f7561a.charAt(this.b) == c) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean k(String... strArr) {
        for (String str : strArr) {
            if (i(str)) {
                return true;
            }
        }
        return false;
    }

    public final boolean l() {
        return !g() && Character.isLetterOrDigit(this.f7561a.charAt(this.b));
    }

    public final String m() {
        String strSubstring = this.f7561a.substring(this.b);
        this.b = this.f7561a.length();
        return strSubstring;
    }

    @Deprecated
    public boolean matchesCS(String str) {
        return this.f7561a.startsWith(str, this.b);
    }

    @Deprecated
    public boolean matchesStartTag() {
        int length = this.f7561a.length();
        int i5 = this.b;
        return length - i5 >= 2 && this.f7561a.charAt(i5) == '<' && Character.isLetter(this.f7561a.charAt(this.b + 1));
    }

    @Deprecated
    public char peek() {
        if (g()) {
            return (char) 0;
        }
        return this.f7561a.charAt(this.b);
    }

    public final String toString() {
        return this.f7561a.substring(this.b);
    }
}
