package org.jsoup.parser;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final enum M0 extends h1 {
    public M0() {
        super("BeforeDoctypeName", 51);
    }

    @Override // org.jsoup.parser.h1
    public final void d(Q q6, C1465a c1465a) {
        boolean zT = c1465a.t();
        N0 n6 = h1.f7605B0;
        if (zT) {
            q6.f7572m.f();
            q6.c = n6;
            return;
        }
        char cE = c1465a.e();
        if (cE == 0) {
            q6.m(this);
            J j6 = q6.f7572m;
            j6.f();
            j6.b.append((char) 65533);
            q6.c = n6;
            return;
        }
        if (cE != ' ') {
            if (cE == 65535) {
                q6.l(this);
                J j7 = q6.f7572m;
                j7.f();
                j7.f7557f = true;
                q6.j();
                q6.c = h1.f7634a;
                return;
            }
            if (cE == '\t' || cE == '\n' || cE == '\f' || cE == '\r') {
                return;
            }
            q6.f7572m.f();
            q6.f7572m.b.append(cE);
            q6.c = n6;
        }
    }
}
