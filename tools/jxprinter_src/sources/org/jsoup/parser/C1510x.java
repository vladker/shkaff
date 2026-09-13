package org.jsoup.parser;

import com.google.common.base.Ascii;
import java.util.ArrayList;
import org.apache.commons.compress.compressors.CompressorStreamFactory;
import org.apache.poi.ss.util.CellUtil;

/* JADX INFO: renamed from: org.jsoup.parser.x, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final enum C1510x extends B {
    public C1510x() {
        super("InBody", 6);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:184:0x02b7  */
    /* JADX WARN: Code duplicated, block: B:186:0x02c3  */
    /* JADX WARN: Code duplicated, block: B:188:0x02c9  */
    /* JADX WARN: Code duplicated, block: B:190:0x02d0  */
    /* JADX WARN: Code duplicated, block: B:192:0x02d6  */
    /* JADX WARN: Code duplicated, block: B:200:0x0316  */
    /* JADX WARN: Code duplicated, block: B:201:0x0319  */
    /* JADX WARN: Code duplicated, block: B:311:0x04bd  */
    /* JADX WARN: Code duplicated, block: B:35:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:660:0x0a7e  */
    /* JADX WARN: Code duplicated, block: B:692:0x0b07  */
    @Override // org.jsoup.parser.B
    public final boolean c(O o6, C1467b c1467b) {
        boolean z6;
        byte b;
        org.jsoup.nodes.q formElement;
        org.jsoup.nodes.c cVar;
        byte b6;
        String[] strArr;
        org.jsoup.nodes.m mVar;
        org.jsoup.nodes.m mVar2;
        int iLastIndexOf;
        boolean z7;
        int iB = p050j.n.b(o6.f7560a);
        if (iB == 0) {
            c1467b.m(this);
            return false;
        }
        String[] strArr2 = C1467b.f7587D;
        B b7 = B.d;
        String[] strArr3 = A.f7503i;
        String[] strArr4 = A.f7507m;
        String[] strArr5 = strArr2;
        if (iB == 1) {
            z6 = true;
            M m6 = (M) o6;
            String str = m6.normalName;
            str.getClass();
            switch (str) {
                case "frameset":
                    b = 0;
                    break;
                case "button":
                    b = 1;
                    break;
                case "iframe":
                    b = 2;
                    break;
                case "option":
                    b = 3;
                    break;
                case "textarea":
                    b = 4;
                    break;
                case "select":
                    b = 5;
                    break;
                case "optgroup":
                    b = 6;
                    break;
                case "a":
                    b = 7;
                    break;
                case "dd":
                    b = 8;
                    break;
                case "dt":
                    b = 9;
                    break;
                case "h1":
                    b = 10;
                    break;
                case "h2":
                    b = 11;
                    break;
                case "h3":
                    b = 12;
                    break;
                case "h4":
                    b = 13;
                    break;
                case "h5":
                    b = 14;
                    break;
                case "h6":
                    b = 15;
                    break;
                case "hr":
                    b = 16;
                    break;
                case "li":
                    b = 17;
                    break;
                case "rp":
                    b = 18;
                    break;
                case "rt":
                    b = 19;
                    break;
                case "pre":
                    b = 20;
                    break;
                case "svg":
                    b = 21;
                    break;
                case "xmp":
                    b = 22;
                    break;
                case "body":
                    b = 23;
                    break;
                case "form":
                    b = Ascii.CAN;
                    break;
                case "html":
                    b = 25;
                    break;
                case "math":
                    b = Ascii.SUB;
                    break;
                case "nobr":
                    b = Ascii.ESC;
                    break;
                case "span":
                    b = Ascii.FS;
                    break;
                case "image":
                    b = 29;
                    break;
                case "input":
                    b = 30;
                    break;
                case "table":
                    b = 31;
                    break;
                case "listing":
                    b = 32;
                    break;
                case "plaintext":
                    b = 33;
                    break;
                case "isindex":
                    b = 34;
                    break;
                case "noembed":
                    b = 35;
                    break;
                default:
                    b = -1;
                    break;
            }
            String[] strArr6 = A.f7504j;
            C1514z c1514z = B.f7525i;
            switch (b) {
                case 0:
                    c1467b.m(this);
                    ArrayList arrayList = c1467b.e;
                    if (arrayList.size() == 1) {
                        return false;
                    }
                    if ((arrayList.size() > 2 && !((org.jsoup.nodes.m) arrayList.get(1)).c.b.equals("body")) || !c1467b.f7599s) {
                        return false;
                    }
                    org.jsoup.nodes.m mVar3 = (org.jsoup.nodes.m) arrayList.get(1);
                    if (mVar3.parent() != null) {
                        mVar3.u();
                    }
                    while (arrayList.size() > 1) {
                        arrayList.remove(arrayList.size() - 1);
                    }
                    c1467b.w(m6);
                    c1467b.f7592l = B.f7536t;
                    return true;
                case 1:
                    if (c1467b.r("button")) {
                        c1467b.m(this);
                        c1467b.e("button");
                        c1467b.d(m6);
                        return true;
                    }
                    c1467b.I();
                    c1467b.w(m6);
                    c1467b.f7599s = false;
                    return true;
                case 2:
                    c1467b.f7599s = false;
                    B.b(m6, c1467b);
                    return true;
                case 3:
                case 6:
                    if (c1467b.b("option")) {
                        c1467b.e("option");
                    }
                    c1467b.I();
                    c1467b.w(m6);
                    return true;
                case 4:
                    c1467b.w(m6);
                    if (!m6.f7559g) {
                        c1467b.c.c = h1.c;
                        c1467b.f7593m = c1467b.f7592l;
                        c1467b.f7599s = false;
                        c1467b.f7592l = B.f7524h;
                        return true;
                    }
                    return true;
                case 5:
                    c1467b.I();
                    c1467b.w(m6);
                    c1467b.f7599s = false;
                    if (!m6.f7559g) {
                        B b8 = c1467b.f7592l;
                        if (b8.equals(c1514z) || b8.equals(B.f7527k) || b8.equals(B.f7529m) || b8.equals(B.f7530n) || b8.equals(B.f7531o)) {
                            c1467b.f7592l = B.f7533q;
                            return true;
                        }
                        c1467b.f7592l = B.f7532p;
                        return true;
                    }
                    return true;
                case 7:
                    if (c1467b.p("a") != null) {
                        c1467b.m(this);
                        c1467b.e("a");
                        org.jsoup.nodes.m fromStack = c1467b.getFromStack("a");
                        if (fromStack != null) {
                            c1467b.J(fromStack);
                            c1467b.K(fromStack);
                        }
                    }
                    c1467b.I();
                    org.jsoup.nodes.m mVarW = c1467b.w(m6);
                    c1467b.i(mVarW);
                    c1467b.f7595o.add(mVarW);
                    return true;
                case 8:
                case 9:
                    c1467b.f7599s = false;
                    ArrayList arrayList2 = c1467b.e;
                    int size = arrayList2.size();
                    int i5 = size - 1;
                    int i6 = i5 >= 24 ? size - 25 : 0;
                    while (i5 >= i6) {
                        F f6 = ((org.jsoup.nodes.m) arrayList2.get(i5)).c;
                        String str2 = f6.b;
                        String str3 = f6.b;
                        if (W4.b.c(str2, A.f7505k)) {
                            c1467b.e(str3);
                        } else if (!W4.b.c(str3, strArr5) || W4.b.c(str3, strArr6)) {
                            i5--;
                        }
                        if (c1467b.r("p")) {
                            c1467b.e("p");
                        }
                        c1467b.w(m6);
                        return true;
                    }
                    if (c1467b.r("p")) {
                        c1467b.e("p");
                    }
                    c1467b.w(m6);
                    return true;
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                    if (c1467b.r("p")) {
                        c1467b.e("p");
                    }
                    if (W4.b.c(c1467b.a().c.b, strArr3)) {
                        c1467b.m(this);
                        c1467b.F();
                    }
                    c1467b.w(m6);
                    return true;
                case 16:
                    if (c1467b.r("p")) {
                        c1467b.e("p");
                    }
                    c1467b.z(m6);
                    c1467b.f7599s = false;
                    return true;
                case 17:
                    c1467b.f7599s = false;
                    ArrayList arrayList3 = c1467b.e;
                    int size2 = arrayList3.size() - 1;
                    while (size2 > 0) {
                        F f7 = ((org.jsoup.nodes.m) arrayList3.get(size2)).c;
                        String str4 = f7.b;
                        String str5 = f7.b;
                        if (str4.equals("li")) {
                            c1467b.e("li");
                        } else {
                            String[] strArr7 = strArr5;
                            if (!W4.b.c(str5, strArr7) || W4.b.c(str5, strArr6)) {
                                size2--;
                                strArr5 = strArr7;
                            }
                        }
                        if (c1467b.r("p")) {
                            c1467b.e("p");
                        }
                        c1467b.w(m6);
                        return true;
                    }
                    if (c1467b.r("p")) {
                        c1467b.e("p");
                    }
                    c1467b.w(m6);
                    return true;
                case 18:
                case 19:
                    if (c1467b.s("ruby")) {
                        c1467b.o(false);
                        if (!c1467b.b("ruby")) {
                            c1467b.m(this);
                            for (int size3 = c1467b.e.size() - 1; size3 >= 0 && !((org.jsoup.nodes.m) c1467b.e.get(size3)).c.b.equals("ruby"); size3--) {
                                c1467b.e.remove(size3);
                            }
                        }
                        c1467b.w(m6);
                        return true;
                    }
                    break;
                case 20:
                case 32:
                    if (c1467b.r("p")) {
                        c1467b.e("p");
                    }
                    c1467b.w(m6);
                    c1467b.b.p("\n");
                    c1467b.f7599s = false;
                    return true;
                case 21:
                    c1467b.I();
                    c1467b.w(m6);
                    return true;
                case 22:
                    if (c1467b.r("p")) {
                        c1467b.e("p");
                    }
                    c1467b.I();
                    c1467b.f7599s = false;
                    B.b(m6, c1467b);
                    return true;
                case 23:
                    c1467b.m(this);
                    ArrayList arrayList4 = c1467b.e;
                    if (arrayList4.size() == 1) {
                        return false;
                    }
                    if ((arrayList4.size() > 2 && !((org.jsoup.nodes.m) arrayList4.get(1)).c.b.equals("body")) || c1467b.D("template")) {
                        return false;
                    }
                    c1467b.f7599s = false;
                    org.jsoup.nodes.m mVar4 = (org.jsoup.nodes.m) arrayList4.get(1);
                    if (m6.n()) {
                        org.jsoup.nodes.c cVar2 = m6.attributes;
                        cVar2.getClass();
                        int i7 = 0;
                        while (true) {
                            if (i7 < cVar2.f7467a && org.jsoup.nodes.c.l(cVar2.b[i7])) {
                                i7++;
                            } else if (i7 < cVar2.f7467a) {
                                org.jsoup.nodes.a aVar = new org.jsoup.nodes.a(cVar2.b[i7], cVar2.c[i7], cVar2);
                                i7++;
                                if (!mVar4.o(aVar.f7465a)) {
                                    mVar4.h().m(aVar);
                                }
                            }
                        }
                    }
                    return true;
                case 24:
                    if (c1467b.getFormElement() != null && !c1467b.D("template")) {
                        c1467b.m(this);
                        return false;
                    }
                    if (c1467b.r("p")) {
                        c1467b.n("p");
                        if (!"p".equals(c1467b.a().c.b)) {
                            c1467b.m(c1467b.f7592l);
                        }
                        c1467b.popStackToClose("p");
                    }
                    c1467b.A(m6, true, true);
                    return true;
                case 25:
                    c1467b.m(this);
                    if (c1467b.D("template")) {
                        return false;
                    }
                    if (c1467b.e.size() > 0) {
                        org.jsoup.nodes.m mVar5 = (org.jsoup.nodes.m) c1467b.e.get(0);
                        if (m6.n()) {
                            org.jsoup.nodes.c cVar3 = m6.attributes;
                            cVar3.getClass();
                            int i8 = 0;
                            while (true) {
                                if (i8 < cVar3.f7467a && org.jsoup.nodes.c.l(cVar3.b[i8])) {
                                    i8++;
                                } else if (i8 >= cVar3.f7467a) {
                                    break;
                                } else {
                                    org.jsoup.nodes.a aVar2 = new org.jsoup.nodes.a(cVar3.b[i8], cVar3.c[i8], cVar3);
                                    i8++;
                                    if (!mVar5.o(aVar2.f7465a)) {
                                        mVar5.h().m(aVar2);
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 26:
                    c1467b.I();
                    c1467b.w(m6);
                    return true;
                case 27:
                    c1467b.I();
                    if (c1467b.s("nobr")) {
                        c1467b.m(this);
                        c1467b.e("nobr");
                        c1467b.I();
                    }
                    org.jsoup.nodes.m mVarW2 = c1467b.w(m6);
                    c1467b.i(mVarW2);
                    c1467b.f7595o.add(mVarW2);
                    return true;
                case 28:
                    c1467b.I();
                    c1467b.w(m6);
                    return true;
                case 29:
                    if (c1467b.getFromStack("svg") == null) {
                        m6.p("img");
                        return c1467b.d(m6);
                    }
                    c1467b.w(m6);
                    return true;
                case 30:
                    c1467b.I();
                    if (!c1467b.z(m6).f("type").equalsIgnoreCase(CellUtil.HIDDEN)) {
                        c1467b.f7599s = false;
                        return true;
                    }
                    break;
                case 31:
                    if (c1467b.d.f7473i != 2 && c1467b.r("p")) {
                        c1467b.e("p");
                    }
                    c1467b.w(m6);
                    c1467b.f7599s = false;
                    c1467b.f7592l = c1514z;
                    return true;
                case 33:
                    if (c1467b.r("p")) {
                        c1467b.e("p");
                    }
                    c1467b.w(m6);
                    c1467b.c.c = h1.f7636g;
                    return true;
                case 34:
                    c1467b.m(this);
                    if (c1467b.getFormElement() != null) {
                        return false;
                    }
                    c1467b.f("form");
                    org.jsoup.nodes.c cVar4 = m6.attributes;
                    if (cVar4 != null && cVar4.j("action") != -1 && (formElement = c1467b.getFormElement()) != null && (cVar = m6.attributes) != null && cVar.j("action") != -1) {
                        formElement.h().put("action", m6.attributes.h("action"));
                    }
                    c1467b.f("hr");
                    c1467b.f("label");
                    org.jsoup.nodes.c cVar5 = m6.attributes;
                    String strH = (cVar5 == null || cVar5.j("prompt") == -1) ? "This is a searchable index. Enter search keywords: " : m6.attributes.h("prompt");
                    H h6 = new H();
                    h6.b = strH;
                    c1467b.d(h6);
                    org.jsoup.nodes.c cVar6 = new org.jsoup.nodes.c();
                    if (m6.n()) {
                        org.jsoup.nodes.c cVar7 = m6.attributes;
                        cVar7.getClass();
                        int i9 = 0;
                        while (true) {
                            int i10 = i9;
                            while (i10 < cVar7.f7467a && org.jsoup.nodes.c.l(cVar7.b[i10])) {
                                i10++;
                            }
                            if (i10 < cVar7.f7467a) {
                                org.jsoup.nodes.a aVar3 = new org.jsoup.nodes.a(cVar7.b[i10], cVar7.c[i10], cVar7);
                                i9 = i10 + 1;
                                if (!W4.b.c(aVar3.f7465a, A.f7510p)) {
                                    cVar6.m(aVar3);
                                }
                            }
                        }
                    }
                    cVar6.put("name", "isindex");
                    M m7 = c1467b.f7675j;
                    if (c1467b.f7672g == m7) {
                        M m8 = new M();
                        m8.tagName = "input";
                        m8.attributes = cVar6;
                        m8.normalName = p051j0.i.i("input");
                        c1467b.d(m8);
                    } else {
                        m7.f();
                        m7.tagName = "input";
                        m7.attributes = cVar6;
                        m7.normalName = p051j0.i.i("input");
                        c1467b.d(m7);
                    }
                    c1467b.e("label");
                    c1467b.f("hr");
                    c1467b.e("form");
                    return true;
                case 35:
                    B.b(m6, c1467b);
                    return true;
                default:
                    if (!F.f7545j.containsKey(str)) {
                        c1467b.w(m6);
                        return true;
                    }
                    if (W4.b.c(str, A.f7508n)) {
                        c1467b.I();
                        c1467b.z(m6);
                        c1467b.f7599s = false;
                        return true;
                    }
                    if (W4.b.c(str, A.f7502h)) {
                        if (c1467b.r("p")) {
                            c1467b.e("p");
                        }
                        c1467b.w(m6);
                        return true;
                    }
                    if (W4.b.c(str, A.f7501g)) {
                        c1467b.f7672g = o6;
                        return b7.c(o6, c1467b);
                    }
                    if (W4.b.c(str, A.f7506l)) {
                        c1467b.I();
                        org.jsoup.nodes.m mVarW3 = c1467b.w(m6);
                        c1467b.i(mVarW3);
                        c1467b.f7595o.add(mVarW3);
                        return true;
                    }
                    if (W4.b.c(str, strArr4)) {
                        c1467b.I();
                        c1467b.w(m6);
                        c1467b.f7595o.add(null);
                        c1467b.f7599s = false;
                        return true;
                    }
                    if (W4.b.c(str, A.f7509o)) {
                        c1467b.z(m6);
                        return true;
                    }
                    if (W4.b.c(str, A.f7511q)) {
                        c1467b.m(this);
                        return false;
                    }
                    c1467b.I();
                    c1467b.w(m6);
                    return true;
            }
        } else if (iB == 2) {
            z6 = true;
            L l6 = (L) o6;
            String str6 = l6.normalName;
            str6.getClass();
            switch (str6) {
                case "template":
                    b6 = 0;
                    break;
                case "p":
                    b6 = 1;
                    break;
                case "br":
                    b6 = 2;
                    break;
                case "dd":
                    b6 = 3;
                    break;
                case "dt":
                    b6 = 4;
                    break;
                case "h1":
                    b6 = 5;
                    break;
                case "h2":
                    b6 = 6;
                    break;
                case "h3":
                    b6 = 7;
                    break;
                case "h4":
                    b6 = 8;
                    break;
                case "h5":
                    b6 = 9;
                    break;
                case "h6":
                    b6 = 10;
                    break;
                case "li":
                    b6 = 11;
                    break;
                case "body":
                    b6 = 12;
                    break;
                case "form":
                    b6 = 13;
                    break;
                case "html":
                    b6 = 14;
                    break;
                case "span":
                    b6 = 15;
                    break;
                case "sarcasm":
                    b6 = 16;
                    break;
                default:
                    b6 = -1;
                    break;
            }
            String[] strArr8 = C1467b.f7588w;
            switch (b6) {
                case 0:
                    c1467b.G(o6, b7);
                    return true;
                case 1:
                    if (!c1467b.r(str6)) {
                        c1467b.m(this);
                        c1467b.f(str6);
                        return c1467b.d(l6);
                    }
                    c1467b.n(str6);
                    if (!c1467b.b(str6)) {
                        c1467b.m(this);
                    }
                    c1467b.popStackToClose(str6);
                    return true;
                case 2:
                    c1467b.m(this);
                    c1467b.f(CompressorStreamFactory.BROTLI);
                    return false;
                case 3:
                case 4:
                    if (!c1467b.s(str6)) {
                        c1467b.m(this);
                        return false;
                    }
                    c1467b.n(str6);
                    if (!c1467b.b(str6)) {
                        c1467b.m(this);
                    }
                    c1467b.popStackToClose(str6);
                    return true;
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                    if (!c1467b.u(strArr3, strArr8, null)) {
                        c1467b.m(this);
                        return false;
                    }
                    c1467b.n(str6);
                    if (!c1467b.b(str6)) {
                        c1467b.m(this);
                    }
                    for (int size4 = c1467b.e.size() - 1; size4 >= 0; size4--) {
                        org.jsoup.nodes.m mVar6 = (org.jsoup.nodes.m) c1467b.e.get(size4);
                        c1467b.e.remove(size4);
                        if (W4.b.c(mVar6.c.b, strArr3)) {
                        }
                        break;
                    }
                    break;
                    break;
                case 11:
                    String[] strArr9 = c1467b.f7602v;
                    strArr9[0] = str6;
                    if (!c1467b.u(strArr9, strArr8, C1467b.f7589x)) {
                        c1467b.m(this);
                        return false;
                    }
                    c1467b.n(str6);
                    if (!c1467b.b(str6)) {
                        c1467b.m(this);
                    }
                    c1467b.popStackToClose(str6);
                    return true;
                case 12:
                    if (c1467b.s("body")) {
                        c1467b.f7592l = B.f7535s;
                        return true;
                    }
                    c1467b.m(this);
                    return false;
                case 13:
                    if (c1467b.D("template")) {
                        if (!c1467b.s(str6)) {
                            c1467b.m(this);
                            return false;
                        }
                        c1467b.o(false);
                        if (!c1467b.b(str6)) {
                            c1467b.m(this);
                        }
                        c1467b.popStackToClose(str6);
                        return true;
                    }
                    org.jsoup.nodes.q formElement2 = c1467b.getFormElement();
                    c1467b.M();
                    if (formElement2 == null || !c1467b.s(str6)) {
                        c1467b.m(this);
                        return false;
                    }
                    c1467b.o(false);
                    if (!c1467b.b(str6)) {
                        c1467b.m(this);
                    }
                    c1467b.K(formElement2);
                    return true;
                case 14:
                    if (c1467b.e("body")) {
                        return c1467b.d(l6);
                    }
                    break;
                case 15:
                case 16:
                    return d(o6, c1467b);
                default:
                    if (W4.b.c(str6, A.f7513s)) {
                        String str7 = l6.normalName;
                        ArrayList arrayList5 = c1467b.e;
                        int i11 = 0;
                        while (i11 < 8) {
                            org.jsoup.nodes.m mVarP = c1467b.p(str7);
                            if (mVarP == null) {
                                return d(o6, c1467b);
                            }
                            F f8 = mVarP.c;
                            if (C1467b.E(c1467b.e, mVarP)) {
                                if (!c1467b.s(f8.b)) {
                                    c1467b.m(this);
                                    return false;
                                }
                                if (c1467b.a() != mVarP) {
                                    c1467b.m(this);
                                }
                                int size5 = arrayList5.size();
                                int i12 = 1;
                                boolean z8 = false;
                                org.jsoup.nodes.m mVar7 = null;
                                int i13 = -1;
                                while (true) {
                                    if (i12 >= size5 || i12 >= 64) {
                                        strArr = strArr5;
                                        mVar = null;
                                    } else {
                                        mVar = (org.jsoup.nodes.m) arrayList5.get(i12);
                                        if (mVar == mVarP) {
                                            org.jsoup.nodes.m mVar8 = (org.jsoup.nodes.m) arrayList5.get(i12 - 1);
                                            int i14 = 0;
                                            while (true) {
                                                if (i14 >= c1467b.f7595o.size()) {
                                                    i14 = -1;
                                                } else if (mVar != c1467b.f7595o.get(i14)) {
                                                    i14++;
                                                }
                                            }
                                            i13 = i14;
                                            strArr = strArr5;
                                            mVar7 = mVar8;
                                            z8 = true;
                                        } else if (z8) {
                                            strArr = strArr5;
                                            if (W4.b.c(mVar.c.b, strArr)) {
                                            }
                                        } else {
                                            strArr = strArr5;
                                        }
                                        i12++;
                                        strArr5 = strArr;
                                    }
                                }
                                if (mVar == null) {
                                    c1467b.popStackToClose(f8.b);
                                    c1467b.J(mVarP);
                                } else {
                                    org.jsoup.nodes.m mVarAboveOnStack = mVar;
                                    org.jsoup.nodes.m mVar9 = mVarAboveOnStack;
                                    int i15 = 0;
                                    try {
                                        while (i15 < 3) {
                                            if (C1467b.E(c1467b.e, mVarAboveOnStack)) {
                                                mVarAboveOnStack = c1467b.aboveOnStack(mVarAboveOnStack);
                                            }
                                            if (!C1467b.E(c1467b.f7595o, mVarAboveOnStack)) {
                                                c1467b.K(mVarAboveOnStack);
                                            } else if (mVarAboveOnStack == mVarP) {
                                                String str8 = str7;
                                                ArrayList arrayList6 = arrayList5;
                                                int i16 = i11;
                                                if (mVar7 != null) {
                                                    if (W4.b.c(mVar7.c.b, A.f7514t)) {
                                                        if (mVar9.parent() != null) {
                                                            mVar9.u();
                                                        }
                                                        c1467b.B(mVar9);
                                                    } else {
                                                        if (mVar9.parent() != null) {
                                                            mVar9.u();
                                                        }
                                                        mVar7.z(mVar9);
                                                    }
                                                }
                                                mVar2 = new org.jsoup.nodes.m(f8, c1467b.f7671f);
                                                mVar2.h().a(mVarP.h());
                                                mVar2.M(-1, mVar.k());
                                                mVar.z(mVar2);
                                                c1467b.J(mVarP);
                                                c1467b.i(mVar2);
                                                c1467b.f7595o.add(i13, mVar2);
                                                c1467b.K(mVarP);
                                                iLastIndexOf = c1467b.e.lastIndexOf(mVar);
                                                if (iLastIndexOf != -1) {
                                                    z7 = true;
                                                } else {
                                                    z7 = false;
                                                }
                                                V4.h.b(z7);
                                                c1467b.e.add(iLastIndexOf + 1, mVar2);
                                                i11 = i16 + 1;
                                                strArr5 = strArr;
                                                str7 = str8;
                                                arrayList5 = arrayList6;
                                            } else {
                                                org.jsoup.nodes.m mVar10 = new org.jsoup.nodes.m(c1467b.h(mVarAboveOnStack.r(), D.d), c1467b.f7671f);
                                                ArrayList arrayList7 = c1467b.f7595o;
                                                int iLastIndexOf2 = arrayList7.lastIndexOf(mVarAboveOnStack);
                                                V4.h.b(iLastIndexOf2 != -1);
                                                arrayList7.set(iLastIndexOf2, mVar10);
                                                ArrayList arrayList8 = c1467b.e;
                                                int iLastIndexOf3 = arrayList8.lastIndexOf(mVarAboveOnStack);
                                                V4.h.b(iLastIndexOf3 != -1);
                                                arrayList8.set(iLastIndexOf3, mVar10);
                                                if (mVar9 == mVar) {
                                                    int i17 = 0;
                                                    while (true) {
                                                        if (i17 >= c1467b.f7595o.size()) {
                                                            i17 = -1;
                                                        } else if (mVar10 != c1467b.f7595o.get(i17)) {
                                                            i17++;
                                                        }
                                                    }
                                                    i13 = i17 + 1;
                                                }
                                                if (mVar9.parent() != null) {
                                                    mVar9.u();
                                                }
                                                mVar10.z(mVar9);
                                                mVarAboveOnStack = mVar10;
                                                mVar9 = mVarAboveOnStack;
                                            }
                                            i15++;
                                            str7 = str7;
                                            arrayList5 = arrayList5;
                                            i11 = i11;
                                        }
                                        c1467b.f7595o.add(i13, mVar2);
                                    } catch (IndexOutOfBoundsException unused) {
                                        c1467b.f7595o.add(mVar2);
                                    }
                                    String str9 = str7;
                                    ArrayList arrayList9 = arrayList5;
                                    int i18 = i11;
                                    if (mVar7 != null) {
                                        if (W4.b.c(mVar7.c.b, A.f7514t)) {
                                            if (mVar9.parent() != null) {
                                                mVar9.u();
                                            }
                                            c1467b.B(mVar9);
                                        } else {
                                            if (mVar9.parent() != null) {
                                                mVar9.u();
                                            }
                                            mVar7.z(mVar9);
                                        }
                                    }
                                    mVar2 = new org.jsoup.nodes.m(f8, c1467b.f7671f);
                                    mVar2.h().a(mVarP.h());
                                    mVar2.M(-1, mVar.k());
                                    mVar.z(mVar2);
                                    c1467b.J(mVarP);
                                    c1467b.i(mVar2);
                                    c1467b.K(mVarP);
                                    iLastIndexOf = c1467b.e.lastIndexOf(mVar);
                                    if (iLastIndexOf != -1) {
                                        z7 = true;
                                    } else {
                                        z7 = false;
                                    }
                                    V4.h.b(z7);
                                    c1467b.e.add(iLastIndexOf + 1, mVar2);
                                    i11 = i18 + 1;
                                    strArr5 = strArr;
                                    str7 = str9;
                                    arrayList5 = arrayList9;
                                }
                                break;
                            } else {
                                c1467b.m(this);
                                c1467b.J(mVarP);
                            }
                            return true;
                        }
                        return true;
                    }
                    if (W4.b.c(str6, A.f7512r)) {
                        if (!c1467b.s(str6)) {
                            c1467b.m(this);
                            return false;
                        }
                        c1467b.o(false);
                        if (!c1467b.b(str6)) {
                            c1467b.m(this);
                        }
                        c1467b.popStackToClose(str6);
                        return true;
                    }
                    if (!W4.b.c(str6, strArr4)) {
                        return d(o6, c1467b);
                    }
                    if (!c1467b.s("name")) {
                        if (!c1467b.s(str6)) {
                            c1467b.m(this);
                            return false;
                        }
                        c1467b.o(false);
                        if (!c1467b.b(str6)) {
                            c1467b.m(this);
                        }
                        c1467b.popStackToClose(str6);
                        c1467b.j();
                        return true;
                    }
                    break;
            }
        } else {
            z6 = true;
            if (iB == 3) {
                c1467b.y((I) o6);
                return true;
            }
            if (iB == 4) {
                H h7 = (H) o6;
                if (h7.b.equals(B.f7540x)) {
                    c1467b.m(this);
                    return false;
                }
                if (c1467b.f7599s && B.a(h7)) {
                    c1467b.I();
                    c1467b.x(h7);
                    return true;
                }
                c1467b.I();
                c1467b.x(h7);
                c1467b.f7599s = false;
                return true;
            }
            if (iB == 5 && c1467b.f7596p.size() > 0) {
                c1467b.f7672g = o6;
                return B.f7534r.c(o6, c1467b);
            }
        }
        return z6;
    }

    public final boolean d(O o6, C1467b c1467b) {
        o6.getClass();
        String str = ((L) o6).normalName;
        ArrayList arrayList = c1467b.e;
        if (c1467b.getFromStack(str) == null) {
            c1467b.m(this);
            return false;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            org.jsoup.nodes.m mVar = (org.jsoup.nodes.m) arrayList.get(size);
            if (mVar.c.b.equals(str)) {
                c1467b.n(str);
                if (!c1467b.b(str)) {
                    c1467b.m(this);
                }
                c1467b.popStackToClose(str);
                return true;
            }
            if (W4.b.c(mVar.c.b, C1467b.f7587D)) {
                c1467b.m(this);
                return false;
            }
        }
        return true;
    }
}
