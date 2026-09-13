package org.jsoup.nodes;

import io.flutter.plugins.firebase.crashlytics.Constants;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.jvm.internal.D;
import org.apache.commons.compress.compressors.CompressorStreamFactory;
import org.jsoup.parser.F;
import p079o.AbstractC1282k;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class m extends s {
    public static final List e = Collections.EMPTY_LIST;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f7476f;
    private c attributes;
    public final F c;
    public List d;
    private WeakReference<List<m>> shadowChildrenRef;

    static {
        Pattern.compile("\\s+");
        f7476f = "/baseUri";
    }

    public m(F f6, String str, c cVar) {
        V4.h.notNull(f6);
        this.d = s.b;
        this.attributes = cVar;
        this.c = f6;
        if (str != null) {
            V4.h.notNull(str);
            G(str);
        }
    }

    public static int L(m mVar, List list) {
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            if (list.get(i5) == mVar) {
                return i5;
            }
        }
        return 0;
    }

    public static boolean preserveWhitespace(s sVar) {
        if (sVar instanceof m) {
            m mVarParent = (m) sVar;
            int i5 = 0;
            while (!mVarParent.c.f7554g) {
                mVarParent = mVarParent.parent();
                i5++;
                if (i5 >= 6 || mVarParent == null) {
                }
            }
            return true;
        }
        return false;
    }

    public final m A(String str) {
        m mVar = new m(F.e(str, AbstractC1282k.e(this).c), i());
        z(mVar);
        return mVar;
    }

    public final void B(s sVar) {
        V4.h.notNull(sVar);
        V4.h.notNull(this.parentNode);
        this.parentNode.e(this.f7484a, sVar);
    }

    public final List C() {
        List<m> list;
        if (this.d.size() == 0) {
            return e;
        }
        WeakReference<List<m>> weakReference = this.shadowChildrenRef;
        if (weakReference != null && (list = weakReference.get()) != null) {
            return list;
        }
        int size = this.d.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i5 = 0; i5 < size; i5++) {
            s sVar = (s) this.d.get(i5);
            if (sVar instanceof m) {
                arrayList.add((m) sVar);
            }
        }
        this.shadowChildrenRef = new WeakReference<>(arrayList);
        return arrayList;
    }

    public final Y4.f D() {
        return new Y4.f(C());
    }

    @Override // org.jsoup.nodes.s
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public m l() {
        return (m) super.l();
    }

    public final String F() {
        StringBuilder sbB = W4.b.b();
        for (s sVar : this.d) {
            if (sVar instanceof f) {
                sbB.append(((f) sVar).z());
            } else if (sVar instanceof e) {
                sbB.append(((e) sVar).z());
            } else if (sVar instanceof m) {
                sbB.append(((m) sVar).F());
            } else if (sVar instanceof d) {
                sbB.append(((d) sVar).z());
            }
        }
        return W4.b.g(sbB);
    }

    public final void G(String str) {
        h().put(f7476f, str);
    }

    public final int H() {
        if (parent() == null) {
            return 0;
        }
        return L(this, parent().C());
    }

    public final boolean I(String str) {
        String str2;
        c cVar = this.attributes;
        if (cVar == null) {
            return false;
        }
        String strI = cVar.i(Constants.CLASS);
        int length = strI.length();
        int length2 = str.length();
        if (length != 0 && length >= length2) {
            if (length == length2) {
                return str.equalsIgnoreCase(strI);
            }
            int i5 = 0;
            boolean z6 = false;
            int i6 = 0;
            while (i5 < length) {
                if (!Character.isWhitespace(strI.charAt(i5))) {
                    str2 = str;
                    if (!z6) {
                        i6 = i5;
                        z6 = true;
                    }
                } else if (z6) {
                    if (i5 - i6 == length2) {
                        str2 = str;
                        if (strI.regionMatches(true, i6, str2, 0, length2)) {
                            return true;
                        }
                    } else {
                        str2 = str;
                    }
                    z6 = false;
                } else {
                    str2 = str;
                }
                i5++;
                str = str2;
            }
            String str3 = str;
            if (z6 && length - i6 == length2) {
                return strI.regionMatches(true, i6, str3, 0, length2);
            }
        }
        return false;
    }

    public final String J() {
        StringBuilder sbB = W4.b.b();
        int size = this.d.size();
        for (int i5 = 0; i5 < size; i5++) {
            s sVar = (s) this.d.get(i5);
            i iVarOwnerDocument = sVar.ownerDocument();
            if (iVarOwnerDocument == null) {
                iVarOwnerDocument = new i("");
            }
            D.c(new xyz.doikki.videoplayer.player.k(sbB, iVarOwnerDocument.f7471g), sVar);
        }
        String strG = W4.b.g(sbB);
        i iVarOwnerDocument2 = ownerDocument();
        if (iVarOwnerDocument2 == null) {
            iVarOwnerDocument2 = new i("");
        }
        return iVarOwnerDocument2.f7471g.d ? strG.trim() : strG;
    }

    public final String K() {
        c cVar = this.attributes;
        return cVar != null ? cVar.i("id") : "";
    }

    public final void M(int i5, List list) {
        V4.h.notNull(list, "Children collection to be inserted must not be null.");
        int size = this.d.size();
        if (i5 < 0) {
            i5 += size + 1;
        }
        V4.h.a("Insert position out of bounds.", i5 >= 0 && i5 <= size);
        e(i5, (s[]) new ArrayList(list).toArray(new s[0]));
    }

    public final void N() {
        this.shadowChildrenRef = null;
    }

    public final String O() {
        StringBuilder sbB = W4.b.b();
        for (int i5 = 0; i5 < this.d.size(); i5++) {
            s sVar = (s) this.d.get(i5);
            if (sVar instanceof u) {
                u uVar = (u) sVar;
                String strZ = uVar.z();
                if (preserveWhitespace(uVar.parentNode) || (uVar instanceof d)) {
                    sbB.append(strZ);
                } else {
                    W4.b.a(sbB, strZ, u.C(sbB));
                }
            } else if ((sVar instanceof m) && ((m) sVar).c.b.equals(CompressorStreamFactory.BROTLI) && !u.C(sbB)) {
                sbB.append(" ");
            }
        }
        return W4.b.g(sbB).trim();
    }

    @Override // org.jsoup.nodes.s
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public final m x() {
        s sVar = this;
        while (true) {
            s sVar2 = sVar.parentNode;
            if (sVar2 == null) {
                return (m) sVar;
            }
            sVar = sVar2;
        }
    }

    public final Y4.f Q(String str) {
        V4.h.notEmpty(str);
        Y4.p pVarH = Y4.r.h(str);
        V4.h.notNull(pVarH);
        V4.h.notNull(this);
        Y4.f fVar = new Y4.f();
        D.c(new W1.a(this, fVar, pVarH), this);
        return fVar;
    }

    public final Y4.f R() {
        if (this.parentNode == null) {
            return new Y4.f(0);
        }
        List<m> listC = parent().C();
        Y4.f fVar = new Y4.f(listC.size() - 1);
        for (m mVar : listC) {
            if (mVar != this) {
                fVar.add(mVar);
            }
        }
        return fVar;
    }

    public final String S() {
        StringBuilder sbB = W4.b.b();
        D.c(new k(sbB), this);
        return W4.b.g(sbB).trim();
    }

    public m closest(String str) {
        return closest(Y4.r.h(str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m getElementById(String str) {
        V4.h.notEmpty(str);
        Y4.h hVar = new Y4.h(str, 6, false);
        Y4.f fVar = new Y4.f();
        D.c(new W1.a(this, fVar, hVar), this);
        if (fVar.size() > 0) {
            return (m) fVar.get(0);
        }
        return null;
    }

    @Override // org.jsoup.nodes.s
    public final c h() {
        if (this.attributes == null) {
            this.attributes = new c();
        }
        return this.attributes;
    }

    @Override // org.jsoup.nodes.s
    public final String i() {
        for (m mVarParent = this; mVarParent != null; mVarParent = mVarParent.parent()) {
            c cVar = mVarParent.attributes;
            if (cVar != null) {
                String str = f7476f;
                if (cVar.j(str) != -1) {
                    return mVarParent.attributes.h(str);
                }
            }
        }
        return "";
    }

    @Override // org.jsoup.nodes.s
    public final int j() {
        return this.d.size();
    }

    @Override // org.jsoup.nodes.s
    public final s m() {
        this.d.clear();
        return this;
    }

    @Override // org.jsoup.nodes.s
    public final List n() {
        if (this.d == s.b) {
            this.d = new l(this, 4);
        }
        return this.d;
    }

    public m nextElementSibling() {
        if (this.parentNode == null) {
            return null;
        }
        List listC = parent().C();
        int iL = L(this, listC) + 1;
        if (listC.size() > iL) {
            return (m) listC.get(iL);
        }
        return null;
    }

    @Override // org.jsoup.nodes.s
    public void outerHtmlHead(Appendable appendable, int i5, h hVar) throws IOException {
        boolean z6;
        boolean z7 = hVar.d;
        F f6 = this.c;
        if (z7 && ((f6.d || (parent() != null && parent().c.d)) && ((f6.c || f6.e || ((parent() != null && !parent().c.c) || previousSibling() == null)) && (!(appendable instanceof StringBuilder) || ((StringBuilder) appendable).length() > 0)))) {
            indent(appendable, i5, hVar);
        }
        appendable.append('<').append(f6.f7552a);
        c cVar = this.attributes;
        if (cVar != null) {
            cVar.html(appendable, hVar);
        }
        if (!this.d.isEmpty() || (!(z6 = f6.e) && !f6.f7553f)) {
            appendable.append('>');
        } else if (hVar.f7470f == g.f7468a && z6) {
            appendable.append('>');
        } else {
            appendable.append(" />");
        }
    }

    @Override // org.jsoup.nodes.s
    public void outerHtmlTail(Appendable appendable, int i5, h hVar) throws IOException {
        boolean zIsEmpty = this.d.isEmpty();
        F f6 = this.c;
        if (zIsEmpty && (f6.e || f6.f7553f)) {
            return;
        }
        if (hVar.d && !this.d.isEmpty() && f6.d) {
            indent(appendable, i5, hVar);
        }
        appendable.append("</").append(f6.f7552a).append('>');
    }

    @Override // org.jsoup.nodes.s
    public final boolean p() {
        return this.attributes != null;
    }

    public m previousElementSibling() {
        List listC;
        int iL;
        if (this.parentNode != null && (iL = L(this, (listC = parent().C()))) > 0) {
            return (m) listC.get(iL - 1);
        }
        return null;
    }

    @Override // org.jsoup.nodes.s
    public String r() {
        return this.c.f7552a;
    }

    public m selectFirst(String str) {
        return Y4.t.selectFirst(str, this);
    }

    public final void z(s sVar) {
        V4.h.notNull(sVar);
        sVar.getClass();
        V4.h.notNull(this);
        s sVar2 = sVar.parentNode;
        if (sVar2 != null) {
            sVar2.v(sVar);
        }
        sVar.parentNode = this;
        n();
        this.d.add(sVar);
        sVar.f7484a = this.d.size() - 1;
    }

    public m closest(Y4.p pVar) {
        V4.h.notNull(pVar);
        m mVarX = x();
        m mVarParent = this;
        while (!pVar.a(mVarX, mVarParent)) {
            mVarParent = mVarParent.parent();
            if (mVarParent == null) {
                return null;
            }
        }
        return mVarParent;
    }

    @Override // org.jsoup.nodes.s
    public m doClone(s sVar) {
        m mVar = (m) super.doClone(sVar);
        c cVar = this.attributes;
        mVar.attributes = cVar != null ? cVar.clone() : null;
        l lVar = new l(mVar, this.d.size());
        mVar.d = lVar;
        lVar.addAll(this.d);
        return mVar;
    }

    @Override // org.jsoup.nodes.s
    public final m parent() {
        return (m) this.parentNode;
    }

    public m selectFirst(Y4.p pVar) {
        return Y4.b.findFirst(pVar, this);
    }

    public m(F f6, String str) {
        this(f6, str, null);
    }
}
