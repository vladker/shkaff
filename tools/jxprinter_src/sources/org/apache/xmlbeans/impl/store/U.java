package org.apache.xmlbeans.impl.store;

import java.util.function.Consumer;
import org.apache.xmlbeans.impl.soap.Node;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class U implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7402a;
    public final /* synthetic */ Node b;

    public /* synthetic */ U(Node node, int i5) {
        this.f7402a = i5;
        this.b = node;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f7402a) {
            case 0:
                DomImpl.lambda$_soapNode_recycleNode$30(this.b, (DomImpl.Dom) obj);
                break;
            default:
                DomImpl.lambda$_soapNode_detachNode$29(this.b, (DomImpl.Dom) obj);
                break;
        }
    }
}
