package org.jsoup.parser;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.compress.compressors.CompressorStreamFactory;

/* JADX INFO: renamed from: org.jsoup.parser.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class C1467b extends i1 {
    private org.jsoup.nodes.m contextElement;
    private org.jsoup.nodes.q formElement;
    private org.jsoup.nodes.m headElement;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public B f7592l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public B f7593m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f7594n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ArrayList f7595o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ArrayList f7596p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ArrayList f7597q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public L f7598r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f7599s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f7600t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f7601u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String[] f7602v = {null};

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String[] f7588w = {"applet", "caption", "html", "marquee", "object", "table", "td", "th"};

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String[] f7589x = {"ol", "ul"};

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String[] f7590y = {"button"};

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String[] f7591z = {"html", "table"};

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public static final String[] f7584A = {"optgroup", "option"};

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public static final String[] f7585B = {"dd", "dt", "li", "optgroup", "option", "p", "rb", "rp", "rt", "rtc"};

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public static final String[] f7586C = {"caption", "colgroup", "dd", "dt", "li", "optgroup", "option", "p", "rb", "rp", "rt", "rtc", "tbody", "td", "tfoot", "th", "thead", "tr"};

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public static final String[] f7587D = {"address", "applet", "area", "article", "aside", "base", "basefont", "bgsound", "blockquote", "body", CompressorStreamFactory.BROTLI, "button", "caption", "center", "col", "colgroup", "command", "dd", "details", "dir", "div", "dl", "dt", "embed", "fieldset", "figcaption", "figure", "footer", "form", TypedValues.AttributesType.S_FRAME, "frameset", "h1", "h2", "h3", "h4", "h5", "h6", "head", "header", "hgroup", "hr", "html", "iframe", "img", "input", "isindex", "li", "link", "listing", "marquee", "menu", "meta", "nav", "noembed", "noframes", "noscript", "object", "ol", "p", "param", "plaintext", "pre", "script", "section", "select", "style", "summary", "table", "tbody", "td", "textarea", "tfoot", "th", "thead", "title", "tr", "ul", "wbr", "xmp"};

    public static boolean E(ArrayList arrayList, org.jsoup.nodes.m mVar) {
        int size = arrayList.size();
        int i5 = size - 1;
        int i6 = i5 >= 256 ? size - 257 : 0;
        while (i5 >= i6) {
            if (((org.jsoup.nodes.m) arrayList.get(i5)) == mVar) {
                return true;
            }
            i5--;
        }
        return false;
    }

    public final void A(M m6, boolean z6, boolean z7) {
        F fH = h(m6.o(), this.f7673h);
        D d = this.f7673h;
        org.jsoup.nodes.c cVar = m6.attributes;
        d.a(cVar);
        org.jsoup.nodes.q qVar = new org.jsoup.nodes.q(fH, cVar);
        if (!z7 || !D("template")) {
            this.formElement = qVar;
        }
        C(qVar);
        if (z6) {
            this.e.add(qVar);
        }
    }

    public final void B(org.jsoup.nodes.s sVar) {
        org.jsoup.nodes.m mVarAboveOnStack;
        org.jsoup.nodes.m fromStack = getFromStack("table");
        boolean z6 = false;
        if (fromStack == null) {
            mVarAboveOnStack = (org.jsoup.nodes.m) this.e.get(0);
        } else if (fromStack.parent() != null) {
            mVarAboveOnStack = fromStack.parent();
            z6 = true;
        } else {
            mVarAboveOnStack = aboveOnStack(fromStack);
        }
        if (!z6) {
            mVarAboveOnStack.z(sVar);
        } else {
            V4.h.notNull(fromStack);
            fromStack.B(sVar);
        }
    }

    public final void C(org.jsoup.nodes.s sVar) {
        org.jsoup.nodes.q qVar;
        if (this.e.isEmpty()) {
            this.d.z(sVar);
        } else if (this.f7600t && W4.b.c(a().c.b, A.f7487C)) {
            B(sVar);
        } else {
            a().z(sVar);
        }
        if (sVar instanceof org.jsoup.nodes.m) {
            org.jsoup.nodes.m mVar = (org.jsoup.nodes.m) sVar;
            if (!mVar.c.f7555h || (qVar = this.formElement) == null) {
                return;
            }
            qVar.f7483g.add(mVar);
        }
    }

    public final boolean D(String str) {
        return getFromStack(str) != null;
    }

    public final void F() {
    }

    public final boolean G(O o6, B b) {
        this.f7672g = o6;
        return b.c(o6, this);
    }

    public final void H(B b) {
        this.f7596p.add(b);
    }

    public final void I() {
        boolean z6 = true;
        org.jsoup.nodes.m mVar = this.f7595o.size() > 0 ? (org.jsoup.nodes.m) androidx.collection.a.e(this.f7595o, 1) : null;
        if (mVar == null || E(this.e, mVar)) {
            return;
        }
        int size = this.f7595o.size();
        int i5 = size - 12;
        if (i5 < 0) {
            i5 = 0;
        }
        int i6 = size - 1;
        int i7 = i6;
        while (i7 != i5) {
            i7--;
            mVar = (org.jsoup.nodes.m) this.f7595o.get(i7);
            if (mVar == null || E(this.e, mVar)) {
                z6 = false;
                break;
            }
        }
        while (true) {
            if (!z6) {
                i7++;
                mVar = (org.jsoup.nodes.m) this.f7595o.get(i7);
            }
            V4.h.notNull(mVar);
            org.jsoup.nodes.m mVar2 = new org.jsoup.nodes.m(h(mVar.c.b, this.f7673h), null);
            C(mVar2);
            this.e.add(mVar2);
            if ((mVar.p() ? mVar.h().f7467a : 0) > 0) {
                mVar2.h().a(mVar.h());
            }
            this.f7595o.set(i7, mVar2);
            if (i7 == i6) {
                return;
            } else {
                z6 = false;
            }
        }
    }

    public final void J(org.jsoup.nodes.m mVar) {
        for (int size = this.f7595o.size() - 1; size >= 0; size--) {
            if (((org.jsoup.nodes.m) this.f7595o.get(size)) == mVar) {
                this.f7595o.remove(size);
                return;
            }
        }
    }

    public final void K(org.jsoup.nodes.m mVar) {
        for (int size = this.e.size() - 1; size >= 0; size--) {
            if (((org.jsoup.nodes.m) this.e.get(size)) == mVar) {
                this.e.remove(size);
                return;
            }
        }
    }

    public final void L() {
        int size = this.e.size();
        int i5 = size - 1;
        int i6 = i5 >= 256 ? size - 257 : 0;
        if (this.e.size() == 0) {
            this.f7592l = B.f7523g;
        }
        boolean z6 = false;
        while (i5 >= i6) {
            org.jsoup.nodes.m mVar = (org.jsoup.nodes.m) this.e.get(i5);
            if (i5 == i6) {
                if (this.f7601u) {
                    mVar = this.contextElement;
                }
                z6 = true;
            }
            String str = mVar != null ? mVar.c.b : "";
            str.getClass();
            switch (str) {
                case "frameset":
                    this.f7592l = B.f7536t;
                    return;
                case "template":
                    B bCurrentTemplateMode = currentTemplateMode();
                    V4.h.notNull(bCurrentTemplateMode, "Bug: no template insertion mode on stack!");
                    this.f7592l = bCurrentTemplateMode;
                    return;
                case "select":
                    this.f7592l = B.f7532p;
                    return;
                case "colgroup":
                    this.f7592l = B.f7528l;
                    return;
                case "td":
                case "th":
                    if (!z6) {
                        this.f7592l = B.f7531o;
                        return;
                    }
                    break;
                case "tr":
                    this.f7592l = B.f7530n;
                    return;
                case "body":
                    this.f7592l = B.f7523g;
                    return;
                case "head":
                    if (!z6) {
                        this.f7592l = B.d;
                        return;
                    }
                    break;
                case "html":
                    this.f7592l = this.headElement == null ? B.c : B.f7522f;
                    return;
                case "table":
                    this.f7592l = B.f7525i;
                    return;
                case "tbody":
                case "tfoot":
                case "thead":
                    this.f7592l = B.f7529m;
                    return;
                case "caption":
                    this.f7592l = B.f7527k;
                    return;
            }
            if (z6) {
                this.f7592l = B.f7523g;
                return;
            }
            i5--;
        }
    }

    public final void M() {
        this.formElement = null;
    }

    public final void N(org.jsoup.nodes.m mVar) {
        this.headElement = mVar;
    }

    public org.jsoup.nodes.m aboveOnStack(org.jsoup.nodes.m mVar) {
        for (int size = this.e.size() - 1; size >= 0; size--) {
            if (((org.jsoup.nodes.m) this.e.get(size)) == mVar) {
                return (org.jsoup.nodes.m) this.e.get(size - 1);
            }
        }
        return null;
    }

    @Override // org.jsoup.parser.i1
    public final D c() {
        return D.c;
    }

    public B currentTemplateMode() {
        if (this.f7596p.size() > 0) {
            return (B) androidx.collection.a.e(this.f7596p, 1);
        }
        return null;
    }

    @Override // org.jsoup.parser.i1
    public final boolean d(O o6) {
        this.f7672g = o6;
        return this.f7592l.c(o6, this);
    }

    public org.jsoup.nodes.q getFormElement() {
        return this.formElement;
    }

    public org.jsoup.nodes.m getFromStack(String str) {
        int size = this.e.size();
        int i5 = size - 1;
        int i6 = i5 >= 256 ? size - 257 : 0;
        while (i5 >= i6) {
            org.jsoup.nodes.m mVar = (org.jsoup.nodes.m) this.e.get(i5);
            if (mVar.c.b.equals(str)) {
                return mVar;
            }
            i5--;
        }
        return null;
    }

    public final void i(org.jsoup.nodes.m mVar) {
        int i5 = 0;
        for (int size = this.f7595o.size() - 1; size >= 0; size--) {
            org.jsoup.nodes.m mVar2 = (org.jsoup.nodes.m) this.f7595o.get(size);
            if (mVar2 == null) {
                return;
            }
            if (mVar.c.b.equals(mVar2.c.b) && mVar.h().equals(mVar2.h())) {
                i5++;
            }
            if (i5 == 3) {
                this.f7595o.remove(size);
                return;
            }
        }
    }

    @Override // org.jsoup.parser.i1
    public void initialiseParse(Reader reader, String str, E e) {
        super.initialiseParse(reader, str, e);
        this.f7592l = B.f7521a;
        this.f7593m = null;
        this.f7594n = false;
        this.headElement = null;
        this.formElement = null;
        this.contextElement = null;
        this.f7595o = new ArrayList();
        this.f7596p = new ArrayList();
        this.f7597q = new ArrayList();
        this.f7598r = new L();
        this.f7599s = true;
        this.f7600t = false;
        this.f7601u = false;
    }

    public final void j() {
        while (!this.f7595o.isEmpty()) {
            int size = this.f7595o.size();
            if ((size > 0 ? (org.jsoup.nodes.m) this.f7595o.remove(size - 1) : null) == null) {
                return;
            }
        }
    }

    public final void k(String... strArr) {
        for (int size = this.e.size() - 1; size >= 0; size--) {
            org.jsoup.nodes.m mVar = (org.jsoup.nodes.m) this.e.get(size);
            String str = mVar.c.b;
            String[] strArr2 = W4.b.f830a;
            for (String str2 : strArr) {
                if (str2.equals(str)) {
                    return;
                }
            }
            if (mVar.c.b.equals("html")) {
                return;
            }
            this.e.remove(size);
        }
    }

    public final void l() {
        k("table", "template");
    }

    public final void m(B b) {
        if (this.f7670a.b.a()) {
            this.f7670a.b.add(new xyz.doikki.videoplayer.player.k(this.b, "Unexpected %s token [%s] when in state [%s]", new Object[]{this.f7672g.getClass().getSimpleName(), this.f7672g, b}));
        }
    }

    public final void n(String str) {
        while (W4.b.c(a().c.b, f7585B)) {
            if (str != null && b(str)) {
                return;
            } else {
                F();
            }
        }
    }

    public final void o(boolean z6) {
        String[] strArr = z6 ? f7586C : f7585B;
        while (W4.b.c(a().c.b, strArr)) {
            F();
        }
    }

    public final org.jsoup.nodes.m p(String str) {
        for (int size = this.f7595o.size() - 1; size >= 0; size--) {
            org.jsoup.nodes.m mVar = (org.jsoup.nodes.m) this.f7595o.get(size);
            if (mVar == null) {
                return null;
            }
            if (mVar.c.b.equals(str)) {
                return mVar;
            }
        }
        return null;
    }

    public List<org.jsoup.nodes.s> parseFragment(String str, org.jsoup.nodes.m mVar, String str2, E e) {
        org.jsoup.nodes.m mVar2;
        this.f7592l = B.f7521a;
        initialiseParse(new StringReader(str), str2, e);
        this.contextElement = mVar;
        byte b = 1;
        this.f7601u = true;
        if (mVar != null) {
            if (mVar.ownerDocument() != null) {
                this.d.f7473i = mVar.ownerDocument().f7473i;
            }
            String str3 = mVar.c.b;
            str3.getClass();
            switch (str3.hashCode()) {
                case -1321546630:
                    b = str3.equals("template") ? (byte) 0 : (byte) -1;
                    break;
                case -1191214428:
                    if (!str3.equals("iframe")) {
                        b = -1;
                    }
                    break;
                case -1003243718:
                    b = str3.equals("textarea") ? (byte) 2 : (byte) -1;
                    break;
                case -907685685:
                    b = str3.equals("script") ? (byte) 3 : (byte) -1;
                    break;
                case 118807:
                    b = str3.equals("xml") ? (byte) 4 : (byte) -1;
                    break;
                case 109780401:
                    b = str3.equals("style") ? (byte) 5 : (byte) -1;
                    break;
                case 110371416:
                    b = str3.equals("title") ? (byte) 6 : (byte) -1;
                    break;
                case 1192721831:
                    b = str3.equals("noframes") ? (byte) 7 : (byte) -1;
                    break;
                case 1551550924:
                    b = str3.equals("noscript") ? (byte) 8 : (byte) -1;
                    break;
                case 1973234167:
                    b = str3.equals("plaintext") ? (byte) 9 : (byte) -1;
                    break;
                case 2115613112:
                    b = str3.equals("noembed") ? (byte) 10 : (byte) -1;
                    break;
                default:
                    b = -1;
                    break;
            }
            switch (b) {
                case 0:
                    this.c.c = h1.f7634a;
                    H(B.f7534r);
                    break;
                case 1:
                case 4:
                case 5:
                case 7:
                case 10:
                    this.c.c = h1.e;
                    break;
                case 2:
                case 6:
                    this.c.c = h1.c;
                    break;
                case 3:
                    this.c.c = h1.f7635f;
                    break;
                case 8:
                    this.c.c = h1.f7634a;
                    break;
                case 9:
                    this.c.c = h1.f7636g;
                    break;
                default:
                    this.c.c = h1.f7634a;
                    break;
            }
            mVar2 = new org.jsoup.nodes.m(h(str3, this.f7673h), str2);
            this.d.z(mVar2);
            this.e.add(mVar2);
            L();
            for (org.jsoup.nodes.m mVarParent = mVar; mVarParent != null; mVarParent = mVarParent.parent()) {
                if (mVarParent instanceof org.jsoup.nodes.q) {
                    this.formElement = (org.jsoup.nodes.q) mVarParent;
                }
            }
        } else {
            mVar2 = null;
        }
        g();
        if (mVar == null) {
            return this.d.k();
        }
        List listY = mVar2.y();
        if (!listY.isEmpty()) {
            mVar2.M(-1, listY);
        }
        return mVar2.k();
    }

    public org.jsoup.nodes.m popStackToClose(String str) {
        for (int size = this.e.size() - 1; size >= 0; size--) {
            org.jsoup.nodes.m mVar = (org.jsoup.nodes.m) this.e.get(size);
            this.e.remove(size);
            if (mVar.c.b.equals(str)) {
                return mVar;
            }
        }
        return null;
    }

    public B popTemplateMode() {
        if (this.f7596p.size() <= 0) {
            return null;
        }
        ArrayList arrayList = this.f7596p;
        return (B) arrayList.remove(arrayList.size() - 1);
    }

    public final org.jsoup.nodes.m q() {
        return this.headElement;
    }

    public final boolean r(String str) {
        String[] strArr = this.f7602v;
        strArr[0] = str;
        return u(strArr, f7588w, f7590y);
    }

    public final boolean s(String str) {
        String[] strArr = this.f7602v;
        strArr[0] = str;
        return u(strArr, f7588w, null);
    }

    public final boolean t(String str) {
        for (int size = this.e.size() - 1; size >= 0; size--) {
            String str2 = ((org.jsoup.nodes.m) this.e.get(size)).c.b;
            if (str2.equals(str)) {
                return true;
            }
            if (!W4.b.c(str2, f7584A)) {
                return false;
            }
        }
        throw new IllegalArgumentException("Should not be reachable");
    }

    public final String toString() {
        return "TreeBuilder{currentToken=" + this.f7672g + ", state=" + this.f7592l + ", currentElement=" + a() + '}';
    }

    public final boolean u(String[] strArr, String[] strArr2, String[] strArr3) {
        int size = this.e.size();
        int i5 = size - 1;
        int i6 = i5 > 100 ? size - 101 : 0;
        while (i5 >= i6) {
            String str = ((org.jsoup.nodes.m) this.e.get(i5)).c.b;
            if (!W4.b.c(str, strArr)) {
                if (W4.b.c(str, strArr2) || (strArr3 != null && W4.b.c(str, strArr3))) {
                    break;
                }
                i5--;
            } else {
                return true;
            }
        }
        return false;
    }

    public final boolean v(String str) {
        String[] strArr = this.f7602v;
        strArr[0] = str;
        return u(strArr, f7591z, null);
    }

    public final org.jsoup.nodes.m w(M m6) {
        if (m6.n()) {
            org.jsoup.nodes.c cVar = m6.attributes;
            if (cVar.f7467a != 0 && cVar.g(this.f7673h) > 0) {
                Object[] objArr = {m6.normalName};
                C c = this.f7670a.b;
                if (c.a()) {
                    c.add(new xyz.doikki.videoplayer.player.k(this.b, "Dropped duplicate attribute(s) in tag [%s]", objArr));
                }
            }
        }
        if (!m6.f7559g) {
            F fH = h(m6.o(), this.f7673h);
            D d = this.f7673h;
            org.jsoup.nodes.c cVar2 = m6.attributes;
            d.a(cVar2);
            org.jsoup.nodes.m mVar = new org.jsoup.nodes.m(fH, null, cVar2);
            C(mVar);
            this.e.add(mVar);
            return mVar;
        }
        org.jsoup.nodes.m mVarZ = z(m6);
        this.e.add(mVarZ);
        Q q6 = this.c;
        q6.c = h1.f7634a;
        L l6 = this.f7598r;
        l6.f();
        l6.p(mVarZ.c.f7552a);
        q6.h(l6);
        return mVarZ;
    }

    public final void x(H h6) {
        org.jsoup.nodes.s fVar;
        org.jsoup.nodes.m mVarA = a();
        String str = mVarA.c.b;
        String str2 = h6.b;
        if (h6 instanceof G) {
            fVar = new org.jsoup.nodes.d(str2);
        } else {
            fVar = (str.equals("script") || str.equals("style")) ? new org.jsoup.nodes.f(str2) : new org.jsoup.nodes.u(str2);
        }
        mVarA.z(fVar);
    }

    public final void y(I i5) {
        String string = i5.c;
        if (string == null) {
            string = i5.b.toString();
        }
        C(new org.jsoup.nodes.e(string));
    }

    public final org.jsoup.nodes.m z(M m6) {
        F fH = h(m6.o(), this.f7673h);
        D d = this.f7673h;
        org.jsoup.nodes.c cVar = m6.attributes;
        d.a(cVar);
        org.jsoup.nodes.m mVar = new org.jsoup.nodes.m(fH, null, cVar);
        C(mVar);
        if (m6.f7559g) {
            if (!F.f7545j.containsKey(fH.f7552a)) {
                fH.f7553f = true;
            } else if (!fH.e) {
                Q q6 = this.c;
                Object[] objArr = {fH.b};
                C c = q6.b;
                if (c.a()) {
                    c.add(new xyz.doikki.videoplayer.player.k(q6.f7564a, "Tag [%s] cannot be self closing; not a void tag", objArr));
                    return mVar;
                }
            }
        }
        return mVar;
    }
}
