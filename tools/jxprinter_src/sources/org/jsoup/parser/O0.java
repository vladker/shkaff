package org.jsoup.parser;

import org.apache.logging.log4j.util.Chars;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final enum O0 extends h1 {
    public O0() {
        super("AfterDoctypeName", 53);
    }

    @Override // org.jsoup.parser.h1
    public final void d(Q q6, C1465a c1465a) {
        boolean zO = c1465a.o();
        C1470c0 c1470c0 = h1.f7634a;
        if (zO) {
            q6.l(this);
            q6.f7572m.f7557f = true;
            q6.j();
            q6.c = c1470c0;
            return;
        }
        if (c1465a.s('\t', '\n', Chars.CR, '\f', Chars.SPACE)) {
            c1465a.a();
            return;
        }
        if (c1465a.r('>')) {
            q6.j();
            q6.a(c1470c0);
            return;
        }
        if (c1465a.q("PUBLIC")) {
            q6.f7572m.c = "PUBLIC";
            q6.c = h1.f7609D0;
        } else if (c1465a.q("SYSTEM")) {
            q6.f7572m.c = "SYSTEM";
            q6.c = h1.f7619J0;
        } else {
            q6.m(this);
            q6.f7572m.f7557f = true;
            q6.a(h1.f7626O0);
        }
    }
}
