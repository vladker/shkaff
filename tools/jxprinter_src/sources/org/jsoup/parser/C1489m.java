package org.jsoup.parser;

/* JADX INFO: renamed from: org.jsoup.parser.m, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final enum C1489m extends B {
    public C1489m() {
        super("Initial", 0);
    }

    @Override // org.jsoup.parser.B
    public final boolean c(O o6, C1467b c1467b) {
        if (B.a(o6)) {
            return true;
        }
        if (o6.a()) {
            c1467b.y((I) o6);
            return true;
        }
        boolean zB = o6.b();
        C1500s c1500s = B.b;
        if (!zB) {
            c1467b.f7592l = c1500s;
            return c1467b.d(o6);
        }
        J j6 = (J) o6;
        org.jsoup.nodes.j jVar = new org.jsoup.nodes.j(c1467b.f7673h.b(j6.b.toString()), j6.d.toString(), j6.e.toString());
        String str = j6.c;
        if (str != null) {
            jVar.g("pubSysKey", str);
        }
        c1467b.d.z(jVar);
        if (j6.f7557f) {
            c1467b.d.f7473i = 2;
        }
        c1467b.f7592l = c1500s;
        return true;
    }
}
