package org.jsoup.nodes;

import org.jsoup.parser.F;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class q extends m {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Y4.f f7483g;

    public q(F f6, c cVar) {
        super(f6, null, cVar);
        this.f7483g = new Y4.f();
    }

    @Override // org.jsoup.nodes.m
    /* JADX INFO: renamed from: E */
    public final m clone() {
        return (q) super.clone();
    }

    @Override // org.jsoup.nodes.m, org.jsoup.nodes.s
    /* JADX INFO: renamed from: clone */
    public Object l() {
        return (q) super.clone();
    }

    @Override // org.jsoup.nodes.m, org.jsoup.nodes.s
    public final s l() {
        return (q) super.clone();
    }

    @Override // org.jsoup.nodes.s
    public final void v(s sVar) {
        super.v(sVar);
        this.f7483g.remove(sVar);
    }
}
