package org.apache.xmlbeans.impl.store;

import java.util.function.Function;
import org.apache.xmlbeans.impl.soap.SOAPElement;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class L implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7395a;
    public final /* synthetic */ SOAPElement b;

    public /* synthetic */ L(SOAPElement sOAPElement, int i5) {
        this.f7395a = i5;
        this.b = sOAPElement;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f7395a) {
            case 0:
                return DomImpl.lambda$_soapElement_getAllAttributes$39(this.b, (DomImpl.Dom) obj);
            case 1:
                return DomImpl.lambda$_soapElement_getNamespacePrefixes$41(this.b, (DomImpl.Dom) obj);
            case 2:
                return DomImpl.lambda$_soapElement_getElementName$52(this.b, (DomImpl.Dom) obj);
            case 3:
                return DomImpl.lambda$_soapElement_getVisibleNamespacePrefixes$54(this.b, (DomImpl.Dom) obj);
            case 4:
                return DomImpl.lambda$_soapElement_getChildElements$40(this.b, (DomImpl.Dom) obj);
            default:
                return DomImpl.lambda$_soapElement_getEncodingStyle$36(this.b, (DomImpl.Dom) obj);
        }
    }
}
