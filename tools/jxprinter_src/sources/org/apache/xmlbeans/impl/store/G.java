package org.apache.xmlbeans.impl.store;

import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class G implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7390a;
    public final /* synthetic */ DomImpl.Dom b;

    public /* synthetic */ G(int i5, DomImpl.Dom dom) {
        this.f7390a = i5;
        this.b = dom;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f7390a) {
            case 0:
                return DomImpl.lambda$_node_removeChild$12(this.b, (DomImpl.Dom) obj);
            case 1:
                return DomImpl.lambda$_attributes_setNamedItem$21(this.b, (DomImpl.Dom) obj);
            default:
                return DomImpl.lambda$_attributes_setNamedItemNS$26(this.b, (DomImpl.Dom) obj);
        }
    }
}
