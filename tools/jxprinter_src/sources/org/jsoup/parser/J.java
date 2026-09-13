package org.jsoup.parser;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class J extends O {
    public final StringBuilder b = new StringBuilder();
    public String c = null;
    public final StringBuilder d = new StringBuilder();
    public final StringBuilder e = new StringBuilder();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f7557f = false;

    public J() {
        this.f7560a = 1;
    }

    @Override // org.jsoup.parser.O
    public final O f() {
        O.g(this.b);
        this.c = null;
        O.g(this.d);
        O.g(this.e);
        this.f7557f = false;
        return this;
    }

    public final String toString() {
        return "<!doctype " + this.b.toString() + ">";
    }
}
