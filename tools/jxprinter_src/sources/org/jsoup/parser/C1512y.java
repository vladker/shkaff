package org.jsoup.parser;

/* JADX INFO: renamed from: org.jsoup.parser.y, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final enum C1512y extends B {
    public C1512y() {
        super("Text", 7);
    }

    @Override // org.jsoup.parser.B
    public final boolean c(O o6, C1467b c1467b) {
        if (o6.f7560a == 5) {
            c1467b.x((H) o6);
            return true;
        }
        if (o6.c()) {
            c1467b.m(this);
            c1467b.F();
            c1467b.f7592l = c1467b.f7593m;
            return c1467b.d(o6);
        }
        if (!o6.d()) {
            return true;
        }
        c1467b.F();
        c1467b.f7592l = c1467b.f7593m;
        return true;
    }
}
