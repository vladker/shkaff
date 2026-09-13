package org.apache.xmlbeans.impl.store;

import java.util.function.Function;
import org.apache.xmlbeans.impl.soap.Node;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class M implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7396a;
    public final /* synthetic */ Node b;

    public /* synthetic */ M(Node node, int i5) {
        this.f7396a = i5;
        this.b = node;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f7396a) {
            case 0:
                return DomImpl.lambda$_soapNode_getParentElement$33(this.b, (DomImpl.Dom) obj);
            default:
                return DomImpl.lambda$_soapNode_getValue$31(this.b, (DomImpl.Dom) obj);
        }
    }
}
