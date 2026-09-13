package org.jsoup.parser;

import java.util.ArrayList;

/* JADX INFO: renamed from: org.jsoup.parser.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final enum C1469c extends B {
    public C1469c() {
        super("InTableText", 9);
    }

    @Override // org.jsoup.parser.B
    public final boolean c(O o6, C1467b c1467b) {
        if (o6.f7560a == 5) {
            H h6 = (H) o6;
            if (h6.b.equals(B.f7540x)) {
                c1467b.m(this);
                return false;
            }
            c1467b.f7597q.add(h6.b);
            return true;
        }
        if (c1467b.f7597q.size() > 0) {
            ArrayList arrayList = c1467b.f7597q;
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                Object obj = arrayList.get(i5);
                i5++;
                String str = (String) obj;
                if (W4.b.d(str)) {
                    H h7 = new H();
                    h7.b = str;
                    c1467b.x(h7);
                } else {
                    c1467b.m(this);
                    boolean zC = W4.b.c(c1467b.a().c.b, A.f7487C);
                    B b = B.f7523g;
                    if (zC) {
                        c1467b.f7600t = true;
                        H h8 = new H();
                        h8.b = str;
                        c1467b.G(h8, b);
                        c1467b.f7600t = false;
                    } else {
                        H h9 = new H();
                        h9.b = str;
                        c1467b.G(h9, b);
                    }
                }
            }
            c1467b.f7597q = new ArrayList();
        }
        c1467b.f7592l = c1467b.f7593m;
        return c1467b.d(o6);
    }
}
