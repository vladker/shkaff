package org.apache.xmlbeans.impl.store;

import java.util.function.Function;
import org.apache.xmlbeans.impl.soap.SOAPHeaderElement;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class K implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7394a;
    public final /* synthetic */ SOAPHeaderElement b;

    public /* synthetic */ K(SOAPHeaderElement sOAPHeaderElement, int i5) {
        this.f7394a = i5;
        this.b = sOAPHeaderElement;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f7394a) {
            case 0:
                return DomImpl.lambda$soapHeaderElement_getMustUnderstand$88(this.b, (DomImpl.Dom) obj);
            default:
                return DomImpl.lambda$soapHeaderElement_getActor$90(this.b, (DomImpl.Dom) obj);
        }
    }
}
