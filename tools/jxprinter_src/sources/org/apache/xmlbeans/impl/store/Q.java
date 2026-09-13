package org.apache.xmlbeans.impl.store;

import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class Q implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7399a;
    public final /* synthetic */ DomImpl.Dom b;
    public final /* synthetic */ DomImpl.Dom c;

    public /* synthetic */ Q(DomImpl.Dom dom, DomImpl.Dom dom2, int i5) {
        this.f7399a = i5;
        this.b = dom;
        this.c = dom2;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f7399a) {
            case 0:
                return DomImpl.lambda$_node_insertBefore$11(this.b, this.c, (DomImpl.Dom) obj);
            default:
                return DomImpl.lambda$_node_replaceChild$10(this.b, this.c, (DomImpl.Dom) obj);
        }
    }
}
