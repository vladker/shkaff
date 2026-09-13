package org.jsoup.parser;

import java.util.Arrays;
import org.apache.logging.log4j.util.Chars;
import org.apache.xmlbeans.impl.common.NameUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class Q {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final char[] f7562r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int[] f7563s;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1465a f7564a;
    public final C b;
    public O d;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public N f7568i;
    private String lastStartCloseSeq;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f7574o;
    public h1 c = h1.f7634a;
    public boolean e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f7565f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final StringBuilder f7566g = new StringBuilder(1024);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final StringBuilder f7567h = new StringBuilder(1024);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final M f7569j = new M();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final L f7570k = new L();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final H f7571l = new H();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final J f7572m = new J();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final I f7573n = new I();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int[] f7575p = new int[1];

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int[] f7576q = new int[2];

    static {
        char[] cArr = {'\t', '\n', Chars.CR, '\f', Chars.SPACE, '<', '&'};
        f7562r = cArr;
        f7563s = new int[]{8364, 129, 8218, 402, 8222, 8230, 8224, 8225, 710, 8240, 352, 8249, 338, 141, 381, 143, 144, 8216, 8217, 8220, 8221, 8226, 8211, 8212, 732, 8482, 353, 8250, 339, 157, 382, 376};
        Arrays.sort(cArr);
    }

    public Q(C1465a c1465a, C c) {
        this.f7564a = c1465a;
        this.b = c;
    }

    public final void a(h1 h1Var) {
        this.f7564a.a();
        this.c = h1Var;
    }

    public final String b() {
        if (this.lastStartCloseSeq == null) {
            this.lastStartCloseSeq = "</" + this.f7574o;
        }
        return this.lastStartCloseSeq;
    }

    public final void c(String str, Object... objArr) {
        C c = this.b;
        if (c.a()) {
            String str2 = String.format("Invalid character reference: ".concat(str), objArr);
            xyz.doikki.videoplayer.player.k kVar = new xyz.doikki.videoplayer.player.k(6);
            C1465a c1465a = this.f7564a;
            c1465a.getClass();
            kVar.b = c1465a.n();
            kVar.c = str2;
            c.add(kVar);
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0191  */
    /* JADX WARN: Code duplicated, block: B:101:0x0196  */
    /* JADX WARN: Code duplicated, block: B:120:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:123:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:124:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:126:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:127:0x0200  */
    /* JADX WARN: Code duplicated, block: B:129:0x0203  */
    /* JADX WARN: Code duplicated, block: B:130:0x0207  */
    /* JADX WARN: Code duplicated, block: B:132:0x020a  */
    /* JADX WARN: Code duplicated, block: B:134:0x020f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:135:0x0211 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:136:0x0212  */
    /* JADX WARN: Code duplicated, block: B:140:0x0223  */
    /* JADX WARN: Code duplicated, block: B:14:0x0032  */
    /* JADX WARN: Code duplicated, block: B:16:0x003c  */
    /* JADX WARN: Code duplicated, block: B:19:0x005a  */
    /* JADX WARN: Code duplicated, block: B:21:0x0062  */
    /* JADX WARN: Code duplicated, block: B:35:0x0090  */
    /* JADX WARN: Code duplicated, block: B:45:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:47:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:49:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:51:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:52:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:70:0x0114  */
    /* JADX WARN: Code duplicated, block: B:72:0x0127  */
    /* JADX WARN: Code duplicated, block: B:94:0x017e  */
    /* JADX WARN: Code duplicated, block: B:95:0x0183  */
    /* JADX WARN: Code duplicated, block: B:98:0x0187  */
    public int[] consumeCharacterReference(Character ch, boolean z6) {
        boolean zP;
        int[] iArr;
        int i5;
        int i6;
        String strC;
        boolean zR;
        org.jsoup.nodes.o oVar;
        int iBinarySearch;
        int i7;
        String str;
        int[] iArr2;
        org.jsoup.nodes.o oVar2;
        int iBinarySearch2;
        int i8;
        char c;
        char c6;
        org.jsoup.nodes.o oVar3;
        int iBinarySearch3;
        int i9;
        char c7;
        char c8;
        boolean zQ;
        int i10;
        String strC2;
        char c9;
        int i11;
        int iIntValue;
        int i12;
        char c10;
        C1465a c1465a = this.f7564a;
        if (!c1465a.o() && (ch == null || ch.charValue() != c1465a.m())) {
            c1465a.b();
            if (c1465a.o()) {
                if (c1465a.c - c1465a.e < 1024) {
                    c1465a.d = 0;
                }
                c1465a.b();
                c1465a.f7579g = c1465a.e;
                zP = c1465a.p("#");
                iArr = this.f7575p;
                if (zP) {
                    zQ = c1465a.q("X");
                    if (zQ) {
                        c1465a.b();
                        int i13 = c1465a.e;
                        while (true) {
                            i12 = c1465a.e;
                            if (i12 >= c1465a.c) {
                                break;
                            }
                            break;
                            c1465a.e = i12 + 1;
                        }
                        strC2 = C1465a.c(c1465a.f7577a, c1465a.f7580h, i13, i12 - i13);
                    } else {
                        c1465a.b();
                        int i14 = c1465a.e;
                        while (true) {
                            i10 = c1465a.e;
                            if (i10 >= c1465a.c) {
                                break;
                            }
                            break;
                            c1465a.e = i10 + 1;
                        }
                        strC2 = C1465a.c(c1465a.f7577a, c1465a.f7580h, i14, i10 - i14);
                    }
                    if (strC2.length() == 0) {
                        c("numeric reference with no numerals", new Object[0]);
                        c1465a.w();
                        return null;
                    }
                    c1465a.f7579g = -1;
                    if (!c1465a.p(";")) {
                        c("missing semicolon on [&#%s]", strC2);
                    }
                    if (zQ) {
                        i11 = 16;
                    } else {
                        i11 = 10;
                    }
                    iIntValue = Integer.valueOf(strC2, i11).intValue();
                    if (iIntValue != -1) {
                        c("character [%s] outside of valid range", Integer.valueOf(iIntValue));
                        iArr[0] = 65533;
                    } else {
                        c("character [%s] outside of valid range", Integer.valueOf(iIntValue));
                        iArr[0] = 65533;
                    }
                    return iArr;
                }
                c1465a.b();
                int i15 = c1465a.e;
                while (true) {
                    i5 = c1465a.e;
                    if (i5 >= c1465a.c) {
                        break;
                    }
                    break;
                    break;
                    c1465a.e++;
                }
                while (true) {
                    i6 = c1465a.e;
                    if (i6 < c1465a.c) {
                        break;
                    }
                    c1465a.e = i6 + 1;
                }
                strC = C1465a.c(c1465a.f7577a, c1465a.f7580h, i15, i6 - i15);
                zR = c1465a.r(';');
                char[] cArr = org.jsoup.nodes.p.f7482a;
                oVar = org.jsoup.nodes.o.base;
                iBinarySearch = Arrays.binarySearch(oVar.f7481a, strC);
                if (iBinarySearch >= 0) {
                    i7 = oVar.b[iBinarySearch];
                } else {
                    i7 = -1;
                }
                if (i7 == -1) {
                    oVar3 = org.jsoup.nodes.o.extended;
                    iBinarySearch3 = Arrays.binarySearch(oVar3.f7481a, strC);
                    if (iBinarySearch3 >= 0) {
                        i9 = oVar3.b[iBinarySearch3];
                    } else {
                        i9 = -1;
                    }
                    if (i9 != -1) {
                    }
                    c1465a.w();
                    if (zR) {
                        c("invalid named reference [%s]", strC);
                    }
                }
                if (!z6) {
                }
                c1465a.f7579g = -1;
                if (!c1465a.p(";")) {
                    c("missing semicolon on [&%s]", strC);
                }
                str = (String) org.jsoup.nodes.p.b.get(strC);
                iArr2 = this.f7576q;
                if (str != null) {
                    iArr2[0] = str.codePointAt(0);
                    iArr2[1] = str.codePointAt(1);
                    c = 2;
                } else {
                    oVar2 = org.jsoup.nodes.o.extended;
                    iBinarySearch2 = Arrays.binarySearch(oVar2.f7481a, strC);
                    if (iBinarySearch2 >= 0) {
                        i8 = oVar2.b[iBinarySearch2];
                    } else {
                        i8 = -1;
                    }
                    if (i8 != -1) {
                        iArr2[0] = i8;
                        c = 1;
                    } else {
                        c = 0;
                    }
                }
                if (c == 1) {
                    iArr[0] = iArr2[0];
                    return iArr;
                }
                if (c == 2) {
                    return iArr2;
                }
                throw new IllegalArgumentException("Unexpected characters returned for ".concat(strC));
            }
            if (Arrays.binarySearch(f7562r, c1465a.f7577a[c1465a.e]) < 0) {
                if (c1465a.c - c1465a.e < 1024) {
                    c1465a.d = 0;
                }
                c1465a.b();
                c1465a.f7579g = c1465a.e;
                zP = c1465a.p("#");
                iArr = this.f7575p;
                if (zP) {
                    zQ = c1465a.q("X");
                    if (zQ) {
                        c1465a.b();
                        int i16 = c1465a.e;
                        while (true) {
                            i12 = c1465a.e;
                            if (i12 >= c1465a.c || (((c10 = c1465a.f7577a[i12]) < '0' || c10 > '9') && ((c10 < 'A' || c10 > 'F') && (c10 < 'a' || c10 > 'f')))) {
                                break;
                            }
                            c1465a.e = i12 + 1;
                        }
                        strC2 = C1465a.c(c1465a.f7577a, c1465a.f7580h, i16, i12 - i16);
                    } else {
                        c1465a.b();
                        int i17 = c1465a.e;
                        while (true) {
                            i10 = c1465a.e;
                            if (i10 >= c1465a.c || (c9 = c1465a.f7577a[i10]) < '0' || c9 > '9') {
                                break;
                            }
                            c1465a.e = i10 + 1;
                        }
                        strC2 = C1465a.c(c1465a.f7577a, c1465a.f7580h, i17, i10 - i17);
                    }
                    if (strC2.length() == 0) {
                        c("numeric reference with no numerals", new Object[0]);
                        c1465a.w();
                        return null;
                    }
                    c1465a.f7579g = -1;
                    if (!c1465a.p(";")) {
                        c("missing semicolon on [&#%s]", strC2);
                    }
                    if (zQ) {
                        i11 = 16;
                    } else {
                        i11 = 10;
                    }
                    try {
                        iIntValue = Integer.valueOf(strC2, i11).intValue();
                    } catch (NumberFormatException unused) {
                        iIntValue = -1;
                    }
                    if (iIntValue != -1 || ((iIntValue >= 55296 && iIntValue <= 57343) || iIntValue > 1114111)) {
                        c("character [%s] outside of valid range", Integer.valueOf(iIntValue));
                        iArr[0] = 65533;
                    } else {
                        if (iIntValue >= 128 && iIntValue < 160) {
                            c("character [%s] is not a valid unicode code point", Integer.valueOf(iIntValue));
                            iIntValue = f7563s[iIntValue - 128];
                        }
                        iArr[0] = iIntValue;
                    }
                    return iArr;
                }
                c1465a.b();
                int i18 = c1465a.e;
                while (true) {
                    i5 = c1465a.e;
                    if (i5 >= c1465a.c || (((c8 = c1465a.f7577a[i5]) < 'A' || c8 > 'Z') && ((c8 < 'a' || c8 > 'z') && !Character.isLetter(c8)))) {
                        break;
                    }
                    c1465a.e++;
                }
                while (true) {
                    i6 = c1465a.e;
                    if (i6 < c1465a.c || (c7 = c1465a.f7577a[i6]) < '0' || c7 > '9') {
                        break;
                    }
                    c1465a.e = i6 + 1;
                }
                strC = C1465a.c(c1465a.f7577a, c1465a.f7580h, i18, i6 - i18);
                zR = c1465a.r(';');
                char[] cArr2 = org.jsoup.nodes.p.f7482a;
                oVar = org.jsoup.nodes.o.base;
                iBinarySearch = Arrays.binarySearch(oVar.f7481a, strC);
                if (iBinarySearch >= 0) {
                    i7 = oVar.b[iBinarySearch];
                } else {
                    i7 = -1;
                }
                if (i7 == -1) {
                    oVar3 = org.jsoup.nodes.o.extended;
                    iBinarySearch3 = Arrays.binarySearch(oVar3.f7481a, strC);
                    if (iBinarySearch3 >= 0) {
                        i9 = oVar3.b[iBinarySearch3];
                    } else {
                        i9 = -1;
                    }
                    if (i9 != -1 || !zR) {
                        c1465a.w();
                        if (zR) {
                            c("invalid named reference [%s]", strC);
                        }
                    }
                }
                if (!z6 && (c1465a.u() || ((!c1465a.o() && (c6 = c1465a.f7577a[c1465a.e]) >= '0' && c6 <= '9') || c1465a.s(Chars.EQ, '-', NameUtil.USCORE)))) {
                    c1465a.w();
                    return null;
                }
                c1465a.f7579g = -1;
                if (!c1465a.p(";")) {
                    c("missing semicolon on [&%s]", strC);
                }
                str = (String) org.jsoup.nodes.p.b.get(strC);
                iArr2 = this.f7576q;
                if (str != null) {
                    iArr2[0] = str.codePointAt(0);
                    iArr2[1] = str.codePointAt(1);
                    c = 2;
                } else {
                    oVar2 = org.jsoup.nodes.o.extended;
                    iBinarySearch2 = Arrays.binarySearch(oVar2.f7481a, strC);
                    if (iBinarySearch2 >= 0) {
                        i8 = oVar2.b[iBinarySearch2];
                    } else {
                        i8 = -1;
                    }
                    if (i8 != -1) {
                        iArr2[0] = i8;
                        c = 1;
                    } else {
                        c = 0;
                    }
                }
                if (c == 1) {
                    iArr[0] = iArr2[0];
                    return iArr;
                }
                if (c == 2) {
                    return iArr2;
                }
                throw new IllegalArgumentException("Unexpected characters returned for ".concat(strC));
            }
        }
        return null;
    }

    public final N d(boolean z6) {
        N n6;
        if (z6) {
            n6 = this.f7569j;
            n6.f();
        } else {
            n6 = this.f7570k;
            n6.f();
        }
        this.f7568i = n6;
        return n6;
    }

    public final void e() {
        O.g(this.f7567h);
    }

    public final void f(char c) {
        if (this.f7565f == null) {
            this.f7565f = String.valueOf(c);
            return;
        }
        StringBuilder sb = this.f7566g;
        if (sb.length() == 0) {
            sb.append(this.f7565f);
        }
        sb.append(c);
    }

    public final void g(String str) {
        if (this.f7565f == null) {
            this.f7565f = str;
            return;
        }
        StringBuilder sb = this.f7566g;
        if (sb.length() == 0) {
            sb.append(this.f7565f);
        }
        sb.append(str);
    }

    public final void h(O o6) {
        if (this.e) {
            throw new IllegalArgumentException("Must be false");
        }
        this.d = o6;
        this.e = true;
        int i5 = o6.f7560a;
        if (i5 == 2) {
            this.f7574o = ((M) o6).tagName;
            this.lastStartCloseSeq = null;
        } else if (i5 == 3) {
            L l6 = (L) o6;
            if (l6.n()) {
                Object[] objArr = {l6.normalName};
                C c = this.b;
                if (c.a()) {
                    c.add(new xyz.doikki.videoplayer.player.k(this.f7564a, "Attributes incorrectly present on end tag [/%s]", objArr));
                }
            }
        }
    }

    public final void i() {
        h(this.f7573n);
    }

    public final void j() {
        h(this.f7572m);
    }

    public final void k() {
        N n6 = this.f7568i;
        if (n6.c) {
            n6.q();
        }
        h(this.f7568i);
    }

    public final void l(h1 h1Var) {
        C c = this.b;
        if (c.a()) {
            c.add(new xyz.doikki.videoplayer.player.k(this.f7564a, "Unexpectedly reached end of file (EOF) in input state [%s]", new Object[]{h1Var}));
        }
    }

    public final void m(h1 h1Var) {
        C c = this.b;
        if (c.a()) {
            C1465a c1465a = this.f7564a;
            c.add(new xyz.doikki.videoplayer.player.k(c1465a, "Unexpected character '%s' in input state [%s]", new Object[]{Character.valueOf(c1465a.m()), h1Var}));
        }
    }

    public final boolean n() {
        return this.f7574o != null && this.f7568i.o().equalsIgnoreCase(this.f7574o);
    }
}
