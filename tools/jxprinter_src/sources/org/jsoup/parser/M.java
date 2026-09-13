package org.jsoup.parser;

import A3.AbstractC0157z;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class M extends N {
    public M() {
        this.f7560a = 2;
    }

    @Override // org.jsoup.parser.N, org.jsoup.parser.O
    public final /* bridge */ /* synthetic */ O f() {
        f();
        return this;
    }

    @Override // org.jsoup.parser.N
    /* JADX INFO: renamed from: r */
    public final N f() {
        super.f();
        this.attributes = null;
        return this;
    }

    public final String toString() {
        if (!n() || this.attributes.f7467a <= 0) {
            StringBuilder sb = new StringBuilder("<");
            String str = this.tagName;
            return AbstractC0157z.s(sb, str != null ? str : "[unset]", ">");
        }
        StringBuilder sb2 = new StringBuilder("<");
        String str2 = this.tagName;
        sb2.append(str2 != null ? str2 : "[unset]");
        sb2.append(" ");
        sb2.append(this.attributes.toString());
        sb2.append(">");
        return sb2.toString();
    }
}
