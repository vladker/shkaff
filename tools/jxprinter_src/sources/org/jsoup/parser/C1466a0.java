package org.jsoup.parser;

/* JADX INFO: renamed from: org.jsoup.parser.a0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final enum C1466a0 extends h1 {
    public C1466a0() {
        super("ScriptDataEndTagOpen", 17);
    }

    @Override // org.jsoup.parser.h1
    public final void d(Q q6, C1465a c1465a) {
        if (c1465a.t()) {
            q6.d(false);
            q6.c = h1.f7654s;
        } else {
            q6.g("</");
            q6.c = h1.f7635f;
        }
    }
}
