package org.apache.xmlbeans.impl.store;

import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class V implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7403a;
    public final /* synthetic */ Function b;
    public final /* synthetic */ DomImpl.Dom c;

    public /* synthetic */ V(Function function, DomImpl.Dom dom, int i5) {
        this.f7403a = i5;
        this.b = function;
        this.c = dom;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f7403a) {
            case 0:
                return DomImpl.lambda$syncWrap$107(this.b, this.c);
            default:
                return DomImpl.lambda$syncWrapNoEnter$108(this.b, this.c);
        }
    }
}
