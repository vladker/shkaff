package org.jsoup.parser;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final enum Z extends h1 {
    public Z() {
        super("ScriptDataLessthanSign", 16);
    }

    @Override // org.jsoup.parser.h1
    public final void d(Q q6, C1465a c1465a) {
        char cE = c1465a.e();
        if (cE == '!') {
            q6.g("<!");
            q6.c = h1.f7656t;
            return;
        }
        if (cE == '/') {
            q6.e();
            q6.c = h1.f7652r;
        } else if (cE != 65535) {
            q6.g("<");
            c1465a.z();
            q6.c = h1.f7635f;
        } else {
            q6.g("<");
            q6.l(this);
            q6.c = h1.f7634a;
        }
    }
}
