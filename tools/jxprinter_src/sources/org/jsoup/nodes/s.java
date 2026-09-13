package org.jsoup.nodes;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.apache.logging.log4j.util.Chars;
import org.jsoup.parser.D;
import p079o.AbstractC1282k;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class s implements Cloneable {
    public static final List b = Collections.EMPTY_LIST;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7484a;
    s parentNode;

    public String a(String str) {
        V4.h.notEmpty(str);
        if (!p() || h().k(str) == -1) {
            return "";
        }
        String strI = i();
        String strI2 = h().i(str);
        String[] strArr = W4.b.f830a;
        try {
            try {
                return W4.b.resolve(new URL(strI), strI2).toExternalForm();
            } catch (MalformedURLException unused) {
                return new URL(strI2).toExternalForm();
            }
        } catch (MalformedURLException unused2) {
            return W4.b.c.matcher(strI2).find() ? strI2 : "";
        }
    }

    public s doClone(s sVar) {
        try {
            s sVar2 = (s) super.clone();
            sVar2.parentNode = sVar;
            sVar2.f7484a = sVar == null ? 0 : this.f7484a;
            return sVar2;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public final void e(int i5, s... sVarArr) {
        V4.h.notNull(sVarArr);
        if (sVarArr.length == 0) {
            return;
        }
        List listN = n();
        s sVarParent = sVarArr[0].parent();
        if (sVarParent != null && sVarParent.j() == sVarArr.length) {
            List listN2 = sVarParent.n();
            int length = sVarArr.length;
            while (true) {
                int i6 = length - 1;
                if (length <= 0) {
                    boolean z6 = j() == 0;
                    sVarParent.m();
                    listN.addAll(i5, Arrays.asList(sVarArr));
                    int length2 = sVarArr.length;
                    while (true) {
                        int i7 = length2 - 1;
                        if (length2 <= 0) {
                            break;
                        }
                        sVarArr[i7].parentNode = this;
                        length2 = i7;
                    }
                    if (z6 && sVarArr[0].f7484a == 0) {
                        return;
                    }
                    t(i5);
                    return;
                }
                if (sVarArr[i6] != listN2.get(i6)) {
                    break;
                } else {
                    length = i6;
                }
            }
        }
        for (s sVar : sVarArr) {
            if (sVar == null) {
                throw new IllegalArgumentException("Array must not contain any null objects");
            }
        }
        for (s sVar2 : sVarArr) {
            sVar2.getClass();
            V4.h.notNull(this);
            s sVar3 = sVar2.parentNode;
            if (sVar3 != null) {
                sVar3.v(sVar2);
            }
            sVar2.parentNode = this;
        }
        listN.addAll(i5, Arrays.asList(sVarArr));
        t(i5);
    }

    public boolean equals(Object obj) {
        return this == obj;
    }

    public String f(String str) {
        V4.h.notNull(str);
        if (!p()) {
            return "";
        }
        String strI = h().i(str);
        if (strI.length() > 0) {
            return strI;
        }
        return str.startsWith("abs:") ? a(str.substring(4)) : "";
    }

    public void g(String str, String str2) {
        D d = AbstractC1282k.e(this).c;
        d.getClass();
        String strTrim = str.trim();
        if (!d.b) {
            strTrim = p051j0.i.i(strTrim);
        }
        h().putIgnoreCase(strTrim, str2);
    }

    public abstract c h();

    public boolean hasSameValue(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return s().equals(((s) obj).s());
    }

    public abstract String i();

    public void indent(Appendable appendable, int i5, h hVar) {
        String strValueOf;
        Appendable appendableAppend = appendable.append('\n');
        int i6 = i5 * hVar.e;
        if (i6 < 0) {
            String[] strArr = W4.b.f830a;
            throw new IllegalArgumentException("width must be > 0");
        }
        String[] strArr2 = W4.b.f830a;
        if (i6 < 21) {
            strValueOf = strArr2[i6];
        } else {
            int iMin = Math.min(i6, 30);
            char[] cArr = new char[iMin];
            for (int i7 = 0; i7 < iMin; i7++) {
                cArr[i7] = Chars.SPACE;
            }
            strValueOf = String.valueOf(cArr);
        }
        appendableAppend.append(strValueOf);
    }

    public abstract int j();

    public final List k() {
        if (j() == 0) {
            return b;
        }
        List listN = n();
        ArrayList arrayList = new ArrayList(listN.size());
        arrayList.addAll(listN);
        return Collections.unmodifiableList(arrayList);
    }

    @Override // 
    public s l() {
        s sVarDoClone = doClone(null);
        LinkedList linkedList = new LinkedList();
        linkedList.add(sVarDoClone);
        while (!linkedList.isEmpty()) {
            s sVar = (s) linkedList.remove();
            int iJ = sVar.j();
            for (int i5 = 0; i5 < iJ; i5++) {
                List listN = sVar.n();
                s sVarDoClone2 = ((s) listN.get(i5)).doClone(sVar);
                listN.set(i5, sVarDoClone2);
                linkedList.add(sVarDoClone2);
            }
        }
        return sVarDoClone;
    }

    public abstract s m();

    public abstract List n();

    public s nextSibling() {
        s sVar = this.parentNode;
        if (sVar == null) {
            return null;
        }
        List listN = sVar.n();
        int i5 = this.f7484a + 1;
        if (listN.size() > i5) {
            return (s) listN.get(i5);
        }
        return null;
    }

    public boolean o(String str) {
        V4.h.notNull(str);
        if (!p()) {
            return false;
        }
        if (str.startsWith("abs:")) {
            String strSubstring = str.substring(4);
            if (h().k(strSubstring) != -1 && !a(strSubstring).isEmpty()) {
                return true;
            }
        }
        return h().k(str) != -1;
    }

    public abstract void outerHtmlHead(Appendable appendable, int i5, h hVar);

    public abstract void outerHtmlTail(Appendable appendable, int i5, h hVar);

    public i ownerDocument() {
        s sVarX = x();
        if (sVarX instanceof i) {
            return (i) sVarX;
        }
        return null;
    }

    public abstract boolean p();

    public s parent() {
        return this.parentNode;
    }

    public final s parentNode() {
        return this.parentNode;
    }

    public s previousSibling() {
        s sVar = this.parentNode;
        if (sVar != null && this.f7484a > 0) {
            return (s) sVar.n().get(this.f7484a - 1);
        }
        return null;
    }

    public final boolean q() {
        return this.parentNode != null;
    }

    public abstract String r();

    public String s() {
        StringBuilder sbB = W4.b.b();
        i iVarOwnerDocument = ownerDocument();
        if (iVarOwnerDocument == null) {
            iVarOwnerDocument = new i("");
        }
        kotlin.jvm.internal.D.c(new xyz.doikki.videoplayer.player.k(sbB, iVarOwnerDocument.f7471g), this);
        return W4.b.g(sbB);
    }

    public final void t(int i5) {
        if (j() == 0) {
            return;
        }
        List listN = n();
        while (i5 < listN.size()) {
            ((s) listN.get(i5)).f7484a = i5;
            i5++;
        }
    }

    public String toString() {
        return s();
    }

    public final void u() {
        V4.h.notNull(this.parentNode);
        this.parentNode.v(this);
    }

    public s unwrap() {
        V4.h.notNull(this.parentNode);
        List listN = n();
        s sVar = listN.size() > 0 ? (s) listN.get(0) : null;
        this.parentNode.e(this.f7484a, (s[]) n().toArray(new s[0]));
        u();
        return sVar;
    }

    public void v(s sVar) {
        V4.h.b(sVar.parentNode == this);
        int i5 = sVar.f7484a;
        n().remove(i5);
        t(i5);
        sVar.parentNode = null;
    }

    public final void w(t tVar) {
        V4.h.notNull(tVar);
        V4.h.notNull(this.parentNode);
        s sVar = this.parentNode;
        sVar.getClass();
        V4.h.b(this.parentNode == sVar);
        V4.h.notNull(tVar);
        s sVar2 = tVar.parentNode;
        if (sVar2 != null) {
            sVar2.v(tVar);
        }
        int i5 = this.f7484a;
        sVar.n().set(i5, tVar);
        tVar.parentNode = sVar;
        tVar.f7484a = i5;
        this.parentNode = null;
    }

    public s x() {
        s sVar = this;
        while (true) {
            s sVar2 = sVar.parentNode;
            if (sVar2 == null) {
                return sVar;
            }
            sVar = sVar2;
        }
    }

    public final List y() {
        s sVar = this.parentNode;
        if (sVar == null) {
            return Collections.EMPTY_LIST;
        }
        List<s> listN = sVar.n();
        ArrayList arrayList = new ArrayList(listN.size() - 1);
        for (s sVar2 : listN) {
            if (sVar2 != this) {
                arrayList.add(sVar2);
            }
        }
        return arrayList;
    }
}
