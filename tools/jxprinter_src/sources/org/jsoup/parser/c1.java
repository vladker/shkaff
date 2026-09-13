package org.jsoup.parser;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final enum c1 extends h1 {
    public c1() {
        super("CdataSection", 66);
    }

    @Override // org.jsoup.parser.h1
    public final void d(Q q6, C1465a c1465a) {
        String strC;
        int iV = c1465a.v("]]>");
        if (iV != -1) {
            strC = C1465a.c(c1465a.f7577a, c1465a.f7580h, c1465a.e, iV);
            c1465a.e += iV;
        } else {
            int i5 = c1465a.c;
            int i6 = c1465a.e;
            if (i5 - i6 < 3) {
                c1465a.b();
                char[] cArr = c1465a.f7577a;
                String[] strArr = c1465a.f7580h;
                int i7 = c1465a.e;
                strC = C1465a.c(cArr, strArr, i7, c1465a.c - i7);
                c1465a.e = c1465a.c;
            } else {
                int i8 = i5 - 2;
                strC = C1465a.c(c1465a.f7577a, c1465a.f7580h, i6, i8 - i6);
                c1465a.e = i8;
            }
        }
        q6.f7567h.append(strC);
        if (c1465a.p("]]>") || c1465a.o()) {
            String string = q6.f7567h.toString();
            G g6 = new G();
            g6.b = string;
            q6.h(g6);
            q6.c = h1.f7634a;
        }
    }
}
