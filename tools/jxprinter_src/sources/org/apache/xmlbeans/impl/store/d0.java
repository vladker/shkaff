package org.apache.xmlbeans.impl.store;

import java.util.function.Function;
import org.apache.xmlbeans.impl.soap.Detail;
import org.apache.xmlbeans.impl.soap.Node;
import org.apache.xmlbeans.impl.soap.Text;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class d0 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7416a;
    public final /* synthetic */ Node b;

    public /* synthetic */ d0(Node node, int i5) {
        this.f7416a = i5;
        this.b = node;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f7416a) {
            case 0:
                return DomImpl.lambda$detail_getDetailEntries$92((Detail) this.b, (DomImpl.Dom) obj);
            default:
                return DomImpl.lambda$_soapText_isComment$28((Text) this.b, (DomImpl.Dom) obj);
        }
    }
}
