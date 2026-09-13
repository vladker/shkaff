package org.jsoup.parser;

import A3.AbstractC0157z;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class I extends O {
    public String c;
    public final StringBuilder b = new StringBuilder();
    public boolean d = false;

    public I() {
        this.f7560a = 4;
    }

    @Override // org.jsoup.parser.O
    public final O f() {
        O.g(this.b);
        this.c = null;
        this.d = false;
        return this;
    }

    public final void h(char c) {
        String str = this.c;
        StringBuilder sb = this.b;
        if (str != null) {
            sb.append(str);
            this.c = null;
        }
        sb.append(c);
    }

    public final void i(String str) {
        String str2 = this.c;
        StringBuilder sb = this.b;
        if (str2 != null) {
            sb.append(str2);
            this.c = null;
        }
        if (sb.length() == 0) {
            this.c = str;
        } else {
            sb.append(str);
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("<!--");
        String string = this.c;
        if (string == null) {
            string = this.b.toString();
        }
        return AbstractC0157z.s(sb, string, "-->");
    }
}
