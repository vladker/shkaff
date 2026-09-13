package org.jsoup.parser;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class N extends O {
    private String attrNameS;
    private String attrValueS;
    org.jsoup.nodes.c attributes;
    public final StringBuilder b = new StringBuilder();
    public boolean c = false;
    public final StringBuilder d = new StringBuilder();
    public boolean e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f7558f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f7559g = false;
    protected String normalName;
    protected String tagName;

    public final void h(char c) {
        this.c = true;
        String str = this.attrNameS;
        StringBuilder sb = this.b;
        if (str != null) {
            sb.append(str);
            this.attrNameS = null;
        }
        sb.append(c);
    }

    public final void i(String str) {
        String strReplace = str.replace((char) 0, (char) 65533);
        this.c = true;
        String str2 = this.attrNameS;
        StringBuilder sb = this.b;
        if (str2 != null) {
            sb.append(str2);
            this.attrNameS = null;
        }
        if (sb.length() == 0) {
            this.attrNameS = strReplace;
        } else {
            sb.append(strReplace);
        }
    }

    public final void j(char c) {
        this.e = true;
        String str = this.attrValueS;
        StringBuilder sb = this.d;
        if (str != null) {
            sb.append(str);
            this.attrValueS = null;
        }
        sb.append(c);
    }

    public final void k(String str) {
        this.e = true;
        String str2 = this.attrValueS;
        StringBuilder sb = this.d;
        if (str2 != null) {
            sb.append(str2);
            this.attrValueS = null;
        }
        if (sb.length() == 0) {
            this.attrValueS = str;
        } else {
            sb.append(str);
        }
    }

    public final void l(int[] iArr) {
        this.e = true;
        String str = this.attrValueS;
        StringBuilder sb = this.d;
        if (str != null) {
            sb.append(str);
            this.attrValueS = null;
        }
        for (int i5 : iArr) {
            sb.appendCodePoint(i5);
        }
    }

    public final void m(String str) {
        String strReplace = str.replace((char) 0, (char) 65533);
        String str2 = this.tagName;
        if (str2 != null) {
            strReplace = str2.concat(strReplace);
        }
        this.tagName = strReplace;
        this.normalName = p051j0.i.i(strReplace.trim());
    }

    public final boolean n() {
        return this.attributes != null;
    }

    public final String o() {
        String str = this.tagName;
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Must be false");
        }
        return this.tagName;
    }

    public final void p(String str) {
        this.tagName = str;
        this.normalName = p051j0.i.i(str.trim());
    }

    public final void q() {
        String string;
        if (this.attributes == null) {
            this.attributes = new org.jsoup.nodes.c();
        }
        boolean z6 = this.c;
        StringBuilder sb = this.d;
        StringBuilder sb2 = this.b;
        if (z6 && this.attributes.f7467a < 512) {
            String strTrim = (sb2.length() > 0 ? sb2.toString() : this.attrNameS).trim();
            if (strTrim.length() > 0) {
                if (this.e) {
                    string = sb.length() > 0 ? sb.toString() : this.attrValueS;
                } else {
                    string = this.f7558f ? "" : null;
                }
                this.attributes.add(strTrim, string);
            }
        }
        O.g(sb2);
        this.attrNameS = null;
        this.c = false;
        O.g(sb);
        this.attrValueS = null;
        this.e = false;
        this.f7558f = false;
    }

    @Override // org.jsoup.parser.O
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public N f() {
        this.tagName = null;
        this.normalName = null;
        O.g(this.b);
        this.attrNameS = null;
        this.c = false;
        O.g(this.d);
        this.attrValueS = null;
        this.f7558f = false;
        this.e = false;
        this.f7559g = false;
        this.attributes = null;
        return this;
    }
}
