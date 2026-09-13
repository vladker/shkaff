package org.jsoup.parser;

import java.io.Reader;
import kotlinx.serialization.json.internal.AbstractC1127c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class j1 extends i1 {
    @Override // org.jsoup.parser.i1
    public final D c() {
        return D.d;
    }

    @Override // org.jsoup.parser.i1
    public final boolean d(O o6) {
        org.jsoup.nodes.v vVarAsXmlDeclaration;
        String str;
        int iB = p050j.n.b(o6.f7560a);
        if (iB == 0) {
            J j6 = (J) o6;
            org.jsoup.nodes.j jVar = new org.jsoup.nodes.j(this.f7673h.b(j6.b.toString()), j6.d.toString(), j6.e.toString());
            String str2 = j6.c;
            if (str2 != null) {
                jVar.g("pubSysKey", str2);
            }
            a().z(jVar);
            return true;
        }
        org.jsoup.nodes.m mVar = null;
        if (iB == 1) {
            M m6 = (M) o6;
            F fH = h(m6.o(), this.f7673h);
            if (m6.n()) {
                m6.attributes.g(this.f7673h);
            }
            D d = this.f7673h;
            org.jsoup.nodes.c cVar = m6.attributes;
            d.a(cVar);
            org.jsoup.nodes.m mVar2 = new org.jsoup.nodes.m(fH, null, cVar);
            a().z(mVar2);
            if (!m6.f7559g) {
                this.e.add(mVar2);
                return true;
            }
            if (!F.f7545j.containsKey(fH.f7552a)) {
                fH.f7553f = true;
            }
        } else if (iB == 2) {
            String strB = this.f7673h.b(((L) o6).tagName);
            int size = this.e.size();
            int i5 = size + (-1) >= 256 ? size - 257 : 0;
            for (int size2 = this.e.size() - 1; size2 >= i5; size2--) {
                org.jsoup.nodes.m mVar3 = (org.jsoup.nodes.m) this.e.get(size2);
                if (mVar3.r().equals(strB)) {
                    mVar = mVar3;
                    break;
                }
            }
            if (mVar != null) {
                for (int size3 = this.e.size() - 1; size3 >= 0; size3--) {
                    org.jsoup.nodes.m mVar4 = (org.jsoup.nodes.m) this.e.get(size3);
                    this.e.remove(size3);
                    if (mVar4 == mVar) {
                        break;
                    }
                }
            }
        } else {
            if (iB == 3) {
                I i6 = (I) o6;
                String string = i6.c;
                if (string == null) {
                    string = i6.b.toString();
                }
                org.jsoup.nodes.e eVar = new org.jsoup.nodes.e(string);
                if (i6.d) {
                    String strZ = eVar.z();
                    if (strZ.length() > 1 && ((strZ.startsWith("!") || strZ.startsWith("?")) && (vVarAsXmlDeclaration = eVar.asXmlDeclaration()) != null)) {
                        eVar = vVarAsXmlDeclaration;
                    }
                }
                a().z(eVar);
                return true;
            }
            if (iB == 4) {
                H h6 = (H) o6;
                String str3 = h6.b;
                a().z(h6 instanceof G ? new org.jsoup.nodes.d(str3) : new org.jsoup.nodes.u(str3));
                return true;
            }
            if (iB != 5) {
                switch (o6.f7560a) {
                    case 1:
                        str = "Doctype";
                        break;
                    case 2:
                        str = "StartTag";
                        break;
                    case 3:
                        str = "EndTag";
                        break;
                    case 4:
                        str = "Comment";
                        break;
                    case 5:
                        str = "Character";
                        break;
                    case 6:
                        str = "EOF";
                        break;
                    default:
                        str = AbstractC1127c.NULL;
                        break;
                }
                throw new IllegalArgumentException("Unexpected token type: ".concat(str));
            }
        }
        return true;
    }

    @Override // org.jsoup.parser.i1
    public void initialiseParse(Reader reader, String str, E e) {
        super.initialiseParse(reader, str, e);
        this.e.add(this.d);
        org.jsoup.nodes.h hVar = this.d.f7471g;
        hVar.f7470f = org.jsoup.nodes.g.b;
        hVar.f7469a = org.jsoup.nodes.o.xhtml;
        hVar.d = false;
    }
}
