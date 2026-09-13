package org.jsoup.parser;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class D {
    public static final D c = new D(false, false);
    public static final D d = new D(true, true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f7543a;
    public final boolean b;

    public D(boolean z6, boolean z7) {
        this.f7543a = z6;
        this.b = z7;
    }

    public final void a(org.jsoup.nodes.c cVar) {
        if (cVar == null || this.b) {
            return;
        }
        for (int i5 = 0; i5 < cVar.f7467a; i5++) {
            String[] strArr = cVar.b;
            strArr[i5] = p051j0.i.i(strArr[i5]);
        }
    }

    public final String b(String str) {
        String strTrim = str.trim();
        return !this.f7543a ? p051j0.i.i(strTrim) : strTrim;
    }
}
